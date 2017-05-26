package br.uece.gesad.pcatoolbrasil.modelAntigo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class Questao implements Serializable {

    private long id_questao;
    private String numeroQuestao;
    private String descricao;
    private ArrayList<Resposta> respostas;

    public long getId_questao() {
        return id_questao;
    }

    public void setId_questao(long id_questao) {
        this.id_questao = id_questao;
    }

    public String getNumeroQuestao() {
        return numeroQuestao;
    }

    public void setNumeroQuestao(String numeroQuestao) {
        this.numeroQuestao = numeroQuestao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

}
