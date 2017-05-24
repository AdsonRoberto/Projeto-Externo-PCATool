package com.developer.barbosa.pcatool.model.domain;

/**
 * Created by Messias on 23/05/2017.
 */

public class Resultado {

    private String descricaoColuna1;
    private String mediaColuna2;

    public Resultado(){

    }

    public Resultado(String descricaoColuna1, String mediaColuna2) {
        this.descricaoColuna1 = descricaoColuna1;
        this.mediaColuna2 = mediaColuna2;
    }

    public String getDescricaoColuna1() {
        return descricaoColuna1;
    }

    public void setDescricaoColuna1(String descricaoColuna1) {
        this.descricaoColuna1 = descricaoColuna1;
    }

    public String getMediaColuna2() {
        return mediaColuna2;
    }

    public void setMediaColuna2(String mediaColuna2) {
        this.mediaColuna2 = mediaColuna2;
    }
}
