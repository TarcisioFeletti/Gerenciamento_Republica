/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter.P0000State;

import Model.SemTeto;
import Presenter.P0000Presenter;
import View.LoginCadastro.PessoaNovoLoginModalView;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Carvalho
 */
public class PessoaNovoLoginState extends P0000AbstractState {

    private PessoaNovoLoginModalView view;

    public PessoaNovoLoginState(P0000Presenter presenter) {
        super(presenter);
        view = new PessoaNovoLoginModalView(new Frame(), true);
        //recria os listeners pra essa tela com addActionListener()
        this.getView().getConfirmarPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA LOGAR NO SISTEMA
                confirmarCadastro();
            }
        });
        this.getView().getCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA FECHAR O PROGRAMA
                fechar();
            }
        });
        //só se abilita a modal[setVisible(true)] DEPOIS de realizar todas as iterações
        view.setVisible(true);
    }

    public PessoaNovoLoginModalView getView() {
        return view;
    }

    @Override
    public void confirmarCadastro() {
        //troca de estado
        try {
            //verifica os campos
            if (this.getView().getNome().getText().isBlank()) {
                throw new Exception("Campo nome vazio");
            }
            if (this.getView().getApelido().getText().isBlank()) {
                throw new Exception("Campo apelido vazio");
            }
            if (this.getView().getTelefone().getText().isBlank()) {
                throw new Exception("Campo telefone vazio");
            }
            if (this.getView().getCpf().getText().isBlank()) {
                throw new Exception("Campo CPF vazio");
            }
            if (this.getView().getLinkRedeSocial().getText().isBlank()) {
                throw new Exception("Campo rede social vazio");
            }
            if (this.getView().getTelefoneResponsavel1().getText().isBlank()) {
                throw new Exception("Campo telefone responsavel 1 vazio");
            }
            if (this.getView().getTelefoneResponsavel2().getText().isBlank()) {
                throw new Exception("Campo telefone responsavel 2 vazio");
            }
            var pessoa = new SemTeto(
                    this.getView().getNome().getText(), 
                    this.getView().getApelido().getText(), 
                    this.getView().getTelefone().getText(), 
                    this.getView().getCpf().getText(), 
                    this.getView().getLinkRedeSocial().getText(),
                    this.getView().getTelefoneResponsavel1().getText(), 
                    this.getView().getTelefoneResponsavel2().getText()
            );
            this.getView().dispose();   //primeiro fecha-se a modal, antes de iniciar outra
            this.getPresenter().setEstado(new NovoLoginState(this.getPresenter(), pessoa));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    @Override
    public void fechar() {
        //volta para o estado anterior
        this.getView().dispose();
        super.getPresenter().setEstado(new LoginState(this.getPresenter()));
    }
}
