package com.developer.barbosa.pcatool.activity.telas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.activity.adulto.AdultoA;
import com.developer.barbosa.pcatool.activity.profissional.ProfissionalA;
import com.developer.barbosa.pcatool.model.dao.RegionalDAO;
import com.developer.barbosa.pcatool.model.domain.Entrevistado;
import com.developer.barbosa.pcatool.model.domain.Questionario;
import com.developer.barbosa.pcatool.model.domain.Regional;
import com.developer.barbosa.pcatool.util.Mascara;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ModuloQuestionario extends AppCompatActivity {

    private Entrevistado entrevistado;

    private EditText dataRealização;
    private Spinner spnRegional;
    private Spinner spnTipoQuestionario;
    private FloatingActionButton fltAvancarModuloQuestionario;

    private RegionalDAO regionalDAO;

    private ArrayList<Regional> regionais;

    private Regional regionalSelecionadaAux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_questionario);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.fltAvancarModuloQuestionario = (FloatingActionButton) findViewById(R.id.fltAvancarModuloQuestionario);
        this.dataRealização = (EditText) findViewById(R.id.txtDataRealizacao);
        this.spnRegional = (Spinner) findViewById(R.id.spnRegional);
        this.spnTipoQuestionario = (Spinner) findViewById(R.id.spnTipoQuestionario);

        this.entrevistado = (Entrevistado) getIntent().getSerializableExtra("entrevistado");

        this.regionalDAO = new RegionalDAO(this);

        ArrayAdapter<String> adapterSpinnerRegional = new ArrayAdapter<>(ModuloQuestionario.this,
                R.layout.spinner_item_pattern, this.getRegionaisString());
        adapterSpinnerRegional.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spnRegional.setAdapter(adapterSpinnerRegional);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_tipo_questionario, R.layout.spinner_item_pattern);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spnTipoQuestionario.setAdapter(adapter);

        this.fltAvancarModuloQuestionario.setOnClickListener(this.onClickListenerFltAvancarModuloQuestionario);
        this.spnRegional.setOnItemSelectedListener(this.onItemSelectedListenerSpnRegional);

        this.dataRealização.addTextChangedListener(Mascara.insert("##/##/####", this.dataRealização));
        this.dataRealização.setText(this.getDataAtual());

    }

    View.OnClickListener onClickListenerFltAvancarModuloQuestionario = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String dataRealizacao = dataRealização.getText().toString();

            if(dataRealizacao.equals("")){
                Toast.makeText(ModuloQuestionario.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            Questionario questionario = new Questionario();

            questionario.setEntrevistado(entrevistado);

            questionario.setDataRealizacao(dataRealizacao);
            questionario.setRegional(regionalSelecionadaAux);

            String tipoQuestionario = spnTipoQuestionario.getSelectedItem().toString();

            questionario.setTipoQuestionario(tipoQuestionario);

            Intent intent = null;
            switch (tipoQuestionario){
                case "ADULTO":
                    intent = new Intent(getApplicationContext(), AdultoA.class);
                    break;
                case "PROFISSIONAL":
                    intent = new Intent(getApplicationContext(), ProfissionalA.class);
                    break;
            }
            intent.putExtra("questionario", questionario);
            startActivity(intent);
        }
    };

    AdapterView.OnItemSelectedListener onItemSelectedListenerSpnRegional = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            int ordemItemSelecionado = i;

            regionalSelecionadaAux = regionais.get(ordemItemSelecionado);
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

    private String getDataAtual(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String data = dateFormat.format(date);
        return data;
    }

}
