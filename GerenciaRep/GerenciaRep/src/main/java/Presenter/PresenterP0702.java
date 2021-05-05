/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.SemTeto;
import view.ManterPerfil.P0702;
import view.P0000;

/**
 *
 * @author gabri
 */
public class PresenterP0702 {

    private P0702 viewIncluirPerfil;

    public PresenterP0702() {
        viewIncluirPerfil = new P0702();
    }

    public void adicionarPerfil(P0000 Desktop) {
        Desktop.getDesktop().add(viewIncluirPerfil);
        viewIncluirPerfil.setVisible(true);
        viewIncluirPerfil.getConfirmarPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE CONFIRMAR A INCLUSÃO
                confirmarPerfil();
            }
        });
    }

    private void confirmarPerfil() {
        /*
        //tratamentos dos campos//
        if (this.viewIncluirPerfil.getNome().getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O campo nome não pode ficar vazio.");
            return;
        }
        //criação da novaRepublica com os campos//
        SemTeto novaPessoa = new SemTeto(
                this.viewIncluirPerfil.getNome().getText(),
                this.viewIncluirPerfil.getApelido().getText(),
                this.viewIncluirPerfil.getTelefone().getText(),
                this.viewIncluirPerfil.getLinkRedeSocial().getText(),
                this.viewIncluirPerfil.getTelefoneResponsavel1().getText(),
                this.viewIncluirPerfil.getTelefoneResponsavel2().getText()
              //CONSTRUCTOR DO SEM TETO = (String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, String login, String senha)
        );
        //chamar a Presenter<->Service<->DAO pra salvar//
         */
    }
}
