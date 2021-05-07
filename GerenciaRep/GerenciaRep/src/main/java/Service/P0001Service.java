/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.LoginDAO;
import Model.Pessoa;
import java.sql.SQLException;

/**
 *
 * @author Lucas Carvalho
 */
public class P0001Service {
    
    public Pessoa efetuarLogin(String nomeUsuario, String senha) throws SQLException {
        try {
            return new LoginDAO().read(nomeUsuario, senha);
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
