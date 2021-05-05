/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Presenter.State.StateAbstrato;
import view.P0000;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Pessoa;

/**
 *
 * @author Davidson
 */
public class PresenterP0000 {

    private P0000 tela;
    private StateAbstrato telaPrincipalState;
    private Pessoa usuario;

    public PresenterP0000(/*StateAbstrato telaPrincipalState*/) {
        //mudarState(Login);
        this.telaPrincipalState = telaPrincipalState;
    }
    
    private void mudarState(StateAbstrato novoState){
        this.telaPrincipalState = novoState;
    }
    
    public StateAbstrato login(){
        new PresenterP0001().criarLogin(tela);
    }
    //PAROU O DESENVOLVIMENTO PQ SAIU A PROVA, DEPOIS TERMINO
    public void abrirTelaInicial() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(P0000.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P0000.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P0000.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P0000.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        tela = new P0000();
        tela.setVisible(true);

        //ABRE TELA DE LOGIN - P0001
        PresenterP0001 presenterP0001 = new PresenterP0001();
        presenterP0001.criarLogin(tela);

        //CRIAR REPUBLICA - P0101
        tela.getCriarRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //telaPrincipalState.criarRepublica(){PresenterP0101 presenterP0101 = new PresenterP0101(); presenterP0101.criarRepublica(tela); //função do botão de criar republica}
                PresenterP0101 presenterP0101 = new PresenterP0101();
                presenterP0101.criarRepublica(tela); //função do botão de criar republica
            }
        });

        //MANTER REPUBLICA - P0102
        tela.getManterRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                PresenterP0102 presenterP0102 = new PresenterP0102();
                presenterP0102.manterRepublica(tela); //funcao do botão de editar republica
            }
        });

        //MANTER MORADOR - P0201
        tela.getManterMorador().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                PresenterP0201 presenterP0201 = new PresenterP0201();
                presenterP0201.manterMorador(tela); //funcao do botão de manter morador
            }
        });

        //MANTER PERFIL - P0701
        tela.getAdicionarPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                PresenterP0702 presenterP0702 = new PresenterP0702();
                presenterP0702.adicionarPerfil(tela); //funcao do botão confirmar perfil
            }
        });
    }

}
