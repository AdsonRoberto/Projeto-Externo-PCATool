package com.developer.barbosa.pcatool.model;

import java.io.Serializable;

/**
 * Created by Messias on 28/04/2017.
 */

public class Resposta implements Serializable{

    private long id_resposta;
    private String numeroQuestao;
    private int opcao;
    private String nomeProfServ;
    private String endereco;
    private Questionario questionario;

    public long getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(long id_resposta) {
        this.id_resposta = id_resposta;
    }

    public String getNumeroQuestao() {
        return numeroQuestao;
    }

    public void setNumeroQuestao(String numeroQuestao) {
        this.numeroQuestao = numeroQuestao;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public String getNomeProfServ() {
        return nomeProfServ;
    }

    public void setNomeProfServ(String nomeProfServ) {
        this.nomeProfServ = nomeProfServ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }
}
