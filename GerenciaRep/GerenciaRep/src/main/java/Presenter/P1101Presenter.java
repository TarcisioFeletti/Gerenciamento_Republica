/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import View.ConsultarResultadoMensalRepublica.P1101View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class P1101Presenter {

    private P1101View view;

    public P1101Presenter(JDesktopPane desktop) {
        this.view = new P1101View();
        desktop.add(this.view);
        preencherDados();
        this.getView().getBuscarResultadoRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA REFINAR A BUSCA
                refinarBusca();
            }
        });
        this.getView().getVisualizarGrafico().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO PARA VISUALIZAR GRAFICO DA BUSCA SELECIONADA
                visualizarGrafico();
            }
        });
    }

    public P1101View getView() {
        return view;
    }

    public void preencherDados() {
        try {
            //requisitar a lista da Service
            //tratar lista vazia
            //preencher os anos na lista
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void refinarBusca() {
        try {
            //requisitar a lista da Service
            //tratar lista vazia
            //preencher os dados na lista
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void visualizarGrafico() {
        try {
            //requisitar a lista da Service
            //tratar lista vazia
            //criar grafico com a lista(?)
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
