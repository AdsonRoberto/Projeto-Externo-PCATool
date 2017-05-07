package com.developer.barbosa.pcatool.activity.adulto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.model.Componente;
import com.developer.barbosa.pcatool.model.Questionario;
import com.developer.barbosa.pcatool.model.Resposta;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AdultoE extends AppCompatActivity {

    private Button btnProximo;

    private RadioGroup rdgRespE1A, rdgRespE2A, rdgRespE3A, rdgRespE4A, rdgRespE5A, rdgRespE6A, rdgRespE7A,
            rdgRespE8A, rdgRespE9A;

    private Questionario questionario;

    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7, resposta8,
            resposta9;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_e);

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        btnProximo = (Button) findViewById(R.id.btnProximo);
        rdgRespE1A = (RadioGroup) findViewById(R.id.rdgRespE1A);
        rdgRespE2A = (RadioGroup) findViewById(R.id.rdgRespE2A);
        rdgRespE3A = (RadioGroup) findViewById(R.id.rdgRespE3A);
        rdgRespE4A = (RadioGroup) findViewById(R.id.rdgRespE4A);
        rdgRespE5A = (RadioGroup) findViewById(R.id.rdgRespE5A);
        rdgRespE6A = (RadioGroup) findViewById(R.id.rdgRespE6A);
        rdgRespE7A = (RadioGroup) findViewById(R.id.rdgRespE7A);
        rdgRespE8A = (RadioGroup) findViewById(R.id.rdgRespE8A);
        rdgRespE9A = (RadioGroup) findViewById(R.id.rdgRespE9A);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespE1A.getCheckedRadioButtonId()){
                    case R.id.rdoE1SimA:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoE1NaoA:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoE1NaoSeiA:
                        resposta1.setOpcao(3);
                        break;
                }
                resposta1.setNumeroQuestao("A-E1");

                resposta2 = new Resposta();
                switch (rdgRespE2A.getCheckedRadioButtonId()){
                    case R.id.rdoE24A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoE23A:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoE22A:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoE21A:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoE29A:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("A-E2");

                resposta3 = new Resposta();
                switch (rdgRespE3A.getCheckedRadioButtonId()){
                    case R.id.rdoE34A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoE33A:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoE32A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoE31A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoE39A:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("A-E3");

                resposta4 = new Resposta();
                switch (rdgRespE4A.getCheckedRadioButtonId()){
                    case R.id.rdoE44A:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoE43A:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoE42A:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoE41A:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoE49A:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("A-E4");

                resposta5 = new Resposta();
                switch (rdgRespE5A.getCheckedRadioButtonId()){
                    case R.id.rdoE54A:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoE53A:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoE52A:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoE51A:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoE59A:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("A-E5");

                resposta6 = new Resposta();
                switch (rdgRespE6A.getCheckedRadioButtonId()){
                    case R.id.rdoE64A:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoE63A:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoE62A:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoE61A:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoE69A:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("A-E6");

                resposta7 = new Resposta();
                switch (rdgRespE7A.getCheckedRadioButtonId()){
                    case R.id.rdoE74A:
                        resposta7.setOpcao(1);
                        break;
                    case R.id.rdoE73A:
                        resposta7.setOpcao(2);
                        break;
                    case R.id.rdoE72A:
                        resposta7.setOpcao(3);
                        break;
                    case R.id.rdoE71A:
                        resposta7.setOpcao(4);
                        break;
                    case R.id.rdoE79A:
                        resposta7.setOpcao(5);
                        break;
                }
                resposta7.setNumeroQuestao("A-E7");

                resposta8 = new Resposta();
                switch (rdgRespE8A.getCheckedRadioButtonId()){
                    case R.id.rdoE84A:
                        resposta8.setOpcao(1);
                        break;
                    case R.id.rdoE83A:
                        resposta8.setOpcao(2);
                        break;
                    case R.id.rdoE82A:
                        resposta8.setOpcao(3);
                        break;
                    case R.id.rdoE81A:
                        resposta8.setOpcao(4);
                        break;
                    case R.id.rdoE89A:
                        resposta8.setOpcao(5);
                        break;
                }
                resposta8.setNumeroQuestao("A-E8");

                resposta9 = new Resposta();
                switch (rdgRespE9A.getCheckedRadioButtonId()){
                    case R.id.rdoE94A:
                        resposta9.setOpcao(1);
                        break;
                    case R.id.rdoE93A:
                        resposta9.setOpcao(2);
                        break;
                    case R.id.rdoE92A:
                        resposta9.setOpcao(3);
                        break;
                    case R.id.rdoE91A:
                        resposta9.setOpcao(4);
                        break;
                    case R.id.rdoE99A:
                        resposta9.setOpcao(5);
                        break;
                }
                resposta9.setNumeroQuestao("A-E9");

                questionario.getRespostas().add(resposta1);
                questionario.getRespostas().add(resposta2);
                questionario.getRespostas().add(resposta3);
                questionario.getRespostas().add(resposta4);
                questionario.getRespostas().add(resposta5);
                questionario.getRespostas().add(resposta6);
                questionario.getRespostas().add(resposta7);
                questionario.getRespostas().add(resposta8);
                questionario.getRespostas().add(resposta9);

                Componente componente = new Componente();
                componente.setLetraComponente("A-E");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                questionario.getComponentes().add(componente);

                Toast.makeText(AdultoE.this, "Escore do Componente E = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),AdultoF.class);
                intent.putExtra("questionario", questionario);
                startActivity(intent);
            }
        });
    }

    private boolean ehPossivelCalcularEscoreComponente(){
        double numeroDeRespostasBrancasOuNaoSei = 0;

        // Item E1 não deve entrar no calculo do escore deste componente

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
        if (resposta7.getOpcao() == 0 || resposta7.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta8.getOpcao() == 0 || resposta8.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta9.getOpcao() == 0 || resposta9.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }

        System.out.println("Resposta brancas ou nao sei = " + numeroDeRespostasBrancasOuNaoSei);

        return numeroDeRespostasBrancasOuNaoSei/8 < 0.5;
    }

    private double somatorioDosItens(){
        double somatorioDosItens = 0;

        // Item E1 não deve entrar no calculo do escore deste componente

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
        if (resposta7.getOpcao() != 5){
            somatorioDosItens += (5 - resposta7.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta8.getOpcao() != 5){
            somatorioDosItens += (5 - resposta8.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta9.getOpcao() != 5){
            somatorioDosItens += (5 - resposta9.getOpcao());
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

            this.escoreComponente = somatorioDosItens / 8;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

            // Transformacao do Escore
            // this.escoreComponente = ((this.escoreComponente - 1) * 10)/3;

        }

        return this.escoreComponente;

    }

}
