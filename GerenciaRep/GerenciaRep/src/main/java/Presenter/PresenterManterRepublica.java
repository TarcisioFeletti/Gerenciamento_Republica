/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import model.Republica;
import view.ManterRepublica.P0101;
import view.TelaInicial;

/**
 *
 * @author Lucas Carvalho
 */
public class PresenterManterRepublica {

    private static P0101 viewIncluirRepublica = new P0101();

    public static void criarRepublica() {
        TelaInicial Desktop = MainClass.getTela();
        Desktop.add(viewIncluirRepublica);
        viewIncluirRepublica.setVisible(true);
        viewIncluirRepublica.getConfirmar().addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            confirmar();
        }});
    }

    public PresenterManterRepublica() {
        this.viewIncluirRepublica = new P0101();
    }

    private static void confirmar() {
        //tratamentos dos campos//
        if (viewIncluirRepublica.getNome().getText().isBlank()) {
            //JOptionPane de erro
            return;
        }
        //criação da model com os campos//
        Republica model = new Republica(
                viewIncluirRepublica.getNome().getText(),
                viewIncluirRepublica.getEndereco().getText(),
                LocalDate.parse(viewIncluirRepublica.getDataFundacao().getText()),
                viewIncluirRepublica.getBairro().getText(),
                viewIncluirRepublica.getPontoDeReferencia().getText(),
                viewIncluirRepublica.getLocalizacaoGeografica().getText(),
                viewIncluirRepublica.getVantagens().getText(),
                Integer.parseInt(viewIncluirRepublica.getNumero().getText()),
                Integer.parseInt(viewIncluirRepublica.getTotalVagas().getText()), 1,
                Integer.parseInt(viewIncluirRepublica.getTotalVagas().getText()) - 1);
        //chamar a Presenter<->Service<->DAO pra salvar//
        //try{
            //Service.incluiRepublica(model);
            //JJOptionPane(frame, "SUCESSO");
        //}catch(Exception e){
            //JOptionPane(frame, e.getmessage());
        //}
    }

}
