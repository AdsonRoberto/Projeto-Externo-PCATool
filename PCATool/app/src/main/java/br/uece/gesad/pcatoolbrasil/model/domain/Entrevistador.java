package br.uece.gesad.pcatoolbrasil.model.domain;

/**
 * Created by Messias on 20/05/2017.
 */

public class Entrevistador {

    private String nome;

    public Entrevistador(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
