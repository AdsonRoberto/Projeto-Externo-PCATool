package com.developer.barbosa.pcatool.activity.telas;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.adapter.QuestionarioAdapter;
import com.developer.barbosa.pcatool.model.dao.QuestionarioDAO;
import com.developer.barbosa.pcatool.model.domain.Questionario;

import java.util.ArrayList;

public class VisualizarQuestionariosActivity extends AppCompatActivity {

    private ListView lvQuestionarios;
    private QuestionarioDAO questionarioDAO;
    private ArrayList<Questionario> questionarios;
    private TextView txtTotalDeQuestionarios;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_questionarios);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionarioDAO = new QuestionarioDAO(this);

        this.lvQuestionarios = (ListView) findViewById(R.id.lvQuestionarios);
        this.txtTotalDeQuestionarios = (TextView) findViewById(R.id.txtTotalDeQuestionarios);
    }

    @Override
    protected void onStart() {
        super.onStart();
        VisualizarQuestionariosAsync visualizarQuestionariosAsync = new VisualizarQuestionariosAsync();
        visualizarQuestionariosAsync.execute();
    }

    private class VisualizarQuestionariosAsync extends AsyncTask<Void, Void, ArrayList<Questionario>> {

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(VisualizarQuestionariosActivity.this, "Por favor, aguarde", "Buscando questionários cadastrados ...");
        }

        @Override
        protected ArrayList<Questionario> doInBackground(Void... params) {
            questionarios = questionarioDAO.getAll();
            return questionarios;
        }

        @Override
        protected void onPostExecute(ArrayList<Questionario> questionarios) {
            QuestionarioAdapter questionarioAdapter = new QuestionarioAdapter(VisualizarQuestionariosActivity.this, questionarios);
            lvQuestionarios.setAdapter(questionarioAdapter);
            txtTotalDeQuestionarios.setText("TOTAL DE QUESTIONÁRIOS = " + questionarios.size());
            dialog.dismiss();
        }

    }

}
