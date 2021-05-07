/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author tarci
 */
public class Historico {
    private Pessoa pessoa;
    private Republica republica;
    private LocalDate referenciaData;
    private int nr;
    private int nrr;
    private int tam;
    private int tcm;
    private int dppd;
    private int ddpd;
    private float isr;
    private float irt;
    private float icp;

    public Historico(Pessoa pessoa, Republica republica, LocalDate referenciaData, int nr, int nrr, int tam, int tcm, int dppd, int ddpd, float isr, float irt, float icp) {
        this.pessoa = pessoa;
        this.republica = republica;
        this.referenciaData = referenciaData;
        this.nr = nr;
        this.nrr = nrr;
        this.tam = tam;
        this.tcm = tcm;
        this.dppd = dppd;
        this.ddpd = ddpd;
        this.isr = isr;
        this.irt = irt;
        this.icp = icp;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Republica getRepublica() {
        return republica;
    }

    public LocalDate getReferenciaData() {
        return referenciaData;
    }

    public int getNr() {
        return nr;
    }

    public int getNrr() {
        return nrr;
    }

    public int getTam() {
        return tam;
    }

    public int getTcm() {
        return tcm;
    }

    public int getDppd() {
        return dppd;
    }

    public int getDdpd() {
        return ddpd;
    }

    public float getIsr() {
        return isr;
    }

    public float getIrt() {
        return irt;
    }

    public float getIcp() {
        return icp;
    }
    
    
    
    
}
