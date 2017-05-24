package com.developer.barbosa.pcatool.activity.profissional;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.model.domain.Componente;
import com.developer.barbosa.pcatool.model.domain.Questionario;
import com.developer.barbosa.pcatool.model.domain.Resposta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ProfissionalG extends AppCompatActivity {

    private FloatingActionButton fltProximoP;

    private RadioGroup rdgRespG1P, rdgRespG2P, rdgRespG3P;
    private Resposta resposta1, resposta2, resposta3;

    Questionario questionario;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_g);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        fltProximoP = (FloatingActionButton) findViewById(R.id.fltProximoP);
        rdgRespG1P = (RadioGroup) findViewById(R.id.rdgRespG1P);
        rdgRespG2P = (RadioGroup) findViewById(R.id.rdgRespG2P);
        rdgRespG3P = (RadioGroup) findViewById(R.id.rdgRespG3P);

        fltProximoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespG1P.getCheckedRadioButtonId()){
                    case R.id.rdoG14P:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoG13P:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoG12P:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoG11P:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoG19P:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("P-G1");

                resposta2 = new Resposta();
                switch (rdgRespG2P.getCheckedRadioButtonId()){
                    case R.id.rdoG24P:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoG23P:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoG22P:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoG21P:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoG29P:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("P-G2");

                resposta3 = new Resposta();
                switch (rdgRespG3P.getCheckedRadioButtonId()){
                    case R.id.rdoG34P:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoG33P:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoG32P:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoG31P:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoG39P:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("P-G3");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 72) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("P-G1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-G2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-G3"))
                            respostas.set(i, resposta3);
                    }
                } else {
                    questionario.getRespostas().add(resposta1);
                    questionario.getRespostas().add(resposta2);
                    questionario.getRespostas().add(resposta3);
                }

                Componente componente = new Componente();
                componente.setLetraComponente("P-G");
                componente.setEscoreComponente( calcularEscoreComponente() );

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 7){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("P-G"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(ProfissionalG.this, "Escore do Componente G = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),ProfissionalH.class);
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

        return (numeroDeRespostasBrancasOuNaoSei/3 < 0.5);
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

    private double calcularEscoreComponente(){

        this.escoreComponente = -1;

        double somatorioDosItens = 0;

        if ( this.ehPossivelCalcularEscoreComponente() ){

            somatorioDosItens = this.somatorioDosItens();

            this.escoreComponente = somatorioDosItens / 3;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

        }

        return this.escoreComponente;

    }

}