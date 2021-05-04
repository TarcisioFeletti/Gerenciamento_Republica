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
import java.util.ArrayList;
import java.util.List;
import model.ReclamacaoSugestao;

/**
 *
 * @author tarci
 */
public class ReclamacaoSugestaoDAO {

    private Connection conexao;

    public ReclamacaoSugestaoDAO() {
        this.conexao = DBConnection.getConexao();

    }

    public void create(ReclamacaoSugestao reclamacaoSugestao) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO ReclamacaoSugestao\n"
                    + "(dataAbertura, descricao, dataSolucao, idade, excluída, idMorador)\n"
                    + "VALUES(?,?,?,?,?,?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(reclamacaoSugestao.getDataAbertura().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setString(2, reclamacaoSugestao.getDescricao());
            ps.setDate(3, Date.valueOf(reclamacaoSugestao.getDataSolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setInt(4, reclamacaoSugestao.getIdade());
            ps.setBoolean(5, reclamacaoSugestao.getExcluida());
            ps.setInt(6, reclamacaoSugestao.getMorador().getIdPessoa());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public void delete(LocalDate dataAbertura, String descricao) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM ReclamacaoSugestao WHERE (dataAbertura = ?) and (descricao = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(dataAbertura));
            ps.setString(2, descricao);
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public ReclamacaoSugestao read(LocalDate dataAbertura, String descricao) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ReclamacaoSugestao reclamacaoSugestao = null;
        try {
            String query = "SELECT * FROM ReclamacaoSugestao WHERE (dataAbertura = ?) and (descricao = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(dataAbertura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setString(2, descricao);
            rs = ps.executeQuery();
            reclamacaoSugestao = new ReclamacaoSugestao(LocalDate.parse(rs.getString("dataAbertura")),
                    rs.getString("descricao"), LocalDate.parse(rs.getString("dataAberturaSolucao")), rs.getInt("idade"),
                    rs.getBoolean("excluida"), new PessoaDAO().read(rs.getInt("idPessoa")), rs.getInt("idRecSus"));
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
        return reclamacaoSugestao;
    }

    public List<ReclamacaoSugestao> getAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ReclamacaoSugestao> recSusCollection = new ArrayList<>();
        ReclamacaoSugestao reclamacaoSugestao;

        try {
            String query = "SELECT * FROM ReclamacaoSugestao";
            ps = conexao.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                reclamacaoSugestao = new ReclamacaoSugestao(LocalDate.parse(rs.getString("dataAbertura")),
                        rs.getString("descricao"), LocalDate.parse(rs.getString("dataAberturaSolucao")), rs.getInt("idade"),
                        rs.getBoolean("excluida"), new PessoaDAO().read(rs.getInt("idPessoa")), rs.getInt("idRecSus"));
            }
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
        return recSusCollection;
    }

    public void update(ReclamacaoSugestao reclamacaoSugestao, LocalDate dataAbertura, String descricao) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE ReclamacaoSugestao\n"
                    + "SET dataAbertura = ?, idPessoa = ?, descricao = ?, dataSolucao = ?, idade = ?, excluída = ?\n"
                    + "WHERE (dataAbertura = ?) AND (descricao = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(reclamacaoSugestao.getDataAbertura().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setInt(2, reclamacaoSugestao.getMorador().getIdPessoa());
            ps.setString(3, reclamacaoSugestao.getDescricao());
            ps.setDate(4, Date.valueOf(reclamacaoSugestao.getDataSolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setInt(5, reclamacaoSugestao.getIdade());
            ps.setBoolean(6, reclamacaoSugestao.getExcluida());
            ps.setDate(7, Date.valueOf(dataAbertura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setString(8, descricao);
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
}
