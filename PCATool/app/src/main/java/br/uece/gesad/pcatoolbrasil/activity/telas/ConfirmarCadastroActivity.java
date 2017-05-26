package br.uece.gesad.pcatoolbrasil.activity.telas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.model.dao.ComponenteDAO;
import br.uece.gesad.pcatoolbrasil.model.dao.EntrevistadoDAO;
import br.uece.gesad.pcatoolbrasil.model.dao.QuestionarioDAO;
import br.uece.gesad.pcatoolbrasil.model.dao.RespostaDAO;
import br.uece.gesad.pcatoolbrasil.model.domain.Componente;
import br.uece.gesad.pcatoolbrasil.model.domain.Entrevistado;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;
import br.uece.gesad.pcatoolbrasil.model.domain.Resposta;

import java.util.ArrayList;

public class ConfirmarCadastroActivity extends AppCompatActivity {

    private Questionario questionario;

    private LinearLayout opcCadastrarQuestionario, opcCancelarQuestionário;
    private TextView txtNome, txtSexo, txtIdade, txtData, txtRegional, txtTipo;

    private QuestionarioDAO questionarioDAO;
    private EntrevistadoDAO entrevistadoDAO;
    private RespostaDAO respostaDAO;
    private ComponenteDAO componenteDAO;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_cadastro);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.questionarioDAO = new QuestionarioDAO(this);
        this.entrevistadoDAO = new EntrevistadoDAO(this);
        this.respostaDAO = new RespostaDAO(this);
        this.componenteDAO = new ComponenteDAO(this);

        this.questionario = (Questionario) getIntent().getSerializableExtra("questionario");

        this.opcCadastrarQuestionario = (LinearLayout) findViewById(R.id.opcCadastrarQuestionario);
        this.opcCancelarQuestionário= (LinearLayout) findViewById(R.id.opcCancelarQuestionário);
        this.txtNome = (TextView) findViewById(R.id.txtNome);
        this.txtSexo = (TextView) findViewById(R.id.txtSexo);
        this.txtIdade = (TextView) findViewById(R.id.txtIdade);
        this.txtData = (TextView) findViewById(R.id.txtData);
        this.txtRegional = (TextView) findViewById(R.id.txtRegional);
        this.txtTipo = (TextView) findViewById(R.id.txtTipo);

        this.atualizarViews();

        this.opcCadastrarQuestionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastrarQuestionarioAsync cadastrarQuestionarioAsync = new CadastrarQuestionarioAsync();
                cadastrarQuestionarioAsync.execute();
            }
        });

        this.opcCancelarQuestionário.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizarEntrevista();
            }
        });

    }

    private class CadastrarQuestionarioAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(ConfirmarCadastroActivity.this, "Por favor, aguarde", "Cadastrando questionário ...");
        }

        @Override
        protected Void doInBackground(Void... params) {
            cadastrarQuestionario();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            dialog.dismiss();
            Toast.makeText(ConfirmarCadastroActivity.this, "Questionário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            finalizarEntrevista();
        }

    }

    private void cadastrarQuestionario(){

        // Pegando Entrevistado
        Entrevistado entrevistado = questionario.getEntrevistado();
        long idEntrevistado = entrevistadoDAO.insertEntrevistado(entrevistado);
        Entrevistado entrevistadoComID = entrevistadoDAO.getEntrevistadoById(idEntrevistado);

        // Setando os atributos do Questionario (entrevistado, escores)
        questionario.setEntrevistado(entrevistadoComID);
        double escoreEssencial = questionario.calcularEscoreEssencial();
        questionario.setEscoreEssencial(escoreEssencial);
        double escoreGeral = questionario.calcularEscoreGeral();
        questionario.setEscoreGeral(escoreGeral);
        long id = questionarioDAO.insertQuestionario(questionario);
        Questionario questionarioComID = questionarioDAO.getQuestionarioById(id);

        // Setandos as respostas do Questionario
        ArrayList<Resposta> respostas = questionario.getRespostas();
        for (Resposta r : respostas) {
            System.out.println("RESPOSTA " + r.getNumeroQuestao());
            r.setQuestionario(questionarioComID);
            respostaDAO.insertResposta(r);
        }

        // Setando os componentes do Questionario
        ArrayList<Componente> componentes = questionario.getComponentes();
        for (Componente p : componentes) {
            System.out.println("COMPONENTE " + p.getLetraComponente() + " ESCORE = " + p.getEscoreComponente());
            p.setQuestionario(questionarioComID);
            componenteDAO.insertComponente(p);
        }

    }

    private void finalizarEntrevista(){
        Intent intent = new Intent(getApplicationContext(), DashActivity.class);
        // Voltando para a Activity de Cadastro dizendo que todas as outras Activities que estão
        // em cima dela na pilha de execução deverão ser finalizadas
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("START", true);
        startActivity(intent);
    }

    private void atualizarViews(){
        this.txtNome.setText("NOME = " + this.questionario.getEntrevistado().getNome());
        this.txtSexo.setText("SEXO = " + this.questionario.getEntrevistado().getSexo());
        this.txtIdade.setText("IDADE = " + this.questionario.getEntrevistado().getIdade() + "");
        this.txtData.setText("DATA DE REALIZAÇÃO = " + this.questionario.getDataRealizacao());
        this.txtRegional.setText("REGIONAL = " + this.questionario.getRegional().getNome());
        this.txtTipo.setText("TIPO = " + this.questionario.getTipoQuestionario());
    }

}
