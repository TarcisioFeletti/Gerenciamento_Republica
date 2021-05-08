/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.RepublicaDAO;
import Model.Republica;
import Model.VagaRepublicaModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas Carvalho
 */
public class BuscarVagasService {

    public List<Republica> solicitarTodosDados() throws SQLException {
        try {
            return new RepublicaDAO().getAll();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Republica getRepublicaSelecionadaPorNome(String nome) throws SQLException {
        try {
            return new RepublicaDAO().read(nome);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void solicitarMoradia(VagaRepublicaModel vagaRepublicaModel) throws SQLException {
        try {
            new RequisitarMoradiaDAO().create(vagaRepublicaModel);
        } catch (SQLException e) {
            throw e;
        }
    }
}
