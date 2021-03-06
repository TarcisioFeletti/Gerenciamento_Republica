/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Pessoa;
import view.ManterMoradores.P0201;
import view.TelaInicial;

/**
 *
 * @author gabri
 */
public class PresenterP0201 {

    private P0201 viewManterMorador;
    private List<Pessoa> pessoaArray;

    public PresenterP0201() {
        viewManterMorador = new P0201();
        // Função para puxar a lista de moradores na service
        // preencher a tabela
    }

    //BOTÃO MANTER MORADOR - P0201
    public void manterMorador() {
        TelaInicial Desktop = PresenterTelaInicial.getTela();
        Desktop.add(viewManterMorador);
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
