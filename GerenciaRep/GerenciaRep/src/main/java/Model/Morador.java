/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Davidson
 */
public class Morador extends Pessoa {
    private Republica republicaAtual;

    public Morador(Republica republicaAtual, String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, int idPessoa) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, idPessoa, false, true, false);
        this.republicaAtual = republicaAtual;
    }

    public Morador(Republica republicaAtual, String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, false, true, false);
        this.republicaAtual = republicaAtual;
    }

    

    public Republica getRepublicaAtual() {
        return republicaAtual;
    }

    public void setRepublicaAtual(Republica republicaAtual) {
        this.republicaAtual = republicaAtual;
    }
}
