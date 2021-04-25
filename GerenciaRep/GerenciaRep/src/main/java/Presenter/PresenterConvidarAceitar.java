/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import view.ConvidarAceitar.P0501;
import view.ConvidarAceitar.P0502;

/**
 *
 * @author gabri
 */
public class PresenterConvidarAceitar {
   
    private P0501 viewAceitarPerfil;
    private P0502 viewAceitarRepublica;

    public PresenterConvidarAceitar() {
        this.viewAceitarPerfil = new P0501();
        this.viewAceitarRepublica = new P0502();
    }
    
    //BOTOES P0501
    private void recusarPerfilActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }  
    
    private void aceitarPerfilActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }  
    
    private void convidarPerfilActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }   
    
    //BOTOES P0502
    private void recusarRepublicaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }  
    
    private void aceitarRepublicaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }
}
