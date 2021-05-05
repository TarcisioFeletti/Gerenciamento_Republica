/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Service.ServiceP0102;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import model.Republica;
import view.ManterRepublica.P0102;
import view.P0000;

/**
 *
 * @author Lucas Carvalho
 */
public class PresenterP0102 {

    private P0102 viewManterRepublica;
    private Republica republica;
    private ServiceP0102 serviceP0102;

    public PresenterP0102() {
        viewManterRepublica = new P0102();
        serviceP0102 = ServiceP0102.getInstancia();
        republica = serviceP0102.recebeRepublica(/*arg com usuario*/);// PUXA INFO DA REPUBLICA
        preencherCampos(this.republica);
    }

    private void preencherCampos(Republica republica) {
        this.viewManterRepublica.getNome().setText(republica.getNomeRepublica());
        this.viewManterRepublica.getEndereco().setText(republica.getEndereco());
        this.viewManterRepublica.getDataFundacao().setText(republica.getDataFundacao().toString());
        this.viewManterRepublica.getBairro().setText(republica.getBairro());
        this.viewManterRepublica.getPontoDeReferencia().setText(republica.getPontoReferencia());
        this.viewManterRepublica.getLocalizacaoGeografica().setText(republica.getLocalizacaoGeografica());
        this.viewManterRepublica.getVantagens().setText(republica.getVantagens());
        this.viewManterRepublica.getCodigoEtica().setText(republica.getCodigoEtica());
        this.viewManterRepublica.getNumero().setText(String.valueOf(republica.getNumero()));
        this.viewManterRepublica.getDespesasMediasMorador().setText(String.valueOf(republica.getDespesasMediasPorMorador()));
        this.viewManterRepublica.getTotalVagas().setText(String.valueOf(republica.getVagasTotal()));
        this.viewManterRepublica.getCep().setText(String.valueOf(republica.getCep()));
    }

    //BOTÃO MANTER REPUBLICA - P0102
    public void manterRepublica(P0000 Desktop) {
        Desktop.getDesktop().add(viewManterRepublica);
        viewManterRepublica.setVisible(true);
        viewManterRepublica.getEditarRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE EDITAR A REPUBLICA
                editar();
            }
        });
        viewManterRepublica.getExcluirRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE REMOVER A REPUBLICA
                remover();
            }
        });
        viewManterRepublica.getManterMoradores().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE MANTER MORADORES
                //manterMorador();
            }
        });

    }

    private void editar() {
        //tratamentos dos campos//
        if (this.viewManterRepublica.getNome().getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O campo nome não pode ficar vazio.");
            return;
        }
        //edição da republica com os campos//
        this.republica.setNomeRepublica(this.viewManterRepublica.getNome().getText());
        this.republica.setEndereco(this.viewManterRepublica.getEndereco().getText());
        this.republica.setDataFundacao(LocalDate.parse(this.viewManterRepublica.getDataFundacao().getText()));
        this.republica.setBairro(this.viewManterRepublica.getBairro().getText());
        this.republica.setPontoReferencia(this.viewManterRepublica.getPontoDeReferencia().getText());
        this.republica.setLocalizacaoGeografica(this.viewManterRepublica.getLocalizacaoGeografica().getText());
        this.republica.setVantagens(this.viewManterRepublica.getVantagens().getText());
        this.republica.setCodigoEtica(this.viewManterRepublica.getCodigoEtica().getText());
        this.republica.setNumero(Integer.parseInt(this.viewManterRepublica.getNumero().getText()));
        this.republica.setDespesasMediasPorMorador(Integer.parseInt(this.viewManterRepublica.getDespesasMediasMorador().getText()));
        this.republica.setVagasTotal(Integer.parseInt(this.viewManterRepublica.getTotalVagas().getText()));
        this.republica.setCep(Double.parseDouble(this.viewManterRepublica.getCep().getText()));
        this.republica.setVagasDisponiveis(Integer.parseInt(this.viewManterRepublica.getTotalVagas().getText()) - this.republica.getVagasOcupadas());
        //chamar a Presenter<->Service<->DAO pra salvar//
        try {
            this.serviceP0102.editarRepublica(this.republica);
            JOptionPane.showMessageDialog(null, "SUCESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void remover() {
        if (0 == JOptionPane.showConfirmDialog(viewManterRepublica, "MENSAGEM", "ATENÇÃO", YES_NO_OPTION)) {
            try {
                this.serviceP0102.removerRepublica(this.republica);
                JOptionPane.showMessageDialog(null, "SUCESSO");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
