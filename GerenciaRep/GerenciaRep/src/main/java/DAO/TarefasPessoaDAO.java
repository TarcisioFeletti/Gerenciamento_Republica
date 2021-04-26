/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBConnection.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Morador;
import model.Tarefa;
import model.Pessoa;
import model.Representante;
import model.Republica;
import model.SemTeto;
import model.TarefaPessoa;

/**
 *
 * @author tarci
 */
public class TarefasPessoaDAO {

    private final TarefasDAO tarefaDAO = new TarefasDAO();
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    private Connection conexao;

    public TarefasPessoaDAO() {
        this.conexao = DBConnection.getConexao();
    }
    
    

    //Create
    public void adicionar(List<TarefaPessoa> tmCollection) throws SQLException {
        PreparedStatement ps = null;
        try {
            for (TarefaPessoa tm : tmCollection) {
                String query = "INSERT INTO TarefaMorador(idTarefa, idPessoa)  Values(?,?)";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, tm.getTarefa().getIdTarefa());
                ps.setInt(2, tm.getUsuario().getIdPessoa());
                ps.execute();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public void adicionar(TarefaPessoa tm) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO TarefaMorador(idTarefa, idPessoa)  Values(?,?)";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, tm.getTarefa().getIdTarefa());
            ps.setInt(2, tm.getUsuario().getIdPessoa());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    //Delete
    public void removerPorTarefa(int idTarefa) throws SQLException {
        //Excluir todas as relações entre a tarefa com idTarefa e os moradores
        //pertencentes àquela tarefa
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM TarefaMorador WHERE (idTarefa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, idTarefa);
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
        }
    }

    public void removerPorPessoa(int idPessoa) throws SQLException {
        //Excluir todas as relações entre a pessoa com idPessoa e as tarefas
        //atribuídas a ele
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM TarefaMorador WHERE (idPessoa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, idPessoa);
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
        }
    }

    //Read
    //Read Line
    //rever
    public TarefaPessoa buscarLinha(String descricao, LocalDate dataInicio, String nome) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa;
        Tarefa tarefa;

        try {
            tarefa = this.tarefaDAO.read(dataInicio, descricao);
            pessoa = this.pessoaDAO.read(nome);
            TarefaPessoa tm = new TarefaPessoa(pessoa, tarefa);
            return tm;
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                throw new SQLException(e.toString());
            }
        }
    }

    //Read all
    public List<TarefaPessoa> lerTodasAsPessoasEmUmaTarefa(String descricao, LocalDate dataInicio) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        Tarefa tarefa;
        List<TarefaPessoa> tmCollection = new ArrayList<>();
        try {
            tarefa = this.tarefaDAO.read(dataInicio, descricao);
            String query = "SELECT * FROM TarefaMorador WHERE (idTarefa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, tarefa.getIdTarefa());
            rs = ps.executeQuery();

            while (rs.next()) {
                query = "SELECT * FROM TarefaMorador tm inner join Pessoa p on tm.idPessoa = p.idPessoa where(idPessoa = ?);";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, rs.getInt("idPessoa"));
                ResultSet r = ps.executeQuery();
                if(rs.getBoolean("SemTeto")){
                    pessoa = new SemTeto(r.getString("nome"), r.getString("apelido"), r.getString("telefone"), 
                            r.getString("cpf"), r.getString("redesSociais"), r.getString("contato1"), 
                            r.getString("contato2"), r.getInt("idPessoa"), r.getString("login"), r.getString("senha"));
                }else if(rs.getBoolean("Morador")){
                    String subQuery = "SELECT r.nomeRepublica FROM Morador m inner join Republica r on m.idRepublica = r.idRepublica WHERE(idPessoa = ?);";
                    PreparedStatement p = conexao.prepareStatement(subQuery);
                    p.setInt(1, r.getInt("idPessoa"));
                    ResultSet rt = p.executeQuery();
                    RepublicaDAO repDAO = new RepublicaDAO();
                    Republica rep = repDAO.read(rt.getString("r.nomeRepublica"));
                    pessoa = new Morador(rep, r.getString("nome"), r.getString("apelido"), r.getString("telefone"), 
                            r.getString("cpf"), r.getString("redesSociais"), r.getString("contato1"), 
                            r.getString("contato2"), r.getInt("idPessoa"), r.getString("login"), r.getString("senha"));
                }else if(rs.getBoolean("Representante")){
                    String subQuery = "SELECT r.nomeRepublica, re.dataInicio, re.dataFim FROM Representante re inner join Republica r on m.idRepublica = r.idRepublica WHERE(idPessoa = ?);";
                    PreparedStatement p = conexao.prepareStatement(subQuery);
                    p.setInt(1, r.getInt("idPessoa"));
                    ResultSet rt = p.executeQuery();
                    RepublicaDAO repDAO = new RepublicaDAO();
                    Republica rep = repDAO.read(rt.getString("r.nomeRepublica"));
                    pessoa = new Representante(rep, LocalDate.parse(rt.getString("dataInicio")), 
                            LocalDate.parse(rt.getString("dataFim")), r.getString("nome"), r.getString("apelido"), 
                            r.getString("telefone"), r.getString("cpf"), r.getString("redesSociais"), 
                            r.getString("contato1"), 
                            r.getString("contato2"), r.getInt("idPessoa"), r.getString("login"), r.getString("senha"));
                }
                TarefaPessoa tm = new TarefaPessoa(pessoa, tarefa);
                tmCollection.add(tm);
            }

            
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
        return tmCollection;
    }
    
    public List<TarefaPessoa> lerTodasAsTarefasDeUmaPessoa(String nome) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        Tarefa tarefa;
        List<TarefaPessoa> tmCollection = new ArrayList<>();
        try {
            pessoa = this.pessoaDAO.read(nome);
            String query = "SELECT * FROM TarefaMorador WHERE (idPessoa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, pessoa.getIdPessoa());
            rs = ps.executeQuery();

            while (rs.next()) {
                query = "SELECT t.descricao, t.dataInicio FROM Tarefa t inner join TarefaMorador tm on tm.idTarefa = t.idTarefa WHERE(tm.idTarefa = ?);";
                PreparedStatement p = conexao.prepareStatement(query);
                p.setInt(1, rs.getInt("idTarefa"));
                ResultSet r = p.executeQuery();
                tarefa = new Tarefa(r.getInt("idTarefa"), LocalDate.parse(r.getString("dataInicio")),
                r.getString("descricao"), LocalDate.parse(r.getString("dataTermino")), r.getBoolean("terminada"));
                TarefaPessoa tm = new TarefaPessoa(pessoa, tarefa);
                tmCollection.add(tm);
                r.close();
                p.close();
            }

            
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
        return tmCollection;
    }
}
