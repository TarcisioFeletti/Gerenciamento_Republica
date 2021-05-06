/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEPRECATED;

import Service.ServiceP0002;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.LoginCadastro.P0002;
import view.P0000View;

/**
 *
 * @author Lucas Carvalho
 */
public class DEPRECATED_PresenterP0002 {
    
    private P0002 viewCadastroLogin;
    private ServiceP0002 serviceP0002;

    public DEPRECATED_PresenterP0002() {
        viewCadastroLogin = new P0002();
        serviceP0002 = serviceP0002.getInstancia();
    }

    //TELA DE LOGIN - P0002
    public void cadastrarNovoUsuario(P0000View Desktop) {
        Desktop.getDesktop().add(viewCadastroLogin);
        Dimension desktopSize = Desktop.getDesktop().getSize();
        Dimension viewCadastroLoginSize = viewCadastroLogin.getSize();
        viewCadastroLogin.setLocation((desktopSize.width - viewCadastroLoginSize.width)/2, (desktopSize.height- viewCadastroLoginSize.height)/2);
        viewCadastroLogin.setVisible(true);
        viewCadastroLogin.getBotaoCadastrarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CADASTRAR NOVO USUARIO
                inserirCadastroNovoUsuario();
            }
        });
        viewCadastroLogin.getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CANCELAR CADASTRO DE NOVO USUARIO
                viewCadastroLogin.dispose();
            }
        });
    }

    void inserirCadastroNovoUsuario() {
        //tratamentos dos campos//
        if (this.viewCadastroLogin.getCampoUsuario().getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo usuario vazio");
            return;
        }
        //chamar a Presenter<->Service<->DAO pra fazer login//
        try {
            this.serviceP0002.cadastrarUsuario(this.viewCadastroLogin.getCampoUsuario().getText(), this.viewCadastroLogin.getCampoSenha().getText());
            JOptionPane.showMessageDialog(null, "SUCESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
