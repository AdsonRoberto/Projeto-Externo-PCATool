package br.uece.gesad.pcatoolbrasil.modelAntigo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class Entrevistado implements Serializable {

    private long id_entrevistado;
    private String nome;
    private String sexo;
    private String dataNascimento;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Questionario> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(ArrayList<Questionario> questionarios) {
        this.questionarios = questionarios;
    }

}
