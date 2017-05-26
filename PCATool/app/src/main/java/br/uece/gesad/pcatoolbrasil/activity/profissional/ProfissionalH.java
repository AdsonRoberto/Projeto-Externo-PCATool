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
import br.uece.gesad.pcatoolbrasil.activity.telas.ConfirmarCadastroActivity;
import br.uece.gesad.pcatoolbrasil.model.domain.Componente;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;
import br.uece.gesad.pcatoolbrasil.model.domain.Resposta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ProfissionalH extends AppCompatActivity {

    private FloatingActionButton fltProximoP;

    private RadioGroup rdgRespH1P, rdgRespH2P, rdgRespH3P, rdgRespH4P, rdgRespH5P, rdgRespH6P;
    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6;

    Questionario questionario;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_h);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        fltProximoP = (FloatingActionButton) findViewById(R.id.fltProximoP);
        rdgRespH1P = (RadioGroup) findViewById(R.id.rdgRespH1P);
        rdgRespH2P = (RadioGroup) findViewById(R.id.rdgRespH2P);
        rdgRespH3P = (RadioGroup) findViewById(R.id.rdgRespH3P);
        rdgRespH4P = (RadioGroup) findViewById(R.id.rdgRespH4P);
        rdgRespH5P = (RadioGroup) findViewById(R.id.rdgRespH5P);
        rdgRespH6P = (RadioGroup) findViewById(R.id.rdgRespH6P);

        fltProximoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespH1P.getCheckedRadioButtonId()){
                    case R.id.rdoH14P:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoH13P:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoH12P:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoH11P:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoH19P:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("P-H1");

                resposta2 = new Resposta();
                switch (rdgRespH2P.getCheckedRadioButtonId()){
                    case R.id.rdoH24P:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoH23P:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoH22P:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoH21P:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoH29P:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("P-H2");

                resposta3 = new Resposta();
                switch (rdgRespH3P.getCheckedRadioButtonId()){
                    case R.id.rdoH34P:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoH33P:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoH32P:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoH31P:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoH39P:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("P-H3");

                resposta4 = new Resposta();
                switch (rdgRespH4P.getCheckedRadioButtonId()){
                    case R.id.rdoH44P:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoH43P:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoH42P:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoH41P:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoH49P:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("P-H4");

                resposta5 = new Resposta();
                switch (rdgRespH5P.getCheckedRadioButtonId()){
                    case R.id.rdoH54P:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoH53P:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoH52P:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoH51P:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoH59P:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("P-H5");

                resposta6 = new Resposta();
                switch (rdgRespH6P.getCheckedRadioButtonId()){
                    case R.id.rdoH64P:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoH63P:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoH62P:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoH61P:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoH69P:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("P-H6");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 78) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("P-H1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-H2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-H3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-H4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-H5"))
                            respostas.set(i, resposta5);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-H6"))
                            respostas.set(i, resposta6);
                    }
                } else {
                    questionario.getRespostas().add(resposta1);
                    questionario.getRespostas().add(resposta2);
                    questionario.getRespostas().add(resposta3);
                    questionario.getRespostas().add(resposta4);
                    questionario.getRespostas().add(resposta5);
                    questionario.getRespostas().add(resposta6);
                }

                Componente componente = new Componente();
                componente.setLetraComponente("P-H");
                componente.setEscoreComponente( calcularEscoreComponente() );

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 8){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("P-H"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(ProfissionalH.this, "Escore do Componente H = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),ConfirmarCadastroActivity.class);
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