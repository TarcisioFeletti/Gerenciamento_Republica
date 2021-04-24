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

    public Morador(Republica republicaAtual, String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, int idPessoa, boolean semTeto, boolean morador, boolean representante, String login, String senha) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, idPessoa, semTeto, morador, representante, login, senha);
        this.republicaAtual = republicaAtual;
    }

    public Morador(Republica republicaAtual, String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, boolean semTeto, boolean morador, boolean representante, String login, String senha) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, semTeto, morador, representante, login, senha);
        this.republicaAtual = republicaAtual;
    }

    

    public Republica getRepublicaAtual() {
        return republicaAtual;
    }

    public void setRepublicaAtual(Republica republicaAtual) {
        this.republicaAtual = republicaAtual;
    }
}
