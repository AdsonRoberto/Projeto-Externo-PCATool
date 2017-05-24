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

public class AdultoD extends AppCompatActivity implements ReplaceQuestions{

    private FloatingActionButton fltProximo;

    private RadioGroup rdgRespD1A, rdgRespD2A, rdgRespD3A, rdgRespD4A, rdgRespD5A, rdgRespD6A, rdgRespD7A,
            rdgRespD8A, rdgRespD9A, rdgRespD10A, rdgRespD11A, rdgRespD12A, rdgRespD13A, rdgRespD14A;
    private TextView txtQuestaoD1A, txtQuestaoD14A;

    private Questionario questionario;

    private static String NOME_MEDICO_SERVICO_DEFINIDO = "nome do serviço de saúde / ou nome médico/enfermeiro";

    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7, resposta8,
            resposta9, resposta10, resposta11, resposta12, resposta13, resposta14;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_d);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        this.NOME_MEDICO_SERVICO_DEFINIDO = this.questionario.getRespostas().get(4).getNomeProfServ();

        fltProximo = (FloatingActionButton) findViewById(R.id.fltProximo);
        rdgRespD1A = (RadioGroup) findViewById(R.id.rdgRespD1A);
        rdgRespD2A = (RadioGroup) findViewById(R.id.rdgRespD2A);
        rdgRespD3A = (RadioGroup) findViewById(R.id.rdgRespD3A);
        rdgRespD4A = (RadioGroup) findViewById(R.id.rdgRespD4A);
        rdgRespD5A = (RadioGroup) findViewById(R.id.rdgRespD5A);
        rdgRespD6A = (RadioGroup) findViewById(R.id.rdgRespD6A);
        rdgRespD7A = (RadioGroup) findViewById(R.id.rdgRespD7A);
        rdgRespD8A = (RadioGroup) findViewById(R.id.rdgRespD8A);
        rdgRespD9A = (RadioGroup) findViewById(R.id.rdgRespD9A);
        rdgRespD10A = (RadioGroup) findViewById(R.id.rdgRespD10A);
        rdgRespD11A = (RadioGroup) findViewById(R.id.rdgRespD11A);
        rdgRespD12A = (RadioGroup) findViewById(R.id.rdgRespD12A);
        rdgRespD13A = (RadioGroup) findViewById(R.id.rdgRespD13A);
        rdgRespD14A = (RadioGroup) findViewById(R.id.rdgRespD14A);
        txtQuestaoD1A = (TextView) findViewById(R.id.txtQuestaoD1A);
        txtQuestaoD14A = (TextView) findViewById(R.id.txtQuestaoD14A);

        this.replaceQuestionsAdulto();

        fltProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespD1A.getCheckedRadioButtonId()){
                    case R.id.rdoD14A:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoD13A:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoD12A:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoD11A:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoD19A:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("A-D1");

                resposta2 = new Resposta();
                switch (rdgRespD2A.getCheckedRadioButtonId()){
                    case R.id.rdoD24A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoD23A:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoD22A:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoD21A:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoD29A:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("A-D2");

                resposta3 = new Resposta();
                switch (rdgRespD3A.getCheckedRadioButtonId()){
                    case R.id.rdoD34A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoD33A:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoD32A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoD31A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoD39A:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("A-D3");

                resposta4 = new Resposta();
                switch (rdgRespD4A.getCheckedRadioButtonId()){
                    case R.id.rdoD44A:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoD43A:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoD42A:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoD41A:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoD49A:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("A-D4");

                resposta5 = new Resposta();
                switch (rdgRespD5A.getCheckedRadioButtonId()){
                    case R.id.rdoD54A:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoD53A:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoD52A:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoD51A:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoD59A:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("A-D5");

                resposta6 = new Resposta();
                switch (rdgRespD6A.getCheckedRadioButtonId()){
                    case R.id.rdoD64A:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoD63A:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoD62A:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoD61A:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoD69A:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("A-D6");

                resposta7 = new Resposta();
                switch (rdgRespD7A.getCheckedRadioButtonId()){
                    case R.id.rdoD74A:
                        resposta7.setOpcao(1);
                        break;
                    case R.id.rdoD73A:
                        resposta7.setOpcao(2);
                        break;
                    case R.id.rdoD72A:
                        resposta7.setOpcao(3);
                        break;
                    case R.id.rdoD71A:
                        resposta7.setOpcao(4);
                        break;
                    case R.id.rdoD79A:
                        resposta7.setOpcao(5);
                        break;
                }
                resposta7.setNumeroQuestao("A-D7");

                resposta8 = new Resposta();
                switch (rdgRespD8A.getCheckedRadioButtonId()){
                    case R.id.rdoD84A:
                        resposta8.setOpcao(1);
                        break;
                    case R.id.rdoD83A:
                        resposta8.setOpcao(2);
                        break;
                    case R.id.rdoD82A:
                        resposta8.setOpcao(3);
                        break;
                    case R.id.rdoD81A:
                        resposta8.setOpcao(4);
                        break;
                    case R.id.rdoD89A:
                        resposta8.setOpcao(5);
                        break;
                }
                resposta8.setNumeroQuestao("A-D8");

                resposta9 = new Resposta();
                switch (rdgRespD9A.getCheckedRadioButtonId()){
                    case R.id.rdoD94A:
                        resposta9.setOpcao(1);
                        break;
                    case R.id.rdoD93A:
                        resposta9.setOpcao(2);
                        break;
                    case R.id.rdoD92A:
                        resposta9.setOpcao(3);
                        break;
                    case R.id.rdoD91A:
                        resposta9.setOpcao(4);
                        break;
                    case R.id.rdoD99A:
                        resposta9.setOpcao(5);
                        break;
                }
                resposta9.setNumeroQuestao("A-D9");

                resposta10 = new Resposta();
                switch (rdgRespD10A.getCheckedRadioButtonId()){
                    case R.id.rdoD104A:
                        resposta10.setOpcao(1);
                        break;
                    case R.id.rdoD103A:
                        resposta10.setOpcao(2);
                        break;
                    case R.id.rdoD102A:
                        resposta10.setOpcao(3);
                        break;
                    case R.id.rdoD101A:
                        resposta10.setOpcao(4);
                        break;
                    case R.id.rdoD109A:
                        resposta10.setOpcao(5);
                        break;
                }
                resposta10.setNumeroQuestao("A-D10");

                resposta11 = new Resposta();
                switch (rdgRespD11A.getCheckedRadioButtonId()){
                    case R.id.rdoD114A:
                        resposta11.setOpcao(1);
                        break;
                    case R.id.rdoD113A:
                        resposta11.setOpcao(2);
                        break;
                    case R.id.rdoD112A:
                        resposta11.setOpcao(3);
                        break;
                    case R.id.rdoD111A:
                        resposta11.setOpcao(4);
                        break;
                    case R.id.rdoD119A:
                        resposta11.setOpcao(5);
                        break;
                }
                resposta11.setNumeroQuestao("A-D11");

                resposta12 = new Resposta();
                switch (rdgRespD12A.getCheckedRadioButtonId()){
                    case R.id.rdoD124A:
                        resposta12.setOpcao(1);
                        break;
                    case R.id.rdoD123A:
                        resposta12.setOpcao(2);
                        break;
                    case R.id.rdoD122A:
                        resposta12.setOpcao(3);
                        break;
                    case R.id.rdoD121A:
                        resposta12.setOpcao(4);
                        break;
                    case R.id.rdoD129A:
                        resposta12.setOpcao(5);
                        break;
                }
                resposta12.setNumeroQuestao("A-D12");

                resposta13 = new Resposta();
                switch (rdgRespD13A.getCheckedRadioButtonId()){
                    case R.id.rdoD134A:
                        resposta13.setOpcao(1);
                        break;
                    case R.id.rdoD133A:
                        resposta13.setOpcao(2);
                        break;
                    case R.id.rdoD132A:
                        resposta13.setOpcao(3);
                        break;
                    case R.id.rdoD131A:
                        resposta13.setOpcao(4);
                        break;
                    case R.id.rdoD139A:
                        resposta13.setOpcao(5);
                        break;
                }
                resposta13.setNumeroQuestao("A-D13");

                resposta14 = new Resposta();
                switch (rdgRespD14A.getCheckedRadioButtonId()){
                    case R.id.rdoD144A:
                        resposta14.setOpcao(1);
                        break;
                    case R.id.rdoD143A:
                        resposta14.setOpcao(2);
                        break;
                    case R.id.rdoD142A:
                        resposta14.setOpcao(3);
                        break;
                    case R.id.rdoD141A:
                        resposta14.setOpcao(4);
                        break;
                    case R.id.rdoD149A:
                        resposta14.setOpcao(5);
                        break;
                }
                resposta14.setNumeroQuestao("A-D14");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 34) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("A-D1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D5"))
                            respostas.set(i, resposta5);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D6"))
                            respostas.set(i, resposta6);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D7"))
                            respostas.set(i, resposta7);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D8"))
                            respostas.set(i, resposta8);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D9"))
                            respostas.set(i, resposta9);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D10"))
                            respostas.set(i, resposta10);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D11"))
                            respostas.set(i, resposta11);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D12"))
                            respostas.set(i, resposta12);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D13"))
                            respostas.set(i, resposta13);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-D14"))
                            respostas.set(i, resposta14);
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
                }
            
                Componente componente = new Componente();
                componente.setLetraComponente("A-D");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 4){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("A-D"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(AdultoD.this, "Escore do Componente D = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),AdultoE.class);
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

        System.out.println("Resposta brancas ou nao sei = " + numeroDeRespostasBrancasOuNaoSei);

        return numeroDeRespostasBrancasOuNaoSei/14 < 0.5;
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

        // Valores invertidos D14
        if (resposta14.getOpcao() != 5){
            somatorioDosItens += resposta14.getOpcao();
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

            this.escoreComponente = somatorioDosItens / 14;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

            // Transformacao do Escore
            // this.escoreComponente = ((this.escoreComponente - 1) * 10)/3;

        }

        return this.escoreComponente;

    }


    @Override
    public void replaceQuestionsAdulto() {
        txtQuestaoD1A.setText( txtQuestaoD1A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoD14A.setText( txtQuestaoD14A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        
    }
}
