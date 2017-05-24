package com.developer.barbosa.pcatool.modelAntigo;

import java.io.Serializable;

/**
 * Created by Messias on 28/04/2017.
 */

public class Posto implements Serializable {

    private long id_posto;
    private String nome;
    private String endereco;
    private Regional regional;

    public long getId_posto() {
        return id_posto;
    }

    public void setId_posto(long id_posto) {
        this.id_posto = id_posto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

}
