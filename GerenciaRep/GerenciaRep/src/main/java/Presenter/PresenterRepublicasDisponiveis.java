/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import View.RepublicasDisponiveis.P1301;
import View.RepublicasDisponiveis.VerInformacoesRepublica;


/**
 *
 * @author gabri
 */
public class PresenterRepublicasDisponiveis {
    
    private P1301 viewSolicitarMoradia;
    private VerInformacoesRepublica viewInformacoesRepublica;

    public PresenterRepublicasDisponiveis() {
        this.viewSolicitarMoradia = new P1301();
        this.viewInformacoesRepublica = new VerInformacoesRepublica();
    }
    
    //TELAS P1301
    private void buscarRepublicaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    } 
    
    //Abre tela VerinformacoesRepublica
    private void informacoesRepublicaActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    } 
    
    private void solicitarMoradiaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    } 
    
}
