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
public class DespesaMorador {
    private Pessoa pessoa;
    private Despesa despesa;

    public DespesaMorador(Pessoa pessoa, Despesa despesa) {
        this.pessoa = pessoa;
        this.despesa = despesa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }
    
    
}
