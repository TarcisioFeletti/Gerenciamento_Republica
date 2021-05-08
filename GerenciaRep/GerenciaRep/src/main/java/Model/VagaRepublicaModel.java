/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lucas Carvalho
 */
public class VagaRepublicaModel {

    private int pessoaId;
    private int republicaId;

    public VagaRepublicaModel(int pessoaId, int republicaId) {
        this.pessoaId = pessoaId;
        this.republicaId = republicaId;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public int getRepublicaId() {
        return republicaId;
    }

}
