/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tarci
 */
public class Pagamento {
    private int id;
    private float valor;
    private int numeroDaParcela;
    private Despesa despesa;
    private Pessoa pessoa;

    public Pagamento(int id, float valor, int numeroDaParcela, Despesa despesa, Pessoa pessoa) {
        this.id = id;
        this.valor = valor;
        this.numeroDaParcela = numeroDaParcela;
        this.despesa = despesa;
        this.pessoa = pessoa;
    }

    public Pagamento(float valor, int numeroDaParcela, Despesa despesa, Pessoa pessoa) {
        this.valor = valor;
        this.numeroDaParcela = numeroDaParcela;
        this.despesa = despesa;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public float getValor() {
        return valor;
    }

    public int getNumeroDaParcela() {
        return numeroDaParcela;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    
}
