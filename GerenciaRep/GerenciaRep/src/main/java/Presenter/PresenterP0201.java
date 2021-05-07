/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Service.ServiceP0201;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Model.Pessoa;
import View.ManterMoradores.P0201;
import View.P0000View;

/**
 *
 * @author gabri
 */
public class PresenterP0201 {

    private P0201 viewManterMorador;
    private ServiceP0201 serviceP0201;
    private List<Pessoa> pessoaArray;

    public PresenterP0201() {
        viewManterMorador = new P0201();
        serviceP0201 = ServiceP0201.getInstancia();
        //pessoaArray = serviceP0201.consultaMoradoresRepublica(/*args do usuario / republica*/); //Função para puxar a lista de moradores na service
        //preencherTabela(pessoaAray);
    }

    //BOTÃO MANTER MORADOR - P0201
    public void manterMorador(P0000View Desktop) {
        Desktop.getDesktop().add(viewManterMorador);
        viewManterMorador.setVisible(true);
        viewManterMorador.getConvidarMoradorSemTeto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO de convidar morador ou sem teto
            }
        });
        viewManterMorador.getEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO para editar chama a P0202
                PresenterP0202 presenterP0202 = new PresenterP0202();
                //presenterP0202.editarMorador(viewManterMorador.getTabelaMoradores().getSelectedRow());
            }
        });
        viewManterMorador.getRemoverDaRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO de remover morador da republica
            }
        });
        viewManterMorador.getVerHistorico().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO para ver historico do morador
            }
        });
    }

    private void preencherTabela(List<Pessoa> pessoaAray) {
        if (pessoaAray == null) {
            return;
        }
        DefaultTableModel tabela = (DefaultTableModel) this.viewManterMorador.getTabelaMoradores().getModel();
        for (int i = 0; i < pessoaAray.size(); i++) {
            tabela.addRow(new Object[]{
                pessoaArray.get(i).getNome(),
                //pessoaArray.get(i).getDataIngresso,
                //pessoaAray.get(i).getRateio
            });
        }
    }
}
