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
import view.LoginCadastro.P0001ModalView;

/**
 *
 * @author Lucas Carvalho
 */
public class LoginState extends P0000AbstractState {

    private P0001ModalView view;

    public LoginState(P0000Presenter presenter) {
        super(presenter);
        view = new P0001ModalView(new Frame(), true);
        view.setVisible(true);
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
                sair();
            }
        });
    }

    public P0001ModalView getView() {
        return view;
    }

    @Override
    public void logar() {
        try {
            //tratamentos dos campos//
            if (this.getView().getCampoUsuario().getText().isBlank()) {
                throw new Exception("Campo usuário não pode ficar vazio");
            }
            //chamar a Presenter<->Service<->DAO pra fazer login//
            //this.serviceP0001.efetuarLogin(this.viewLogin.getCampoUsuario().getText(), this.viewLogin.getCampoSenha().getPassword());
            //troca de estado
            /*if(login é sem teto){*/
                this.getPresenter().setEstado(new SemTetoState(this.getPresenter()));
            /*}else if(login é morador){
                this.getPresenter().setEstado(new MoradorState(this.getPresenter()));
            }else if(login é representante){
                this.getPresenter().setEstado(new RepresentanteState(this.getPresenter()));
            }*/
            this.getView().dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void cadastrarNovo() {
        //troca de estado
        this.getPresenter().setEstado(new NovoLoginState(this.getPresenter()));
        this.getView().dispose();
    }

    @Override
    public void sair() {
        //fecha o programa
        System.exit(0);
    }

}
