/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter.P0000State;

import Presenter.P0000Presenter;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.LoginCadastro.P0002ModalView;

/**
 *
 * @author Lucas Carvalho
 */
public class NovoLoginState extends P0000AbstractState {

    private P0002ModalView view;

    public NovoLoginState(P0000Presenter presenter) {
        super(presenter);
        view = new P0002ModalView(new Frame(), true);
        view.setVisible(true);
        //recria os listeners pra essa tela com addActionListener()
        this.getView().getBotaoCadastrarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CADASTRAR O USUARIO
                confirmarCadastro();
            }
        });
        this.getView().getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CANCELAR O CADASTRO
                sair();
            }
        });
    }

    public P0002ModalView getView() {
        return view;
    }

    @Override
    public void confirmarCadastro() {
        try {
            //verifica os campos
            if (this.getView().getCampoUsuario().getText().isBlank()) {
                throw new Exception("Campo usuario vazio");
            }
            //chamar a Presenter<->Service<->DAO pra fazer login//
            //new P0002Service().cadastrarUsuario(this.viewCadastroLogin.getCampoUsuario().getText(), this.viewCadastroLogin.getCampoSenha().getText());
            //retorna ao estado de login
            super.getPresenter().setEstado(new LoginState(this.getPresenter()));
            this.getView().dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
        }
    }

    @Override
    public void sair() {
        //volta para o estado anterior
        super.getPresenter().setEstado(new LoginState(this.getPresenter()));
        this.getView().dispose();
    }
}
