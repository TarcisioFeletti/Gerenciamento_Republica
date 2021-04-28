/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Service.ServiceP0101;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Republica;
import view.ManterRepublica.P0101;
import view.P0000;

/**
 *
 * @author Lucas Carvalho
 */
public class PresenterP0101 {

    private P0101 viewIncluirRepublica;
    private ServiceP0101 serviceP0101;

    public PresenterP0101() {
        viewIncluirRepublica = new P0101();
        serviceP0101 = ServiceP0101.getInstancia();
    }

    //BOTÃO CRIAR NOVA REPUBLICA - P0101
    public void criarRepublica(P0000 Desktop/*, usuario*/) {
        Desktop.getDesktop().add(viewIncluirRepublica);
        viewIncluirRepublica.setVisible(true);
        viewIncluirRepublica.getConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE CONFIRMAR A INCLUSÃO
                confirmar(/*usuario*/);
            }
        });
    }

    private void confirmar(/*representante*/) {
        //tratamentos dos campos//
        if (this.viewIncluirRepublica.getNome().getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O campo nome não pode ficar vazio.");
            return;
        }
        //criação da novaRepublica com os campos//
        Republica novaRepublica = new Republica(
                this.viewIncluirRepublica.getNome().getText(),
                this.viewIncluirRepublica.getEndereco().getText(),
                LocalDate.parse(this.viewIncluirRepublica.getDataFundacao().getText()),
                null,
                this.viewIncluirRepublica.getBairro().getText(),
                this.viewIncluirRepublica.getPontoDeReferencia().getText(),
                this.viewIncluirRepublica.getLocalizacaoGeografica().getText(),
                this.viewIncluirRepublica.getVantagens().getText(),
                this.viewIncluirRepublica.getCodigoEtica().getText(),
                Integer.parseInt(this.viewIncluirRepublica.getNumero().getText()),
                Integer.parseInt(this.viewIncluirRepublica.getDespesasMediasMorador().getText()),
                Integer.parseInt(this.viewIncluirRepublica.getTotalVagas().getText()),
                1,
                (Integer.parseInt(this.viewIncluirRepublica.getTotalVagas().getText()) - 1),
                Double.parseDouble(this.viewIncluirRepublica.getCep().getText()),
                0
        );
        //chamar a Presenter<->Service<->DAO pra salvar//
        try {
            this.serviceP0101.incluirRepublica(novaRepublica/*, representante*/);
            JOptionPane.showMessageDialog(null, "SUCESSO");
            limparCamposP0101();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void limparCamposP0101() {
        this.viewIncluirRepublica.getNome().setText("");
        this.viewIncluirRepublica.getEndereco().setText("");
        this.viewIncluirRepublica.getDataFundacao().setText("");
        this.viewIncluirRepublica.getBairro().setText("");
        this.viewIncluirRepublica.getPontoDeReferencia().setText("");
        this.viewIncluirRepublica.getLocalizacaoGeografica().setText("");
        this.viewIncluirRepublica.getVantagens().setText("");
        this.viewIncluirRepublica.getCodigoEtica().setText("");
        this.viewIncluirRepublica.getNumero().setText("");
        this.viewIncluirRepublica.getDespesasMediasMorador().setText("");
        this.viewIncluirRepublica.getTotalVagas().setText("");
        this.viewIncluirRepublica.getCep().setText("");
    }

}
