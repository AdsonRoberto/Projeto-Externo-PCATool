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

public class ProfissionalB extends AppCompatActivity {

    private FloatingActionButton fltProximoP;

    private RadioGroup rdgRespB1P, rdgRespB2P, rdgRespB3P, rdgRespB4P, rdgRespB5P, rdgRespB6P,
            rdgRespB7P, rdgRespB8P, rdgRespB9P, rdgRespB10P, rdgRespB11P, rdgRespB12P, rdgRespB13P;
    private Resposta resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7, resposta8, resposta9,
            resposta10, resposta11, resposta12, resposta13;

    Questionario questionario;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_b);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        fltProximoP = (FloatingActionButton) findViewById(R.id.fltProximoP);
        rdgRespB1P = (RadioGroup) findViewById(R.id.rdgRespB1P);
        rdgRespB2P = (RadioGroup) findViewById(R.id.rdgRespB2P);
        rdgRespB3P = (RadioGroup) findViewById(R.id.rdgRespB3P);
        rdgRespB4P = (RadioGroup) findViewById(R.id.rdgRespB4P);
        rdgRespB5P = (RadioGroup) findViewById(R.id.rdgRespB5P);
        rdgRespB6P = (RadioGroup) findViewById(R.id.rdgRespB6P);
        rdgRespB7P = (RadioGroup) findViewById(R.id.rdgRespB7P);
        rdgRespB8P = (RadioGroup) findViewById(R.id.rdgRespB8P);
        rdgRespB9P = (RadioGroup) findViewById(R.id.rdgRespB9P);
        rdgRespB10P = (RadioGroup) findViewById(R.id.rdgRespB10P);
        rdgRespB11P = (RadioGroup) findViewById(R.id.rdgRespB11P);
        rdgRespB12P = (RadioGroup) findViewById(R.id.rdgRespB12P);
        rdgRespB13P = (RadioGroup) findViewById(R.id.rdgRespB13P);

        fltProximoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespB1P.getCheckedRadioButtonId()){
                    case R.id.rdoB14P:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoB13P:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoB12P:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoB11P:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoB19P:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("P-B1");

                resposta2 = new Resposta();
                switch (rdgRespB2P.getCheckedRadioButtonId()){
                    case R.id.rdoB24P:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoB23P:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoB22P:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoB21P:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoB29P:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("P-B2");

                resposta3 = new Resposta();
                switch (rdgRespB3P.getCheckedRadioButtonId()){
                    case R.id.rdoB34P:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoB33P:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoB32P:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoB31P:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoB39P:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("P-B3");

                resposta4 = new Resposta();
                switch (rdgRespB4P.getCheckedRadioButtonId()){
                    case R.id.rdoB44P:
                        resposta4.setOpcao(1);
                        break;
                    case R.id.rdoB43P:
                        resposta4.setOpcao(2);
                        break;
                    case R.id.rdoB42P:
                        resposta4.setOpcao(3);
                        break;
                    case R.id.rdoB41P:
                        resposta4.setOpcao(4);
                        break;
                    case R.id.rdoB49P:
                        resposta4.setOpcao(5);
                        break;
                }
                resposta4.setNumeroQuestao("P-B4");

                resposta5 = new Resposta();
                switch (rdgRespB5P.getCheckedRadioButtonId()){
                    case R.id.rdoB54P:
                        resposta5.setOpcao(1);
                        break;
                    case R.id.rdoB53P:
                        resposta5.setOpcao(2);
                        break;
                    case R.id.rdoB52P:
                        resposta5.setOpcao(3);
                        break;
                    case R.id.rdoB51P:
                        resposta5.setOpcao(4);
                        break;
                    case R.id.rdoB59P:
                        resposta5.setOpcao(5);
                        break;
                }
                resposta5.setNumeroQuestao("P-B5");

                resposta6 = new Resposta();
                switch (rdgRespB6P.getCheckedRadioButtonId()){
                    case R.id.rdoB64P:
                        resposta6.setOpcao(1);
                        break;
                    case R.id.rdoB63P:
                        resposta6.setOpcao(2);
                        break;
                    case R.id.rdoB62P:
                        resposta6.setOpcao(3);
                        break;
                    case R.id.rdoB61P:
                        resposta6.setOpcao(4);
                        break;
                    case R.id.rdoB69P:
                        resposta6.setOpcao(5);
                        break;
                }
                resposta6.setNumeroQuestao("P-B6");

                resposta7 = new Resposta();
                switch (rdgRespB7P.getCheckedRadioButtonId()){
                    case R.id.rdoB74P:
                        resposta7.setOpcao(1);
                        break;
                    case R.id.rdoB73P:
                        resposta7.setOpcao(2);
                        break;
                    case R.id.rdoB72P:
                        resposta7.setOpcao(3);
                        break;
                    case R.id.rdoB71P:
                        resposta7.setOpcao(4);
                        break;
                    case R.id.rdoB79P:
                        resposta7.setOpcao(5);
                        break;
                }
                resposta7.setNumeroQuestao("P-B7");

                resposta8 = new Resposta();
                switch (rdgRespB8P.getCheckedRadioButtonId()){
                    case R.id.rdoB84P:
                        resposta8.setOpcao(1);
                        break;
                    case R.id.rdoB83P:
                        resposta8.setOpcao(2);
                        break;
                    case R.id.rdoB82P:
                        resposta8.setOpcao(3);
                        break;
                    case R.id.rdoB81P:
                        resposta8.setOpcao(4);
                        break;
                    case R.id.rdoB89P:
                        resposta8.setOpcao(5);
                        break;
                }
                resposta8.setNumeroQuestao("P-B8");

                resposta9 = new Resposta();
                switch (rdgRespB9P.getCheckedRadioButtonId()){
                    case R.id.rdoB94P:
                        resposta9.setOpcao(1);
                        break;
                    case R.id.rdoB93P:
                        resposta9.setOpcao(2);
                        break;
                    case R.id.rdoB92P:
                        resposta9.setOpcao(3);
                        break;
                    case R.id.rdoB91P:
                        resposta9.setOpcao(4);
                        break;
                    case R.id.rdoB99P:
                        resposta9.setOpcao(5);
                        break;
                }
                resposta9.setNumeroQuestao("P-B9");

                resposta10 = new Resposta();
                switch (rdgRespB10P.getCheckedRadioButtonId()){
                    case R.id.rdoB104P:
                        resposta10.setOpcao(1);
                        break;
                    case R.id.rdoB103P:
                        resposta10.setOpcao(2);
                        break;
                    case R.id.rdoB102P:
                        resposta10.setOpcao(3);
                        break;
                    case R.id.rdoB101P:
                        resposta10.setOpcao(4);
                        break;
                    case R.id.rdoB109P:
                        resposta10.setOpcao(5);
                        break;
                }
                resposta10.setNumeroQuestao("P-B10");

                resposta11 = new Resposta();
                switch (rdgRespB11P.getCheckedRadioButtonId()){
                    case R.id.rdoB114P:
                        resposta11.setOpcao(1);
                        break;
                    case R.id.rdoB113P:
                        resposta11.setOpcao(2);
                        break;
                    case R.id.rdoB112P:
                        resposta11.setOpcao(3);
                        break;
                    case R.id.rdoB111P:
                        resposta11.setOpcao(4);
                        break;
                    case R.id.rdoB119P:
                        resposta11.setOpcao(5);
                        break;
                }
                resposta11.setNumeroQuestao("P-B11");

                resposta12 = new Resposta();
                switch (rdgRespB12P.getCheckedRadioButtonId()){
                    case R.id.rdoB124P:
                        resposta12.setOpcao(1);
                        break;
                    case R.id.rdoB123P:
                        resposta12.setOpcao(2);
                        break;
                    case R.id.rdoB122P:
                        resposta12.setOpcao(3);
                        break;
                    case R.id.rdoB121P:
                        resposta12.setOpcao(4);
                        break;
                    case R.id.rdoB129P:
                        resposta12.setOpcao(5);
                        break;
                }
                resposta12.setNumeroQuestao("P-B12");

                resposta13 = new Resposta();
                switch (rdgRespB13P.getCheckedRadioButtonId()){
                    case R.id.rdoB134P:
                        resposta13.setOpcao(1);
                        break;
                    case R.id.rdoB133P:
                        resposta13.setOpcao(2);
                        break;
                    case R.id.rdoB132P:
                        resposta13.setOpcao(3);
                        break;
                    case R.id.rdoB131P:
                        resposta13.setOpcao(4);
                        break;
                    case R.id.rdoB139P:
                        resposta13.setOpcao(5);
                        break;
                }
                resposta13.setNumeroQuestao("P-B13");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 22) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("P-B1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B3"))
                            respostas.set(i, resposta3);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B4"))
                            respostas.set(i, resposta4);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B5"))
                            respostas.set(i, resposta5);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B6"))
                            respostas.set(i, resposta6);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B7"))
                            respostas.set(i, resposta7);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B8"))
                            respostas.set(i, resposta8);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B9"))
                            respostas.set(i, resposta9);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B10"))
                            respostas.set(i, resposta10);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B11"))
                            respostas.set(i, resposta11);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B12"))
                            respostas.set(i, resposta12);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-B13"))
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
                componente.setLetraComponente("P-B");
                componente.setEscoreComponente( calcularEscoreComponente() );

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 2){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("P-B"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(ProfissionalB.this, "Escore do Componente B = " + escoreComponente, Toast.LENGTH_SHORT).show();
                
                Intent intent = new Intent(getApplicationContext(),ProfissionalC.class);
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

        return (numeroDeRespostasBrancasOuNaoSei/13 < 0.5);
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
        
        return somatorioDosItens;
    }

    public double calcularEscoreComponente(){

        this.escoreComponente = -1;

        double somatorioDosItens = 0;

        if ( this.ehPossivelCalcularEscoreComponente() ){

            somatorioDosItens = this.somatorioDosItens();

            this.escoreComponente = somatorioDosItens / 13;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

        }

        return this.escoreComponente;

    }
    
}