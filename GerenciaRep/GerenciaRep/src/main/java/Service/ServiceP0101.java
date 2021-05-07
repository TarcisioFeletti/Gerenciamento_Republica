/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Republica;

/**
 *
 * @author Lucas Carvalho
 */
public class ServiceP0101 /*throws SQLException*/ {

    private static ServiceP0101 serviceP0101;

    private ServiceP0101() {
        
    }
    
    public static ServiceP0101 getInstancia(){
        if(serviceP0101 == null){
            serviceP0101 = new ServiceP0101();
        }
        return serviceP0101;
    }

    public void incluirRepublica(Republica republica) {
        /*try{
            new RepublicaDAO().create(novaRepublica);
        }catch(SQLException e){
            throw e;
        }*/
    }
}
