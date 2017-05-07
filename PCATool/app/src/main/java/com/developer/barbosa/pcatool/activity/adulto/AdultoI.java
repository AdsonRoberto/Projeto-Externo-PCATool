package com.developer.barbosa.pcatool.activity.adulto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class AdultoI extends AppCompatActivity {

    private Button btnProximo;

    private RadioGroup rdgRespI1A, rdgRespI2A, rdgRespI3A;

    private Questionario questionario;

    private Resposta resposta1, resposta2, resposta3;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_i);

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        btnProximo = (Button) findViewById(R.id.btnProximo);
        rdgRespI1A = (RadioGroup) findViewById(R.id.rdgRespI1A);
        rdgRespI2A = (RadioGroup) findViewById(R.id.rdgRespI2A);
        rdgRespI3A = (RadioGroup) findViewById(R.id.rdgRespI3A);

        btnProximo.setOnClickListener(new View.OnClickListener() {
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

                questionario.getRespostas().add(resposta1);
                questionario.getRespostas().add(resposta2);
                questionario.getRespostas().add(resposta3);

                Componente componente = new Componente();
                componente.setLetraComponente("A-I");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

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

}
