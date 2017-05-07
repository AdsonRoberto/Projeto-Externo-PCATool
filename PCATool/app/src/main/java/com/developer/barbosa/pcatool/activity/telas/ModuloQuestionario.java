package com.developer.barbosa.pcatool.activity.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.activity.adulto.AdultoA;
import com.developer.barbosa.pcatool.activity.profissional.ProfissionalA;
import com.developer.barbosa.pcatool.model.Entrevistado;
import com.developer.barbosa.pcatool.model.Posto;
import com.developer.barbosa.pcatool.model.PostoDAO;
import com.developer.barbosa.pcatool.model.Questionario;
import com.developer.barbosa.pcatool.model.Regional;
import com.developer.barbosa.pcatool.model.RegionalDAO;

import java.util.ArrayList;

public class ModuloQuestionario extends AppCompatActivity {

    private Entrevistado entrevistado;

    private EditText dataRealização;
    private Spinner spnRegional;
    private Spinner spnPosto;
    private Button btnAdulto, btnProfissional;

    private RegionalDAO regionalDAO;
    private PostoDAO postoDAO;

    private ArrayList<Regional> regionais;
    private ArrayList<Posto> postos;

    private Regional regionalSelecionadaAux;
    private Posto postoSelecionadoAux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_questionario);

        this.btnAdulto = (Button) findViewById(R.id.btnAdulto);
        this.btnProfissional = (Button) findViewById(R.id.btnProfissional);
        this.dataRealização = (EditText) findViewById(R.id.txtDataRealizacao);
        this.spnRegional = (Spinner) findViewById(R.id.spnRegional);
        this.spnPosto = (Spinner) findViewById(R.id.spnPosto);

        this.entrevistado = (Entrevistado) getIntent().getSerializableExtra("entrevistado");

        this.regionalDAO = new RegionalDAO(this);
        this.postoDAO = new PostoDAO(this);

        ArrayAdapter<String> adapterSpinnerRegional = new ArrayAdapter<>(ModuloQuestionario.this,
                android.R.layout.simple_spinner_item, this.getRegionaisString());
        adapterSpinnerRegional.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spnRegional.setAdapter(adapterSpinnerRegional);

        this.btnAdulto.setOnClickListener(this.onClickListenerBtnAdulto);
        this.btnProfissional.setOnClickListener(this.onClickListenerBtnProfissional);
        this.spnRegional.setOnItemSelectedListener(this.onItemSelectedListenerSpnRegional);
        this.spnPosto.setOnItemSelectedListener(this.onItemSelectedListenerSpnPosto);

    }

    View.OnClickListener onClickListenerBtnAdulto = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Questionario questionario = new Questionario();

            questionario.setEntrevistado(entrevistado);

            String dataRealizacao = dataRealização.getText().toString();

            questionario.setDataRealizacao(dataRealizacao);
            questionario.setRegional(regionalSelecionadaAux);
            questionario.setTipoQuestionario("ADULTO");

            System.out.println("Passando o Questionario Adulto para outra Tela");

            Intent intent = new Intent(getApplicationContext(), AdultoA.class);
            intent.putExtra("questionario", questionario);
            startActivity(intent);
        }
    };

    View.OnClickListener onClickListenerBtnProfissional = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Instanciando um questionario e ja colocando o entrevistado nele. Mas sem as respostas ainda
            // Nenhum dos objetos ate agora foram cadastrados no banco de dados
            // A ideia eh que isso só aconteça no fim da entrevista
            Questionario questionario = new Questionario();

            questionario.setEntrevistado(entrevistado);

            String dataRealizacao = dataRealização.getText().toString();

            questionario.setDataRealizacao(dataRealizacao);
            questionario.setRegional(regionalSelecionadaAux);
            questionario.setTipoQuestionario("PROFISSIONAL");

            System.out.println("Passando o Questionario Profissional para outra Tela");

            // Enviando o questionario via intent
            Intent intent = new Intent(getApplicationContext(), ProfissionalA.class);
            intent.putExtra("questionario", questionario);
            startActivity(intent);
        }
    };

    AdapterView.OnItemSelectedListener onItemSelectedListenerSpnRegional = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            int ordemItemSelecionado = i;

            regionalSelecionadaAux = regionais.get(ordemItemSelecionado);

            ArrayAdapter<String> adapterSpinnerPosto = new ArrayAdapter<>(ModuloQuestionario.this,
                    android.R.layout.simple_spinner_item,
                    getPostosStringByRegional(regionalSelecionadaAux));
            adapterSpinnerPosto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spnPosto.setAdapter(adapterSpinnerPosto);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    AdapterView.OnItemSelectedListener onItemSelectedListenerSpnPosto = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            int ordemPostoSelecionadoAux = i;

            postoSelecionadoAux = postos.get(ordemPostoSelecionadoAux);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private ArrayList<String> getRegionaisString(){
        ArrayList<String> regionaisString = new ArrayList<>();
        this.regionais = this.regionalDAO.getAll();
        for (Regional r : this.regionais){
            regionaisString.add(r.getNome());
        }
        return regionaisString;
    }

    private ArrayList<String> getPostosStringByRegional(Regional regional){
        ArrayList<String> postosString = new ArrayList<>();
        String SQL_QUERY = "SELECT posto.* FROM posto WHERE id_regional = " + regional.getId_regional();
        this.postos = this.postoDAO.findByQuery(SQL_QUERY);
        for (Posto p : this.postos){
            postosString.add("NOME: " + p.getNome() + " | ENDEREÇO: " + p.getEndereco());
        }
        return postosString;
    }

}
