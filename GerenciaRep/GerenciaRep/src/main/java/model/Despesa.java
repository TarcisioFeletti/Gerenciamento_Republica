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
public class Despesa extends Lancamento {
    private LocalDate dataVencimento;
    
    /*Lançamento ainda está incompleto*/

    public Despesa(LocalDate dataVencimento, String descricao, double valor, String periocidade, Republica republica, int idLancamento) {
        super(descricao, valor, periocidade, republica, idLancamento);
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
    
    
}
