/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import View.ManterReclamacoesSugestoes.P0801View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class P0801Presenter {

    private P0801View view;

    public P0801Presenter(JDesktopPane desktop) {
        this.view = new P0801View();
        desktop.add(view);
        this.view.setVisible(true);
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

    public P0801View getView() {
        return view;
    }

    public void refinarBusca() {
        try {
            
            //tratamento
            if (this.getView().getCampoBusca().getText().isBlank()) {
                //mostrar todos
            } else {
                //pego o tipo de busca
                //pego o campo de busca
                //faço a busca com a service
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
