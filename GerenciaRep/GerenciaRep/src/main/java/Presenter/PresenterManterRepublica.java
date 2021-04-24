/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.time.LocalDate;
import model.Republica;
import view.ManterRepublica.P0101;

/**
 *
 * @author Lucas Carvalho
 */
public class PresenterManterRepublica {

    private P0101 viewIncluirRepublica;

    public PresenterManterRepublica() {
        this.viewIncluirRepublica = new P0101();
    }

    private void confirmar() {
        //tratamentos dos campos//
        if (this.viewIncluirRepublica.getNome().getText().isBlank()) {
            //Mensagem de Erro
            return;
        }
        //criação da model com os campos//
        Republica model = new Republica(
                this.viewIncluirRepublica.getNome().getText(),
                this.viewIncluirRepublica.getEndereco().getText(),
                LocalDate.parse(this.viewIncluirRepublica.getDataFundacao().getText()),
                this.viewIncluirRepublica.getBairro().getText(),
                this.viewIncluirRepublica.getPontoDeReferencia().getText(),
                this.viewIncluirRepublica.getLocalizacaoGeografica().getText(),
                this.viewIncluirRepublica.getVantagens().getText(),
                Integer.parseInt(this.viewIncluirRepublica.getNumero().getText()),
                Integer.parseInt(this.viewIncluirRepublica.getTotalVagas().getText()), 1,
                Integer.parseInt(this.viewIncluirRepublica.getTotalVagas().getText()) - 1);
        //chamar a Presenter<->Service<->DAO pra salvar//
        //resposta = Service.incluiRepublica(model);
        //CONFIRMAR/NEGAR com JPanel//
        //if (resposta == null) Panel mensagem = CONFIRMADO;
        //else Panel mensagem = FALHA: + resposta;
    }

}
