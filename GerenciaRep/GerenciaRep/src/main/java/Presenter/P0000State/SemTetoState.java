/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter.P0000State;

import Presenter.P0000Presenter;
import Presenter.P0101Presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lucas Carvalho
 */
public class SemTetoState extends P0000AbstractState {

    public SemTetoState(P0000Presenter presenter) {
        super(presenter);
        //remove listener da tela principal, caso existam
        super.getPresenter().removeListeners();
        //recria os listeners pra essa tela com addActionListener()
        super.getPresenter().getView().getCriarRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CRIAR UMA NOVA REPUBLICA
                criarRepublica();
            }
        });
        super.getPresenter().getView().getBuscarVagaRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA BUSCAR VAGAS EM REPUBLICAS
                buscarRepublica();
            }
        });
        super.getPresenter().getView().getBotaoSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA TROCAR DE USUÁRIO
                sair();
            }
        });
        //disable e enable em botões
        super.getPresenter().getView().getManterRepublica().setEnabled(false);
        super.getPresenter().getView().getManterMorador().setEnabled(false);
        super.getPresenter().getView().getConfirmarSolucaoDeReclamacoesSolucoes().setEnabled(false);
        super.getPresenter().getView().getConvidarMoradoresAceitarConvite().setEnabled(false);
        super.getPresenter().getView().getCriarRepublica().setEnabled(true);
        super.getPresenter().getView().getBuscarVagaRepublica().setEnabled(true);
        super.getPresenter().getView().getConsultarResultadoMensal().setEnabled(false);
        super.getPresenter().getView().getManterReclamacoesSugestoes().setEnabled(false);
        super.getPresenter().getView().getManterPerfil().setEnabled(false);
        super.getPresenter().getView().getAceitarConvite().setEnabled(false);
        super.getPresenter().getView().getManterTarefas().setEnabled(false);
        super.getPresenter().getView().getRegistrarConclusaoDaTarefa().setEnabled(false);
        super.getPresenter().getView().getManterReceitasEDespesas().setEnabled(false);
        super.getPresenter().getView().getFazerEstornoDeLancamentos().setEnabled(false);
        super.getPresenter().getView().getConsultarMinhasReceitasEDespesas().setEnabled(false);
        super.getPresenter().getView().getRegistrarPagamentoDeReceitaOuDespesa().setEnabled(false);
    }

    @Override
    public void criarRepublica() {
        new P0101Presenter(this.getPresenter().getView().getDesktop());
    }

    @Override
    public void buscarRepublica() {
        //new P1301Presenter(this.getPresenter().getView().getDesktop());
    }

    @Override
    public void sair() {
        //abrir tela de login (mudar estado)
        super.getPresenter().setEstado(new LoginState(this.getPresenter()));
    }
}
