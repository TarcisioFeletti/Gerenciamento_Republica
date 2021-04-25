/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Republica;
import view.ManterMoradores.P0201;
import view.ManterRepublica.P0101;
import view.TelaInicial;

/**
 *
 * @author Lucas Carvalho
 */
public class PresenterManterRepublica {

    private static P0101 viewIncluirRepublica = new P0101();
    
    //BOTÃO CRIAR NOVA REPUBLICA - P0101
    public static void criarRepublica() {
        TelaInicial Desktop = MainClass.getTela();
        Desktop.add(viewIncluirRepublica);
        viewIncluirRepublica.setVisible(true);
        viewIncluirRepublica.getConfirmar().addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            confirmar();
        }});
    }
    /* ESSA PRESENTER N PODE GERIR P0101 E P0102 AO MESMO TEMPO
    public PresenterManterRepublica() {
        this.viewIncluirRepublica = new P0101();
        this.viewModificarRepublica = new P0102();
    }*/

    private static void confirmar() {
        //tratamentos dos campos//
        if (viewIncluirRepublica.getNome().getText().isBlank()) {
            //JOptionPane de erro
            return;
        }
        //criação da model com os campos//
        Republica model = new Republica(
                viewIncluirRepublica.getNome().getText(),
                viewIncluirRepublica.getEndereco().getText(),
                LocalDate.parse(viewIncluirRepublica.getDataFundacao().getText()),
                viewIncluirRepublica.getBairro().getText(),
                viewIncluirRepublica.getPontoDeReferencia().getText(),
                viewIncluirRepublica.getLocalizacaoGeografica().getText(),
                viewIncluirRepublica.getVantagens().getText(),
                Integer.parseInt(viewIncluirRepublica.getNumero().getText()),
                Integer.parseInt(viewIncluirRepublica.getTotalVagas().getText()), 1,
                Integer.parseInt(viewIncluirRepublica.getTotalVagas().getText()) - 1);
        //chamar a Presenter<->Service<->DAO pra salvar//
        //try{
            //Service.incluiRepublica(model);
            //JJOptionPane(frame, "SUCESSO");
        //}catch(Exception e){
            //JOptionPane(frame, e.getmessage());
        //}
    }
    
    //BOTOES 102
    private void editarRepublicaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    } 
    
    private void manterMoradoresActionPerformed(java.awt.event.ActionEvent evt) {
        //N É AQUI QUE ISSO VEM
        /*P0201 a = new P0201();
        Desktop.add(a);
        a.setVisible(true);*/
    }   
    
    private void excluirRepublicaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    } 

}
