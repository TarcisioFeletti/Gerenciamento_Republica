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
public class ServiceP0201 /*throes SQLException*/{
    
    private static ServiceP0201 serviceP0201;

    private ServiceP0201() {
        
    }
    
    public static ServiceP0201 getInstancia(){
        if(serviceP0201 == null){
            serviceP0201 = new ServiceP0201();
        }
        return serviceP0201;
    }

    public void consultaMoradoresRepublica(/*args do usuario / republica*/) {
        /*try{
            //DAO.consultaMoradoresRepublica(args do usuario / republica);
        }catch(SQLException e){
            throw e;
        }*/
    }
}
