/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import model.Republica;

/**
 *
 * @author Lucas Carvalho
 */
public class ServiceP0102 /*throws SQLException*/{
    
    private static ServiceP0102 serviceP0102;
    
    private ServiceP0102(){
        
    }
    
    public static ServiceP0102 getInstancia(){
        if(serviceP0102 == null){
            serviceP0102 = new ServiceP0102();
        }
        return serviceP0102;
    }
    
    public Republica recebeRepublica(/*arg com usuario*/){
        Republica republica = null;
        //DAO.recebeRepublica(usuario);
        return republica;
    }
    
    public void editarRepublica(Republica republica){
        /*try{
            //DAO.editarRepublica(republica);
        }catch(SQLException e){
            throw e;
        }*/
    }
    
    public void removerRepublica(Republica republica){
        /*try{
            //DAO.removerRepublica(republica);
        }catch(SQLException e){
            throw e;
        }*/
    }
}
