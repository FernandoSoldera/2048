package com.fernando.a2048.model;

/**
 * Created by ferna on 24/11/2017.
 */

public class Pontuacao {

    private int pk_Funcionario;
    private String pontuacao;

    public Pontuacao(String pontuacao){
        this.pontuacao = pontuacao;
    }

    public int getPk_Funcionario() {
        return pk_Funcionario;
    }

    public void setPk_Funcionario(int pk_Funcionario) {
        this.pk_Funcionario = pk_Funcionario;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }
}
