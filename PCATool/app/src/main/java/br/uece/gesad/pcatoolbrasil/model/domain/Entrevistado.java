package br.uece.gesad.pcatoolbrasil.model.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

@XStreamAlias("entrevistado")
public class Entrevistado implements Serializable {

    @XStreamAlias("idEntrevistado")
    private long id_entrevistado;

    @XStreamAlias("nome")
    private String nome;

    @XStreamAlias("sexo")
    private String sexo;

    @XStreamAlias("idade")
    private int idade;

    @XStreamOmitField
    private ArrayList<Questionario> questionarios;

    public long getId_entrevistado() {
        return id_entrevistado;
    }

    public void setId_entrevistado(long id_entrevistado) {
        this.id_entrevistado = id_entrevistado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<Questionario> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(ArrayList<Questionario> questionarios) {
        this.questionarios = questionarios;
    }

}
