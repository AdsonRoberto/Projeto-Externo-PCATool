package br.uece.gesad.pcatoolbrasil.activity.adulto;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.interfaces.ReplaceQuestions;
import br.uece.gesad.pcatoolbrasil.model.domain.Componente;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;
import br.uece.gesad.pcatoolbrasil.model.domain.Resposta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AdultoI extends AppCompatActivity implements ReplaceQuestions{

    private FloatingActionButton fltProximo;

    private RadioGroup rdgRespI1A, rdgRespI2A, rdgRespI3A;
    private TextView txtDescricao1IA;

    private Questionario questionario;

    private static String NOME_MEDICO_SERVICO_DEFINIDO = "nome do serviço de saúde / ou nome médico/enfermeiro";

    private Resposta resposta1, resposta2, resposta3;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_i);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        this.NOME_MEDICO_SERVICO_DEFINIDO = this.questionario.getRespostas().get(4).getNomeProfServ();

        fltProximo = (FloatingActionButton) findViewById(R.id.fltProximo);
        rdgRespI1A = (RadioGroup) findViewById(R.id.rdgRespI1A);
        rdgRespI2A = (RadioGroup) findViewById(R.id.rdgRespI2A);
        rdgRespI3A = (RadioGroup) findViewById(R.id.rdgRespI3A);
        txtDescricao1IA = (TextView) findViewById(R.id.txtDescricao1IA);

        this.replaceQuestionsAdulto();

        fltProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespI1A.getCheckedRadioButtonId()){
                    case R.id.rdoI14A:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoI13A:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoI12A:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoI11A:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoI19A:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("A-I1");

                resposta2 = new Resposta();
                switch (rdgRespI2A.getCheckedRadioButtonId()){
                    case R.id.rdoI24A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoI23A:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoI22A:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoI21A:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoI29A:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("A-I2");

                resposta3 = new Resposta();
                switch (rdgRespI3A.getCheckedRadioButtonId()){
                    case R.id.rdoI34A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoI33A:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoI32A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoI31A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoI39A:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("A-I3");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 84) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("A-I1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-I2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-I3"))
                            respostas.set(i, resposta3);
                    }
                } else {
                    questionario.getRespostas().add(resposta1);
                    questionario.getRespostas().add(resposta2);
                    questionario.getRespostas().add(resposta3);
                }

                Componente componente = new Componente();
                componente.setLetraComponente("A-I");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 9){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("A-I"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(AdultoI.this, "Escore do Componente I = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),AdultoJ.class);
                intent.putExtra("questionario", questionario);
                startActivity(intent);
            }
        });
    }

    private boolean ehPossivelCalcularEscoreComponente(){
        double numeroDeRespostasBrancasOuNaoSei = 0;

        if (resposta1.getOpcao() == 0 || resposta1.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta2.getOpcao() == 0 || resposta2.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta3.getOpcao() == 0 || resposta3.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }

        System.out.println("Resposta brancas ou nao sei = " + numeroDeRespostasBrancasOuNaoSei);

        return numeroDeRespostasBrancasOuNaoSei/3 < 0.5;
    }

    private double somatorioDosItens(){
        double somatorioDosItens = 0;

        if (resposta1.getOpcao() != 5){
            somatorioDosItens += (5 - resposta1.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta2.getOpcao() != 5){
            somatorioDosItens += (5 - resposta2.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta3.getOpcao() != 5){
            somatorioDosItens += (5 - resposta3.getOpcao());
        } else {
            somatorioDosItens += 2;
        }

        return somatorioDosItens;
    }

    public double calcularEscoreComponente(){

        this.escoreComponente = -1;

        double somatorioDosItens = 0;

        // Se nao der pra calcular os escores do componente
        if ( !this.ehPossivelCalcularEscoreComponente() ){

            this.escoreComponente = -1;
            System.out.println("Nao da pra calcular o escore deste  componente");

        } else {

            somatorioDosItens = this.somatorioDosItens();

            System.out.println("Somatorio dos Itens = " + somatorioDosItens);

            this.escoreComponente = somatorioDosItens / 3;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

            // Transformacao do Escore
            // this.escoreComponente = ((this.escoreComponente - 1) * 10)/3;

        }

        return this.escoreComponente;

    }

    @Override
    public void replaceQuestionsAdulto() {
        txtDescricao1IA.setText( txtDescricao1IA.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
    }
}
