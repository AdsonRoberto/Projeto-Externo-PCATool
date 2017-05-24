package com.developer.barbosa.pcatool.util;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import com.developer.barbosa.pcatool.model.dao.ComponenteDAO;
import com.developer.barbosa.pcatool.model.dao.EntrevistadoDAO;
import com.developer.barbosa.pcatool.model.dao.EntrevistadorDAO;
import com.developer.barbosa.pcatool.model.dao.QuestionarioDAO;
import com.developer.barbosa.pcatool.model.dao.RegionalDAO;
import com.developer.barbosa.pcatool.model.dao.RespostaDAO;
import com.developer.barbosa.pcatool.model.domain.Componente;
import com.developer.barbosa.pcatool.model.domain.Entrevistado;
import com.developer.barbosa.pcatool.model.domain.Questionario;
import com.developer.barbosa.pcatool.model.domain.Regional;
import com.developer.barbosa.pcatool.model.domain.Resposta;
import com.thoughtworks.xstream.XStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Messias on 16/05/2017.
 */

public class Conversor {

    private Context context;
    private EntrevistadorDAO entrevistadorDAO;
    private EntrevistadoDAO entrevistadoDAO;
    private RegionalDAO regionalDAO;
    private ComponenteDAO componenteDAO;
    private QuestionarioDAO questionarioDAO;

    private int numeroDeQuestionariosNovos = 0;

    public static final String NOME_ARQUIVO = "BACKUP_QUEST_PCATOOL_";

    public Conversor(Context context){
        this.context = context;
        this.entrevistadorDAO = new EntrevistadorDAO(context);
        this.entrevistadoDAO = new EntrevistadoDAO(context);
        this.regionalDAO = new RegionalDAO(context);
        this.componenteDAO = new ComponenteDAO(context);
        this.questionarioDAO = new QuestionarioDAO(context);
    }

    public boolean exportarQuestionariosXml(){
        QuestionarioDAO questionarioDAO = new QuestionarioDAO(this.context);
        ComponenteDAO componenteDAO = new ComponenteDAO(this.context);
        RespostaDAO respostaDAO = new RespostaDAO(this.context);
        List<Questionario> questionarios = questionarioDAO.getAll();
        for(Questionario q : questionarios){
            String sqlQuery1 = "SELECT componente.* FROM componente WHERE id_questionario = " + q.getId_questionario();
            ArrayList<Componente> componentes = componenteDAO.findByQuery(sqlQuery1);
            q.setComponentes(componentes);
            String sqlQuery2 = "SELECT resposta.* FROM resposta WHERE id_questionario = " + q.getId_questionario();
            ArrayList<Resposta> respostas = respostaDAO.findByQuery(sqlQuery2);
            q.setRespostas(respostas);
        }

        XStream xStream = new XStream();
        xStream.alias("questionarios", List.class);
        xStream.processAnnotations(new Class[]{Questionario.class});
        String xml = xStream.toXML(questionarios);

        File file;
        FileOutputStream fileOutputStream;
        try {
            file = new File(Environment.getExternalStorageDirectory(),
                    NOME_ARQUIVO + entrevistadorDAO.getEntrevistador().getNome() + ".xml");
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(xml.getBytes());
            fileOutputStream.close();
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public ArrayList<Questionario> deXmlParaArrayObjeto(Uri uri){
        String linha = "";
        String xml = "";

        this.numeroDeQuestionariosNovos = 0;

        try {
            InputStream inputStream = this.context.getContentResolver().openInputStream(uri);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);

            BufferedReader br = new BufferedReader(inputStreamReader);

            while ( (linha = br.readLine()) != null){
                xml += linha + "\n";
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        ArrayList<Questionario> questionarios;
        XStream xStream = new XStream();
        xStream.alias("questionarios", List.class);
        xStream.processAnnotations(new Class[]{Questionario.class});
        questionarios = (ArrayList<Questionario>) xStream.fromXML(xml);

        for(Questionario q : questionarios){

            Entrevistado entrevistado = q.getEntrevistado();

            if(entrevistadoDAO.entrevistadoJaCadastrado(entrevistado))
                continue;

            numeroDeQuestionariosNovos++;

            long idEntrevistado = entrevistadoDAO.insertEntrevistado(entrevistado);
            Entrevistado entrevistadoComID = entrevistadoDAO.getEntrevistadoById(idEntrevistado);

            Regional regional = regionalDAO.getRegionalById(q.getRegional().getId_regional());
            q.setRegional(regional);

            q.setEntrevistado(entrevistadoComID);
            long id = questionarioDAO.insertQuestionario(q);
            Questionario questionarioComID = questionarioDAO.getQuestionarioById(id);

            ArrayList<Componente> componentes = q.getComponentes();
            for (Componente p : componentes) {
                p.setQuestionario(questionarioComID);
                componenteDAO.insertComponente(p);
            }

        }

        return questionarios;
    }

    public int getNumeroDeQuestionariosNovos(){
        return this.numeroDeQuestionariosNovos;
    }

}
