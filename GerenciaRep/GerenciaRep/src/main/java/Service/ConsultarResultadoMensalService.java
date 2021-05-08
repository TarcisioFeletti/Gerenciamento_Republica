/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DespesaDAO;
import DAO.ReceitaDAO;
import DAO.RepublicaDAO;
import Model.Despesa;
import Model.Pessoa;
import Model.Receita;
import Model.Republica;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas Carvalho
 */
public class ConsultarResultadoMensalService {
    
    public Republica getRepublicaPorUsuario(Pessoa usuario) throws SQLException{
        try{
            return new RepublicaDAO().getRepublicaPorIdUsuario(usuario.getIdPessoa());
        }catch(SQLException e)
            throw e;
        }
    }
    
    public List<Despesa> getDespesasRepublica(Republica republica) throws SQLException{
        try{
            return new DespesaDAO().getDespesasRepublicaPorId(republica.getIdRepublica());
        }catch(SQLException e)
            throw e;
        }
    }
    
    public List<Receita> getReceitasRepublica(Republica republica) throws SQLException{
        try{
            return new ReceitaDAO().getReceitasRepublicaPorId(republica.getIdRepublica());
        }catch(SQLException e)
            throw e;
        }
    }
}
