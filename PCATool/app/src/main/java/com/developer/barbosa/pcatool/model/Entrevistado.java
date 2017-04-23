package com.developer.barbosa.pcatool.model;

import com.developer.barbosa.pcatool.Enum.Sexo;
import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by Bruno Barbosa on 10/01/2017.
 */

@Table
public class Entrevistado extends SugarRecord {

    private String nome;

    private Sexo sexo;

    public Entrevistado(){}

    public Entrevistado(String nome, Sexo sexo){
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
