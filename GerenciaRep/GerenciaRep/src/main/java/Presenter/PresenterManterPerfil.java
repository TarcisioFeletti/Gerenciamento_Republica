/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import View.ManterPerfil.P0701;
import View.ManterPerfil.P0702;
import View.TelaInicialView;

/**
 *
 * @author gabri
 */
public class PresenterManterPerfil {
    
    private P0701 viewModificarPerfil;
    private P0702 viewIncluirPerfil;

    public PresenterManterPerfil() {
        this.viewModificarPerfil = new P0701();
        this.viewIncluirPerfil = new P0702();
    }
    
    //BOTOES P0701
    private void excluirPerfilActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }  
    
    private void historicoPerfilActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }
    
    private void editarPerfilActionPerformed(java.awt.event.ActionEvent evt) {                                             
        P0702 a = new P0702();
        TelaInicialView.Desktop.add(a);
        a.setVisible(true);
    } 
    
    //BOTOES P0702
    private void confirmarPerfilActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }   
    
}
