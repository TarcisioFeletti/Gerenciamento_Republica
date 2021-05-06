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
import model.Receita;
import model.Republica;

/**
 *
 * @author tarci
 */
public class ReceitaDAO {
     private Connection conexao;

    public ReceitaDAO() {
        conexao = DBConnection.getConexao();
    }

    //Criar uma receita
    public void create(Receita receita) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO Lancamento(descricao, valor, periodicidade, idRepublica)"
                    + "VALUES(?,?,?,?)";
            ps = conexao.prepareStatement(query);
            ps.setString(1, receita.getDescricao());
            ps.setDouble(2, receita.getValor());
            ps.setString(3, receita.getPeriocidade());
            ps.setInt(4, receita.getRepublica().getIdRepublica());
            ps.execute();
            Receita temp = this.read(receita.getDescricao(), receita.getData());
            query = "INSERT INTO Receita(idReceita, data)  "
                    + "VALUES(?,?)";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdLancamento());
            ps.setDate(2, Date.valueOf(receita.getData().format(DateTimeFormatter.ISO_DATE)));
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
        }
    }

    //Ler uma receita pela descricao e data
    public Receita read(String descricao, LocalDate data) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Receita receita = null;

        try {
            String query = "SELECT * FROM Receita r inner join Lancamento l on r.idReceita = l.idLancamento WHERE (data = ?) and (descricao = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(data.format(DateTimeFormatter.ISO_DATE)));
            ps.setString(2, descricao);
            rs = ps.executeQuery();
            Republica republica = new RepublicaDAO().read(rs.getInt("idRepublica"));
            receita = new Receita(LocalDate.parse(rs.getString("data")), rs.getString("descricao"), rs.getFloat("valor"),
                                    rs.getString("periodicidade"), republica, rs.getInt("idLancamento"));
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
        return receita;
    }
    
    //Ler uma receita pelo id
    public Receita read(int idLancamento) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Receita receita = null;

        try {
            String query = "SELECT * FROM Despesa d inner join Lancamento l on d.idLancamento = l.idLancamento WHERE (idLancamento = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, idLancamento);
            rs = ps.executeQuery();
            Republica republica = new RepublicaDAO().read(rs.getInt("idRepublica"));
            receita = new Receita(LocalDate.parse(rs.getString("data")), rs.getString("descricao"), rs.getFloat("valor"),
                                    rs.getString("periodicidade"), republica, rs.getInt("idLancamento"));
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
        return receita;
    }

    //Excluir uma despesa
    public void delete(String descricao, LocalDate data) throws SQLException {
        PreparedStatement ps = null;
        try {
            Receita receita = this.read(descricao, data);
            String query = "DELETE FROM Lancamento WHERE (idLancamento = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, receita.getIdLancamento());
            ps.execute();
            query = "DELETE FROM Receita WHERE (idReceita = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, receita.getIdLancamento());
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
    
    //Atualizar uma despesa
    public void update(Receita receita, String descricaoAntiga, LocalDate dataAntiga) throws SQLException {
        PreparedStatement ps = null;
        try {
            Receita receitaAntiga = this.read(descricaoAntiga, dataAntiga);
            String query = "UPDATE Lancamento SET descricao = ?, valor = ?, periodicidade = ?, idRepublica = ? "
                    + "WHERE(idLancamento = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, receita.getDescricao());
            ps.setDouble(2, receita.getValor());
            ps.setString(3, receita.getPeriocidade());
            ps.setInt(4, receita.getRepublica().getIdRepublica());
            ps.setInt(5, receita.getIdLancamento());
            ps.execute();
            query = "UPDATE Receita SET dataVencimento = ?"
                    + "WHERE(idReceita = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(receita.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setInt(2, receita.getIdLancamento());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
}
