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

public class ProfissionalE extends AppCompatActivity {

    private Button btnProximoP;
    private RadioGroup rdgRespE1P, rdgRespE2P, rdgRespE3P, rdgRespE4P, rdgRespE5P, rdgRespE6P,
            rdgRespE7P, rdgRespE8P, rdgRespE9P, rdgRespE10P, rdgRespE11P, rdgRespE12P, rdgRespE13P, rdgRespE14P, rdgRespE15P,
            rdgRespE16P, rdgRespE17P, rdgRespE18P, rdgRespE19P, rdgRespE20P, rdgRespE21P, rdgRespE22P;
    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7, resposta8, resposta9,
            resposta10, resposta11, resposta12, resposta13, resposta14, resposta15, resposta16, resposta17, resposta18, resposta19,
            resposta20, resposta21, resposta22;

    Questionario questionario;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_e);

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        btnProximoP = (Button) findViewById(R.id.btnProximoP);
        rdgRespE1P = (RadioGroup) findViewById(R.id.rdgRespE1P);
        rdgRespE2P = (RadioGroup) findViewById(R.id.rdgRespE2P);
        rdgRespE3P = (RadioGroup) findViewById(R.id.rdgRespE3P);
        rdgRespE4P = (RadioGroup) findViewById(R.id.rdgRespE4P);
        rdgRespE5P = (RadioGroup) findViewById(R.id.rdgRespE5P);
        rdgRespE6P = (RadioGroup) findViewById(R.id.rdgRespE6P);
        rdgRespE7P = (RadioGroup) findViewById(R.id.rdgRespE7P);
        rdgRespE8P = (RadioGroup) findViewById(R.id.rdgRespE8P);
        rdgRespE9P = (RadioGroup) findViewById(R.id.rdgRespE9P);
        rdgRespE10P = (RadioGroup) findViewById(R.id.rdgRespE10P);
        rdgRespE11P = (RadioGroup) findViewById(R.id.rdgRespE11P);
        rdgRespE12P = (RadioGroup) findViewById(R.id.rdgRespE12P);
        rdgRespE13P = (RadioGroup) findViewById(R.id.rdgRespE13P);
        rdgRespE14P = (RadioGroup) findViewById(R.id.rdgRespE14P);
        rdgRespE15P = (RadioGroup) findViewById(R.id.rdgRespE15P);
        rdgRespE16P = (RadioGroup) findViewById(R.id.rdgRespE16P);
        rdgRespE17P = (RadioGroup) findViewById(R.id.rdgRespE17P);
        rdgRespE18P = (RadioGroup) findViewById(R.id.rdgRespE18P);
        rdgRespE19P = (RadioGroup) findViewById(R.id.rdgRespE19P);
        rdgRespE20P = (RadioGroup) findViewById(R.id.rdgRespE20P);
        rdgRespE21P = (RadioGroup) findViewById(R.id.rdgRespE21P);
        rdgRespE22P = (RadioGroup) findViewById(R.id.rdgRespE22P);

        btnProximoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespE1P.getCheckedRadioButtonId()){
                    case R.id.rdoE14P:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoE13P:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoE12P:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoE11P:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoE19P:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("P-E1");

                resposta2 = new Resposta();
                switch (rdgRespE2P.getCheckedRadioButtonId()){
                    case R.id.rdoE24P:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoE23P:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoE22P:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoE21P:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoE29P:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("P-E2");

                resposta3 = new Resposta();
                switch (rdgRespE3P.getCheckedRadioButtonId()){
                    case R.id.rdoE34P:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoE33P:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoE32P:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoE31P:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoE39P:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("P-E3");

                resposta4 = new Resposta();
                switch (rdgRespE4P.getCheckedRadioButtonId()){
                    case R.id.rdoE44P:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoE43P:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoE42P:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoE41P:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoE49P:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("P-E4");

                resposta5 = new Resposta();
                switch (rdgRespE5P.getCheckedRadioButtonId()){
                    case R.id.rdoE54P:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoE53P:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoE52P:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoE51P:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoE59P:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("P-E5");

                resposta6 = new Resposta();
                switch (rdgRespE6P.getCheckedRadioButtonId()){
                    case R.id.rdoE64P:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoE63P:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoE62P:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoE61P:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoE69P:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("P-E6");

                resposta7 = new Resposta();
                switch (rdgRespE7P.getCheckedRadioButtonId()){
                    case R.id.rdoE74P:
                        resposta7.setOpcao(1);
                        break;
                    case R.id.rdoE73P:
                        resposta7.setOpcao(2);
                        break;
                    case R.id.rdoE72P:
                        resposta7.setOpcao(3);
                        break;
                    case R.id.rdoE71P:
                        resposta7.setOpcao(4);
                        break;
                    case R.id.rdoE79P:
                        resposta7.setOpcao(5);
                        break;
                }
                resposta7.setNumeroQuestao("P-E7");

                resposta8 = new Resposta();
                switch (rdgRespE8P.getCheckedRadioButtonId()){
                    case R.id.rdoE84P:
                        resposta8.setOpcao(1);
                        break;
                    case R.id.rdoE83P:
                        resposta8.setOpcao(2);
                        break;
                    case R.id.rdoE82P:
                        resposta8.setOpcao(3);
                        break;
                    case R.id.rdoE81P:
                        resposta8.setOpcao(4);
                        break;
                    case R.id.rdoE89P:
                        resposta8.setOpcao(5);
                        break;
                }
                resposta8.setNumeroQuestao("P-E8");

                resposta9 = new Resposta();
                switch (rdgRespE9P.getCheckedRadioButtonId()){
                    case R.id.rdoE94P:
                        resposta9.setOpcao(1);
                        break;
                    case R.id.rdoE93P:
                        resposta9.setOpcao(2);
                        break;
                    case R.id.rdoE92P:
                        resposta9.setOpcao(3);
                        break;
                    case R.id.rdoE91P:
                        resposta9.setOpcao(4);
                        break;
                    case R.id.rdoE99P:
                        resposta9.setOpcao(5);
                        break;
                }
                resposta9.setNumeroQuestao("P-E9");

                resposta10 = new Resposta();
                switch (rdgRespE10P.getCheckedRadioButtonId()){
                    case R.id.rdoE104P:
                        resposta10.setOpcao(1);
                        break;
                    case R.id.rdoE103P:
                        resposta10.setOpcao(2);
                        break;
                    case R.id.rdoE102P:
                        resposta10.setOpcao(3);
                        break;
                    case R.id.rdoE101P:
                        resposta10.setOpcao(4);
                        break;
                    case R.id.rdoE109P:
                        resposta10.setOpcao(5);
                        break;
                }
                resposta10.setNumeroQuestao("P-E10");

                resposta11 = new Resposta();
                switch (rdgRespE11P.getCheckedRadioButtonId()){
                    case R.id.rdoE114P:
                        resposta11.setOpcao(1);
                        break;
                    case R.id.rdoE113P:
                        resposta11.setOpcao(2);
                        break;
                    case R.id.rdoE112P:
                        resposta11.setOpcao(3);
                        break;
                    case R.id.rdoE111P:
                        resposta11.setOpcao(4);
                        break;
                    case R.id.rdoE119P:
                        resposta11.setOpcao(5);
                        break;
                }
                resposta11.setNumeroQuestao("P-E11");

                resposta12 = new Resposta();
                switch (rdgRespE12P.getCheckedRadioButtonId()){
                    case R.id.rdoE124P:
                        resposta12.setOpcao(1);
                        break;
                    case R.id.rdoE123P:
                        resposta12.setOpcao(2);
                        break;
                    case R.id.rdoE122P:
                        resposta12.setOpcao(3);
                        break;
                    case R.id.rdoE121P:
                        resposta12.setOpcao(4);
                        break;
                    case R.id.rdoE129P:
                        resposta12.setOpcao(5);
                        break;
                }
                resposta12.setNumeroQuestao("P-E12");

                resposta13 = new Resposta();
                switch (rdgRespE13P.getCheckedRadioButtonId()){
                    case R.id.rdoE134P:
                        resposta13.setOpcao(1);
                        break;
                    case R.id.rdoE133P:
                        resposta13.setOpcao(2);
                        break;
                    case R.id.rdoE132P:
                        resposta13.setOpcao(3);
                        break;
                    case R.id.rdoE131P:
                        resposta13.setOpcao(4);
                        break;
                    case R.id.rdoE139P:
                        resposta13.setOpcao(5);
                        break;
                }
                resposta13.setNumeroQuestao("P-E13");

                resposta14 = new Resposta();
                switch (rdgRespE14P.getCheckedRadioButtonId()){
                    case R.id.rdoE144P:
                        resposta14.setOpcao(1);
                        break;
                    case R.id.rdoE143P:
                        resposta14.setOpcao(2);
                        break;
                    case R.id.rdoE142P:
                        resposta14.setOpcao(3);
                        break;
                    case R.id.rdoE141P:
                        resposta14.setOpcao(4);
                        break;
                    case R.id.rdoE149P:
                        resposta14.setOpcao(5);
                        break;
                }
                resposta14.setNumeroQuestao("P-E14");

                resposta15 = new Resposta();
                switch (rdgRespE15P.getCheckedRadioButtonId()){
                    case R.id.rdoE154P:
                        resposta15.setOpcao(1);
                        break;
                    case R.id.rdoE153P:
                        resposta15.setOpcao(2);
                        break;
                    case R.id.rdoE152P:
                        resposta15.setOpcao(3);
                        break;
                    case R.id.rdoE151P:
                        resposta15.setOpcao(4);
                        break;
                    case R.id.rdoE159P:
                        resposta15.setOpcao(5);
                        break;
                }
                resposta15.setNumeroQuestao("P-E15");

                resposta16 = new Resposta();
                switch (rdgRespE16P.getCheckedRadioButtonId()){
                    case R.id.rdoE164P:
                        resposta16.setOpcao(1);
                        break;
                    case R.id.rdoE163P:
                        resposta16.setOpcao(2);
                        break;
                    case R.id.rdoE162P:
                        resposta16.setOpcao(3);
                        break;
                    case R.id.rdoE161P:
                        resposta16.setOpcao(4);
                        break;
                    case R.id.rdoE169P:
                        resposta16.setOpcao(5);
                        break;
                }
                resposta16.setNumeroQuestao("P-E16");

                resposta17 = new Resposta();
                switch (rdgRespE17P.getCheckedRadioButtonId()){
                    case R.id.rdoE174P:
                        resposta17.setOpcao(1);
                        break;
                    case R.id.rdoE173P:
                        resposta17.setOpcao(2);
                        break;
                    case R.id.rdoE172P:
                        resposta17.setOpcao(3);
                        break;
                    case R.id.rdoE171P:
                        resposta17.setOpcao(4);
                        break;
                    case R.id.rdoE179P:
                        resposta17.setOpcao(5);
                        break;
                }
                resposta17.setNumeroQuestao("P-E17");

                resposta18 = new Resposta();
                switch (rdgRespE18P.getCheckedRadioButtonId()){
                    case R.id.rdoE184P:
                        resposta18.setOpcao(1);
                        break;
                    case R.id.rdoE183P:
                        resposta18.setOpcao(2);
                        break;
                    case R.id.rdoE182P:
                        resposta18.setOpcao(3);
                        break;
                    case R.id.rdoE181P:
                        resposta18.setOpcao(4);
                        break;
                    case R.id.rdoE189P:
                        resposta18.setOpcao(5);
                        break;
                }
                resposta18.setNumeroQuestao("P-E18");

                resposta19 = new Resposta();
                switch (rdgRespE19P.getCheckedRadioButtonId()){
                    case R.id.rdoE194P:
                        resposta19.setOpcao(1);
                        break;
                    case R.id.rdoE193P:
                        resposta19.setOpcao(2);
                        break;
                    case R.id.rdoE192P:
                        resposta19.setOpcao(3);
                        break;
                    case R.id.rdoE191P:
                        resposta19.setOpcao(4);
                        break;
                    case R.id.rdoE199P:
                        resposta19.setOpcao(5);
                        break;
                }
                resposta19.setNumeroQuestao("P-E19");

                resposta20 = new Resposta();
                switch (rdgRespE20P.getCheckedRadioButtonId()){
                    case R.id.rdoE204P:
                        resposta20.setOpcao(1);
                        break;
                    case R.id.rdoE203P:
                        resposta20.setOpcao(2);
                        break;
                    case R.id.rdoE202P:
                        resposta20.setOpcao(3);
                        break;
                    case R.id.rdoE201P:
                        resposta20.setOpcao(4);
                        break;
                    case R.id.rdoE209P:
                        resposta20.setOpcao(5);
                        break;
                }
                resposta20.setNumeroQuestao("P-E20");

                resposta21 = new Resposta();
                switch (rdgRespE21P.getCheckedRadioButtonId()){
                    case R.id.rdoE214P:
                        resposta21.setOpcao(1);
                        break;
                    case R.id.rdoE213P:
                        resposta21.setOpcao(2);
                        break;
                    case R.id.rdoE212P:
                        resposta21.setOpcao(3);
                        break;
                    case R.id.rdoE211P:
                        resposta21.setOpcao(4);
                        break;
                    case R.id.rdoE219P:
                        resposta21.setOpcao(5);
                        break;
                }
                resposta21.setNumeroQuestao("P-E21");

                resposta22 = new Resposta();
                switch (rdgRespE22P.getCheckedRadioButtonId()){
                    case R.id.rdoE224P:
                        resposta22.setOpcao(1);
                        break;
                    case R.id.rdoE223P:
                        resposta22.setOpcao(2);
                        break;
                    case R.id.rdoE222P:
                        resposta22.setOpcao(3);
                        break;
                    case R.id.rdoE221P:
                        resposta22.setOpcao(4);
                        break;
                    case R.id.rdoE229P:
                        resposta22.setOpcao(5);
                        break;
                }
                resposta22.setNumeroQuestao("P-E22");

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
                questionario.getRespostas().add(resposta16);
                questionario.getRespostas().add(resposta17);
                questionario.getRespostas().add(resposta18);
                questionario.getRespostas().add(resposta19);
                questionario.getRespostas().add(resposta20);
                questionario.getRespostas().add(resposta21);
                questionario.getRespostas().add(resposta22);

                Componente componente = new Componente();
                componente.setLetraComponente("P-E");
                componente.setEscoreComponente( calcularEscoreComponente() );

                questionario.getComponentes().add(componente);

                Toast.makeText(ProfissionalE.this, "Escore do Componente E = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),ProfissionalF.class);
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
        if (resposta16.getOpcao() == 0 || resposta16.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta17.getOpcao() == 0 || resposta17.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta18.getOpcao() == 0 || resposta18.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta19.getOpcao() == 0 || resposta19.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta20.getOpcao() == 0 || resposta20.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta21.getOpcao() == 0 || resposta21.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }
        if (resposta22.getOpcao() == 0 || resposta22.getOpcao() == 5){
            numeroDeRespostasBrancasOuNaoSei++;
        }

        return (numeroDeRespostasBrancasOuNaoSei/22 < 0.5);
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
        if (resposta16.getOpcao() != 5){
            somatorioDosItens += (5 - resposta16.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta17.getOpcao() != 5){
            somatorioDosItens += (5 - resposta17.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta18.getOpcao() != 5){
            somatorioDosItens += (5 - resposta18.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta19.getOpcao() != 5){
            somatorioDosItens += (5 - resposta19.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta20.getOpcao() != 5){
            somatorioDosItens += (5 - resposta20.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta21.getOpcao() != 5){
            somatorioDosItens += (5 - resposta21.getOpcao());
        } else {
            somatorioDosItens += 2;
        }
        if (resposta22.getOpcao() != 5){
            somatorioDosItens += (5 - resposta22.getOpcao());
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

            this.escoreComponente = somatorioDosItens / 22;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

        }

        return this.escoreComponente;

    }

}