/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import View.ManterReceitaDespesa.P0401;
import View.ManterReceitaDespesa.P0402;
import View.ManterReceitaDespesa.P0403;
import View.ManterReceitaDespesa.P0404;
import View.ManterReceitaDespesa.P0405;
import View.P0000View;

/**
 *
 * @author gabri
 */
public class PresenterManterReceitaDespesa {
    
    private P0401 viewModificarPagamento;
    private P0402 viewIncluirPagamento;
    private P0403 viewInformacaoPagamento;
    private P0404 viewJustificarPagamento;
    private P0405 viewConfirmarPagamento;

    public PresenterManterReceitaDespesa() {
        this.viewModificarPagamento = new P0401();
        this.viewIncluirPagamento = new P0402();
        this.viewInformacaoPagamento = new P0403();
        this.viewJustificarPagamento = new P0404();
        this.viewConfirmarPagamento = new P0405();
    }
    
    //BOTOES P0401
    private void buscarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                

    } 
    
    private void cadastrarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        P0402 cad = new P0402();
        P0000View.Desktop.add(cad);
        cad.setVisible(true);
    }   
    
    private void estornarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        P0404 cad = new P0404();
        P0000View.Desktop.add(cad);
        cad.setVisible(true);
    } 
    
    //ABRE TELA P0403
    private void informacoesPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        P0403 v = new P0403();
        P0000View.Desktop.add(v);
        v.setVisible(true);
    }  
    
    private void editarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                
        P0402 cad = new P0402();
        P0000View.Desktop.add(cad);
        cad.setVisible(true);
    } 
    
    //BOTOES P0402
    private void adicionarPagamentoMoradorActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }  
    
    private void removerPagamentoMoradorActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }
    
    private void confirmarSolicitacaoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        // TODO add your handling code here:
    }  
    
    //BOTAO P0404
    private void justificarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    } 
    
    //BOTAO P0405
    private void consultaResultadoMensalRepublicaActionPerformed(java.awt.event.ActionEvent evt) {                                                                 
        // TODO add your handling code here:
    } 
    
    private void confirmarRecebimentoActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }  
}
