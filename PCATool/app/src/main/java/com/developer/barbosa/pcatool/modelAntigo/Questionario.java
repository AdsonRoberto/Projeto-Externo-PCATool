package com.developer.barbosa.pcatool.modelAntigo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class Questionario implements Serializable {

    private long id_questionario;
    private String dataRealizacao;
    private String tipoFormulario;
    private Entrevistado entrevistado;
    private Posto posto;
    private ArrayList<Resposta> respostas;

    public Questionario(){
        this.respostas = new ArrayList<>();
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

    public Entrevistado getEntrevistado() {
        return entrevistado;
    }

    public void setEntrevistado(Entrevistado entrevistado) {
        this.entrevistado = entrevistado;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    public String getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(String tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
    }
}
