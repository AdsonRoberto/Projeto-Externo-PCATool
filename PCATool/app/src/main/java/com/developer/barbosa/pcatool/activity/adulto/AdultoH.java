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

public class AdultoH extends AppCompatActivity implements ReplaceQuestions{

    private FloatingActionButton fltProximo;

    private RadioGroup rdgRespH1A, rdgRespH2A, rdgRespH3A, rdgRespH4A, rdgRespH5A, rdgRespH6A, rdgRespH7A,
            rdgRespH8A, rdgRespH9A, rdgRespH10A, rdgRespH11A, rdgRespH12A, rdgRespH13A;
    private TextView txtDescricao1HA, txtDescricao2HA;

    private Questionario questionario;

    private static String NOME_MEDICO_SERVICO_DEFINIDO = "nome do serviço de saúde / ou nome médico/enfermeiro";

    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7, resposta8,
            resposta9, resposta10, resposta11, resposta12, resposta13;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_h);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        this.NOME_MEDICO_SERVICO_DEFINIDO = this.questionario.getRespostas().get(4).getNomeProfServ();

        fltProximo = (FloatingActionButton) findViewById(R.id.fltProximo);
        rdgRespH1A = (RadioGroup) findViewById(R.id.rdgRespH1A);
        rdgRespH2A = (RadioGroup) findViewById(R.id.rdgRespH2A);
        rdgRespH3A = (RadioGroup) findViewById(R.id.rdgRespH3A);
        rdgRespH4A = (RadioGroup) findViewById(R.id.rdgRespH4A);
        rdgRespH5A = (RadioGroup) findViewById(R.id.rdgRespH5A);
        rdgRespH6A = (RadioGroup) findViewById(R.id.rdgRespH6A);
        rdgRespH7A = (RadioGroup) findViewById(R.id.rdgRespH7A);
        rdgRespH8A = (RadioGroup) findViewById(R.id.rdgRespH8A);
        rdgRespH9A = (RadioGroup) findViewById(R.id.rdgRespH9A);
        rdgRespH10A = (RadioGroup) findViewById(R.id.rdgRespH10A);
        rdgRespH11A = (RadioGroup) findViewById(R.id.rdgRespH11A);
        rdgRespH12A = (RadioGroup) findViewById(R.id.rdgRespH12A);
        rdgRespH13A = (RadioGroup) findViewById(R.id.rdgRespH13A);
        txtDescricao1HA = (TextView) findViewById(R.id.txtDescricao1HA);
        txtDescricao2HA = (TextView) findViewById(R.id.txtDescricao2HA);

        this.replaceQuestionsAdulto();

        fltProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespH1A.getCheckedRadioButtonId()){
                    case R.id.rdoH14A:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoH13A:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoH12A:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoH11A:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoH19A:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("A-H1");

                resposta2 = new Resposta();
                switch (rdgRespH2A.getCheckedRadioButtonId()){
                    case R.id.rdoH24A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoH23A:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoH22A:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoH21A:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoH29A:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("A-H2");

                resposta3 = new Resposta();
                switch (rdgRespH3A.getCheckedRadioButtonId()){
                    case R.id.rdoH34A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoH33A:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoH32A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoH31A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoH39A:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("A-H3");

                resposta4 = new Resposta();
                switch (rdgRespH4A.getCheckedRadioButtonId()){
                    case R.id.rdoH44A:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoH43A:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoH42A:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoH41A:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoH49A:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("A-H4");

                resposta5 = new Resposta();
                switch (rdgRespH5A.getCheckedRadioButtonId()){
                    case R.id.rdoH54A:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoH53A:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoH52A:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoH51A:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoH59A:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("A-H5");

                resposta6 = new Resposta();
                switch (rdgRespH6A.getCheckedRadioButtonId()){
                    case R.id.rdoH64A:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoH63A:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoH62A:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoH61A:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoH69A:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("A-H6");

                resposta7 = new Resposta();
                switch (rdgRespH7A.getCheckedRadioButtonId()){
                    case R.id.rdoH74A:
                        resposta7.setOpcao(1);
                        break;
                    case R.id.rdoH73A:
                        resposta7.setOpcao(2);
                        break;
                    case R.id.rdoH72A:
                        resposta7.setOpcao(3);
                        break;
                    case R.id.rdoH71A:
                        resposta7.setOpcao(4);
                        break;
                    case R.id.rdoH79A:
                        resposta7.setOpcao(5);
                        break;
                }
                resposta7.setNumeroQuestao("A-H7");

                resposta8 = new Resposta();
                switch (rdgRespH8A.getCheckedRadioButtonId()){
                    case R.id.rdoH84A:
                        resposta8.setOpcao(1);
                        break;
                    case R.id.rdoH83A:
                        resposta8.setOpcao(2);
                        break;
                    case R.id.rdoH82A:
                        resposta8.setOpcao(3);
                        break;
                    case R.id.rdoH81A:
                        resposta8.setOpcao(4);
                        break;
                    case R.id.rdoH89A:
                        resposta8.setOpcao(5);
                        break;
                }
                resposta8.setNumeroQuestao("A-H8");

                resposta9 = new Resposta();
                switch (rdgRespH9A.getCheckedRadioButtonId()){
                    case R.id.rdoH94A:
                        resposta9.setOpcao(1);
                        break;
                    case R.id.rdoH93A:
                        resposta9.setOpcao(2);
                        break;
                    case R.id.rdoH92A:
                        resposta9.setOpcao(3);
                        break;
                    case R.id.rdoH91A:
                        resposta9.setOpcao(4);
                        break;
                    case R.id.rdoH99A:
                        resposta9.setOpcao(5);
                        break;
                }
                resposta9.setNumeroQuestao("A-H9");

                resposta10 = new Resposta();
                switch (rdgRespH10A.getCheckedRadioButtonId()){
                    case R.id.rdoH104A:
                        resposta10.setOpcao(1);
                        break;
                    case R.id.rdoH103A:
                        resposta10.setOpcao(2);
                        break;
                    case R.id.rdoH102A:
                        resposta10.setOpcao(3);
                        break;
                    case R.id.rdoH101A:
                        resposta10.setOpcao(4);
                        break;
                    case R.id.rdoH109A:
                        resposta10.setOpcao(5);
                        break;
                }
                resposta10.setNumeroQuestao("A-H10");

                resposta11 = new Resposta();
                switch (rdgRespH11A.getCheckedRadioButtonId()){
                    case R.id.rdoH114A:
                        resposta11.setOpcao(1);
                        break;
                    case R.id.rdoH113A:
                        resposta11.setOpcao(2);
                        break;
                    case R.id.rdoH112A:
                        resposta11.setOpcao(3);
                        break;
                    case R.id.rdoH111A:
                        resposta11.setOpcao(4);
                        break;
                    case R.id.rdoH119A:
                        resposta11.setOpcao(5);
                        break;
                }
                resposta11.setNumeroQuestao("A-H11");

                resposta12 = new Resposta();
                switch (rdgRespH12A.getCheckedRadioButtonId()){
                    case R.id.rdoH124A:
                        resposta12.setOpcao(1);
                        break;
                    case R.id.rdoH123A:
                        resposta12.setOpcao(2);
                        break;
                    case R.id.rdoH122A:
                        resposta12.setOpcao(3);
                        break;
                    case R.id.rdoH121A:
                        resposta12.setOpcao(4);
                        break;
                    case R.id.rdoH129A:
                        resposta12.setOpcao(5);
                        break;
                }
                resposta12.setNumeroQuestao("A-H12");

                resposta13 = new Resposta();
                switch (rdgRespH13A.getCheckedRadioButtonId()){
                    case R.id.rdoH134A:
                        resposta13.setOpcao(1);
                        break;
                    case R.id.rdoH133A:
                        resposta13.setOpcao(2);
                        break;
                    case R.id.rdoH132A:
                        resposta13.setOpcao(3);
                        break;
                    case R.id.rdoH131A:
                        resposta13.setOpcao(4);
                        break;
                    case R.id.rdoH139A:
                        resposta13.setOpcao(5);
                        break;
                }
                resposta13.setNumeroQuestao("A-H13");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 81) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("A-H1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H5"))
                            respostas.set(i, resposta5);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H6"))
                            respostas.set(i, resposta6);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H7"))
                            respostas.set(i, resposta7);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H8"))
                            respostas.set(i, resposta8);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H9"))
                            respostas.set(i, resposta9);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H10"))
                            respostas.set(i, resposta10);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H11"))
                            respostas.set(i, resposta11);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H12"))
                            respostas.set(i, resposta12);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-H13"))
                            respostas.set(i, resposta13);                        
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
                }

                Componente componente = new Componente();
                componente.setLetraComponente("A-H");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 8){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("A-H"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(AdultoH.this, "Escore do Componente H = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),AdultoI.class);
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

        System.out.println("Resposta brancas ou nao sei = " + numeroDeRespostasBrancasOuNaoSei);

        // Verificando se entrevistado eh homem ou mulher
        if(this.questionario.getEntrevistado().getSexo().equals("FEMININO")){

            if (resposta12.getOpcao() == 0 || resposta12.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }
            if (resposta13.getOpcao() == 0 || resposta13.getOpcao() == 5){
                numeroDeRespostasBrancasOuNaoSei++;
            }

            return numeroDeRespostasBrancasOuNaoSei/13 < 0.5;
        }

        return numeroDeRespostasBrancasOuNaoSei/11 < 0.5;
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

        if (this.questionario.getEntrevistado().getSexo().equals("FEMININO")){

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

        // Se nao der pra calcular os escores do componente
        if ( !this.ehPossivelCalcularEscoreComponente() ){

            this.escoreComponente = -1;
            System.out.println("Nao da pra calcular o escore deste  componente");

        } else {

            somatorioDosItens = this.somatorioDosItens();

            System.out.println("Somatorio dos Itens = " + somatorioDosItens);

            if (this.questionario.getEntrevistado().getSexo().equals("FEMININO"))
                this.escoreComponente = somatorioDosItens / 13;
            else
                this.escoreComponente = somatorioDosItens / 11;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

            // Transformacao do Escore
            // this.escoreComponente = ((this.escoreComponente - 1) * 10)/3;

        }

        return this.escoreComponente;

    }

    @Override
    public void replaceQuestionsAdulto() {
        txtDescricao1HA.setText( txtDescricao1HA.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtDescricao2HA.setText( txtDescricao2HA.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
    }
}
