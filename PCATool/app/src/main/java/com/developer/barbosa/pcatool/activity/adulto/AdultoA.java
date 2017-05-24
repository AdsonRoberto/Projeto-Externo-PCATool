package com.developer.barbosa.pcatool.activity.adulto;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.model.domain.Componente;
import com.developer.barbosa.pcatool.model.domain.Questionario;
import com.developer.barbosa.pcatool.model.domain.Resposta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AdultoA extends AppCompatActivity {

    private FloatingActionButton fltProximo;
    private Button btnPreencherAutomaticamente;
    private RadioGroup rdgRespA1A, rdgRespA2A, rdgRespA3A;
    private EditText edtRespA1ANomeProfServ, edtRespA1AEnd, edtRespA2ANomeProfServ, edtRespA2AEnd, edtRespA3ANomeProfServ, edtRespA3AEnd,
            edtRespA4ANomeMedServUlt, edtRespA5ANomeMedServ;
    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5;

    private Questionario questionario;

    // Verificar depois, mas era pra comecar com -1. Deixei 2 por que eh mais facil ser 2 no inicio
    private double escoreComponente = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_a);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        fltProximo = (FloatingActionButton) findViewById(R.id.fltProximo);
        btnPreencherAutomaticamente = (Button) findViewById(R.id.btnPreencherAutomaticamente);
        rdgRespA1A = (RadioGroup) findViewById(R.id.rdgRespA1A);
        rdgRespA2A = (RadioGroup) findViewById(R.id.rdgRespA2A);
        rdgRespA3A = (RadioGroup) findViewById(R.id.rdgRespA3A);
        edtRespA1ANomeProfServ = (EditText) findViewById(R.id.edtRespA1ANomeProfServ);
        edtRespA1AEnd = (EditText) findViewById(R.id.edtRespA1AEnd);
        edtRespA2ANomeProfServ = (EditText) findViewById(R.id.edtRespA2ANomeProfServ);
        edtRespA2AEnd = (EditText) findViewById(R.id.edtRespA2AEnd);
        edtRespA3ANomeProfServ = (EditText) findViewById(R.id.edtRespA3ANomeProfServ);
        edtRespA3AEnd = (EditText) findViewById(R.id.edtRespA3AEnd);
        edtRespA4ANomeMedServUlt = (EditText) findViewById(R.id.edtRespA4ANomeMedServUlt);
        edtRespA5ANomeMedServ = (EditText) findViewById(R.id.edtRespA5ANomeMedServ);

        fltProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespA1A.getCheckedRadioButtonId()){
                    case R.id.rdoNaoA1A:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoSimA1A:
                        resposta1.setOpcao(2);
                        resposta1.setNomeProfServ(edtRespA1ANomeProfServ.getText().toString());
                        resposta1.setEndereco(edtRespA1AEnd.getText().toString());
                        break;
                }
                resposta1.setNumeroQuestao("A-A1");
                // Questionario da Resposta seta so no fim

                resposta2 = new Resposta();
                switch (rdgRespA2A.getCheckedRadioButtonId()){
                    case R.id.rdoNaoA2A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoSim1A2A:
                        resposta2.setOpcao(2);
                        // Aqui pode haver um verificação do Medico ou Serviço da questao anterior
                        // Sim, mesmo médico/enfermeiro/serviço de saúde que acima
                        break;
                    case R.id.rdoSim2A2A:
                        resposta2.setOpcao(3);
                        resposta2.setNomeProfServ(edtRespA2ANomeProfServ.getText().toString());
                        resposta2.setEndereco(edtRespA2AEnd.getText().toString());
                        break;
                }
                resposta2.setNumeroQuestao("A-A2");

                resposta3 = new Resposta();
                switch (rdgRespA3A.getCheckedRadioButtonId()){
                    case R.id.rdoNaoA3A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoSim1A3A:
                        resposta3.setOpcao(2);
                        // Aqui pode haver um verificação do Medico ou Serviço da questao anterior
                        // Sim, mesmo médico/enfermeiro/serviço de saúde que acima
                        break;
                    case R.id.rdoSim2A3A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoSim3A3A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoSim4A3A:
                        resposta3.setOpcao(5);
                        resposta3.setNomeProfServ(edtRespA3ANomeProfServ.getText().toString());
                        resposta3.setEndereco(edtRespA3AEnd.getText().toString());
                        break;
                }
                resposta3.setNumeroQuestao("A-A3");

                resposta4 = new Resposta();
                resposta4.setNomeProfServ(edtRespA4ANomeMedServUlt.getText().toString());
                resposta4.setNumeroQuestao("A-A4");

                resposta5 = new Resposta();
                resposta5.setNomeProfServ(edtRespA5ANomeMedServ.getText().toString());
                resposta5.setNumeroQuestao("A-A5");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 5) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("A-A1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-A2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-A3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-A4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-A5"))
                            respostas.set(i, resposta5);
                    }
                } else {
                    questionario.getRespostas().add(resposta1);
                    questionario.getRespostas().add(resposta2);
                    questionario.getRespostas().add(resposta3);
                    questionario.getRespostas().add(resposta4);
                    questionario.getRespostas().add(resposta5);
                }

                Componente componente = new Componente();
                componente.setLetraComponente("A-A");
                componente.setEscoreComponente( calcularEscoreComponente() );

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 1){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("A-A"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(AdultoA.this, "Escore do Componente A = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),AdultoB.class);
                intent.putExtra("questionario", questionario);
                startActivity(intent);
            }
        });

        btnPreencherAutomaticamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                identificarMedicoServicoAutomaticamente();
            }
        });
    }

    private void identificarMedicoServicoAutomaticamente(){

        Resposta resposta1 = new Resposta();
        switch (rdgRespA1A.getCheckedRadioButtonId()){
            case R.id.rdoNaoA1A:
                resposta1.setOpcao(1);
                break;
            case R.id.rdoSimA1A:
                resposta1.setOpcao(2);
                resposta1.setNomeProfServ(edtRespA1ANomeProfServ.getText().toString());
                resposta1.setEndereco(edtRespA1AEnd.getText().toString());
                break;
        }

        Resposta resposta2 = new Resposta();
        switch (rdgRespA2A.getCheckedRadioButtonId()){
            case R.id.rdoNaoA2A:
                resposta2.setOpcao(1);
                break;
            case R.id.rdoSim1A2A:
                resposta2.setOpcao(2);
                // Aqui pode haver um verificação do Medico ou Serviço da questao anterior
                // Sim, mesmo médico/enfermeiro/serviço de saúde que acima
                break;
            case R.id.rdoSim2A2A:
                resposta2.setOpcao(3);
                resposta2.setNomeProfServ(edtRespA2ANomeProfServ.getText().toString());
                resposta2.setEndereco(edtRespA2AEnd.getText().toString());
                break;
        }

        Resposta resposta3 = new Resposta();
        switch (rdgRespA3A.getCheckedRadioButtonId()){
            case R.id.rdoNaoA3A:
                resposta3.setOpcao(1);
                break;
            case R.id.rdoSim1A3A:
                resposta3.setOpcao(2);
                // Aqui pode haver um verificação do Medico ou Serviço da questao anterior
                // Sim, mesmo médico/enfermeiro/serviço de saúde que acima
                break;
            case R.id.rdoSim2A3A:
                resposta3.setOpcao(3);
                break;
            case R.id.rdoSim3A3A:
                resposta3.setOpcao(4);
                break;
            case R.id.rdoSim4A3A:
                resposta3.setOpcao(5);
                resposta3.setNomeProfServ(edtRespA3ANomeProfServ.getText().toString());
                resposta3.setEndereco(edtRespA3AEnd.getText().toString());
                break;
        }

        // Se o entrevistado indicou o mesmo serviço de saúde nas três perguntas, continue o restante do questionário
        // sobre esse médico/enfermeiro ou serviço de saúde. (Preencha o item A5).
        if ( resposta1.getOpcao() == 2 && resposta2.getOpcao() == 2 && resposta3.getOpcao() == 2){
            edtRespA5ANomeMedServ.setText( resposta1.getNomeProfServ() );
        } else {

            // Se o entrevistado respondeu duas perguntas iguais, continue o restante do questionário sobre esse médico/enfermeiro ou
            // serviço de saúde (Preencha o item A5).
            if ( resposta1.getOpcao() == 2 && resposta2.getOpcao() == 2 && (resposta3.getOpcao() == 1 || resposta3.getOpcao() == 5) ) {
                edtRespA5ANomeMedServ.setText( resposta1.getNomeProfServ() );
            } else if ( resposta1.getOpcao() == 2 && resposta3.getOpcao() == 3 && ( resposta2.getOpcao() == 1 || resposta2.getOpcao() == 3 ) ) {
                edtRespA5ANomeMedServ.setText( resposta1.getNomeProfServ() );
            } else if ( resposta2.getOpcao() == 3 && resposta3.getOpcao() == 4 ) {
                edtRespA5ANomeMedServ.setText(resposta2.getNomeProfServ());
            } else {

                // Se todos as respostas forem diferentes, continue o restante do questionário sobre o médico/ enfermeiro ou serviço
                // de saúde identificado na pergunta A1 (Preencha o item A5).
                if ( resposta1.getOpcao() == 2 && resposta2.getOpcao() == 3 && resposta3.getOpcao() == 5){
                    edtRespA5ANomeMedServ.setText(resposta1.getNomeProfServ());
                } else {

                    // Se o entrevistado respondeu NÃO a duas perguntas, continue o restante do questionário sobre esse médico/enfermeiro ou serviço
                    // de saúde identificado na pergunta à qual o entrevistado respondeu SIM. (Preencha o item A5).
                    if (resposta1.getOpcao() == 1 && resposta2.getOpcao() == 1 && (resposta3.getOpcao() != 1 || resposta3.getOpcao() == 5)) {
                        edtRespA5ANomeMedServ.setText(resposta3.getNomeProfServ());
                    } else if (resposta1.getOpcao() == 1 && resposta3.getOpcao() == 1 && (resposta2.getOpcao() != 1 || resposta2.getOpcao() == 3)){
                        edtRespA5ANomeMedServ.setText(resposta2.getNomeProfServ());
                    } else if (resposta2.getOpcao() == 1 && resposta3.getOpcao() == 1 && (resposta1.getOpcao() != 1 || resposta1.getOpcao() == 2)){
                        edtRespA5ANomeMedServ.setText(resposta1.getNomeProfServ());
                    } else {

                        // Se o entrevistado responder NÃO à pergunta A1 e indicar respostas diferentes para as perguntas A2 e A3,
                        // continue o restante do questionário sobre esse médico/enfermeiro ou serviço de saúde indicado na respostas A3 (Preencha o item A5).
                        if (resposta1.getOpcao() == 1 && resposta2.getOpcao() == 3 && resposta3.getOpcao() == 5) {
                            edtRespA5ANomeMedServ.setText(resposta3.getNomeProfServ());
                        } else {

                            // Se o entrevistado respondeu NÃO a todas as três perguntas, por favor pergunte o nome do último médico/enfermeiro
                            // ou serviço de saúde onde a criança consultou e continue o restante do questionário sobre esse médico/enfermeiro ou
                            // serviço de saúde (Preencha o item A4 e A5).
                            if (resposta1.getOpcao() == 1 && resposta2.getOpcao() == 1 && resposta3.getOpcao() == 1) {
                                if(!edtRespA4ANomeMedServUlt.getText().toString().equals("")){
                                    edtRespA5ANomeMedServ.setText(edtRespA4ANomeMedServUlt.getText().toString());
                                } else {
                                    Toast.makeText(this, "Por favor, pergunte qual o nome do último médico/enfermeiro ou serviço de saúde onde a criança consultou e preencha os itens A4 e A5.", Toast.LENGTH_LONG).show();
                                }

                            } else {
                                Toast.makeText(this, "Não foi possível identificar automaticamente. Verifique suas respostas e tente novamente.", Toast.LENGTH_LONG).show();
                            }

                        }

                    }

                }

            }

        }
    }

    private double calcularEscoreComponente(){

        this.escoreComponente = 2;

        if ( resposta1.getOpcao() == 1 && resposta2.getOpcao() == 1 && resposta3.getOpcao() == 1){
            escoreComponente = 1;
        } else {

            if ( resposta1.getOpcao() == 2 && resposta2.getOpcao() == 3 && resposta3.getOpcao() == 5){
                escoreComponente = 2;
            } else {

                // Se o entrevistado respondeu NÃO a duas perguntas, continue o restante do questionário sobre esse médico/enfermeiro ou serviço
                // de saúde identificado na pergunta à qual o entrevistado respondeu SIM. (Preencha o item A5).
                if (resposta1.getOpcao() == 1 && resposta2.getOpcao() == 1 && (resposta3.getOpcao() != 1 || resposta3.getOpcao() == 5)) {
                    escoreComponente = 2;
                } else if (resposta1.getOpcao() == 1 && resposta3.getOpcao() == 1 && (resposta2.getOpcao() != 1 || resposta2.getOpcao() == 3)){
                    escoreComponente = 2;
                } else if (resposta2.getOpcao() == 1 && resposta3.getOpcao() == 1 && (resposta1.getOpcao() != 1 || resposta1.getOpcao() == 2)){
                    escoreComponente = 2;
                } else {

                    if (resposta1.getOpcao() == 1 && resposta2.getOpcao() == 3 && resposta3.getOpcao() == 5) {
                        escoreComponente = 2;
                    } else {

                        if ( resposta1.getOpcao() == 2 && resposta2.getOpcao() == 2 && (resposta3.getOpcao() == 1 || resposta3.getOpcao() == 5) ) {
                            escoreComponente = 3;
                        } else if ( resposta1.getOpcao() == 2 && resposta3.getOpcao() == 3 && ( resposta2.getOpcao() == 1 || resposta2.getOpcao() == 3 ) ) {
                            escoreComponente = 3;
                        } else if ( resposta2.getOpcao() == 3 && resposta3.getOpcao() == 4 ) {
                            escoreComponente = 3;
                        } else {

                            if ( resposta1.getOpcao() == 2 && resposta2.getOpcao() == 2 && resposta3.getOpcao() == 2){
                                escoreComponente = 4;
                            }

                        }

                    }

                }

            }
        }

        BigDecimal a = new BigDecimal(this.escoreComponente);
        this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

        // Transformacao do Escore
        // this.escoreComponente = ((this.escoreComponente - 1) * 10)/3;

        return this.escoreComponente;

    }

}
