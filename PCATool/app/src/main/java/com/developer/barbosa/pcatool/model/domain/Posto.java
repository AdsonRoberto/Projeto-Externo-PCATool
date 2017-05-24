package com.developer.barbosa.pcatool.model.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.Serializable;

/**
 * Created by Messias on 28/04/2017.
 */

@XStreamAlias("posto")
public class Posto implements Serializable {

    @XStreamAlias("idPosto")
    private long id_posto;

    @XStreamAlias("nome")
    private String nome;

    @XStreamAlias("endereco")
    private String endereco;

    @XStreamOmitField
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
