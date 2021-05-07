/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter.P0000State;

import Model.SemTeto;
import Presenter.P0000Presenter;
import Service.P0002Service;
import View.LoginCadastro.NovoLoginModalView;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Carvalho
 */
public class NovoLoginState extends P0000AbstractState {

    private NovoLoginModalView view;
    private SemTeto pessoa;

    public NovoLoginState(P0000Presenter presenter, SemTeto pessoa) {
        super(presenter);
        this.pessoa = pessoa;
        view = new NovoLoginModalView(new Frame(), true);
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
                fechar();
            }
        });
        view.setVisible(true);
    }

    public NovoLoginModalView getView() {
        return view;
    }

    public SemTeto getPessoa() {
        return pessoa;
    }  

    @Override
    public void confirmarCadastro() {
        try {
            //verifica os campos
            if (this.getView().getCampoUsuario().getText().isBlank()) {
                throw new Exception("Campo usuario vazio");
            }
            if (this.getView().getCampoSenha().getText().isBlank()) {
                throw new Exception("Campo senha vazio");
            }
            if (this.getView().getCampoSenhaConfirmar().getText().isBlank()) {
                throw new Exception("Campo senha confirmar vazio");
            }
            if (!this.getView().getCampoSenhaConfirmar().getText().equals(this.getView().getCampoSenha().getText())) {
                throw new Exception("Senhas diferentes.");
            }
            //chamar a Presenter<->Service<->DAO pra fazer login//
            new P0002Service().cadastrarUsuario(this.getPessoa(), this.getView().getCampoUsuario().getText(), this.getView().getCampoSenha().getText());
            //retorna ao estado de login
            super.getPresenter().setEstado(new LoginState(this.getPresenter()));
            this.getView().dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.toString());
        }
    }

    @Override
    public void fechar() {
        //volta para o estado anterior
        this.getView().dispose();
        super.getPresenter().setEstado(new LoginState(this.getPresenter()));
    }
}
