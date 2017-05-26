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

public class ProfissionalD extends AppCompatActivity {

    private FloatingActionButton fltProximoP;

    private RadioGroup rdgRespD1P, rdgRespD2P, rdgRespD3P;
    private Resposta resposta1, resposta2, resposta3;

    Questionario questionario;

    private double escoreComponente = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_d);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionario = (Questionario) this.getIntent().getSerializableExtra("questionario");

        fltProximoP = (FloatingActionButton) findViewById(R.id.fltProximoP);
        rdgRespD1P = (RadioGroup) findViewById(R.id.rdgRespD1P);
        rdgRespD2P = (RadioGroup) findViewById(R.id.rdgRespD2P);
        rdgRespD3P = (RadioGroup) findViewById(R.id.rdgRespD3P);

        fltProximoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resposta1 = new Resposta();
                switch (rdgRespD1P.getCheckedRadioButtonId()){
                    case R.id.rdoD14P:
                        resposta1.setOpcao(1);
                        break;
                    case R.id.rdoD13P:
                        resposta1.setOpcao(2);
                        break;
                    case R.id.rdoD12P:
                        resposta1.setOpcao(3);
                        break;
                    case R.id.rdoD11P:
                        resposta1.setOpcao(4);
                        break;
                    case R.id.rdoD19P:
                        resposta1.setOpcao(5);
                        break;
                }
                resposta1.setNumeroQuestao("P-D1");

                resposta2 = new Resposta();
                switch (rdgRespD2P.getCheckedRadioButtonId()){
                    case R.id.rdoD24P:
                        resposta2.setOpcao(1);
                        break;
                    case R.id.rdoD23P:
                        resposta2.setOpcao(2);
                        break;
                    case R.id.rdoD22P:
                        resposta2.setOpcao(3);
                        break;
                    case R.id.rdoD21P:
                        resposta2.setOpcao(4);
                        break;
                    case R.id.rdoD29P:
                        resposta2.setOpcao(5);
                        break;
                }
                resposta2.setNumeroQuestao("P-D2");

                resposta3 = new Resposta();
                switch (rdgRespD3P.getCheckedRadioButtonId()){
                    case R.id.rdoD34P:
                        resposta3.setOpcao(1);
                        break;
                    case R.id.rdoD33P:
                        resposta3.setOpcao(2);
                        break;
                    case R.id.rdoD32P:
                        resposta3.setOpcao(3);
                        break;
                    case R.id.rdoD31P:
                        resposta3.setOpcao(4);
                        break;
                    case R.id.rdoD39P:
                        resposta3.setOpcao(5);
                        break;
                }
                resposta3.setNumeroQuestao("P-D3");

                ArrayList<Resposta> respostas = questionario.getRespostas();
                if(respostas.size() >= 31) {
                    for (int i = 0; i < respostas.size(); i++) {
                        if (respostas.get(i).getNumeroQuestao().equals("P-D1"))
                            respostas.set(i, resposta1);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-D2"))
                            respostas.set(i, resposta2);
                        else if (respostas.get(i).getNumeroQuestao().equals("P-D3"))
                            respostas.set(i, resposta3);                        
                    }
                } else {
                    questionario.getRespostas().add(resposta1);
                    questionario.getRespostas().add(resposta2);
                    questionario.getRespostas().add(resposta3);                    
                }                

                Componente componente = new Componente();
                componente.setLetraComponente("P-D");
                componente.setEscoreComponente( calcularEscoreComponente() );

                ArrayList<Componente> componentes = questionario.getComponentes();
                if(componentes.size() >= 4){
                    for(int i = 0; i < componentes.size(); i++){
                        if(componentes.get(i).getLetraComponente().equals("P-D"))
                            componentes.set(i, componente);
                    }
                } else
                    questionario.getComponentes().add(componente);

                Toast.makeText(ProfissionalD.this, "Escore do Componente D = " + escoreComponente, Toast.LENGTH_SHORT).show();
                
                Intent intent = new Intent(getApplicationContext(),ProfissionalE.class);
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

        return (numeroDeRespostasBrancasOuNaoSei/3 < 0.5);
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

    private double calcularEscoreComponente(){

        this.escoreComponente = -1;

        double somatorioDosItens = 0;

        if ( this.ehPossivelCalcularEscoreComponente() ){

            somatorioDosItens = this.somatorioDosItens();

            this.escoreComponente = somatorioDosItens / 3;

            BigDecimal a = new BigDecimal(this.escoreComponente);
            this.escoreComponente = a.subtract(new BigDecimal("1")).multiply(new BigDecimal("10")).divide(new BigDecimal("3"),2, RoundingMode.UP).doubleValue();

        }

        return this.escoreComponente;

    }
    
}