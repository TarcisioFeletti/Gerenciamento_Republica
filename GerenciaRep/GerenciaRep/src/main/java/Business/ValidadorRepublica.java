/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.time.LocalDate;

/**
 *
 * @author Lucas Carvalho
 */
public abstract class ValidadorRepublica {

    public boolean validarInclusao(String nomeRepublica, String endereco, LocalDate dataFundacao, String bairro, String pontoReferencia, String vantagens, int numero, int vagasTotal) {
        if(nomeRepublica.isBlank()){
            return false;
        }
        if(endereco.isBlank()){
            return false;
        }
        if(dataFundacao == null){
            return false;
        }
        if(bairro.isBlank()){
            return false;
        }
        if(pontoReferencia.isBlank()){
            return false;
        }
        if(vantagens.isBlank()){
            return false;
        }
        if(bairro.isBlank()){
            return false;
        }
        return true;
    }
}
