/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ManterMoradores.P0202;
import view.P0000View;

/**
 *
 * @author Davidson
 */
public class PresenterP0202 {
    
    private P0202 viewEditarMorador;
    
    public PresenterP0202(){
        viewEditarMorador = new P0202();
    }
    
    //BOTÃO EDITAR MORADOR - P0202
    public void editarMorador(P0000View Desktop, int index) {
        Desktop.getDesktop().add(viewEditarMorador);
        viewEditarMorador.setVisible(true);
        viewEditarMorador.getBotaoSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO para salvar alterações do morador
                // salvarMorador(index);
            }
        });
    }
    
}
