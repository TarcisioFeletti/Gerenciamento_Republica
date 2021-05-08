/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.RepublicaDAO;
import Model.Pessoa;
import Model.Republica;
import java.sql.SQLException;

/**
 *
 * @author Lucas Carvalho
 */
public class CriarRepublicaService {

    public void incluirRepublica(Republica republica, Pessoa representante) throws SQLException {
        try {
            new RepublicaDAO().create(republica, representante);
        } catch (SQLException e) {
            throw e;
        }
    }
}
