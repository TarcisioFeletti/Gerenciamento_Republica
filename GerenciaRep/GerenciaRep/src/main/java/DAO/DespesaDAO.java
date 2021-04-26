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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import model.Despesa;
import model.Pessoa;
import model.Republica;
import model.Tarefa;

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
            String query = "INSERT INTO Lancamento(descricao, valor, periodicidade)"
                    + "VALUES(?,?,?,?)";
            ps = conexao.prepareStatement(query);
            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setString(3, despesa.getPeriocidade());
            ps.execute();
            Despesa temp = this.read(despesa.getDescricao(), despesa.getDataVencimento());
            query = "INSERT INTO Despesa(idDespesa, dataVencimento)  "
                    + "VALUES(?,?)";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdLancamento());
            ps.setDate(2, Date.valueOf(despesa.getDataVencimento()));
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
        }
    }
    
    public Despesa read(String descricao, LocalDate dataVencimento) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Despesa despesa = null;

        try {
            String query = "SELECT * FROM Despesa WHERE (dataVencimento = ?) and (descricao = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(dataVencimento));
            ps.setString(2, descricao);
            rs = ps.executeQuery();
            despesa = new Despesa(LocalDate.parse(rs.getString("dataVencimento")), rs.getString("descricao"), 
                    rs.getDouble("valor"), rs.getString("periodicidade"));
            return despesa;
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                throw e;
            }
        }
    }
}
