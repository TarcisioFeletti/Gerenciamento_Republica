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
public class SemTeto extends Pessoa {

    public SemTeto(String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, int idPessoa, String login, String senha) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, idPessoa, true, false, false, login, senha);
    }

    public SemTeto(String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, String login, String senha) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, true, false, false, login, senha);
    }

    

    
}
