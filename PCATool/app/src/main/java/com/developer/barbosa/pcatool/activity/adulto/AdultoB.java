package com.developer.barbosa.pcatool.activity.adulto;

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

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.interfaces.ReplaceQuestions;
import com.developer.barbosa.pcatool.model.domain.Componente;
import com.developer.barbosa.pcatool.model.domain.Questionario;
import com.developer.barbosa.pcatool.model.domain.Resposta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AdultoB extends AppCompatActivity implements ReplaceQuestions {

    private FloatingActionButton fltProximo;
    private RadioGroup rdgRespB1A, rdgRespB2A, rdgRespB3A;
    private TextView txtQuestaoB1A, txtQuestaoB2A, txtQuestaoB3A;

    private Questionario questionario;

    private static String NOME_MEDICO_SERVICO_DEFINIDO = "nome do serviço de saúde / ou nome médico/enfermeiro";

    private Resposta resposta1, resposta2, resposta3;

    // Caso nao de para calcular o escore do componente, indicaremos isso com o valor -1
    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_b);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        this.NOME_MEDICO_SERVICO_DEFINIDO = this.questionario.getRespostas().get(4).getNomeProfServ();

        fltProximo = (FloatingActionButton) findViewById(R.id.fltProximo);
        rdgRespB1A = (RadioGroup) findViewById(R.id.rdgRespB1A);
        rdgRespB2A = (RadioGroup) findViewById(R.id.rdgRespB2A);
        rdgRespB3A = (RadioGroup) findViewById(R.id.rdgRespB3A);
        txtQuestaoB1A = (TextView) findViewById(R.id.txtQuestaoB1A);
        txtQuestaoB2A = (TextView) findViewById(R.id.txtQuestaoB2A);
        txtQuestaoB3A = (TextView) findViewById(R.id.txtQuestaoB3A);

        this.replaceQuestionsAdulto();

        fltProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespB1A.getCheckedRadioButtonId()){
                    case R.id.rdoB14A:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoB13A:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoB12A:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoB11A:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoB19A:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("A-B1");

                resposta2 = new Resposta();
                switch (rdgRespB2A.getCheckedRadioButtonId()){
                    case R.id.rdoB24A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoB23A:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoB22A:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoB21A:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoB29A:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("A-B2");

                resposta3 = new Resposta();
                switch (rdgRespB3A.getCheckedRadioButtonId()){
                    case R.id.rdoB34A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoB33A:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoB32A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoB31A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoB39A:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("A-B3");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 8) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("A-B1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-B2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-B3"))
                            respostas.set(i, resposta3);
                    }
                } else {
                    questionario.getRespostas().add(resposta1);
                    questionario.getRespostas().add(resposta2);
                    questionario.getRespostas().add(resposta3);
                }

                Componente componente = new Componente();
                componente.setLetraComponente("A-B");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 2){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("A-B"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(AdultoB.this, "Escore do Componente B = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),AdultoC.class);
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

    public void replaceQuestionsAdulto(){
        txtQuestaoB1A.setText( txtQuestaoB1A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoB2A.setText( txtQuestaoB1A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoB3A.setText( txtQuestaoB1A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
    }

}
