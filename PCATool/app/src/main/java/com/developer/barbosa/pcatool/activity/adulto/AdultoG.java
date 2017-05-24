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

public class AdultoG extends AppCompatActivity implements ReplaceQuestions{

    private FloatingActionButton fltProximo;

    private RadioGroup rdgRespG1A, rdgRespG2A, rdgRespG3A, rdgRespG4A, rdgRespG5A, rdgRespG6A, rdgRespG7A,
            rdgRespG8A, rdgRespG9A, rdgRespG10A, rdgRespG11A, rdgRespG12A, rdgRespG13A, rdgRespG14A,
            rdgRespG15A, rdgRespG16A, rdgRespG17A, rdgRespG18A, rdgRespG19A, rdgRespG20A, rdgRespG21A,
            rdgRespG22A;
    private TextView txtDescricao2GA, txtDescricao3GA;

    private Questionario questionario;

    private static String NOME_MEDICO_SERVICO_DEFINIDO = "nome do serviço de saúde / ou nome médico/enfermeiro";

    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7, resposta8,
            resposta9, resposta10, resposta11, resposta12, resposta13, resposta14, resposta15, resposta16,
            resposta17, resposta18, resposta19, resposta20, resposta21, resposta22;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_g);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        this.NOME_MEDICO_SERVICO_DEFINIDO = this.questionario.getRespostas().get(4).getNomeProfServ();

        fltProximo = (FloatingActionButton) findViewById(R.id.fltProximo);
        rdgRespG1A = (RadioGroup) findViewById(R.id.rdgRespG1A);
        rdgRespG2A = (RadioGroup) findViewById(R.id.rdgRespG2A);
        rdgRespG3A = (RadioGroup) findViewById(R.id.rdgRespG3A);
        rdgRespG4A = (RadioGroup) findViewById(R.id.rdgRespG4A);
        rdgRespG5A = (RadioGroup) findViewById(R.id.rdgRespG5A);
        rdgRespG6A = (RadioGroup) findViewById(R.id.rdgRespG6A);
        rdgRespG7A = (RadioGroup) findViewById(R.id.rdgRespG7A);
        rdgRespG8A = (RadioGroup) findViewById(R.id.rdgRespG8A);
        rdgRespG9A = (RadioGroup) findViewById(R.id.rdgRespG9A);
        rdgRespG10A = (RadioGroup) findViewById(R.id.rdgRespG10A);
        rdgRespG11A = (RadioGroup) findViewById(R.id.rdgRespG11A);
        rdgRespG12A = (RadioGroup) findViewById(R.id.rdgRespG12A);
        rdgRespG13A = (RadioGroup) findViewById(R.id.rdgRespG13A);
        rdgRespG14A = (RadioGroup) findViewById(R.id.rdgRespG14A);
        rdgRespG15A = (RadioGroup) findViewById(R.id.rdgRespG15A);
        rdgRespG16A = (RadioGroup) findViewById(R.id.rdgRespG16A);
        rdgRespG17A = (RadioGroup) findViewById(R.id.rdgRespG17A);
        rdgRespG18A = (RadioGroup) findViewById(R.id.rdgRespG18A);
        rdgRespG19A = (RadioGroup) findViewById(R.id.rdgRespG19A);
        rdgRespG20A = (RadioGroup) findViewById(R.id.rdgRespG20A);
        rdgRespG21A = (RadioGroup) findViewById(R.id.rdgRespG21A);
        rdgRespG22A = (RadioGroup) findViewById(R.id.rdgRespG22A);
        txtDescricao2GA = (TextView) findViewById(R.id.txtDescricao2GA);
        txtDescricao3GA = (TextView) findViewById(R.id.txtDescricao3GA);

        this.replaceQuestionsAdulto();

        fltProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespG1A.getCheckedRadioButtonId()){
                    case R.id.rdoG14A:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoG13A:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoG12A:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoG11A:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoG19A:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("A-G1");

                resposta2 = new Resposta();
                switch (rdgRespG2A.getCheckedRadioButtonId()){
                    case R.id.rdoG24A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoG23A:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoG22A:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoG21A:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoG29A:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("A-G2");

                resposta3 = new Resposta();
                switch (rdgRespG3A.getCheckedRadioButtonId()){
                    case R.id.rdoG34A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoG33A:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoG32A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoG31A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoG39A:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("A-G3");

                resposta4 = new Resposta();
                switch (rdgRespG4A.getCheckedRadioButtonId()){
                    case R.id.rdoG44A:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoG43A:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoG42A:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoG41A:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoG49A:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("A-G4");

                resposta5 = new Resposta();
                switch (rdgRespG5A.getCheckedRadioButtonId()){
                    case R.id.rdoG54A:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoG53A:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoG52A:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoG51A:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoG59A:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("A-G5");

                resposta6 = new Resposta();
                switch (rdgRespG6A.getCheckedRadioButtonId()){
                    case R.id.rdoG64A:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoG63A:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoG62A:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoG61A:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoG69A:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("A-G6");

                resposta7 = new Resposta();
                switch (rdgRespG7A.getCheckedRadioButtonId()){
                    case R.id.rdoG74A:
                        resposta7.setOpcao(1);
                        break;
                    case R.id.rdoG73A:
                        resposta7.setOpcao(2);
                        break;
                    case R.id.rdoG72A:
                        resposta7.setOpcao(3);
                        break;
                    case R.id.rdoG71A:
                        resposta7.setOpcao(4);
                        break;
                    case R.id.rdoG79A:
                        resposta7.setOpcao(5);
                        break;
                }
                resposta7.setNumeroQuestao("A-G7");

                resposta8 = new Resposta();
                switch (rdgRespG8A.getCheckedRadioButtonId()){
                    case R.id.rdoG84A:
                        resposta8.setOpcao(1);
                        break;
                    case R.id.rdoG83A:
                        resposta8.setOpcao(2);
                        break;
                    case R.id.rdoG82A:
                        resposta8.setOpcao(3);
                        break;
                    case R.id.rdoG81A:
                        resposta8.setOpcao(4);
                        break;
                    case R.id.rdoG89A:
                        resposta8.setOpcao(5);
                        break;
                }
                resposta8.setNumeroQuestao("A-G8");

                resposta9 = new Resposta();
                switch (rdgRespG9A.getCheckedRadioButtonId()){
                    case R.id.rdoG94A:
                        resposta9.setOpcao(1);
                        break;
                    case R.id.rdoG93A:
                        resposta9.setOpcao(2);
                        break;
                    case R.id.rdoG92A:
                        resposta9.setOpcao(3);
                        break;
                    case R.id.rdoG91A:
                        resposta9.setOpcao(4);
                        break;
                    case R.id.rdoG99A:
                        resposta9.setOpcao(5);
                        break;
                }
                resposta9.setNumeroQuestao("A-G9");

                resposta10 = new Resposta();
                switch (rdgRespG10A.getCheckedRadioButtonId()){
                    case R.id.rdoG104A:
                        resposta10.setOpcao(1);
                        break;
                    case R.id.rdoG103A:
                        resposta10.setOpcao(2);
                        break;
                    case R.id.rdoG102A:
                        resposta10.setOpcao(3);
                        break;
                    case R.id.rdoG101A:
                        resposta10.setOpcao(4);
                        break;
                    case R.id.rdoG109A:
                        resposta10.setOpcao(5);
                        break;
                }
                resposta10.setNumeroQuestao("A-G10");

                resposta11 = new Resposta();
                switch (rdgRespG11A.getCheckedRadioButtonId()){
                    case R.id.rdoG114A:
                        resposta11.setOpcao(1);
                        break;
                    case R.id.rdoG113A:
                        resposta11.setOpcao(2);
                        break;
                    case R.id.rdoG112A:
                        resposta11.setOpcao(3);
                        break;
                    case R.id.rdoG111A:
                        resposta11.setOpcao(4);
                        break;
                    case R.id.rdoG119A:
                        resposta11.setOpcao(5);
                        break;
                }
                resposta11.setNumeroQuestao("A-G11");

                resposta12 = new Resposta();
                switch (rdgRespG12A.getCheckedRadioButtonId()){
                    case R.id.rdoG124A:
                        resposta12.setOpcao(1);
                        break;
                    case R.id.rdoG123A:
                        resposta12.setOpcao(2);
                        break;
                    case R.id.rdoG122A:
                        resposta12.setOpcao(3);
                        break;
                    case R.id.rdoG121A:
                        resposta12.setOpcao(4);
                        break;
                    case R.id.rdoG129A:
                        resposta12.setOpcao(5);
                        break;
                }
                resposta12.setNumeroQuestao("A-G12");

                resposta13 = new Resposta();
                switch (rdgRespG13A.getCheckedRadioButtonId()){
                    case R.id.rdoG134A:
                        resposta13.setOpcao(1);
                        break;
                    case R.id.rdoG133A:
                        resposta13.setOpcao(2);
                        break;
                    case R.id.rdoG132A:
                        resposta13.setOpcao(3);
                        break;
                    case R.id.rdoG131A:
                        resposta13.setOpcao(4);
                        break;
                    case R.id.rdoG139A:
                        resposta13.setOpcao(5);
                        break;
                }
                resposta13.setNumeroQuestao("A-G13");

                resposta14 = new Resposta();
                switch (rdgRespG14A.getCheckedRadioButtonId()){
                    case R.id.rdoG144A:
                        resposta14.setOpcao(1);
                        break;
                    case R.id.rdoG143A:
                        resposta14.setOpcao(2);
                        break;
                    case R.id.rdoG142A:
                        resposta14.setOpcao(3);
                        break;
                    case R.id.rdoG141A:
                        resposta14.setOpcao(4);
                        break;
                    case R.id.rdoG149A:
                        resposta14.setOpcao(5);
                        break;
                }
                resposta14.setNumeroQuestao("A-G14");

                resposta15 = new Resposta();
                switch (rdgRespG15A.getCheckedRadioButtonId()){
                    case R.id.rdoG154A:
                        resposta15.setOpcao(1);
                        break;
                    case R.id.rdoG153A:
                        resposta15.setOpcao(2);
                        break;
                    case R.id.rdoG152A:
                        resposta15.setOpcao(3);
                        break;
                    case R.id.rdoG151A:
                        resposta15.setOpcao(4);
                        break;
                    case R.id.rdoG159A:
                        resposta15.setOpcao(5);
                        break;
                }
                resposta15.setNumeroQuestao("A-G15");

                resposta16 = new Resposta();
                switch (rdgRespG16A.getCheckedRadioButtonId()){
                    case R.id.rdoG164A:
                        resposta16.setOpcao(1);
                        break;
                    case R.id.rdoG163A:
                        resposta16.setOpcao(2);
                        break;
                    case R.id.rdoG162A:
                        resposta16.setOpcao(3);
                        break;
                    case R.id.rdoG161A:
                        resposta16.setOpcao(4);
                        break;
                    case R.id.rdoG169A:
                        resposta16.setOpcao(5);
                        break;
                }
                resposta16.setNumeroQuestao("A-G16");

                resposta17 = new Resposta();
                switch (rdgRespG17A.getCheckedRadioButtonId()){
                    case R.id.rdoG174A:
                        resposta17.setOpcao(1);
                        break;
                    case R.id.rdoG173A:
                        resposta17.setOpcao(2);
                        break;
                    case R.id.rdoG172A:
                        resposta17.setOpcao(3);
                        break;
                    case R.id.rdoG171A:
                        resposta17.setOpcao(4);
                        break;
                    case R.id.rdoG179A:
                        resposta17.setOpcao(5);
                        break;
                }
                resposta17.setNumeroQuestao("A-G17");

                resposta18 = new Resposta();
                switch (rdgRespG18A.getCheckedRadioButtonId()){
                    case R.id.rdoG184A:
                        resposta18.setOpcao(1);
                        break;
                    case R.id.rdoG183A:
                        resposta18.setOpcao(2);
                        break;
                    case R.id.rdoG182A:
                        resposta18.setOpcao(3);
                        break;
                    case R.id.rdoG181A:
                        resposta18.setOpcao(4);
                        break;
                    case R.id.rdoG189A:
                        resposta18.setOpcao(5);
                        break;
                }
                resposta18.setNumeroQuestao("A-G18");

                resposta19 = new Resposta();
                switch (rdgRespG19A.getCheckedRadioButtonId()){
                    case R.id.rdoG194A:
                        resposta19.setOpcao(1);
                        break;
                    case R.id.rdoG193A:
                        resposta19.setOpcao(2);
                        break;
                    case R.id.rdoG192A:
                        resposta19.setOpcao(3);
                        break;
                    case R.id.rdoG191A:
                        resposta19.setOpcao(4);
                        break;
                    case R.id.rdoG199A:
                        resposta19.setOpcao(5);
                        break;
                }
                resposta19.setNumeroQuestao("A-G19");

                resposta20 = new Resposta();
                switch (rdgRespG20A.getCheckedRadioButtonId()){
                    case R.id.rdoG204A:
                        resposta20.setOpcao(1);
                        break;
                    case R.id.rdoG203A:
                        resposta20.setOpcao(2);
                        break;
                    case R.id.rdoG202A:
                        resposta20.setOpcao(3);
                        break;
                    case R.id.rdoG201A:
                        resposta20.setOpcao(4);
                        break;
                    case R.id.rdoG209A:
                        resposta20.setOpcao(5);
                        break;
                }
                resposta20.setNumeroQuestao("A-G20");

                resposta21 = new Resposta();
                switch (rdgRespG21A.getCheckedRadioButtonId()){
                    case R.id.rdoG214A:
                        resposta21.setOpcao(1);
                        break;
                    case R.id.rdoG213A:
                        resposta21.setOpcao(2);
                        break;
                    case R.id.rdoG212A:
                        resposta21.setOpcao(3);
                        break;
                    case R.id.rdoG211A:
                        resposta21.setOpcao(4);
                        break;
                    case R.id.rdoG219A:
                        resposta21.setOpcao(5);
                        break;
                }
                resposta21.setNumeroQuestao("A-G21");

                resposta22 = new Resposta();
                switch (rdgRespG22A.getCheckedRadioButtonId()){
                    case R.id.rdoG224A:
                        resposta22.setOpcao(1);
                        break;
                    case R.id.rdoG223A:
                        resposta22.setOpcao(2);
                        break;
                    case R.id.rdoG222A:
                        resposta22.setOpcao(3);
                        break;
                    case R.id.rdoG221A:
                        resposta22.setOpcao(4);
                        break;
                    case R.id.rdoG229A:
                        resposta22.setOpcao(5);
                        break;
                }
                resposta22.setNumeroQuestao("A-G22");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 68) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("A-G1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G5"))
                            respostas.set(i, resposta5);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G6"))
                            respostas.set(i, resposta6);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G7"))
                            respostas.set(i, resposta7);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G8"))
                            respostas.set(i, resposta8);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G9"))
                            respostas.set(i, resposta9);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G10"))
                            respostas.set(i, resposta10);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G11"))
                            respostas.set(i, resposta11);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G12"))
                            respostas.set(i, resposta12);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G13"))
                            respostas.set(i, resposta13);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G14"))
                            respostas.set(i, resposta14);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G15"))
                            respostas.set(i, resposta15);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G16"))
                            respostas.set(i, resposta16);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G17"))
                            respostas.set(i, resposta17);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G18"))
                            respostas.set(i, resposta18);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G19"))
                            respostas.set(i, resposta19);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G20"))
                            respostas.set(i, resposta20);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G21"))
                            respostas.set(i, resposta21);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-G22"))
                            respostas.set(i, resposta22);                        
                    }
                } else {
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
                }
                
                Componente componente = new Componente();
                componente.setLetraComponente("A-G");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 7){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("A-G"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(AdultoG.this, "Escore do Componente G = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),AdultoH.class);
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

        System.out.println("Resposta brancas ou nao sei = " + numeroDeRespostasBrancasOuNaoSei);

        return numeroDeRespostasBrancasOuNaoSei/22 < 0.5;
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

            this.escoreComponente = somatorioDosItens / 22;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

            // Transformacao do Escore
            // this.escoreComponente = ((this.escoreComponente - 1) * 10)/3;

        }

        return this.escoreComponente;

    }

    @Override
    public void replaceQuestionsAdulto() {
        txtDescricao2GA.setText( txtDescricao2GA.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtDescricao3GA.setText( txtDescricao3GA.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
    }
}
