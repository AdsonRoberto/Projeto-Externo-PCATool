package com.developer.barbosa.pcatool.activity.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.model.Componente;
import com.developer.barbosa.pcatool.model.ComponenteDAO;
import com.developer.barbosa.pcatool.model.Entrevistado;
import com.developer.barbosa.pcatool.model.EntrevistadoDAO;
import com.developer.barbosa.pcatool.model.Questionario;
import com.developer.barbosa.pcatool.model.QuestionarioDAO;
import com.developer.barbosa.pcatool.model.Resposta;
import com.developer.barbosa.pcatool.model.RespostaDAO;

import java.util.ArrayList;

public class Escore extends AppCompatActivity {

    private Button btnCadastrar, btnExibir, btnVoltarIinicio;

    private Questionario questionario;

    private QuestionarioDAO questionarioDAO;
    private EntrevistadoDAO entrevistadoDAO;
    private RespostaDAO respostaDAO;
    private ComponenteDAO componenteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escore);

        this.questionarioDAO = new QuestionarioDAO(this);
        this.entrevistadoDAO = new EntrevistadoDAO(this);
        this.respostaDAO = new RespostaDAO(this);
        this.componenteDAO = new ComponenteDAO(this);

        this.questionario = (Questionario) getIntent().getSerializableExtra("questionario");

        this.btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        this.btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                    r.setQuestionario(questionarioComID);
                    respostaDAO.insertResposta(r);
                }

                // Setando os componentes do Questionario
                ArrayList<Componente> componentes = questionario.getComponentes();
                for (Componente p : componentes) {
                    p.setQuestionario(questionarioComID);
                    componenteDAO.insertComponente(p);
                }

            }
        });

        this.btnExibir = (Button) findViewById(R.id.btnExibir);
        this.btnExibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Escore.this, "NUMERO DE QUESTIONARIOS: " + questionarioDAO.getAll().size(), Toast.LENGTH_LONG).show();

                teste1();
                // teste2();
                // teste3();


            }
        });

        this.btnVoltarIinicio = (Button) findViewById(R.id.btnVoltarInicio);
        this.btnVoltarIinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Cadastro.class);
                // Voltando para a Activity de Cadastro dizendo que todas as outras Activities que estão
                // em cima dela na pilha de execução deverão ser finalizadas
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("START", true);
                startActivity(intent);

            }
        });
    }

    public void teste1() {
        ArrayList<Entrevistado> entrevistados = entrevistadoDAO.getAll();

        for (Entrevistado e : entrevistados) {

            System.out.println("\n\n\n ------------------------------------------------------------ \n\n\n");

            System.out.println("ENTREVISTADO = " + e.getNome() );

            String sqlQuery1 = "SELECT questionario.* FROM questionario WHERE id_entrevistado = " + e.getId_entrevistado();
            ArrayList<Questionario> questionariosEntrevistado = questionarioDAO.findByQuery(sqlQuery1);

            System.out.println("QUESTIONARIO: ");

            for (Questionario q : questionariosEntrevistado) {

                System.out.println("ID = " + q.getId_questionario() + " DATA = " + q.getDataRealizacao() + " TIPO = " + q.getTipoQuestionario() + "\n" +
                        "EE = " + q.getEscoreEssencial() + " EG = " + q.getEscoreGeral());

                System.out.println("COMPONENTES DO QUESTIONARIO: ");

                String sqlQuery2 = "SELECT componente.* FROM componente WHERE id_questionario = " + q.getId_questionario();
                ArrayList<Componente> componentesQuestionario = componenteDAO.findByQuery(sqlQuery2);

                for(Componente p : componentesQuestionario){
                    System.out.println("COMPONENTE = " + p.getLetraComponente() + " ESCORE = " + p.getEscoreComponente());
                }
                        /*String sqlQuery3 = "SELECT resposta.* FROM resposta" +
                                " WHERE id_questionario = " + q.getId_questionario();
                        System.out.println("Respostas do Questionario: ");
                        ArrayList<Resposta> respostaQuestionario = respostaDAO.findByQuery(sqlQuery3);
                        for(Resposta r : respostaQuestionario){
                            System.out.println("NUMERO DA QUESTAO = " + r.getNumeroQuestao() + " OPCAO = " + r.getOpcao() + " NOME PROFISSIONAL OU SERVICO = " + r.getNomeProfServ() +
                                    " ENDERECO = " + r.getEndereco());
                        }*/
            }

        }

    }

    public void teste2() {
        System.out.println("\n\n ------------------------------------------------------------ \n\n");

        System.out.println("--------- LISTA DE QUESTIONARIOS ---------\n\n");

        ArrayList<Questionario> questionariosEntrevistado = questionarioDAO.getAll();
        for (Questionario q : questionariosEntrevistado) {
            System.out.println("ID = " + q.getId_questionario() +
                    " DATA DA REALIZACAO = " + q.getDataRealizacao() +
                    " TIPO = " + q.getTipoQuestionario() +
                    " REGIONAL = " + q.getRegional().getNome());
        }

        System.out.println("\n\n ------------------------------------------------------------ \n\n");
    }

    private void teste3(){
        System.out.println("\n\n ------------------------------------------------------------ \n\n");

        System.out.println("--------- LISTA DE ENTREVISTADOS ---------\n\n");

        ArrayList<Entrevistado> entrevistados = entrevistadoDAO.getAll();
        for (Entrevistado e : entrevistados) {
            System.out.println("ID = " + e.getId_entrevistado() +
                    " NOME = " + e.getNome() +
                    " IDADE = " + e.getIdade() +
                    " SEXO = " + e.getSexo());
        }

        System.out.println("\n\n ------------------------------------------------------------ \n\n");
    }

}
