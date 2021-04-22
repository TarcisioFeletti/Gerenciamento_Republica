/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.List;

/**
 *
 * @author Lucas Carvalho
 */
public abstract class ICP {

    public float calculaICP(List<Integer> dppdArray, List<Integer> ddpdArray) {
        float icp;
        int dppdaux = 0;
        int ddpdaux = 0;
        for (Integer dppd : dppdArray) {
            dppdaux = dppd + dppdaux;
        }
        for (Integer ddpd : ddpdArray) {
            ddpdaux = ddpd + ddpdaux;
        }
        icp = dppdaux/ddpdaux;
        return icp;
    }
}
