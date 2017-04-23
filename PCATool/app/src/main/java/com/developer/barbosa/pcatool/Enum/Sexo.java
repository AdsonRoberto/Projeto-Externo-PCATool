package com.developer.barbosa.pcatool.Enum;

/**
 * Created by Bruno Barbosa on 10/01/2017.
 */

public enum Sexo {
    MASCULINO("MASCULINO"),
    FEMININO("FEMININO");

    private String sexo;

    private Sexo(String sexo){
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return sexo;
    }
}
