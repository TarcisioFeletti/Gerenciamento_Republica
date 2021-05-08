/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.Pessoa;
import Presenter.TelaInicialState.LoginState;
import Presenter.TelaInicialState.TelaInicialAbstractState;
import View.TelaInicialView;
import java.awt.event.ActionListener;

/**
 *
 * @author Davidson
 */
public class TelaInicialPresenter {

    private TelaInicialView view;
    private TelaInicialAbstractState estado;
    private Pessoa usuario;

    public TelaInicialPresenter() {
        this.view = new TelaInicialView();
        this.view.setVisible(true);
        this.estado = new LoginState(this);
    }

    public TelaInicialView getView() {
        return view;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    public void setEstado(TelaInicialAbstractState estado) {
        this.estado = estado;
    }

    public void removeListeners() {
        // um para cada botão da presenter
        if (this.getView().getCriarRepublica().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getCriarRepublica().getActionListeners()) {
                this.getView().getCriarRepublica().removeActionListener(actionListener);
            }
        }
        if (this.getView().getBuscarVagaRepublica().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getBuscarVagaRepublica().getActionListeners()) {
                this.getView().getBuscarVagaRepublica().removeActionListener(actionListener);
            }
        }
        if (this.getView().getLogout().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getLogout().getActionListeners()) {
                this.getView().getLogout().removeActionListener(actionListener);
            }
        }
        if (this.getView().getFechar().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getFechar().getActionListeners()) {
                this.getView().getFechar().removeActionListener(actionListener);
            }
        }
        if (this.getView().getConsultarResultadoMensal().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getConsultarResultadoMensal().getActionListeners()) {
                this.getView().getConsultarResultadoMensal().removeActionListener(actionListener);
            }
        }
        if (this.getView().getManterReclamacoesSugestoes().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getManterReclamacoesSugestoes().getActionListeners()) {
                this.getView().getManterReclamacoesSugestoes().removeActionListener(actionListener);
            }
        }
        if (this.getView().getManterPerfil().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getManterPerfil().getActionListeners()) {
                this.getView().getManterPerfil().removeActionListener(actionListener);
            }
        }
        if (this.getView().getAceitarConvite().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getAceitarConvite().getActionListeners()) {
                this.getView().getAceitarConvite().removeActionListener(actionListener);
            }
        }
        if (this.getView().getRegistrarConclusaoDaTarefa().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getRegistrarConclusaoDaTarefa().getActionListeners()) {
                this.getView().getRegistrarConclusaoDaTarefa().removeActionListener(actionListener);
            }
        }
        if (this.getView().getConsultarMinhasReceitasEDespesas().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getConsultarMinhasReceitasEDespesas().getActionListeners()) {
                this.getView().getConsultarMinhasReceitasEDespesas().removeActionListener(actionListener);
            }
        }
        if (this.getView().getRegistrarPagamentoDeReceitaOuDespesa().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getRegistrarPagamentoDeReceitaOuDespesa().getActionListeners()) {
                this.getView().getRegistrarPagamentoDeReceitaOuDespesa().removeActionListener(actionListener);
            }
        }
        if (this.getView().getManterRepublica().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getManterRepublica().getActionListeners()) {
                this.getView().getManterRepublica().removeActionListener(actionListener);
            }
        }
        if (this.getView().getManterMorador().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getManterMorador().getActionListeners()) {
                this.getView().getManterMorador().removeActionListener(actionListener);
            }
        }
        if (this.getView().getConfirmarSolucaoDeReclamacoesSolucoes().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getConfirmarSolucaoDeReclamacoesSolucoes().getActionListeners()) {
                this.getView().getConfirmarSolucaoDeReclamacoesSolucoes().removeActionListener(actionListener);
            }
        }
        if (this.getView().getConvidarMoradoresAceitarConvite().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getConvidarMoradoresAceitarConvite().getActionListeners()) {
                this.getView().getConvidarMoradoresAceitarConvite().removeActionListener(actionListener);
            }
        }
        if (this.getView().getManterTarefas().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getManterTarefas().getActionListeners()) {
                this.getView().getManterTarefas().removeActionListener(actionListener);
            }
        }
        if (this.getView().getManterReceitasEDespesas().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getManterReceitasEDespesas().getActionListeners()) {
                this.getView().getManterReceitasEDespesas().removeActionListener(actionListener);
            }
        }
        if (this.getView().getFazerEstornoDeLancamentos().getActionListeners() != null) {
            for (ActionListener actionListener : this.getView().getFazerEstornoDeLancamentos().getActionListeners()) {
                this.getView().getFazerEstornoDeLancamentos().removeActionListener(actionListener);
            }
        }
    }
}
