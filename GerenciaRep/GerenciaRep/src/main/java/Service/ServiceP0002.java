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
public class ServiceP0002 {

    private static ServiceP0002 serviceP0002;

    private ServiceP0002() {
        
    }
    
    public static ServiceP0002 getInstancia(){
        if(serviceP0002 == null){
            serviceP0002 = new ServiceP0002();
        }
        return serviceP0002;
    }

    public void cadastrarUsuario(String nomeUsuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
