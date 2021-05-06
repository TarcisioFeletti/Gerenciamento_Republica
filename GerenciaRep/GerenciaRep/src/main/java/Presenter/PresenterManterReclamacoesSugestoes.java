/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import view.ManterReclamacoesSugestoes.P0801;
import view.ManterReclamacoesSugestoes.P0802;
import view.ManterReclamacoesSugestoes.P0803;
import view.ManterTarefa.P0302;
import view.P0000View;

/**
 *
 * @author gabri
 */
public class PresenterManterReclamacoesSugestoes {
    private P0801 viewModificarReclamacoes;
    private P0802 viewIncluirReclamacao;
    private P0803 viewInformacaoReclamacao;

    public PresenterManterReclamacoesSugestoes() {
        this.viewModificarReclamacoes = new P0801();
        this.viewIncluirReclamacao = new P0802();
        this.viewInformacaoReclamacao = new P0803();
    }
    
    //BOTOES P0801
    private void buscarReclamacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }
    
    private void novaReclamacaoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        P0302 cad = new P0302();
        P0000View.Desktop.add(cad);
        cad.setVisible(true);
    }   
    
    private void confirmarSolucaoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    } 
    
    //ABRE TELA P0803
    private void informacoesReclamacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }  
    
    private void excluirReclamacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }  
    
    private void editarReclamacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }  
    
    //BOTOES P0802
    //adicionar morador na reclamacao
    private void adicionarReclamacaoMoradorActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        // TODO add your handling code here:
    }
    
    private void removerReclamacaoMoradorActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }  
    
    private void confirmarReclamacaoActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    } 
    
}
