package com.developer.barbosa.pcatool.modelAntigo;

import java.io.Serializable;

/**
 * Created by Messias on 28/04/2017.
 */

public class Resposta implements Serializable {

    private long id_resposta;
    private Questao questao;
    private Questionario questionario;
    private int opcao;
    private String nomeProfServ;
    private String endereco;

    public long getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(long id_resposta) {
        this.id_resposta = id_resposta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
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

}
