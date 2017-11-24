package com.fernando.a2048.model;

/**
 * Created by ferna on 24/11/2017.
 */

public class Pontuacao {

    private int pk_Pontuacao;
    private String pontuacao;

    public Pontuacao(String pontuacao){
        this.pontuacao = pontuacao;
    }

    public Pontuacao(){}

    public int getPk_Pontuacao() {
        return pk_Pontuacao;
    }

    public void setPk_Pontuacao(int pk_Pontuacao) {
        this.pk_Pontuacao = pk_Pontuacao;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }
}
