/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.Despesa;
import Model.Pessoa;
import Model.Receita;
import Service.ConsultarResultadoMensalService;
import View.ConsultarResultadoMensalRepublica.ConsultarResultadoMensalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */

// NÃO TERMINADO //
public class ConsultarResultadoMensalPresenter {

    private ConsultarResultadoMensalView view;
    private Pessoa usuario;

    public ConsultarResultadoMensalPresenter(JDesktopPane desktop, Pessoa usuario) {
        this.usuario = usuario;
        this.view = new ConsultarResultadoMensalView();
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

    public ConsultarResultadoMensalView getView() {
        return view;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void preencherDados() {
        try {
            //requisitar a lista da Service
            var republica = new ConsultarResultadoMensalService().getRepublicaPorUsuario(this.getUsuario());
            List<Despesa> listaDespesa = new ConsultarResultadoMensalService().getDespesasRepublica(republica);
            List<Receita> listaReceita = new ConsultarResultadoMensalService().getReceitasRepublica(republica);
            //tratar lista vazia
            if(listaDespesa.size() == 0 && listaReceita.size() == 0){
                
            }else if(listaDespesa.size() == 0){
                
            }else if(listaReceita.size() == 0){
                
            }
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
