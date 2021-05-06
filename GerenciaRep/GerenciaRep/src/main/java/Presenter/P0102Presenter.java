/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.Republica;
import view.ManterRepublica.P0102View;

/**
 *
 * @author Lucas Carvalho
 */
public class P0102Presenter {

    private P0102View view;
    private Republica republica;

    public P0102Presenter(JDesktopPane desktop) {
        view = new P0102View();
        desktop.add(view);
        view.setVisible(true);
        //recebe as informações da republica atual
        //republica = new P0102Service.recebeRepublica(/*arg com usuario*/);
        preencherCampos(republica);
        view.getEditarRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE EDITAR A REPUBLICA
                editar();
            }
        });
        view.getExcluirRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE REMOVER A REPUBLICA
                remover();
            }
        });
        view.getManterMoradores().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE MANTER MORADORES
                //new P0201Presenter(this.getPresenter().getView().getDesktop());
            }
        });
    }

    public P0102View getView() {
        return view;
    }

    public Republica getRepublica() {
        return republica;
    }

    private void preencherCampos(Republica republica) {
        this.getView().getNome().setText(republica.getNomeRepublica());
        this.getView().getEndereco().setText(republica.getEndereco());
        this.getView().getDataFundacao().setText(republica.getDataFundacao().toString());
        this.getView().getBairro().setText(republica.getBairro());
        this.getView().getPontoDeReferencia().setText(republica.getPontoReferencia());
        this.getView().getLocalizacaoGeografica().setText(republica.getLocalizacaoGeografica());
        this.getView().getVantagens().setText(republica.getVantagens());
        this.getView().getCodigoEtica().setText(republica.getCodigoEtica());
        this.getView().getNumero().setText(String.valueOf(republica.getNumero()));
        this.getView().getDespesasMediasMorador().setText(String.valueOf(republica.getDespesasMediasPorMorador()));
        this.getView().getTotalVagas().setText(String.valueOf(republica.getVagasTotal()));
        this.getView().getCep().setText(String.valueOf(republica.getCep()));
    }

    private void editar() {
        try {
            //tratamentos dos campos//
            if (this.getView().getNome().getText().isBlank()) {
                throw new Exception("O campo nome não pode ficar vazio.");
            }
            //edição da republica com os campos//
            this.getRepublica().setNomeRepublica(this.getView().getNome().getText());
            this.getRepublica().setEndereco(this.getView().getEndereco().getText());
            this.getRepublica().setDataFundacao(LocalDate.parse(this.getView().getDataFundacao().getText()));
            this.getRepublica().setBairro(this.getView().getBairro().getText());
            this.getRepublica().setPontoReferencia(this.getView().getPontoDeReferencia().getText());
            this.getRepublica().setLocalizacaoGeografica(this.getView().getLocalizacaoGeografica().getText());
            this.getRepublica().setVantagens(this.getView().getVantagens().getText());
            this.getRepublica().setCodigoEtica(this.getView().getCodigoEtica().getText());
            this.getRepublica().setNumero(Integer.parseInt(this.getView().getNumero().getText()));
            this.getRepublica().setDespesasMediasPorMorador(Integer.parseInt(this.getView().getDespesasMediasMorador().getText()));
            this.getRepublica().setVagasTotal(Integer.parseInt(this.getView().getTotalVagas().getText()));
            this.getRepublica().setCep(Double.parseDouble(this.getView().getCep().getText()));
            this.getRepublica().setVagasDisponiveis(Integer.parseInt(this.getView().getTotalVagas().getText()) - this.republica.getVagasOcupadas());
            //chamar a Presenter<->Service<->DAO pra salvar//
            //new P0102Service().editarRepublica(this.getRepublica());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
        }
    }

    private void remover() {
        try {
            var i = JOptionPane.showConfirmDialog(view, "Deseja mesmo remover?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
            if (0 == i) {
                //new P0102Service().removerRepublica(this.getRepublica());
                this.getView().dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
        }
    }
}
