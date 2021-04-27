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
import java.time.format.DateTimeFormatter;
import model.Despesa;
import model.Republica;

/**
 *
 * @author tarci
 */
public class DespesaDAO {
    private Connection conexao;
    private static DespesaDAO instancia;

    private DespesaDAO() {}
    
    public static DespesaDAO getInstancia(){
        if(instancia == null){
            instancia = new DespesaDAO();
        }
        return instancia;
    }
    
    private void conectar(){
        conexao = DBConnection.getConexao();
    }
    
    //Criar uma despesa
    public void create(Despesa despesa) throws SQLException{
        PreparedStatement ps = null;
        try {
            RepublicaDAO subQuery = RepublicaDAO.getInstancia();
            String query = "INSERT INTO Lancamento(descricao, valor, periodicidade, idRepublica)"
                    + "VALUES(?,?,?,?)";
            ps = conexao.prepareStatement(query);
            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setString(3, despesa.getPeriocidade());
            ps.setInt(4, despesa.getRepublica().getIdRepublica());
            ps.execute();
            Despesa temp = this.read(despesa.getDescricao(), despesa.getDataVencimento());
            query = "INSERT INTO Despesa(idDespesa, dataVencimento)  "
                    + "VALUES(?,?)";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdLancamento());
            ps.setDate(2, Date.valueOf(despesa.getDataVencimento().format(DateTimeFormatter.ISO_DATE)));
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
        }
    }
    
    //Ler uma despesa
    public Despesa read(String descricao, LocalDate dataVencimento) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Despesa despesa = null;

        try {
            String query = "SELECT * FROM Despesa WHERE (dataVencimento = ?) and (descricao = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(dataVencimento.format(DateTimeFormatter.ISO_DATE)));
            ps.setString(2, descricao);
            rs = ps.executeQuery();
            RepublicaDAO republicaDAO = RepublicaDAO.getInstancia();
            Republica republica = republicaDAO.read(rs.getInt("idRepublica"));
            despesa = new Despesa(LocalDate.parse(rs.getString("dataVencimento")), rs.getString("descricao"), 
                    rs.getDouble("valor"), rs.getString("periodicidade"), republica, rs.getInt("idDespesa"));
            return despesa;
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
                DBConnection.fecharConexao();
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    //Excluir uma despesa
    public void delete(String descricao, LocalDate dataVencimento) throws SQLException{
        conectar();
        PreparedStatement ps = null;
        try {
            Despesa despesa = this.read(descricao, dataVencimento);
            String query = "DELETE FROM Despesa WHERE (descricao = ?) and (dataVencimento = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, descricao);
            ps.setDate(2, Date.valueOf(dataVencimento));
            ps.execute();
            DespesaMoradorDAO despesaMoradorDAO = DespesaMoradorDAO.getInstancia();
            despesaMoradorDAO.removerPorDespesa(despesa);
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
}
