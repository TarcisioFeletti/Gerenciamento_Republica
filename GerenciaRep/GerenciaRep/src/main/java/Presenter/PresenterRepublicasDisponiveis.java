/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import View.RepublicasDisponiveis.BuscarVagasView;
import View.RepublicasDisponiveis.VerInformacoesRepublicaView;


/**
 *
 * @author gabri
 */
public class PresenterRepublicasDisponiveis {
    
    private BuscarVagasView viewSolicitarMoradia;
    private VerInformacoesRepublicaView viewInformacoesRepublica;

    public PresenterRepublicasDisponiveis() {
        this.viewSolicitarMoradia = new BuscarVagasView();
        this.viewInformacoesRepublica = new VerInformacoesRepublicaView();
    }
    
    //TELAS BuscarVagasView
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
