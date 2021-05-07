/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.Republica;
import View.ManterRepublica.P0101View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Carvalho
 */
public class P0101Presenter {

    private P0101View view;

    public P0101Presenter(JDesktopPane desktop) {
        view = new P0101View();
        desktop.add(view);
        view.setVisible(true);
        view.getConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE CONFIRMAR A INCLUSÃO
                confirmar();
            }
        });
    }

    public P0101View getView() {
        return view;
    }

    private void confirmar() {
        try {
            //tratamentos dos campos//
            if (this.getView().getNome().getText().isBlank()) {
                throw new Exception("O campo nome não pode ficar vazio.");
            }
            //criação da novaRepublica com os campos//
            Republica novaRepublica = new Republica(
                    this.getView().getNome().getText(),
                    this.getView().getEndereco().getText(),
                    LocalDate.parse(this.view.getDataFundacao().getText()),
                    null,
                    this.getView().getBairro().getText(),
                    this.getView().getPontoDeReferencia().getText(),
                    this.getView().getLocalizacaoGeografica().getText(),
                    this.getView().getVantagens().getText(),
                    this.getView().getCodigoEtica().getText(),
                    Integer.parseInt(this.getView().getNumero().getText()),
                    Integer.parseInt(this.getView().getDespesasMediasMorador().getText()),
                    Integer.parseInt(this.getView().getTotalVagas().getText()),
                    1,
                    (Integer.parseInt(this.getView().getTotalVagas().getText()) - 1),
                    Double.parseDouble(this.getView().getCep().getText()),
                    0
            );
            //NA SERVICE: new RepublicaDAO().create(novaRepublica);
            //chamar a Presenter<->Service<->DAO pra salvar//
            //new P0101Service().incluirRepublica(novaRepublica/*, representante*/);
            this.getView().dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
        }
    }
}
