/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import View.ManterTarefa.P0301;
import View.ManterTarefa.P0302;
import View.ManterTarefa.P0303;
import View.P0000View;



/**
 *
 * @author gabri
 */
public class PresenterManterTarefa {
    
    private P0301 viewModificarTarefa;
    private P0302 viewIncluirTarefa;
    private P0303 viewTarefaConcluidas;

    public PresenterManterTarefa() {
        this.viewModificarTarefa = new P0301();
        this.viewIncluirTarefa = new P0302();
        this.viewTarefaConcluidas = new P0303();
    }
    
    //TELAS 301
    private void buscarTarefaActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    } 
    
    private void cadastrarTarefaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        P0302 cad = new P0302();
        P0000View.Desktop.add(cad);
        cad.setVisible(true);
    }  
    
    private void excluirTarefaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }   
    
    private void editarTarefaActionPerformed(java.awt.event.ActionEvent evt) {                                             
        P0302 cad = new P0302();
        P0000View.Desktop.add(cad);
        cad.setVisible(true);
    } 
    
    //TELAS 302
    private void confirmarTarefaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }  
    
    private void adicionarTarefaMorardorActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }
    
    private void removerTarefaMoradorActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }  
    
    //TELA 303
    private void tarefaConcluidaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }   
    
}
