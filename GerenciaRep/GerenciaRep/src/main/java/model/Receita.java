/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Davidson
 */
public class Receita extends Lancamento {
    private LocalDate data;
    private Republica republica;
    /*Lançamento ainda está incompleto*/

    public Receita(LocalDate data, String descricao, double valor, String periocidade, Republica republica) {
        super(descricao, valor, periocidade);
        this.data = data;
        this.republica = republica;
    }

    public LocalDate getData() {
        return data;
    }
    
}
