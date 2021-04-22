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
public class Morador extends Pessoa {
    private Republica republicaAtual;

    public Morador(Republica republicaAtual, String nome, String apelido, int telefone, int cpf, String redesSociais, int contato1, int contat2, int id) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2,id);
        this.republicaAtual = republicaAtual;
    }

    public Republica getRepublicaAtual() {
        return republicaAtual;
    }

    public void setRepublicaAtual(Republica republicaAtual) {
        this.republicaAtual = republicaAtual;
    }    
}
