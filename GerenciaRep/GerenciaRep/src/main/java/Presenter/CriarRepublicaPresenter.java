/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.Pessoa;
import Model.Republica;
import Service.CriarRepublicaService;
import View.ManterRepublica.CriarRepublicaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Carvalho
 */
public class CriarRepublicaPresenter {

    private final CriarRepublicaView view;
    private final Pessoa usuario;

    public CriarRepublicaPresenter(JDesktopPane desktop, Pessoa usuario) {
        this.usuario = usuario;
        this.view = new CriarRepublicaView();
        desktop.add(view);
        this.view.setVisible(true);
        this.view.getConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE CONFIRMAR A INCLUSÃO
                confirmar();
            }
        });
    }

    public CriarRepublicaView getView() {
        return view;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    private void confirmar() {
        try {
            //tratamentos dos campos//
            if (this.getView().getNome().getText().isBlank()) {
                throw new Exception("O campo nome não pode ficar vazio.");
            }
            if (this.getView().getDataFundacao().getText().isBlank()) {
                throw new Exception("O campo de data de fundação não pode ficar vazio.");
            }
            if (this.getView().getDespesasMediasMorador().getText().isBlank()) {
                throw new Exception("O campo despesas médias por morador não pode ficar vazio.");
            }
            if (this.getView().getTotalVagas().getText().isBlank()) {
                throw new Exception("O campo total de vagas não pode ficar vazio.");
            }
            if (this.getView().getVantagens().getText().isBlank()) {
                throw new Exception("O campo vantagens não pode ficar vazio.");
            }
            if (this.getView().getEndereco().getText().isBlank()) {
                throw new Exception("O campo logradouro não pode ficar vazio.");
            }
            if (this.getView().getBairro().getText().isBlank()) {
                throw new Exception("O campo bairro não pode ficar vazio.");
            }
            if (this.getView().getPontoDeReferencia().getText().isBlank()) {
                throw new Exception("O campo ponto de referencia não pode ficar vazio.");
            }
            if (this.getView().getCep().getText().isBlank()) {
                throw new Exception("O campo CEP não pode ficar vazio.");
            }
            if (this.getView().getNumero().getText().isBlank()) {
                throw new Exception("O campo número não pode ficar vazio.");
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
            //chamar a Presenter<->Service<->DAO pra salvar//
            new CriarRepublicaService().incluirRepublica(novaRepublica, this.getUsuario());
            this.getView().dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
        }
    }
}
