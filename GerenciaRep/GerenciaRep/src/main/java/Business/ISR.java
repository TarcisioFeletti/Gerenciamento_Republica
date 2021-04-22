/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Lucas Carvalho
 */
public abstract class ISR {

    public float calculaISR(int nr, int nrr) {
        float isr;
        if (nr > 0) {
            isr = nrr / nr;
        } else {
            isr = nrr;
        }
        return isr;
    }
}
