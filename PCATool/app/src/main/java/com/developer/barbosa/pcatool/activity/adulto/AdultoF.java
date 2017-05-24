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

public class AdultoF extends AppCompatActivity implements ReplaceQuestions {

    private FloatingActionButton fltProximo;

    private RadioGroup rdgRespF1A, rdgRespF2A, rdgRespF3A;
    private TextView txtQuestaoF1A, txtQuestaoF2A, txtQuestaoF3A;

    private Questionario questionario;

    private static String NOME_MEDICO_SERVICO_DEFINIDO = "nome do serviço de saúde / ou nome médico/enfermeiro";
    
    private Resposta resposta1, resposta2, resposta3;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_f);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        this.NOME_MEDICO_SERVICO_DEFINIDO = this.questionario.getRespostas().get(4).getNomeProfServ();

        fltProximo = (FloatingActionButton) findViewById(R.id.fltProximo);
        rdgRespF1A = (RadioGroup) findViewById(R.id.rdgRespF1A);
        rdgRespF2A = (RadioGroup) findViewById(R.id.rdgRespF2A);
        rdgRespF3A = (RadioGroup) findViewById(R.id.rdgRespF3A);
        txtQuestaoF1A = (TextView) findViewById(R.id.txtQuestaoF1A);
        txtQuestaoF2A = (TextView) findViewById(R.id.txtQuestaoF2A);
        txtQuestaoF3A = (TextView) findViewById(R.id.txtQuestaoF3A);

        this.replaceQuestionsAdulto();

        fltProximo.setOnClickListener(new View.OnClickListener() {
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

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 46) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("A-F1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-F2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-F3"))
                            respostas.set(i, resposta3);
                    }
                } else {
                    questionario.getRespostas().add(resposta1);
                    questionario.getRespostas().add(resposta2);
                    questionario.getRespostas().add(resposta3);
                }

                Componente componente = new Componente();
                componente.setLetraComponente("A-F");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 6){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("A-F"))
                            componentes.set(i, componente);
                    }
                } else
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

    @Override
    public void replaceQuestionsAdulto() {
        txtQuestaoF1A.setText( txtQuestaoF1A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoF2A.setText( txtQuestaoF2A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoF3A.setText( txtQuestaoF3A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
    }
}
