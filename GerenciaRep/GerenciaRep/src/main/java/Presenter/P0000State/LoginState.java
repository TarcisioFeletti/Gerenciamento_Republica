/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter.P0000State;

import Presenter.P0000Presenter;
import Service.P0001Service;
import View.LoginCadastro.LoginModalView;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Carvalho
 */
public class LoginState extends P0000AbstractState {

    private LoginModalView view;

    public LoginState(P0000Presenter presenter) {
        super(presenter);
        view = new LoginModalView(new Frame(), true);
        //faz um removeActionListener() em cada listener da P0000Presenter
        super.getPresenter().removeListeners();
        //recria os listeners pra essa tela com addActionListener()
        this.getView().getBotaoConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA LOGAR NO SISTEMA
                logar();
            }
        });
        this.getView().getBotaoCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CADASTRAR NOVO USUARIO
                cadastrarNovo();
            }
        });
        this.getView().getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA FECHAR O PROGRAMA
                fechar();
            }
        });
        //só se abilita a modal[setVisible(true)] DEPOIS de realizar todas as iterações
        view.setVisible(true);
    }

    public LoginModalView getView() {
        return view;
    }

    @Override
    public void logar() {
        try {
            //tratamentos dos campos//
            if (this.getView().getCampoUsuario().getText().isBlank()) {
                throw new Exception("Campo usuário não pode ficar vazio");
            }
            if (this.getView().getCampoSenha().getText().isBlank()) {
                throw new Exception("Campo senha não pode ficar vazio");
            }
            //chamar a Presenter<->Service<->DAO pra fazer login//
            var login = new P0001Service().efetuarLogin(this.getView().getCampoUsuario().getText(), this.getView().getCampoSenha().getText());
            //troca de estado
            if(login.isSemTeto()){
                this.getPresenter().setEstado(new SemTetoState(this.getPresenter()));
            }else if(login.isMorador()){
                this.getPresenter().setEstado(new MoradorState(this.getPresenter()));
            }else if(login.isRepresentante()){
                this.getPresenter().setEstado(new RepresentanteState(this.getPresenter()));
            }
            this.getView().dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void cadastrarNovo() {
        //troca de estado
        this.getView().dispose();   //primeiro fecha-se a modal, antes de iniciar outra
        this.getPresenter().setEstado(new PessoaNovoLoginState(this.getPresenter()));
    }

    @Override
    public void fechar() {
        //fecha o programa
        System.exit(0);
    }

}
