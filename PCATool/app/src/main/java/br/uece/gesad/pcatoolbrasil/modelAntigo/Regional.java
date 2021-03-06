package br.uece.gesad.pcatoolbrasil.modelAntigo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Messias on 28/04/2017.
 */

public class Regional implements Serializable {

    private long id_regional;
    private String nome;
    private String endereco;
    private ArrayList<Posto> postos;

    public long getId_regional() {
        return id_regional;
    }

    public void setId_regional(long id_regional) {
        this.id_regional = id_regional;
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

    public ArrayList<Posto> getPostos() {
        return postos;
    }

    public void setPostos(ArrayList<Posto> postos) {
        this.postos = postos;
    }

}
