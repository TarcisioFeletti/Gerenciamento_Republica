/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.Pessoa;
import Model.Republica;
import Service.BuscarVagasService;
import View.RepublicasDisponiveis.BuscarVagasView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas Carvalho
 */
public class BuscarVagasPresenter {

    private final BuscarVagasView view;
    private final Pessoa usuario;
    private final JDesktopPane desktop;

    public BuscarVagasPresenter(JDesktopPane desktop, Pessoa usuario) {
        this.desktop = desktop;
        this.usuario = usuario;
        this.view = new BuscarVagasView();
        desktop.add(view);
        this.view.setVisible(true);
        this.view.getBotaoBusca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE REFINAR A BUSCA
                refinarBusca();
            }
        });
        this.view.getBotaoSolicitarMoradia().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE SOLICITAR ENTRADA EM REPUBLICA SELECIONADA
                solicitarMoradia();
            }
        });
        this.view.getBotaoVerInformacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE VER INFORMAÇÕES SOBRE A REPUBLICA SELECIONADA
                verInformacoes();
            }
        });
    }

    public BuscarVagasView getView() {
        return view;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public JDesktopPane getDesktop() {
        return desktop;
    }

    private void preencherDados() {
        try {
            List<Republica> dados = new BuscarVagasService().solicitarTodosDados();
            //Pega a referencia da tabela na view
            DefaultTableModel model = (DefaultTableModel) this.getView().getTabelaBusca().getModel();
            //limpa a tabela
            model.setRowCount(0);
            //preenche a tabela
            for (var dado : dados) {
                String[] linha = {dado.getNomeRepublica(), String.valueOf(dado.getDespesasMediasPorMorador()), String.valueOf(dado.getVagasDisponiveis()), String.valueOf(dado.getVagasTotal())};
                model.addRow(linha);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void refinarBusca() {
        try {
            if (!this.getView().getCampoBusca().getText().isBlank()) {
                List<Republica> dados = new BuscarVagasService().solicitarTodosDados();
                //Pega a referencia da tabela na view
                DefaultTableModel model = (DefaultTableModel) this.getView().getTabelaBusca().getModel();
                //limpa a tabela
                model.setRowCount(0);
                //preenche a tabela
                if (this.getView().getTipoBusca().getSelectedItem().toString().equals("Nome")) {
                    for (var dado : dados) {
                        if (dado.getNomeRepublica().contains(this.getView().getCampoBusca().getText())) {
                            String[] linha = {dado.getNomeRepublica(), String.valueOf(dado.getDespesasMediasPorMorador()), String.valueOf(dado.getVagasDisponiveis()), String.valueOf(dado.getVagasTotal())};
                            model.addRow(linha);
                        }
                    }
                } else if (this.getView().getTipoBusca().getSelectedItem().toString().equals("Despesa")) {
                    for (var dado : dados) {
                        if (dado.getDespesasMediasPorMorador() == Double.parseDouble(this.getView().getCampoBusca().getText())) {
                            String[] linha = {dado.getNomeRepublica(), String.valueOf(dado.getDespesasMediasPorMorador()), String.valueOf(dado.getVagasDisponiveis()), String.valueOf(dado.getVagasTotal())};
                            model.addRow(linha);
                        }
                    }
                } else if (this.getView().getTipoBusca().getSelectedItem().toString().equals("Vantagens")) {
                    for (var dado : dados) {
                        if (dado.getVantagens().contains(this.getView().getCampoBusca().getText())) {
                            String[] linha = {dado.getNomeRepublica(), String.valueOf(dado.getDespesasMediasPorMorador()), String.valueOf(dado.getVagasDisponiveis()), String.valueOf(dado.getVagasTotal())};
                            model.addRow(linha);
                        }
                    }
                }
            } else {
                this.preencherDados();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void solicitarMoradia() {
        //verificação de elemento selecionado
        //pegar elemento selecionado
        //criar uma model de solicitacao com usuario (pessoa), republica desejada
        //solicitar inserção na DAO
        //retornar caixa de dialogo com "solicitação realizada"
    }

    public void verInformacoes() {
        try {
            if(this.getView().getTabelaBusca().getSelectedRow()==-1){
               throw new Exception("Nenhuma republuica selecionada."); 
            }
            var republica = new BuscarVagasService().getRepublicaSelecionadaPorNome(this.getView().getTabelaBusca().getValueAt(this.getView().getTabelaBusca().getSelectedRow(), 0).toString());
            new VerInformacoesRepublicaPresenter(this.getDesktop() ,republica);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
