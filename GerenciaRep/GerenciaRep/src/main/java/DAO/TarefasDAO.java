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
import model.Pessoa;
import model.Tarefa;

/**
 *
 * @author tarci
 */
public class TarefasDAO {
    private Connection conexao;

    public TarefasDAO() {
        this.conexao = DBConnection.getConexao();

    }
    
    public void create(Tarefa tarefa, List<Pessoa> pessoaCollection) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO Tarefas(dataInicio, descricao, dataTermino, terminada)  Values(?,?,?,?)";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(tarefa.getDataInicio()));
            ps.setString(2, tarefa.getDescricao());
            ps.setDate(3, Date.valueOf(tarefa.getDataTermino()));
            ps.setBoolean(4, tarefa.isTerminada());
            ps.execute();
            
            new TarefasPessoaDAO().adicionar(pessoaCollection, tarefa);

        //    tarefaMorador.adicionar(tarefa.getPessoaCollection(), tarefa);
        } catch (SQLException e) {
            throw e;
        }finally{
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public void delete(LocalDate dataInicio, String descricao) throws SQLException {
        PreparedStatement ps = null;
        try {
            Tarefa tarefa = this.read(dataInicio, descricao);
            String query = "DELETE FROM Tarefas WHERE (dataInicio = ?) and (descricao = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(dataInicio));
            ps.setString(2, descricao);
            ps.execute();
            new TarefasPessoaDAO().removerPorTarefa(tarefa);
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
        }
    }

    public Tarefa read(LocalDate dataInicio, String descricao) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tarefa tarefa = null;
        try {
            String query = "SELECT * FROM Tarefas WHERE (dataInicio = ?) and (descricao = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(dataInicio));
            ps.setString(2, descricao);
            rs = ps.executeQuery();
            tarefa = new Tarefa(rs.getInt("idTarefa"), LocalDate.parse(rs.getString("dataInicio")), 
                    rs.getString("descricao"), LocalDate.parse(rs.getString("dataTermino")), rs.getBoolean("terminada"));
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
        return tarefa;
    }

    public List<Tarefa> getAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Tarefa> tarefaCollection = new ArrayList<>();
        Tarefa tarefa;

        try {
            String query = "SELECT * FROM Tarefas";
            ps = conexao.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                tarefa = new Tarefa(rs.getInt("idTarefa"), LocalDate.parse(rs.getString("dataInicio")),
                rs.getString("descricao"), LocalDate.parse(rs.getString("dataTermino")), rs.getBoolean("terminada"));
                tarefaCollection.add(tarefa);
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
        return tarefaCollection;
    }

    public void update(int id, Tarefa tarefa) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE Tarefas SET dataInicio = ?, descricao = ?, dataTermino = ?, terminada = ? WHERE (idTarefa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(tarefa.getDataInicio().toString()));
            ps.setString(2, tarefa.getDescricao());
            ps.setDate(3, Date.valueOf(tarefa.getDataTermino().toString()));
            ps.setBoolean(4, tarefa.isTerminada());
            ps.setInt(5, id);
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
}
