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
import br.uece.gesad.pcatoolbrasil.activity.telas.ConfirmarCadastroActivity;
import br.uece.gesad.pcatoolbrasil.interfaces.ReplaceQuestions;
import br.uece.gesad.pcatoolbrasil.model.domain.Componente;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;
import br.uece.gesad.pcatoolbrasil.model.domain.Resposta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AdultoJ extends AppCompatActivity implements ReplaceQuestions {

    private FloatingActionButton fltProximo;

    private RadioGroup rdgRespJ1A, rdgRespJ2A, rdgRespJ3A, rdgRespJ4A, rdgRespJ5A, rdgRespJ6A;
    private TextView txtQuestaoJ1A, txtQuestaoJ2A, txtQuestaoJ3A, txtDescricao1JA;

    private Questionario questionario;

    private static String NOME_MEDICO_SERVICO_DEFINIDO = "nome do serviço de saúde / ou nome médico/enfermeiro";

    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_j);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        this.NOME_MEDICO_SERVICO_DEFINIDO = this.questionario.getRespostas().get(4).getNomeProfServ();

        fltProximo = (FloatingActionButton) findViewById(R.id.fltProximo);
        rdgRespJ1A = (RadioGroup) findViewById(R.id.rdgRespJ1A);
        rdgRespJ2A = (RadioGroup) findViewById(R.id.rdgRespJ2A);
        rdgRespJ3A = (RadioGroup) findViewById(R.id.rdgRespJ3A);
        rdgRespJ4A = (RadioGroup) findViewById(R.id.rdgRespJ4A);
        rdgRespJ5A = (RadioGroup) findViewById(R.id.rdgRespJ5A);
        rdgRespJ6A = (RadioGroup) findViewById(R.id.rdgRespJ6A);
        txtQuestaoJ1A = (TextView) findViewById(R.id.txtQuestaoJ1A);
        txtQuestaoJ2A = (TextView) findViewById(R.id.txtQuestaoJ2A);
        txtQuestaoJ3A = (TextView) findViewById(R.id.txtQuestaoJ3A);
        txtDescricao1JA = (TextView) findViewById(R.id.txtDescricao1JA);

        this.replaceQuestionsAdulto();

        fltProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespJ1A.getCheckedRadioButtonId()){
                    case R.id.rdoJ14A:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoJ13A:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoJ12A:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoJ11A:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoJ19A:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("A-J1");

                resposta2 = new Resposta();
                switch (rdgRespJ2A.getCheckedRadioButtonId()){
                    case R.id.rdoJ24A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoJ23A:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoJ22A:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoJ21A:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoJ29A:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("A-J2");

                resposta3 = new Resposta();
                switch (rdgRespJ3A.getCheckedRadioButtonId()){
                    case R.id.rdoJ34A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoJ33A:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoJ32A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoJ31A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoJ39A:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("A-J3");

                resposta4 = new Resposta();
                switch (rdgRespJ4A.getCheckedRadioButtonId()){
                    case R.id.rdoJ44A:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoJ43A:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoJ42A:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoJ41A:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoJ49A:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("A-J4");

                resposta5 = new Resposta();
                switch (rdgRespJ5A.getCheckedRadioButtonId()){
                    case R.id.rdoJ54A:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoJ53A:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoJ52A:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoJ51A:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoJ59A:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("A-J5");

                resposta6 = new Resposta();
                switch (rdgRespJ6A.getCheckedRadioButtonId()){
                    case R.id.rdoJ64A:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoJ63A:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoJ62A:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoJ61A:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoJ69A:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("A-J6");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 90) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("A-J1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-J2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-J3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-J4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-J5"))
                            respostas.set(i, resposta5);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-J6"))
                            respostas.set(i, resposta6);
                    }
                } else {
                    questionario.getRespostas().add(resposta1);
                    questionario.getRespostas().add(resposta2);
                    questionario.getRespostas().add(resposta3);
                    questionario.getRespostas().add(resposta4);
                    questionario.getRespostas().add(resposta5);
                    questionario.getRespostas().add(resposta6);
                }

                Componente componente = new Componente();
                componente.setLetraComponente("A-J");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 10){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("A-J"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(AdultoJ.this, "Escore do Componente J = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),ConfirmarCadastroActivity.class);
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
        if (resposta4.getOpcao() == 0 || resposta4.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta5.getOpcao() == 0 || resposta5.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta6.getOpcao() == 0 || resposta6.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }

        System.out.println("Resposta brancas ou nao sei = " + numeroDeRespostasBrancasOuNaoSei);

        return numeroDeRespostasBrancasOuNaoSei/6 < 0.5;
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
        if (resposta4.getOpcao() != 5){
            somatorioDosItens += (5 - resposta4.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta5.getOpcao() != 5){
            somatorioDosItens += (5 - resposta5.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta6.getOpcao() != 5){
            somatorioDosItens += (5 - resposta6.getOpcao());
        } else {
            somatorioDosItens += 2;
        }

        return somatorioDosItens;
    }

    private double calcularEscoreComponente(){

        this.escoreComponente = -1;

        double somatorioDosItens = 0;

        // Se nao der pra calcular os escores do componente
        if ( !this.ehPossivelCalcularEscoreComponente() ){

            this.escoreComponente = -1;
            System.out.println("Nao da pra calcular o escore deste  componente");

        } else {

            somatorioDosItens = this.somatorioDosItens();

            System.out.println("Somatorio dos Itens = " + somatorioDosItens);

            this.escoreComponente = somatorioDosItens / 6;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

            // Transformacao do Escore
            // this.escoreComponente = ((this.escoreComponente - 1) * 10)/3;

        }

        return this.escoreComponente;

    }

    @Override
    public void replaceQuestionsAdulto() {
        txtQuestaoJ1A.setText( txtQuestaoJ1A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoJ2A.setText( txtQuestaoJ2A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoJ3A.setText( txtQuestaoJ3A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtDescricao1JA.setText( txtDescricao1JA.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        
    }
}
