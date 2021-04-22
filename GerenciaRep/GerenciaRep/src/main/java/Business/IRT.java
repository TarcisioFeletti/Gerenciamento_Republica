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
public abstract class IRT {

    public float calculaIRT(int tam, int tcm) {
        float irt;
        if (tam > 0) {
            irt = tcm / tam;
        } else {
            irt = tcm;
        }
        return irt;
    }
}
