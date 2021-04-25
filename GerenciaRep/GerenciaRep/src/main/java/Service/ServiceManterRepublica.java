/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.SQLException;
import model.Republica;

/**
 *
 * @author Lucas Carvalho
 */
public class ServiceManterRepublica throws SQLException {
    public static void incluirRepublica(Republica model){
        try{
            String resposta = ""; //<""> = DAO.incluiRepublica(model);
        }catch(SQLException e){
            throw e;
        }
        return resposta;
    }
}