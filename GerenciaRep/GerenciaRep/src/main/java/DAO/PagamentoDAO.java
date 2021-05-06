/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Despesa;
import model.Pagamento;
import model.Pessoa;

/**
 *
 * @author tarci
 */
public class PagamentoDAO {

    private Connection conexao;

    public PagamentoDAO() {
        conexao = DBConnection.getConexao();
    }

    public void create(Pagamento pagamento) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO Pagamento\n"
                    + "(valorParcela, numParcela, idDespesa, idMorador)\n"
                    + "VALUES(?, ?, ?, ?);";
            ps = conexao.prepareStatement(query);
            ps.setFloat(1, pagamento.getValor());
            ps.setInt(2, pagamento.getNumeroDaParcela());
            ps.setInt(3, pagamento.getDespesa().getIdLancamento());
            ps.setInt(4, pagamento.getPessoa().getIdPessoa());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Delete
    public void remover(Pagamento pagamento) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM Pagamento\n"
                    + "WHERE (idPagamento = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, pagamento.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public Pagamento read(float valorDaParcela, int numParcela) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pagamento pagamento = null;
        try {

            String query = "SELECT *\n"
                    + "FROM Pagamento WHERE (valorDaParcela = ?) AND (numParcela = ?);";
            ps = conexao.prepareStatement(query);
            ps.setFloat(1, valorDaParcela);
            ps.setInt(2, numParcela);
            rs = ps.executeQuery();
            Pessoa pessoa = new PessoaDAO().read(rs.getInt("idPessoa"));
            Despesa despesa = new DespesaDAO().read(rs.getInt("idDespesa"));
            pagamento = new Pagamento(rs.getInt("idPagamento"), rs.getFloat("valorParcela"), rs.getInt("numParcela"),
                    despesa, pessoa);
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
        return pagamento;
    }

    public void update(Pagamento pagamento, float valorDaParcela, int numParcela) throws SQLException {
        PreparedStatement ps = null;
        try {
            Pessoa pessoa = new PessoaDAO().read(pagamento.getPessoa().getNome());
            Despesa despesa = new DespesaDAO().read(pagamento.getDespesa().getDescricao(), pagamento.getDespesa().getDataVencimento());
            String query = "UPDATE Pagamento\n"
                    + "SET valorParcela=?, numParcela=?, idDespesa=?, idMorador=?\n"
                    + "WHERE (valorParcela = ?) AND (numParcela = ?);";
            ps = conexao.prepareStatement(query);
            ps.setFloat(1, pagamento.getValor());
            ps.setInt(2, pagamento.getNumeroDaParcela());
            ps.setInt(3, despesa.getIdLancamento());
            ps.setInt(4, pessoa.getIdPessoa());
            ps.setFloat(5, valorDaParcela);
            ps.setInt(5, numParcela);
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
}
