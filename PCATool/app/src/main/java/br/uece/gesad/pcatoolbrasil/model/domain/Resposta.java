package br.uece.gesad.pcatoolbrasil.model.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.Serializable;

/**
 * Created by Messias on 28/04/2017.
 */

@XStreamAlias("resposta")
public class Resposta implements Serializable {

    @XStreamAlias("idResposta")
    private long id_resposta;

    @XStreamAlias("numeroQuestao")
    private String numeroQuestao;

    @XStreamAlias("opcao")
    private int opcao;

    @XStreamAlias("nomeProfServ")
    private String nomeProfServ;

    @XStreamAlias("endereco")
    private String endereco;

    @XStreamOmitField
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
