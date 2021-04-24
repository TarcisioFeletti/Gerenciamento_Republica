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
import java.util.ArrayList;
import java.util.List;
import model.Tarefa;

/**
 *
 * @author tarci
 */
public class TarefasDAO {
    private TarefasMoradorDAO tarefaMorador = new TarefasMoradorDAO();
    public void create(Tarefa tarefa) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO Tarefas(dataInicio, descricao, dataTermino, terminada)  Values(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setDate(1, Date.valueOf(tarefa.getDataInicio()));
            ps.setString(2, tarefa.getDescricao());
            ps.setDate(3, Date.valueOf(tarefa.getDataTermino()));
            ps.setBoolean(4, tarefa.isTerminada());
            ps.execute();

        //    tarefaMorador.adicionar(tarefa.getPessoaCollection(), tarefa);
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        }
    }

    public void delete(int id) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM Tarefas WHERE (idTarefa = ?);";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public Tarefa read(int id) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tarefa tarefa = new Tarefa();

        try {
            String query = "SELECT * FROM Tarefas WHERE (idTarefa = ?);";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            tarefa.setIdTarefa(rs.getInt("idTarefa"));
            tarefa.setDataInicio(LocalDate.parse(rs.getString("dataInicio")));
            tarefa.setDescricao(rs.getString("descricao"));
            tarefa.setDataTermino(LocalDate.parse(rs.getString("dataTermino")));
            tarefa.setTerminada(rs.getBoolean("terminada"));

        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            try {
                rs.close();
                ps.close();
                DBConnection.fecharConexao();
            } catch (SQLException e) {
                throw new SQLException(e.toString());
            }
        }
        return tarefa;
    }

    public List<Tarefa> getAll() throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Tarefa> tarefaCollection = new ArrayList<>();
        Tarefa tarefa = new Tarefa();

        try {
            String query = "SELECT * FROM Tarefas";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                tarefa.setIdTarefa(rs.getInt("idTarefa"));
                tarefa.setDataInicio(LocalDate.parse(rs.getString("dataInicio")));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setDataTermino(LocalDate.parse(rs.getString("dataTermino")));
                tarefa.setTerminada(rs.getBoolean("terminada"));
                tarefaCollection.add(tarefa);
            }
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            try {
                rs.close();
                ps.close();
                DBConnection.fecharConexao();
            } catch (SQLException e) {
                throw new SQLException(e.toString());
            }
        }
        return tarefaCollection;
    }

    public void update(int id, Tarefa tarefa) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps;
        try {
            String query = "UPDATE Tarefas SET dataInicio = ?, descricao = ?, dataTermino = ?, terminada = ? WHERE (idTarefa = ?);";
            ps = con.prepareStatement(query);
            ps.setDate(1, Date.valueOf(tarefa.getDataInicio()));
            ps.setString(2, tarefa.getDescricao());
            ps.setDate(3, Date.valueOf(tarefa.getDataTermino()));
            ps.setBoolean(4, tarefa.isTerminada());
            ps.setInt(5, id);
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            DBConnection.fecharConexao();
        }
    }
}
