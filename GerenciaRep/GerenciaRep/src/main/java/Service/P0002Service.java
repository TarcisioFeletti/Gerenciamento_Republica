/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.LoginDAO;
import DAO.PessoaDAO;
import Model.SemTeto;
import java.sql.SQLException;

/**
 *
 * @author Lucas Carvalho
 */
public class P0002Service {

    public void cadastrarUsuario(SemTeto pessoa, String nomeUsuario, String senha) throws SQLException {
        try{
            new PessoaDAO().create(pessoa);
            new LoginDAO().create(pessoa, nomeUsuario, senha);
        }catch(SQLException ex){
            throw ex;
        }
    }   
}
