/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Davidson
 */
public abstract class Lancamento {
    private String descricao;
    private double valor;
    private String periocidade;
    private Republica republica;
    private int idLancamento;
    
    
    /*Lançamento ainda está incompleto*/

    public Lancamento(String descricao, double valor, String periocidade, Republica republica, int idLancamento) {
        this.descricao = descricao;
        this.valor = valor;
        this.periocidade = periocidade;
        this.republica = republica;
        this.idLancamento = idLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getPeriocidade() {
        return periocidade;
    }

    public int getIdLancamento() {
        return idLancamento;
    }

    public Republica getRepublica() {
        return republica;
    }
    
}
