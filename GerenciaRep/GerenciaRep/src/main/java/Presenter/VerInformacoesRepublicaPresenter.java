/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.Republica;
import View.RepublicasDisponiveis.VerInformacoesRepublicaView;
import java.time.format.DateTimeFormatter;
import javax.swing.JDesktopPane;

/**
 *
 * @author Lucas Carvalho
 */
public class VerInformacoesRepublicaPresenter {

    private final VerInformacoesRepublicaView view;

    public VerInformacoesRepublicaPresenter(JDesktopPane desktop, Republica republica) {
        this.view = new VerInformacoesRepublicaView();
        desktop.add(view);
        this.view.setVisible(true);
        //preencher as informacoes
        this.view.getNome().setText(republica.getNomeRepublica());
        this.view.getDataFundacao().setText(republica.getDataFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.view.getDespesaMedia().setText(String.valueOf(republica.getDespesasMediasPorMorador()));
        this.view.getTotalVagas().setText(String.valueOf(republica.getVagasTotal()));
        this.view.getVagasDisponiveis().setText(String.valueOf(republica.getVagasDisponiveis()));
        this.view.getVagasOcupadas().setText(String.valueOf(republica.getVagasOcupadas()));
        this.view.getVantagens().setText(republica.getVantagens());
        this.view.getCodEtica().setText(republica.getCodigoEtica());
        this.view.getEndereco().setText(republica.getEndereco());
        this.view.getNumero().setText(String.valueOf(republica.getNumero()));
        this.view.getBairro().setText(republica.getBairro());
        this.view.getPontoReferencia().setText(republica.getPontoReferencia());
        this.view.getLocalizacaoGeografica().setText(republica.getLocalizacaoGeografica());
        this.view.getCep().setText(String.valueOf(republica.getCep()));        
    }
}
