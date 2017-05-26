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

public class ProfissionalA extends AppCompatActivity {

    private FloatingActionButton fltProximoP;
    private RadioGroup rdgRespA1P, rdgRespA2P, rdgRespA3P, rdgRespA4P, rdgRespA5P, rdgRespA6P,
                        rdgRespA7P, rdgRespA8P, rdgRespA9P;
    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7, resposta8, resposta9;

    Questionario questionario;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_a);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        fltProximoP = (FloatingActionButton) findViewById(R.id.fltProximoP);
        rdgRespA1P = (RadioGroup) findViewById(R.id.rdgRespA1P);
        rdgRespA2P = (RadioGroup) findViewById(R.id.rdgRespA2P);
        rdgRespA3P = (RadioGroup) findViewById(R.id.rdgRespA3P);
        rdgRespA4P = (RadioGroup) findViewById(R.id.rdgRespA4P);
        rdgRespA5P = (RadioGroup) findViewById(R.id.rdgRespA5P);
        rdgRespA6P = (RadioGroup) findViewById(R.id.rdgRespA6P);
        rdgRespA7P = (RadioGroup) findViewById(R.id.rdgRespA7P);
        rdgRespA8P = (RadioGroup) findViewById(R.id.rdgRespA8P);
        rdgRespA9P = (RadioGroup) findViewById(R.id.rdgRespA9P);

        fltProximoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespA1P.getCheckedRadioButtonId()){
                    case R.id.rdoA14P:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoA13P:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoA12P:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoA11P:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoA19P:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("P-A1");

                resposta2 = new Resposta();
                switch (rdgRespA2P.getCheckedRadioButtonId()){
                    case R.id.rdoA24P:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoA23P:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoA22P:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoA21P:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoA29P:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("P-A2");

                resposta3 = new Resposta();
                switch (rdgRespA3P.getCheckedRadioButtonId()){
                    case R.id.rdoA34P:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoA33P:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoA32P:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoA31P:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoA39P:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("P-A3");

                resposta4 = new Resposta();
                switch (rdgRespA4P.getCheckedRadioButtonId()){
                    case R.id.rdoA44P:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoA43P:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoA42P:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoA41P:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoA49P:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("P-A4");

                resposta5 = new Resposta();
                switch (rdgRespA5P.getCheckedRadioButtonId()){
                    case R.id.rdoA54P:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoA53P:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoA52P:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoA51P:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoA59P:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("P-A5");

                resposta6 = new Resposta();
                switch (rdgRespA6P.getCheckedRadioButtonId()){
                    case R.id.rdoA64P:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoA63P:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoA62P:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoA61P:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoA69P:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("P-A6");

                resposta7 = new Resposta();
                switch (rdgRespA7P.getCheckedRadioButtonId()){
                    case R.id.rdoA74P:
                        resposta7.setOpcao(1);
                        break;
                    case R.id.rdoA73P:
                        resposta7.setOpcao(2);
                        break;
                    case R.id.rdoA72P:
                        resposta7.setOpcao(3);
                        break;
                    case R.id.rdoA71P:
                        resposta7.setOpcao(4);
                        break;
                    case R.id.rdoA79P:
                        resposta7.setOpcao(5);
                        break;
                }
                resposta7.setNumeroQuestao("P-A7");

                resposta8 = new Resposta();
                switch (rdgRespA8P.getCheckedRadioButtonId()){
                    case R.id.rdoA84P:
                        resposta8.setOpcao(1);
                        break;
                    case R.id.rdoA83P:
                        resposta8.setOpcao(2);
                        break;
                    case R.id.rdoA82P:
                        resposta8.setOpcao(3);
                        break;
                    case R.id.rdoA81P:
                        resposta8.setOpcao(4);
                        break;
                    case R.id.rdoA89P:
                        resposta8.setOpcao(5);
                        break;
                }
                resposta8.setNumeroQuestao("P-A8");

                resposta9 = new Resposta();
                switch (rdgRespA9P.getCheckedRadioButtonId()){
                    case R.id.rdoA94P:
                        resposta9.setOpcao(1);
                        break;
                    case R.id.rdoA93P:
                        resposta9.setOpcao(2);
                        break;
                    case R.id.rdoA92P:
                        resposta9.setOpcao(3);
                        break;
                    case R.id.rdoA91P:
                        resposta9.setOpcao(4);
                        break;
                    case R.id.rdoA99P:
                        resposta9.setOpcao(5);
                        break;
                }
                resposta9.setNumeroQuestao("P-A9");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 9) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("P-A1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-A2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-A3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-A4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-A5"))
                            respostas.set(i, resposta5);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-A6"))
                            respostas.set(i, resposta6);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-A7"))
                            respostas.set(i, resposta7);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-A8"))
                            respostas.set(i, resposta8);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-A9"))
                            respostas.set(i, resposta9);                        
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
                }

                Componente componente = new Componente();
                componente.setLetraComponente("P-A");
                componente.setEscoreComponente( calcularEscoreComponente() );

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 1){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("P-A"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(ProfissionalA.this, "Escore do Componente A = " + escoreComponente, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),ProfissionalB.class);
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

        return (numeroDeRespostasBrancasOuNaoSei/9 < 0.5);
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

        // Valores invertidos C9
        if (resposta9.getOpcao() != 5){
            somatorioDosItens += resposta9.getOpcao();
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

            this.escoreComponente = somatorioDosItens / 9;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

        }

        return this.escoreComponente;

    }

}