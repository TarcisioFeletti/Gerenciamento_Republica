/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import model.Despesa;
import model.Pessoa;
import model.Republica;

/**
 *
 * @author tarci
 */
public class DespesaDAO {
    private Connection conexao;

    public DespesaDAO() {
        conexao = DBConnection.getConexao();
    }
    
    //Criar uma despesa
    public void create(Despesa despesa) throws SQLException{
        PreparedStatement ps = null;
        try {
            RepublicaDAO subQuery = new RepublicaDAO();
            Republica rep = subQuery.read(despesa.getRepublica().getNomeRepublica());
            String query = "INSERT INTO Lancamento(descricao, valor, periodicidade, idrepublica)"
                    + "VALUES(?,?,?,?)";
            ps = conexao.prepareStatement(query);
            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setString(3, despesa.getPeriocidade());
            ps.setInt(4, rep.getIdRepublica());
            ps.execute();
            Despesa temp = this.read(despesa.getDescricao(), despesa.getDataVencimento());
            query = "INSERT INTO Despesa(idDespesa, dataVencimento)  "
                    + "VALUES(?,?)";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdLancamento());
            ps.setDate(2, Date.valueOf(despesa.getDataVencimento()));
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
        }
    }
    
    public Despesa read(String descricao, LocalDate dataVencimento){
        return null;
    }
}
