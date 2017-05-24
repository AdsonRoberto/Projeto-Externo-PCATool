package com.developer.barbosa.pcatool.model.dao;

import android.content.Context;

import com.developer.barbosa.pcatool.model.domain.Componente;
import com.developer.barbosa.pcatool.model.domain.Questionario;
import com.developer.barbosa.pcatool.model.domain.Resultado;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by Messias on 09/05/2017.
 */

public class ResultadosDAO {

    private Context context;
    public final String DEFAULT_SELECAO_REGIONAL = "TODAS AS REGIONAIS";

    public ResultadosDAO(Context context){
        this.context = context;
    }

    public int getTotalDeQuestionarios(String tipoQuestionario, String nomeRegional){
        QuestionarioDAO questionarioDAO = new QuestionarioDAO(this.context);

        // String sqlQuery = "SELECT questionario.* FROM questionario WHERE tipo_questionario LIKE '" + tipoQuestionario + "'";

        String sqlQuery = "SELECT questionario.* FROM questionario" +
                " JOIN regional ON regional.id_regional = questionario.id_regional" +
                " WHERE questionario.tipo_questionario LIKE '" + tipoQuestionario + "'";
        if(!nomeRegional.equals(DEFAULT_SELECAO_REGIONAL))
            sqlQuery += " AND regional.nome_regional LIKE '" + nomeRegional + "'";

        ArrayList<Questionario> questionarios = questionarioDAO.findByQuery(sqlQuery);

        return questionarios.size();
    }

    public ArrayList<Resultado> getResultados(String tipoQuestionario, String nomeRegional){

        ArrayList<Resultado> resultados = new ArrayList<>();

        // Criando resultados para a média dos componentes
        ArrayList<Double> mediaComonentes = getMediaComponentes(tipoQuestionario, nomeRegional);
        Resultado resultadoComponenteA = new Resultado("COMPONENTE A", String.valueOf(mediaComonentes.get(0)));
        Resultado resultadoComponenteB = new Resultado("COMPONENTE B", String.valueOf(mediaComonentes.get(1)));
        Resultado resultadoComponenteC = new Resultado("COMPONENTE C", String.valueOf(mediaComonentes.get(2)));
        Resultado resultadoComponenteD = new Resultado("COMPONENTE D", String.valueOf(mediaComonentes.get(3)));
        Resultado resultadoComponenteE = new Resultado("COMPONENTE E", String.valueOf(mediaComonentes.get(4)));
        Resultado resultadoComponenteF = new Resultado("COMPONENTE F", String.valueOf(mediaComonentes.get(5)));
        Resultado resultadoComponenteG = new Resultado("COMPONENTE G", String.valueOf(mediaComonentes.get(6)));
        Resultado resultadoComponenteH = new Resultado("COMPONENTE H", String.valueOf(mediaComonentes.get(7)));

        resultados.add(resultadoComponenteA);
        resultados.add(resultadoComponenteB);
        resultados.add(resultadoComponenteC);
        resultados.add(resultadoComponenteD);
        resultados.add(resultadoComponenteE);
        resultados.add(resultadoComponenteF);
        resultados.add(resultadoComponenteG);
        resultados.add(resultadoComponenteH);

        if (mediaComonentes.size() == 10){
            Resultado resultadoComponenteI = new Resultado("COMPONENTE I", String.valueOf(mediaComonentes.get(8)));
            Resultado resultadoComponenteJ = new Resultado("COMPONENTE J", String.valueOf(mediaComonentes.get(9)));

            resultados.add(resultadoComponenteI);
            resultados.add(resultadoComponenteJ);
        }

        double mediaEscoreEssencial = getMediaEscoreEssencial(tipoQuestionario, nomeRegional);
        Resultado resultadoMediaEscoreEssencial = new Resultado("MÉDIA ESCORE ESSENCIAL", String.valueOf(mediaEscoreEssencial));

        double mediaEscoreGeral = getMediaEscoreGeral(tipoQuestionario, nomeRegional);
        Resultado resultadoMediaEscoreGeral = new Resultado("MÉDIA ESCORE GERAL", String.valueOf(mediaEscoreGeral));

        resultados.add(resultadoMediaEscoreEssencial);
        resultados.add(resultadoMediaEscoreGeral);

        return resultados;
    }

    private double getMediaEscoreEssencial(String tipoQuestionario, String nomeRegional){
        QuestionarioDAO questionarioDAO = new QuestionarioDAO(this.context);

        // String sqlQuery = "SELECT questionario.* FROM questionario WHERE tipo_questionario LIKE '" + tipoQuestionario + "'";

        String sqlQuery = "SELECT questionario.* FROM questionario" +
                " JOIN regional ON regional.id_regional = questionario.id_regional" +
                " WHERE questionario.tipo_questionario LIKE '" + tipoQuestionario + "'";
        if(!nomeRegional.equals(DEFAULT_SELECAO_REGIONAL))
            sqlQuery += " AND regional.nome_regional LIKE '" + nomeRegional + "'";

        ArrayList<Questionario> questionarios = questionarioDAO.findByQuery(sqlQuery);

        double somatorio = 0;
        double numQuestionariosComEscore = 0;
        double media = 0;

        for(Questionario q : questionarios) {
            if (q.getEscoreEssencial() != -1){
                somatorio += q.getEscoreEssencial();
                numQuestionariosComEscore++;
            }
        }

        if(numQuestionariosComEscore != 0)
            media = new BigDecimal(somatorio).divide(new BigDecimal(numQuestionariosComEscore), 2, RoundingMode.UP).doubleValue();

        return media;
    }

    private double getMediaEscoreGeral(String tipoQuestionario, String nomeRegional){

        QuestionarioDAO questionarioDAO = new QuestionarioDAO(this.context);

        // String sqlQuery = "SELECT questionario.* FROM questionario WHERE tipo_questionario LIKE '" + tipoQuestionario + "'";

        String sqlQuery = "SELECT questionario.* FROM questionario" +
                " JOIN regional ON regional.id_regional = questionario.id_regional" +
                " WHERE questionario.tipo_questionario LIKE '" + tipoQuestionario + "'";
        if(!nomeRegional.equals(DEFAULT_SELECAO_REGIONAL))
            sqlQuery += " AND regional.nome_regional LIKE '" + nomeRegional + "'";

        ArrayList<Questionario> questionarios = questionarioDAO.findByQuery(sqlQuery);

        double somatorio = 0;
        double numQuestionariosComEscore = 0;
        double media = 0;

        for(Questionario q : questionarios) {
            if (q.getEscoreGeral() != -1){
                somatorio += q.getEscoreGeral();
                numQuestionariosComEscore++;
            }
        }

        if(numQuestionariosComEscore != 0)
            media = new BigDecimal(somatorio).divide(new BigDecimal(numQuestionariosComEscore), 2, RoundingMode.UP).doubleValue();

        return media;

    }

    private ArrayList<Double> getMediaComponentes(String tipoQuestionario, String nomeRegional){

        ArrayList<Double> medias = new ArrayList<>();

        double somaA = 0, somaB = 0, somaC = 0, somaD = 0, somaE = 0, somaF = 0, somaG = 0, somaH = 0, somaI = 0, somaJ = 0;
        double numA = 0, numB = 0, numC = 0, numD = 0, numE = 0, numF = 0, numG = 0, numH = 0, numI = 0, numJ = 0;

        ComponenteDAO componenteDAO = new ComponenteDAO(this.context);

        String sqlQuery = "SELECT componente.* FROM componente" +
                " JOIN questionario ON questionario.id_questionario = componente.id_questionario" +
                " JOIN regional ON questionario.id_regional = regional.id_regional" +
                " WHERE questionario.tipo_questionario LIKE '" + tipoQuestionario + "'";
        if(!nomeRegional.equals(DEFAULT_SELECAO_REGIONAL))
            sqlQuery += " AND regional.nome_regional LIKE '" + nomeRegional + "'";

        ArrayList<Componente> componentes = componenteDAO.findByQuery(sqlQuery);
        /*ArrayList<Componente> componentes = componenteDAO.getAll();*/

        for (Componente c : componentes) {

            if (c.getEscoreComponente() != -1){

                // if (c.getQuestionario().getTipoQuestionario().equals(tipoQuestionario) &&
                   //      c.getQuestionario().getRegional().getNome().equals(nomeRegional)){

                    if (c.getLetraComponente().startsWith("A")){

                        if (c.getLetraComponente().equals("A-A")){
                            somaA += c.getEscoreComponente();
                            numA++;
                        } else if (c.getLetraComponente().equals("A-B")) {
                            somaB += c.getEscoreComponente();
                            numB++;
                        } else if (c.getLetraComponente().equals("A-C")) {
                            somaC += c.getEscoreComponente();
                            numC++;
                        } else if (c.getLetraComponente().equals("A-D")) {
                            somaD += c.getEscoreComponente();
                            numD++;
                        } else if (c.getLetraComponente().equals("A-E")) {
                            somaE += c.getEscoreComponente();
                            numE++;
                        } else if (c.getLetraComponente().equals("A-F")) {
                            somaF += c.getEscoreComponente();
                            numF++;
                        } else if (c.getLetraComponente().equals("A-G")) {
                            somaG += c.getEscoreComponente();
                            numG++;
                        } else if (c.getLetraComponente().equals("A-H")) {
                            somaH += c.getEscoreComponente();
                            numH++;
                        } else if (c.getLetraComponente().equals("A-I")) {
                            somaI += c.getEscoreComponente();
                            numI++;
                        } else if (c.getLetraComponente().equals("A-J")) {
                            somaJ += c.getEscoreComponente();
                            numJ++;
                        }

                    } else {

                        if (c.getLetraComponente().equals("P-A")){
                            somaA += c.getEscoreComponente();
                            numA++;
                        } else if (c.getLetraComponente().equals("P-B")) {
                            somaB += c.getEscoreComponente();
                            numB++;
                        } else if (c.getLetraComponente().equals("P-C")) {
                            somaC += c.getEscoreComponente();
                            numC++;
                        } else if (c.getLetraComponente().equals("P-D")) {
                            somaD += c.getEscoreComponente();
                            numD++;
                        } else if (c.getLetraComponente().equals("P-E")) {
                            somaE += c.getEscoreComponente();
                            numE++;
                        } else if (c.getLetraComponente().equals("P-F")) {
                            somaF += c.getEscoreComponente();
                            numF++;
                        } else if (c.getLetraComponente().equals("P-G")) {
                            somaG += c.getEscoreComponente();
                            numG++;
                        } else if (c.getLetraComponente().equals("P-H")) {
                            somaH += c.getEscoreComponente();
                            numH++;
                        }

                    }

                // }

            }

        }

        double mediaA = 0, mediaB = 0, mediaC = 0, mediaD = 0, mediaE = 0, mediaF = 0, mediaG = 0, mediaH = 0,
                mediaI = 0, mediaJ = 0;
        if(numA!=0)
            mediaA = new BigDecimal(somaA).divide(new BigDecimal(numA), 2, RoundingMode.UP).doubleValue();
        if(numB!=0)
            mediaB = new BigDecimal(somaB).divide(new BigDecimal(numB), 2, RoundingMode.UP).doubleValue();
        if(numC!=0)
            mediaC = new BigDecimal(somaC).divide(new BigDecimal(numC), 2, RoundingMode.UP).doubleValue();
        if(numD!=0)
            mediaD = new BigDecimal(somaD).divide(new BigDecimal(numD), 2, RoundingMode.UP).doubleValue();
        if(numE!=0)
            mediaE = new BigDecimal(somaE).divide(new BigDecimal(numE), 2, RoundingMode.UP).doubleValue();
        if(numF!=0)
            mediaF = new BigDecimal(somaF).divide(new BigDecimal(numF), 2, RoundingMode.UP).doubleValue();
        if(numG!=0)
            mediaG = new BigDecimal(somaG).divide(new BigDecimal(numG), 2, RoundingMode.UP).doubleValue();
        if(numH!=0)
            mediaH = new BigDecimal(somaH).divide(new BigDecimal(numH), 2, RoundingMode.UP).doubleValue();

        medias.add(mediaA);
        medias.add(mediaB);
        medias.add(mediaC);
        medias.add(mediaD);
        medias.add(mediaE);
        medias.add(mediaF);
        medias.add(mediaG);
        medias.add(mediaH);

        if (tipoQuestionario.equals("ADULTO")) {

            if(numI!=0)
                mediaI = new BigDecimal(somaI).divide(new BigDecimal(numI), 2, RoundingMode.UP).doubleValue();
            if(numJ!=0)
                mediaJ = new BigDecimal(somaJ).divide(new BigDecimal(numJ), 2, RoundingMode.UP).doubleValue();

            medias.add(mediaI);
            medias.add(mediaJ);

        }

        return medias;

    }

}
