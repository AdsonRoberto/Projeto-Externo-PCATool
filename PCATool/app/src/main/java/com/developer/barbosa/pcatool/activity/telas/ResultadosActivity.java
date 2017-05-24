package com.developer.barbosa.pcatool.activity.telas;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.adapter.ResultadoAdapter;
import com.developer.barbosa.pcatool.model.dao.ResultadosDAO;
import com.developer.barbosa.pcatool.model.domain.Resultado;

import java.util.ArrayList;

public class ResultadosActivity extends AppCompatActivity {

    private LinearLayout opcCalcularDados, lnlRegional, lnlTipoQuestionario, lnlTotalQuestionarios;
    private ListView lvResultados;
    private Spinner spnTipo, spnRegional;
    private TextView txtTipo, txtRegional, txtTotalQuestionarios;

    private ProgressDialog dialog;

    private ResultadosDAO resultadosDAO;

    private int auxTotalDeQuestionarios = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.opcCalcularDados = (LinearLayout) findViewById(R.id.opcCalcularDados);
        this.lnlTipoQuestionario = (LinearLayout) findViewById(R.id.lnlTipoQuestionario);
        this.lnlRegional = (LinearLayout) findViewById(R.id.lnlRegional);
        this.lnlTotalQuestionarios = (LinearLayout) findViewById(R.id.lnlTotalQuestionarios);
        this.lvResultados = (ListView) findViewById(R.id.lvResultados);
        this.spnTipo = (Spinner) findViewById(R.id.spnTipo);
        this.spnRegional = (Spinner) findViewById(R.id.spnRegional);
        this.txtTipo = (TextView) findViewById(R.id.txtTipo);
        this.txtRegional = (TextView) findViewById(R.id.txtRegional);
        this.txtTotalQuestionarios = (TextView) findViewById(R.id.txtTotalQuestionarios);

        this.resultadosDAO = new ResultadosDAO(this);

        this.lnlRegional.setVisibility(View.INVISIBLE);
        this.lnlTipoQuestionario.setVisibility(View.INVISIBLE);
        this.lnlTotalQuestionarios.setVisibility(View.INVISIBLE);

        ArrayAdapter<CharSequence> adapterTipoQuestionario = ArrayAdapter.createFromResource(this, R.array.array_tipo_questionario, R.layout.spinner_item_pattern);
        adapterTipoQuestionario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spnTipo.setAdapter(adapterTipoQuestionario);

        ArrayAdapter<CharSequence> adapterRegional = ArrayAdapter.createFromResource(this, R.array.array_regionais, R.layout.spinner_item_pattern);
        adapterTipoQuestionario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spnRegional.setAdapter(adapterRegional);

        this.opcCalcularDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tipoQuestionario = spnTipo.getSelectedItem().toString();
                String regional = spnRegional.getSelectedItem().toString();

                ResultadosAsync resultadosAsync = new ResultadosAsync(tipoQuestionario, regional);
                resultadosAsync.execute();

            }
        });

        /*this.btnMediaEscoreEssencial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tipoQuestionario = edtTipoQuestionario.getText().toString();
                String nomeRegional = edtRegional.getText().toString();

                double mediaEE = resultadosDAO.getMediaEscoreEssencial(tipoQuestionario, nomeRegional);

                Toast.makeText(ResultadosActivity.this, "MÉDIA E.E. DO " + tipoQuestionario + " - " + nomeRegional + " = " + mediaEE, Toast.LENGTH_LONG).show();

            }
        });

        this.btnMediaEscoreGeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tipoQuestionario = edtTipoQuestionario.getText().toString();
                String nomeRegional = edtRegional.getText().toString();

                double mediaEG = resultadosDAO.getMediaEscoreGeral(tipoQuestionario, nomeRegional);

                Toast.makeText(ResultadosActivity.this, "MÉDIA E.G. DO " + tipoQuestionario + " - " + nomeRegional + " = " + mediaEG, Toast.LENGTH_LONG).show();

            }
        });

        this.btnMediaComponentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tipoQuestionario = edtTipoQuestionario.getText().toString();
                String nomeRegional = edtRegional.getText().toString();

                ArrayList<Double> medias = resultadosDAO.getMediaComponentes(tipoQuestionario, nomeRegional);

                String str = "";

                for(int i = 0; i < medias.size(); i++){
                    str += "COMPONENTE " + (i+1) + " = " + medias.get(i) + "\n";
                }

                Toast.makeText(ResultadosActivity.this, tipoQuestionario + " - " + nomeRegional + "\n" + str, Toast.LENGTH_LONG).show();

            }
        });*/

    }

    private class ResultadosAsync extends AsyncTask<Void, Void, ArrayList<Resultado>> {

        private String tipoQuestionario;
        private String regional;

        public ResultadosAsync(String tipoQuestionario, String regional){
            this.tipoQuestionario = tipoQuestionario;
            this.regional = regional;
        }

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(ResultadosActivity.this, "Por favor, aguarde", "Calculando resultados ...");
        }

        @Override
        protected ArrayList<Resultado> doInBackground(Void... params) {

            auxTotalDeQuestionarios = resultadosDAO.getTotalDeQuestionarios(tipoQuestionario, regional);

            return resultadosDAO.getResultados(tipoQuestionario, regional);
        }

        @Override
        protected void onPostExecute(ArrayList<Resultado> resultados) {
            ResultadoAdapter resultadoAdapter = new ResultadoAdapter(ResultadosActivity.this, resultados);
            lvResultados.setAdapter(resultadoAdapter);

            lnlRegional.setVisibility(View.VISIBLE);
            lnlTipoQuestionario.setVisibility(View.VISIBLE);
            lnlTotalQuestionarios.setVisibility(View.VISIBLE);

            txtTipo.setText(tipoQuestionario);
            txtRegional.setText(regional);
            txtTotalQuestionarios.setText(auxTotalDeQuestionarios + " QUESTIONÁRIOS/ENTREVISTAS");

            dialog.dismiss();
        }

    }

}

