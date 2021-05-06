/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEPRECATED;

import Service.ServiceP0001;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.LoginCadastro.P0001;
import view.P0000View;

/**
 *
 * @author Lucas Carvalho
 */
public class DEPRECATED_PresenterP0001 {

    private P0001 viewLogin;
    private ServiceP0001 serviceP0001;

    public DEPRECATED_PresenterP0001() {
        viewLogin = new P0001();
        serviceP0001 = serviceP0001.getInstancia();
    }

    //TELA DE LOGIN - P0001
    public void criarLogin(P0000View Desktop) {
        Desktop.getDesktop().add(viewLogin);
        Dimension desktopSize = Desktop.getDesktop().getSize();
        Dimension viewLoginSize = viewLogin.getSize();
        viewLogin.setLocation((desktopSize.width - viewLoginSize.width)/2, (desktopSize.height- viewLoginSize.height)/2);
        viewLogin.setVisible(true);
        viewLogin.getBotaoConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA EFETUAR LOGIN
                efetuarLogin();
            }
        });
        viewLogin.getBotaoCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CADASTRAR NOVO USUARIO
                DEPRECATED_PresenterP0002 presenterP0002 = new DEPRECATED_PresenterP0002();
                presenterP0002.cadastrarNovoUsuario(Desktop);
            }
        });
        viewLogin.getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CANCELAR (FECHAR O PROGRAMA)
                System.exit(0);;
            }
        });
    }

    private void efetuarLogin() {
        //tratamentos dos campos//
        if (this.viewLogin.getCampoUsuario().getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O campo usuário não pode ficar vazio.");
            return;
        }
        //chamar a Presenter<->Service<->DAO pra fazer login//
        try {
            this.serviceP0001.efetuarLogin(this.viewLogin.getCampoUsuario().getText(), this.viewLogin.getCampoSenha().getPassword());
            JOptionPane.showMessageDialog(null, "SUCESSO");
            //
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
