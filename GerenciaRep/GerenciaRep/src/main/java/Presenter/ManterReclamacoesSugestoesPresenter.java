/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.Pessoa;
import Model.ReclamacaoSugestao;
import Service.ManterReclamacoesSugestoesService;
import View.ManterReclamacoesSugestoes.ManterReclamacoesSugestoesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class ManterReclamacoesSugestoesPresenter {

    private ManterReclamacoesSugestoesView view;
    private Pessoa usuario;

    public ManterReclamacoesSugestoesPresenter(JDesktopPane desktop, Pessoa usuario) {
        this.usuario = usuario;
        this.view = new ManterReclamacoesSugestoesView();
        desktop.add(view);
        this.view.setVisible(true);
        refinarBusca();
        this.getView().getBuscarReclamacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA REFINAR A BUSCA DE RECLAMACOES/SUGESTOES
                refinarBusca();
            }
        });
        this.getView().getNovaReclamacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CRIAR UMA NOVA RECLAMACAO/SUGESTAO
                novaReclamacaoSugestao();
            }
        });
        this.getView().getConfirmarSolucao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA CONFIRMAR A RECLAMACAO/SUGESTAO SELECIONADA
                confirmarReclamacaoSugestao();
            }
        });
        this.getView().getInformacoesReclamacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA VISUALIZAR A RECLAMACAO/SUGESTAO SELECIONADA
                visualizarReclamacaoSugestao();
            }
        });
        this.getView().getExcluirReclamacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA EXCLUIR A RECLAMACAO/SUGESTAO SELECIONADA
                excluirReclamacaoSugestao();
            }
        });
        this.getView().getConfirmarSolucao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA EDITAR A RECLAMACAO/SUGESTAO SELECIONADA
                editarReclamacaoSugestao();
            }
        });
    }

    public ManterReclamacoesSugestoesView getView() {
        return view;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void refinarBusca() {
        try {
            List<ReclamacaoSugestao> lista;
            if (this.getView().getCampoBusca().getText().isBlank()) {
                lista = new ManterReclamacoesSugestoesService().getAllReclamacoesSugestoes(this.getUsuario());
            } else if (this.getView().getTipoBusca().toString().equals("Pessoa")) {
                lista = new ManterReclamacoesSugestoesService().getReclamacoesSugestoesPorPessoa(this.getView().getCampoBusca().getText());
            } else {
                lista = new ManterReclamacoesSugestoesService().getReclamacoesSugestoesPorDescricao(this.getView().getCampoBusca().getText());
            }
            //exibo o resultado na tabela
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void novaReclamacaoSugestao() {
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void confirmarReclamacaoSugestao() {
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void visualizarReclamacaoSugestao() {
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void excluirReclamacaoSugestao() {
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void editarReclamacaoSugestao() {
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
