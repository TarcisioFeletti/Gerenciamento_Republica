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
public class MoradorState extends P0000AbstractState {

    public MoradorState(P0000Presenter presenter) {
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
        super.getPresenter().getView().getLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA TROCAR DE USUÁRIO
                logout();
            }
        });
        super.getPresenter().getView().getFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA TROCAR DE USUÁRIO
                fechar();
            }
        });
        super.getPresenter().getView().getConsultarResultadoMensal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CONSULTAR RESULTADO MENSAL
                consultarResultadoMensal();
            }
        });
        super.getPresenter().getView().getManterReclamacoesSugestoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA MANTER RECLAMAÇÕES / SUGESTÕES
                manterReclamacoesSugestoes();
            }
        });
        super.getPresenter().getView().getManterPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA MANTER PERFIL
                manterPerfil();
            }
        });
        super.getPresenter().getView().getAceitarConvite().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA ACEITAR CONVITE
                aceitarConvite();
            }
        });
        super.getPresenter().getView().getRegistrarConclusaoDaTarefa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA REGISTRAR CONCLUSÃO DE TAREFA
                registrarConclusaoDaTarefa();
            }
        });
        super.getPresenter().getView().getConsultarMinhasReceitasEDespesas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CONSULTAR MINHAS RECEITAS E DESPESAS
                consultarMinhasReceitasEDespesas();
            }
        });
        super.getPresenter().getView().getRegistrarPagamentoDeReceitaOuDespesa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA REGISTRAR PAGAMENTO DE RECEITA OU DESPEZA
                registrarPagamentoDeReceitaOuDespesa();
            }
        });
        //disable e enable em botões
        super.getPresenter().getView().getManterRepublica().setEnabled(false);
        super.getPresenter().getView().getManterMorador().setEnabled(false);
        super.getPresenter().getView().getConfirmarSolucaoDeReclamacoesSolucoes().setEnabled(false);
        super.getPresenter().getView().getConvidarMoradoresAceitarConvite().setEnabled(false);
        super.getPresenter().getView().getCriarRepublica().setEnabled(true);
        super.getPresenter().getView().getBuscarVagaRepublica().setEnabled(true);
        super.getPresenter().getView().getConsultarResultadoMensal().setEnabled(true);
        super.getPresenter().getView().getManterReclamacoesSugestoes().setEnabled(true);
        super.getPresenter().getView().getManterPerfil().setEnabled(true);
        super.getPresenter().getView().getAceitarConvite().setEnabled(true);
        super.getPresenter().getView().getManterTarefas().setEnabled(false);
        super.getPresenter().getView().getRegistrarConclusaoDaTarefa().setEnabled(true);
        super.getPresenter().getView().getManterReceitasEDespesas().setEnabled(false);
        super.getPresenter().getView().getFazerEstornoDeLancamentos().setEnabled(false);
        super.getPresenter().getView().getConsultarMinhasReceitasEDespesas().setEnabled(true);
        super.getPresenter().getView().getRegistrarPagamentoDeReceitaOuDespesa().setEnabled(true);
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
    public void logout() {
        this.getPresenter().setEstado(new LoginState(this.getPresenter()));
    }

    @Override
    public void fechar() {
        System.exit(0);
    }

    @Override
    public void consultarResultadoMensal() {
        //new P1101Presenter(this.getPresenter().getView().getDesktop());
    }

    @Override
    public void manterReclamacoesSugestoes() {
        //new P0801Presenter(this.getPresenter().getView().getDesktop());
    }

    @Override
    public void manterPerfil() {
        //new P0701Presenter(this.getPresenter().getView().getDesktop());
    }

    @Override
    public void aceitarConvite() {
        //new P0502Presenter(this.getPresenter().getView().getDesktop());
    }

    @Override
    public void registrarConclusaoDaTarefa() {
        //new P0303Presenter(this.getPresenter().getView().getDesktop());
    }

    @Override
    public void consultarMinhasReceitasEDespesas() {
        //new P1001Presenter(this.getPresenter().getView().getDesktop());
    }

    @Override
    public void registrarPagamentoDeReceitaOuDespesa() {
        //new P1002Presenter(this.getPresenter().getView().getDesktop());
    }
}
