/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Lucas Carvalho
 */
public class ServiceP0001 {
    
    private static ServiceP0001 serviceP0001;

    private ServiceP0001() {
        
    }
    
    public static ServiceP0001 getInstancia(){
        if(serviceP0001 == null){
            serviceP0001 = new ServiceP0001();
        }
        return serviceP0001;
    }

    public void efetuarLogin(String nomeUsuario, char[] senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
