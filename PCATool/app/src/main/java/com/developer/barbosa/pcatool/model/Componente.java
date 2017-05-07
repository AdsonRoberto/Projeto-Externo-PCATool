package com.developer.barbosa.pcatool.model;

import java.io.Serializable;

/**
 * Created by Messias on 06/05/2017.
 */

public class Componente implements Serializable{

    private long id_componente;
    private String letraComponente;
    private double escoreComponente;
    private Questionario questionario;

    public long getId_componente() {
        return id_componente;
    }

    public void setId_componente(long id_componente) {
        this.id_componente = id_componente;
    }

    public String getLetraComponente() {
        return letraComponente;
    }

    public void setLetraComponente(String letraComponente) {
        this.letraComponente = letraComponente;
    }

    public double getEscoreComponente() {
        return escoreComponente;
    }

    public void setEscoreComponente(double escoreComponente) {
        this.escoreComponente = escoreComponente;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

}
