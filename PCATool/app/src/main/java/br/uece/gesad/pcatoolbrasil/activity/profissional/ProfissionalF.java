package br.uece.gesad.pcatoolbrasil.activity.profissional;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.model.domain.Componente;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;
import br.uece.gesad.pcatoolbrasil.model.domain.Resposta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ProfissionalF extends AppCompatActivity {

    private FloatingActionButton fltProximoP;
    private RadioGroup rdgRespPergunta1FP, rdgRespF1P, rdgRespF2P, rdgRespF3P, rdgRespF4P, rdgRespF5P, rdgRespF6P,
            rdgRespF7P, rdgRespF8P, rdgRespF9P, rdgRespF10P, rdgRespF11P, rdgRespF12P, rdgRespF13P, rdgRespF14P, rdgRespF15P;
    private Resposta respostaPergunta0, resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7, resposta8, resposta9,
            resposta10, resposta11, resposta12, resposta13, resposta14, resposta15;

    Questionario questionario;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_f);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        fltProximoP = (FloatingActionButton) findViewById(R.id.fltProximoP);
        rdgRespPergunta1FP = (RadioGroup) findViewById(R.id.rdgRespPergunta1FP);
        rdgRespF1P = (RadioGroup) findViewById(R.id.rdgRespF1P);
        rdgRespF2P = (RadioGroup) findViewById(R.id.rdgRespF2P);
        rdgRespF3P = (RadioGroup) findViewById(R.id.rdgRespF3P);
        rdgRespF4P = (RadioGroup) findViewById(R.id.rdgRespF4P);
        rdgRespF5P = (RadioGroup) findViewById(R.id.rdgRespF5P);
        rdgRespF6P = (RadioGroup) findViewById(R.id.rdgRespF6P);
        rdgRespF7P = (RadioGroup) findViewById(R.id.rdgRespF7P);
        rdgRespF8P = (RadioGroup) findViewById(R.id.rdgRespF8P);
        rdgRespF9P = (RadioGroup) findViewById(R.id.rdgRespF9P);
        rdgRespF10P = (RadioGroup) findViewById(R.id.rdgRespF10P);
        rdgRespF11P = (RadioGroup) findViewById(R.id.rdgRespF11P);
        rdgRespF12P = (RadioGroup) findViewById(R.id.rdgRespF12P);
        rdgRespF13P = (RadioGroup) findViewById(R.id.rdgRespF13P);
        rdgRespF14P = (RadioGroup) findViewById(R.id.rdgRespF14P);
        rdgRespF15P = (RadioGroup) findViewById(R.id.rdgRespF15P);

        fltProximoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                respostaPergunta0 = new Resposta();
                switch (rdgRespPergunta1FP.getCheckedRadioButtonId()){
                    case R.id.rdoTodasIdadesFP:
                        respostaPergunta0.setOpcao(1);
                        break;
                    case R.id.rdoSoCriancasFP:
                        respostaPergunta0.setOpcao(2);
                        break;
                    case R.id.rdoSoAdultosFP:
                        respostaPergunta0.setOpcao(3);
                        break;
                }
                respostaPergunta0.setNumeroQuestao("P-F0");

                resposta1 = new Resposta();
                switch (rdgRespF1P.getCheckedRadioButtonId()){
                    case R.id.rdoF14P:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoF13P:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoF12P:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoF11P:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoF19P:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("P-F1");

                resposta2 = new Resposta();
                switch (rdgRespF2P.getCheckedRadioButtonId()){
                    case R.id.rdoF24P:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoF23P:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoF22P:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoF21P:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoF29P:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("P-F2");

                resposta3 = new Resposta();
                switch (rdgRespF3P.getCheckedRadioButtonId()){
                    case R.id.rdoF34P:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoF33P:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoF32P:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoF31P:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoF39P:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("P-F3");

                resposta4 = new Resposta();
                switch (rdgRespF4P.getCheckedRadioButtonId()){
                    case R.id.rdoF44P:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoF43P:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoF42P:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoF41P:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoF49P:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("P-F4");

                resposta5 = new Resposta();
                switch (rdgRespF5P.getCheckedRadioButtonId()){
                    case R.id.rdoF54P:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoF53P:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoF52P:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoF51P:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoF59P:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("P-F5");

                resposta6 = new Resposta();
                switch (rdgRespF6P.getCheckedRadioButtonId()){
                    case R.id.rdoF64P:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoF63P:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoF62P:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoF61P:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoF69P:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("P-F6");

                resposta7 = new Resposta();
                switch (rdgRespF7P.getCheckedRadioButtonId()){
                    case R.id.rdoF74P:
                        resposta7.setOpcao(1);
                        break;
                    case R.id.rdoF73P:
                        resposta7.setOpcao(2);
                        break;
                    case R.id.rdoF72P:
                        resposta7.setOpcao(3);
                        break;
                    case R.id.rdoF71P:
                        resposta7.setOpcao(4);
                        break;
                    case R.id.rdoF79P:
                        resposta7.setOpcao(5);
                        break;
                }
                resposta7.setNumeroQuestao("P-F7");

                resposta8 = new Resposta();
                switch (rdgRespF8P.getCheckedRadioButtonId()){
                    case R.id.rdoF84P:
                        resposta8.setOpcao(1);
                        break;
                    case R.id.rdoF83P:
                        resposta8.setOpcao(2);
                        break;
                    case R.id.rdoF82P:
                        resposta8.setOpcao(3);
                        break;
                    case R.id.rdoF81P:
                        resposta8.setOpcao(4);
                        break;
                    case R.id.rdoF89P:
                        resposta8.setOpcao(5);
                        break;
                }
                resposta8.setNumeroQuestao("P-F8");

                resposta9 = new Resposta();
                switch (rdgRespF9P.getCheckedRadioButtonId()){
                    case R.id.rdoF94P:
                        resposta9.setOpcao(1);
                        break;
                    case R.id.rdoF93P:
                        resposta9.setOpcao(2);
                        break;
                    case R.id.rdoF92P:
                        resposta9.setOpcao(3);
                        break;
                    case R.id.rdoF91P:
                        resposta9.setOpcao(4);
                        break;
                    case R.id.rdoF99P:
                        resposta9.setOpcao(5);
                        break;
                }
                resposta9.setNumeroQuestao("P-F9");

                resposta10 = new Resposta();
                switch (rdgRespF10P.getCheckedRadioButtonId()){
                    case R.id.rdoF104P:
                        resposta10.setOpcao(1);
                        break;
                    case R.id.rdoF103P:
                        resposta10.setOpcao(2);
                        break;
                    case R.id.rdoF102P:
                        resposta10.setOpcao(3);
                        break;
                    case R.id.rdoF101P:
                        resposta10.setOpcao(4);
                        break;
                    case R.id.rdoF109P:
                        resposta10.setOpcao(5);
                        break;
                }
                resposta10.setNumeroQuestao("P-F10");

                resposta11 = new Resposta();
                switch (rdgRespF11P.getCheckedRadioButtonId()){
                    case R.id.rdoF114P:
                        resposta11.setOpcao(1);
                        break;
                    case R.id.rdoF113P:
                        resposta11.setOpcao(2);
                        break;
                    case R.id.rdoF112P:
                        resposta11.setOpcao(3);
                        break;
                    case R.id.rdoF111P:
                        resposta11.setOpcao(4);
                        break;
                    case R.id.rdoF119P:
                        resposta11.setOpcao(5);
                        break;
                }
                resposta11.setNumeroQuestao("P-F11");

                resposta12 = new Resposta();
                switch (rdgRespF12P.getCheckedRadioButtonId()){
                    case R.id.rdoF124P:
                        resposta12.setOpcao(1);
                        break;
                    case R.id.rdoF123P:
                        resposta12.setOpcao(2);
                        break;
                    case R.id.rdoF122P:
                        resposta12.setOpcao(3);
                        break;
                    case R.id.rdoF121P:
                        resposta12.setOpcao(4);
                        break;
                    case R.id.rdoF129P:
                        resposta12.setOpcao(5);
                        break;
                }
                resposta12.setNumeroQuestao("P-F12");

                resposta13 = new Resposta();
                switch (rdgRespF13P.getCheckedRadioButtonId()){
                    case R.id.rdoF134P:
                        resposta13.setOpcao(1);
                        break;
                    case R.id.rdoF133P:
                        resposta13.setOpcao(2);
                        break;
                    case R.id.rdoF132P:
                        resposta13.setOpcao(3);
                        break;
                    case R.id.rdoF131P:
                        resposta13.setOpcao(4);
                        break;
                    case R.id.rdoF139P:
                        resposta13.setOpcao(5);
                        break;
                }
                resposta13.setNumeroQuestao("P-F13");

                resposta14 = new Resposta();
                switch (rdgRespF14P.getCheckedRadioButtonId()){
                    case R.id.rdoF144P:
                        resposta14.setOpcao(1);
                        break;
                    case R.id.rdoF143P:
                        resposta14.setOpcao(2);
                        break;
                    case R.id.rdoF142P:
                        resposta14.setOpcao(3);
                        break;
                    case R.id.rdoF141P:
                        resposta14.setOpcao(4);
                        break;
                    case R.id.rdoF149P:
                        resposta14.setOpcao(5);
                        break;
                }
                resposta14.setNumeroQuestao("P-F14");

                resposta15 = new Resposta();
                switch (rdgRespF15P.getCheckedRadioButtonId()){
                    case R.id.rdoF154P:
                        resposta15.setOpcao(1);
                        break;
                    case R.id.rdoF153P:
                        resposta15.setOpcao(2);
                        break;
                    case R.id.rdoF152P:
                        resposta15.setOpcao(3);
                        break;
                    case R.id.rdoF151P:
                        resposta15.setOpcao(4);
                        break;
                    case R.id.rdoF159P:
                        resposta15.setOpcao(5);
                        break;
                }
                resposta15.setNumeroQuestao("P-F15");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 69) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("P-F0"))
                            respostas.set(i, respostaPergunta0);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F5"))
                            respostas.set(i, resposta5);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F6"))
                            respostas.set(i, resposta6);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F7"))
                            respostas.set(i, resposta7);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F8"))
                            respostas.set(i, resposta8);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F9"))
                            respostas.set(i, resposta9);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F10"))
                            respostas.set(i, resposta10);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F11"))
                            respostas.set(i, resposta11);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F12"))
                            respostas.set(i, resposta12);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F13"))
                            respostas.set(i, resposta13);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F14"))
                            respostas.set(i, resposta14);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-F15"))
                            respostas.set(i, resposta15);                        
                    }
                } else {
                    questionario.getRespostas().add(respostaPergunta0);
                    questionario.getRespostas().add(resposta1);
                    questionario.getRespostas().add(resposta2);
                    questionario.getRespostas().add(resposta3);
                    questionario.getRespostas().add(resposta4);
                    questionario.getRespostas().add(resposta5);
                    questionario.getRespostas().add(resposta6);
                    questionario.getRespostas().add(resposta7);
                    questionario.getRespostas().add(resposta8);
                    questionario.getRespostas().add(resposta9);
                    questionario.getRespostas().add(resposta10);
                    questionario.getRespostas().add(resposta11);
                    questionario.getRespostas().add(resposta12);
                    questionario.getRespostas().add(resposta13);
                    questionario.getRespostas().add(resposta14);
                    questionario.getRespostas().add(resposta15);                    
                }

                Componente componente = new Componente();
                componente.setLetraComponente("P-F");
                componente.setEscoreComponente( calcularEscoreComponente() );

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 6){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("P-F"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(ProfissionalF.this, "Escore do Componente F = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),ProfissionalG.class);
                intent.putExtra("questionario", questionario);
                startActivity(intent);
            }
        });
    }

    private boolean ehPossivelCalcularEscoreComponente(){
        double numeroDeRespostasBrancasOuNaoSei = 0;

        // Se ele antender a todas as faixas etarias
        if (respostaPergunta0.getOpcao() == 1) {

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
            if (resposta7.getOpcao() == 0 || resposta7.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta8.getOpcao() == 0 || resposta8.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta9.getOpcao() == 0 || resposta9.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta10.getOpcao() == 0 || resposta10.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta11.getOpcao() == 0 || resposta11.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta12.getOpcao() == 0 || resposta12.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta13.getOpcao() == 0 || resposta13.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta14.getOpcao() == 0 || resposta14.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta15.getOpcao() == 0 || resposta15.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }

            return (numeroDeRespostasBrancasOuNaoSei/15 < 0.5);

        } else if (respostaPergunta0.getOpcao() == 2){ // Se ele atender somente criancas

            if (resposta1.getOpcao() == 0 || resposta1.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta2.getOpcao() == 0 || resposta2.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta3.getOpcao() == 0 || resposta3.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta14.getOpcao() == 0 || resposta14.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta15.getOpcao() == 0 || resposta15.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }

            return (numeroDeRespostasBrancasOuNaoSei/5 < 0.5);

        } else { // Se ele atender somente adultos

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
            if (resposta7.getOpcao() == 0 || resposta7.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta8.getOpcao() == 0 || resposta8.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta9.getOpcao() == 0 || resposta9.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta10.getOpcao() == 0 || resposta10.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta11.getOpcao() == 0 || resposta11.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta12.getOpcao() == 0 || resposta12.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta13.getOpcao() == 0 || resposta13.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }

            return (numeroDeRespostasBrancasOuNaoSei/13 < 0.5);

        }

    }

    private double somatorioDosItens(){
        double somatorioDosItens = 0;

        if (respostaPergunta0.getOpcao() == 1) {

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
            if (resposta10.getOpcao() != 5){
                somatorioDosItens += (5 - resposta10.getOpcao());
            } else {
                somatorioDosItens += 2;
            }
            if (resposta11.getOpcao() != 5){
                somatorioDosItens += (5 - resposta11.getOpcao());
            } else {
                somatorioDosItens += 2;
            }
            if (resposta12.getOpcao() != 5){
                somatorioDosItens += (5 - resposta12.getOpcao());
            } else {
                somatorioDosItens += 2;
            }
            if (resposta13.getOpcao() != 5){
                somatorioDosItens += (5 - resposta13.getOpcao());
            } else {
                somatorioDosItens += 2;
            }
            if (resposta14.getOpcao() != 5){
                somatorioDosItens += (5 - resposta14.getOpcao());
            } else {
                somatorioDosItens += 2;
            }
            if (resposta15.getOpcao() != 5){
                somatorioDosItens += (5 - resposta15.getOpcao());
            } else {
                somatorioDosItens += 2;
            }

        } else if (respostaPergunta0.getOpcao() == 2) {

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
            if (resposta14.getOpcao() != 5){
                somatorioDosItens += (5 - resposta14.getOpcao());
            } else {
                somatorioDosItens += 2;
            }
            if (resposta15.getOpcao() != 5){
                somatorioDosItens += (5 - resposta15.getOpcao());
            } else {
                somatorioDosItens += 2;
            }

        } else {

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
            if (resposta10.getOpcao() != 5){
                somatorioDosItens += (5 - resposta10.getOpcao());
            } else {
                somatorioDosItens += 2;
            }
            if (resposta11.getOpcao() != 5){
                somatorioDosItens += (5 - resposta11.getOpcao());
            } else {
                somatorioDosItens += 2;
            }
            if (resposta12.getOpcao() != 5){
                somatorioDosItens += (5 - resposta12.getOpcao());
            } else {
                somatorioDosItens += 2;
            }
            if (resposta13.getOpcao() != 5){
                somatorioDosItens += (5 - resposta13.getOpcao());
            } else {
                somatorioDosItens += 2;
            }

        }

        return somatorioDosItens;
    }

    public double calcularEscoreComponente(){

        this.escoreComponente = -1;

        double somatorioDosItens = 0;

        if ( this.ehPossivelCalcularEscoreComponente() ){

            somatorioDosItens = this.somatorioDosItens();

            if (respostaPergunta0.getOpcao() == 1) {
                this.escoreComponente = somatorioDosItens / 15;
            } else if (respostaPergunta0.getOpcao() == 2) {
                this.escoreComponente = somatorioDosItens / 5;
            } else {
                this.escoreComponente = somatorioDosItens / 13;
            }

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

        }

        return this.escoreComponente;

    }

}