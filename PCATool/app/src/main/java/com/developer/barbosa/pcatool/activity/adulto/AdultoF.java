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

public class AdultoF extends AppCompatActivity {

    private Button btnProximo;

    private RadioGroup rdgRespF1A, rdgRespF2A, rdgRespF3A;

    private Questionario questionario;

    private Resposta resposta1, resposta2, resposta3;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_f);

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        btnProximo = (Button) findViewById(R.id.btnProximo);
        rdgRespF1A = (RadioGroup) findViewById(R.id.rdgRespF1A);
        rdgRespF2A = (RadioGroup) findViewById(R.id.rdgRespF2A);
        rdgRespF3A = (RadioGroup) findViewById(R.id.rdgRespF3A);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespF1A.getCheckedRadioButtonId()){
                    case R.id.rdoF14A:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoF13A:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoF12A:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoF11A:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoF19A:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("A-F1");

                resposta2 = new Resposta();
                switch (rdgRespF2A.getCheckedRadioButtonId()){
                    case R.id.rdoF24A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoF23A:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoF22A:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoF21A:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoF29A:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("A-F2");

                resposta3 = new Resposta();
                switch (rdgRespF3A.getCheckedRadioButtonId()){
                    case R.id.rdoF34A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoF33A:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoF32A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoF31A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoF39A:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("A-F3");

                questionario.getRespostas().add(resposta1);
                questionario.getRespostas().add(resposta2);
                questionario.getRespostas().add(resposta3);

                Componente componente = new Componente();
                componente.setLetraComponente("A-F");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                questionario.getComponentes().add(componente);

                Toast.makeText(AdultoF.this, "Escore do Componente F = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),AdultoG.class);
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

}
