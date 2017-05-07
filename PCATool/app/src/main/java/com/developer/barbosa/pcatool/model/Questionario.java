package com.developer.barbosa.pcatool.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class Questionario implements Serializable{

    private long id_questionario;
    private String dataRealizacao;
    private String tipoQuestionario;
    private double escoreEssencial;
    private double escoreGeral;
    private Entrevistado entrevistado;
    private Regional regional;
    private ArrayList<Resposta> respostas;
    private ArrayList<Componente> componentes;

    public Questionario(){
        this.respostas = new ArrayList<>();
        this.componentes = new ArrayList<>();
        this.escoreEssencial = -1;
        this.escoreGeral = -1;
    }

    public long getId_questionario() {
        return id_questionario;
    }

    public void setId_questionario(long id_questionario) {
        this.id_questionario = id_questionario;
    }

    public String getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getTipoQuestionario() {
        return tipoQuestionario;
    }

    public void setTipoQuestionario(String tipoQuestionario) {
        this.tipoQuestionario = tipoQuestionario;
    }

    public double getEscoreEssencial() {
        return escoreEssencial;
    }

    public void setEscoreEssencial(double escoreEssencial) {
        this.escoreEssencial = escoreEssencial;
    }

    public double getEscoreGeral() {
        return escoreGeral;
    }

    public void setEscoreGeral(double escoreGeral) {
        this.escoreGeral = escoreGeral;
    }

    public Entrevistado getEntrevistado() {
        return entrevistado;
    }

    public void setEntrevistado(Entrevistado entrevistado) {
        this.entrevistado = entrevistado;
    }

    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    private boolean ehPossivelCalcularEscoreEssencial(){

        int numeroDeComponentesEssenciaisSemEscore = 0;
        int limiteDeComponentesEssenciaisSemEscore = tipoQuestionario.equals("ADULTO") ? 4 : 3;

        for(Componente c : componentes){
            String letraComp = c.getLetraComponente();
            if(!letraComp.equals("A-A") && !letraComp.equals("A-I") && !letraComp.equals("A-J") && !letraComp.equals("P-G") && !letraComp.equals("P-H"))
                if (c.getEscoreComponente() == -1)
                    numeroDeComponentesEssenciaisSemEscore++;

        }

        if (numeroDeComponentesEssenciaisSemEscore >= limiteDeComponentesEssenciaisSemEscore)
            return false;

        return true;
    }

    private boolean ehPossivelCalcularEscoreGeral(){
        int numeroDeComponentesSemEscore = 0;
        int limiteDeComponentesSemEscore = tipoQuestionario.equals("ADULTO") ? 5 : 4;

        for(Componente c : componentes){
            String letraComp = c.getLetraComponente();
            if (c.getEscoreComponente() == -1)
                numeroDeComponentesSemEscore++;
        }

        if (numeroDeComponentesSemEscore >= limiteDeComponentesSemEscore)
            return false;

        return true;
    }

    public double calcularEscoreEssencial(){
        double somatorio = 0;
        double countComponentesComEscore = 0;

        if (this.ehPossivelCalcularEscoreEssencial()){

            // Fazendo o somatorio dos componentes essenciais que tem escore
            // Ja tratando os casos de o questionario ser de Adulto ou Profissional
            for (Componente c : this.componentes) {

                String letraComp = c.getLetraComponente();

                if (this.tipoQuestionario.equals("ADULTO")) {
                    if(!letraComp.equals("A-I") && !letraComp.equals("A-J")){
                        if (c.getEscoreComponente() != -1){
                            somatorio += c.getEscoreComponente();
                            countComponentesComEscore++;
                        }
                    }
                } else {
                    if(!letraComp.equals("P-G") && !letraComp.equals("P-H")){
                        if (c.getEscoreComponente() != -1){
                            somatorio += c.getEscoreComponente();
                            countComponentesComEscore++;
                        }
                    }
                }

            }

            this.escoreEssencial = new BigDecimal(somatorio).divide(new BigDecimal(countComponentesComEscore),2, RoundingMode.UP).doubleValue();

            // this.escoreEssencial = somatorio/countComponentesComEscore;

        }

        return this.escoreEssencial;
    }

    public double calcularEscoreGeral(){
        double somatorio = 0;
        double countComponentesComEscore = 0;

        if (this.ehPossivelCalcularEscoreGeral()){

            for (Componente c : this.componentes) {
                if (c.getEscoreComponente() != -1) {
                    somatorio += c.getEscoreComponente();
                    countComponentesComEscore++;
                }
            }

            this.escoreGeral = new BigDecimal(somatorio).divide(new BigDecimal(countComponentesComEscore),2,RoundingMode.UP).doubleValue();

            // this.escoreGeral = somatorio/countComponentesComEscore;

        }

        return this.escoreGeral;
    }

}
