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
    /*Lançamento ainda está incompleto*/

    public Receita(LocalDate data, String descricao, double valor, String periocidade, Republica republica, int idLancamento) {
        super(descricao, valor, periocidade, republica, idLancamento);
        this.data = data;
    }
    
    public LocalDate getData() {
        return data;
    }
    
}
