package br.uece.gesad.pcatoolbrasil.activity.adulto;

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

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.interfaces.ReplaceQuestions;
import br.uece.gesad.pcatoolbrasil.model.domain.Componente;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;
import br.uece.gesad.pcatoolbrasil.model.domain.Resposta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AdultoC extends AppCompatActivity implements ReplaceQuestions {

    private FloatingActionButton fltProximo;

    private RadioGroup rdgRespC1A, rdgRespC2A, rdgRespC3A, rdgRespC4A, rdgRespC5A, rdgRespC6A, rdgRespC7A,
                        rdgRespC8A, rdgRespC9A, rdgRespC10A, rdgRespC11A, rdgRespC12A;
    private TextView txtQuestaoC1A, txtQuestaoC2A, txtQuestaoC3A, txtQuestaoC4A, txtQuestaoC5A, txtQuestaoC6A,
                        txtQuestaoC7A, txtQuestaoC8A, txtQuestaoC9A, txtQuestaoC10A, txtQuestaoC11A, txtQuestaoC12A;

    private Questionario questionario;

    private static String NOME_MEDICO_SERVICO_DEFINIDO = "nome do serviço de saúde / ou nome médico/enfermeiro";

    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7, resposta8,
                        resposta9, resposta10, resposta11, resposta12;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_c);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        this.NOME_MEDICO_SERVICO_DEFINIDO = this.questionario.getRespostas().get(4).getNomeProfServ();

        fltProximo = (FloatingActionButton) findViewById(R.id.fltProximo);
        rdgRespC1A = (RadioGroup) findViewById(R.id.rdgRespC1A);
        rdgRespC2A = (RadioGroup) findViewById(R.id.rdgRespC2A);
        rdgRespC3A = (RadioGroup) findViewById(R.id.rdgRespC3A);
        rdgRespC4A = (RadioGroup) findViewById(R.id.rdgRespC4A);
        rdgRespC5A = (RadioGroup) findViewById(R.id.rdgRespC5A);
        rdgRespC6A = (RadioGroup) findViewById(R.id.rdgRespC6A);
        rdgRespC7A = (RadioGroup) findViewById(R.id.rdgRespC7A);
        rdgRespC8A = (RadioGroup) findViewById(R.id.rdgRespC8A);
        rdgRespC9A = (RadioGroup) findViewById(R.id.rdgRespC9A);
        rdgRespC10A = (RadioGroup) findViewById(R.id.rdgRespC10A);
        rdgRespC11A = (RadioGroup) findViewById(R.id.rdgRespC11A);
        rdgRespC12A = (RadioGroup) findViewById(R.id.rdgRespC12A);
        txtQuestaoC1A = (TextView) findViewById(R.id.txtQuestaoC1A);
        txtQuestaoC2A = (TextView) findViewById(R.id.txtQuestaoC2A);
        txtQuestaoC3A = (TextView) findViewById(R.id.txtQuestaoC3A);
        txtQuestaoC4A = (TextView) findViewById(R.id.txtQuestaoC4A);
        txtQuestaoC5A = (TextView) findViewById(R.id.txtQuestaoC5A);
        txtQuestaoC6A = (TextView) findViewById(R.id.txtQuestaoC6A);
        txtQuestaoC7A = (TextView) findViewById(R.id.txtQuestaoC7A);
        txtQuestaoC8A = (TextView) findViewById(R.id.txtQuestaoC8A);
        txtQuestaoC9A = (TextView) findViewById(R.id.txtQuestaoC9A);
        txtQuestaoC10A = (TextView) findViewById(R.id.txtQuestaoC10A);
        txtQuestaoC11A = (TextView) findViewById(R.id.txtQuestaoC11A);
        txtQuestaoC12A = (TextView) findViewById(R.id.txtQuestaoC12A);

        this.replaceQuestionsAdulto();

        fltProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespC1A.getCheckedRadioButtonId()){
                    case R.id.rdoC14A:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoC13A:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoC12A:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoC11A:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoC19A:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("A-C1");

                resposta2 = new Resposta();
                switch (rdgRespC2A.getCheckedRadioButtonId()){
                    case R.id.rdoC24A:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoC23A:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoC22A:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoC21A:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoC29A:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("A-C2");

                resposta3 = new Resposta();
                switch (rdgRespC3A.getCheckedRadioButtonId()){
                    case R.id.rdoC34A:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoC33A:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoC32A:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoC31A:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoC39A:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("A-C3");

                resposta4 = new Resposta();
                switch (rdgRespC4A.getCheckedRadioButtonId()){
                    case R.id.rdoC44A:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoC43A:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoC42A:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoC41A:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoC49A:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("A-C4");

                resposta5 = new Resposta();
                switch (rdgRespC5A.getCheckedRadioButtonId()){
                    case R.id.rdoC54A:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoC53A:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoC52A:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoC51A:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoC59A:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("A-C5");

                resposta6 = new Resposta();
                switch (rdgRespC6A.getCheckedRadioButtonId()){
                    case R.id.rdoC64A:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoC63A:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoC62A:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoC61A:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoC69A:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("A-C6");

                resposta7 = new Resposta();
                switch (rdgRespC7A.getCheckedRadioButtonId()){
                    case R.id.rdoC74A:
                        resposta7.setOpcao(1);
                        break;
                    case R.id.rdoC73A:
                        resposta7.setOpcao(2);
                        break;
                    case R.id.rdoC72A:
                        resposta7.setOpcao(3);
                        break;
                    case R.id.rdoC71A:
                        resposta7.setOpcao(4);
                        break;
                    case R.id.rdoC79A:
                        resposta7.setOpcao(5);
                        break;
                }
                resposta7.setNumeroQuestao("A-C7");

                resposta8 = new Resposta();
                switch (rdgRespC8A.getCheckedRadioButtonId()){
                    case R.id.rdoC84A:
                        resposta8.setOpcao(1);
                        break;
                    case R.id.rdoC83A:
                        resposta8.setOpcao(2);
                        break;
                    case R.id.rdoC82A:
                        resposta8.setOpcao(3);
                        break;
                    case R.id.rdoC81A:
                        resposta8.setOpcao(4);
                        break;
                    case R.id.rdoC89A:
                        resposta8.setOpcao(5);
                        break;
                }
                resposta8.setNumeroQuestao("A-C8");

                resposta9 = new Resposta();
                switch (rdgRespC9A.getCheckedRadioButtonId()){
                    case R.id.rdoC94A:
                        resposta9.setOpcao(1);
                        break;
                    case R.id.rdoC93A:
                        resposta9.setOpcao(2);
                        break;
                    case R.id.rdoC92A:
                        resposta9.setOpcao(3);
                        break;
                    case R.id.rdoC91A:
                        resposta9.setOpcao(4);
                        break;
                    case R.id.rdoC99A:
                        resposta9.setOpcao(5);
                        break;
                }
                resposta9.setNumeroQuestao("A-C9");

                resposta10 = new Resposta();
                switch (rdgRespC10A.getCheckedRadioButtonId()){
                    case R.id.rdoC104A:
                        resposta10.setOpcao(1);
                        break;
                    case R.id.rdoC103A:
                        resposta10.setOpcao(2);
                        break;
                    case R.id.rdoC102A:
                        resposta10.setOpcao(3);
                        break;
                    case R.id.rdoC101A:
                        resposta10.setOpcao(4);
                        break;
                    case R.id.rdoC109A:
                        resposta10.setOpcao(5);
                        break;
                }
                resposta10.setNumeroQuestao("A-C10");

                resposta11 = new Resposta();
                switch (rdgRespC11A.getCheckedRadioButtonId()){
                    case R.id.rdoC114A:
                        resposta11.setOpcao(1);
                        break;
                    case R.id.rdoC113A:
                        resposta11.setOpcao(2);
                        break;
                    case R.id.rdoC112A:
                        resposta11.setOpcao(3);
                        break;
                    case R.id.rdoC111A:
                        resposta11.setOpcao(4);
                        break;
                    case R.id.rdoC119A:
                        resposta11.setOpcao(5);
                        break;
                }
                resposta11.setNumeroQuestao("A-C11");

                resposta12 = new Resposta();
                switch (rdgRespC12A.getCheckedRadioButtonId()){
                    case R.id.rdoC124A:
                        resposta12.setOpcao(1);
                        break;
                    case R.id.rdoC123A:
                        resposta12.setOpcao(2);
                        break;
                    case R.id.rdoC122A:
                        resposta12.setOpcao(3);
                        break;
                    case R.id.rdoC121A:
                        resposta12.setOpcao(4);
                        break;
                    case R.id.rdoC129A:
                        resposta12.setOpcao(5);
                        break;
                }
                resposta12.setNumeroQuestao("A-C12");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 20) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("A-C1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C5"))
                            respostas.set(i, resposta5);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C6"))
                            respostas.set(i, resposta6);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C7"))
                            respostas.set(i, resposta7);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C8"))
                            respostas.set(i, resposta8);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C9"))
                            respostas.set(i, resposta9);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C10"))
                            respostas.set(i, resposta10);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C11"))
                            respostas.set(i, resposta11);
                        else if (respostas.get(i).getNumeroQuestao().equals("A-C12"))
                            respostas.set(i, resposta12);
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
                }

                Componente componente = new Componente();
                componente.setLetraComponente("A-C");
                calcularEscoreComponente();
                componente.setEscoreComponente(escoreComponente);

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 3){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("A-C"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(AdultoC.this, "Escore do Componente C = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),AdultoD.class);
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

        System.out.println("Resposta brancas ou nao sei = " + numeroDeRespostasBrancasOuNaoSei);

        return numeroDeRespostasBrancasOuNaoSei/12 < 0.5;
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

        // Valores invertidos C9,C10,C11,C12
        if (resposta9.getOpcao() != 5){
            somatorioDosItens += resposta9.getOpcao();
        } else {
            somatorioDosItens += 2;
        }
        if (resposta10.getOpcao() != 5){
            somatorioDosItens += resposta10.getOpcao();
        } else {
            somatorioDosItens += 2;
        }
        if (resposta11.getOpcao() != 5){
            somatorioDosItens += resposta11.getOpcao();
        } else {
            somatorioDosItens += 2;
        }
        if (resposta12.getOpcao() != 5){
            somatorioDosItens += resposta12.getOpcao();
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

            this.escoreComponente = somatorioDosItens / 12;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

            // Transformacao do Escore
            // this.escoreComponente = ((this.escoreComponente - 1) * 10)/3;

        }

        return this.escoreComponente;

    }

    @Override
    public void replaceQuestionsAdulto() {
        txtQuestaoC1A.setText( txtQuestaoC1A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC2A.setText( txtQuestaoC2A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC3A.setText( txtQuestaoC3A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC4A.setText( txtQuestaoC4A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC5A.setText( txtQuestaoC5A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC6A.setText( txtQuestaoC6A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC7A.setText( txtQuestaoC7A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC8A.setText( txtQuestaoC8A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC9A.setText( txtQuestaoC9A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC10A.setText( txtQuestaoC10A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC11A.setText( txtQuestaoC11A.getText().toString().replaceAll(NOME_SERVICO_MEDICO, NOME_MEDICO_SERVICO_DEFINIDO) );
        txtQuestaoC12A.setText( txtQuestaoC12A.getText().toString().replaceAll(NOME_MEDICO_ENFERMEIRA_LOCAL, NOME_MEDICO_SERVICO_DEFINIDO) );
    }
}
