/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Republica;
import view.ManterMoradores.P0201;
import view.ManterRepublica.P0101;
import view.ManterRepublica.P0102;
import static view.TelaInicial.Desktop;

/**
 *
 * @author Lucas Carvalho
 */
public class PresenterManterRepublica {

    private P0101 viewIncluirRepublica;
    private P0102 viewModificarRepublica;

    public PresenterManterRepublica() {
        this.viewIncluirRepublica = new P0101();
        this.viewModificarRepublica = new P0102();
    }

    //TELA 101
    private void confirmarActionPerformed() {
        //tratamentos dos campos//
        //if (this.viewIncluirRepublica.getNome().getText().isBlank()) {
            //Mensagem de Erro
        //}
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
    
    //BOTOES 102
    private void editarRepublicaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    } 
    
    private void manterMoradoresActionPerformed(java.awt.event.ActionEvent evt) {
        P0201 a = new P0201();
        Desktop.add(a);
        a.setVisible(true);
    }   
    
    private void excluirRepublicaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    } 

}
