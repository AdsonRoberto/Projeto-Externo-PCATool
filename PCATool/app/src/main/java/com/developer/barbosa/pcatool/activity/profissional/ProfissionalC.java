package com.developer.barbosa.pcatool.activity.profissional;

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

public class ProfissionalC extends AppCompatActivity {

    private Button btnProximoP;

    private RadioGroup rdgRespC1P, rdgRespC2P, rdgRespC3P, rdgRespC4P, rdgRespC5P, rdgRespC6P;
    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6;

    Questionario questionario;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_c);

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        btnProximoP = (Button) findViewById(R.id.btnProximoP);
        rdgRespC1P = (RadioGroup) findViewById(R.id.rdgRespC1P);
        rdgRespC2P = (RadioGroup) findViewById(R.id.rdgRespC2P);
        rdgRespC3P = (RadioGroup) findViewById(R.id.rdgRespC3P);
        rdgRespC4P = (RadioGroup) findViewById(R.id.rdgRespC4P);
        rdgRespC5P = (RadioGroup) findViewById(R.id.rdgRespC5P);
        rdgRespC6P = (RadioGroup) findViewById(R.id.rdgRespC6P);

        btnProximoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespC1P.getCheckedRadioButtonId()){
                    case R.id.rdoC14P:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoC13P:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoC12P:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoC11P:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoC19P:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("P-C1");

                resposta2 = new Resposta();
                switch (rdgRespC2P.getCheckedRadioButtonId()){
                    case R.id.rdoC24P:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoC23P:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoC22P:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoC21P:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoC29P:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("P-C2");

                resposta3 = new Resposta();
                switch (rdgRespC3P.getCheckedRadioButtonId()){
                    case R.id.rdoC34P:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoC33P:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoC32P:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoC31P:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoC39P:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("P-C3");

                resposta4 = new Resposta();
                switch (rdgRespC4P.getCheckedRadioButtonId()){
                    case R.id.rdoC44P:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoC43P:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoC42P:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoC41P:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoC49P:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("P-C4");

                resposta5 = new Resposta();
                switch (rdgRespC5P.getCheckedRadioButtonId()){
                    case R.id.rdoC54P:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoC53P:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoC52P:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoC51P:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoC59P:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("P-C5");

                resposta6 = new Resposta();
                switch (rdgRespC6P.getCheckedRadioButtonId()){
                    case R.id.rdoC64P:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoC63P:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoC62P:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoC61P:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoC69P:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("P-C6");

                questionario.getRespostas().add(resposta1);
                questionario.getRespostas().add(resposta2);
                questionario.getRespostas().add(resposta3);
                questionario.getRespostas().add(resposta4);
                questionario.getRespostas().add(resposta5);
                questionario.getRespostas().add(resposta6);

                Componente componente = new Componente();
                componente.setLetraComponente("P-C");
                componente.setEscoreComponente( calcularEscoreComponente() );

                questionario.getComponentes().add(componente);

                Toast.makeText(ProfissionalC.this, "Escore do Componente C = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),ProfissionalD.class);
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

        return (numeroDeRespostasBrancasOuNaoSei/6 < 0.5);
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

    public double calcularEscoreComponente(){

        this.escoreComponente = -1;

        double somatorioDosItens = 0;

        if ( this.ehPossivelCalcularEscoreComponente() ){

            somatorioDosItens = this.somatorioDosItens();

            this.escoreComponente = somatorioDosItens / 6;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

        }

        return this.escoreComponente;

    }

}