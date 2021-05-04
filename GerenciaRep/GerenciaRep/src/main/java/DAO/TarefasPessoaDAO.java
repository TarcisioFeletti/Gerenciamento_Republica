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

    private Connection conexao;

    public TarefasPessoaDAO() {
        this.conexao = DBConnection.getConexao();
    }

    //Create
    public void adicionar(List<Pessoa> tmCollection, Tarefa tarefa) throws SQLException {
        PreparedStatement ps = null;
        try {
            for (Pessoa tm : tmCollection) {
                String query = "INSERT INTO TarefaMorador(idTarefa, idPessoa)  Values(?,?)";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, tarefa.getIdTarefa());
                ps.setInt(2, tm.getIdPessoa());
                ps.execute();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void adicionar(List<Tarefa> tmCollection, Pessoa pessoa) throws SQLException {
        PreparedStatement ps = null;
        try {
            for (Tarefa tm : tmCollection) {
                String query = "INSERT INTO TarefaMorador(idTarefa, idPessoa)  Values(?,?)";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, tm.getIdTarefa());
                ps.setInt(2, pessoa.getIdPessoa());
                ps.execute();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    //Delete
    public void removerPorTarefa(Tarefa tarefa) throws SQLException {
        //Excluir todas as relações entre a tarefa com idTarefa e os moradores
        //pertencentes àquela tarefa
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM TarefaMorador WHERE (idTarefa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, tarefa.getIdTarefa());
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public void removerPorPessoa(Pessoa pessoa) throws SQLException {
        //Excluir todas as relações entre a pessoa com idPessoa e as tarefas
        //atribuídas a ele
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM TarefaMorador WHERE (idPessoa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, pessoa.getIdPessoa());
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Read
    //Read Line
    public TarefaPessoa buscarLinha(String descricao, LocalDate dataInicio, String nome) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa;
        Tarefa tarefa;

        try {
            tarefa = new TarefasDAO().read(dataInicio, descricao);
            pessoa = new PessoaDAO().read(nome);
            TarefaPessoa tm = new TarefaPessoa(pessoa, tarefa);
            return tm;
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
    }

    //Ler todas as pessoas participantes de uma tarefa
    public List<TarefaPessoa> buscarTodasAsPessoasEmUmaTarefa(String descricao, LocalDate dataInicio) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        Tarefa tarefa;
        List<TarefaPessoa> tmCollection = new ArrayList<>();
        try {
            tarefa = new TarefasDAO().read(dataInicio, descricao);
            String query = "SELECT * FROM TarefaMorador WHERE (idTarefa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, tarefa.getIdTarefa());
            rs = ps.executeQuery();

            while (rs.next()) {
                query = "SELECT * FROM TarefaMorador tm inner join Pessoa p on tm.idPessoa = p.idPessoa where(idPessoa = ?);";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, rs.getInt("idPessoa"));
                ResultSet r = ps.executeQuery();
                if (rs.getBoolean("SemTeto")) {
                    pessoa = new SemTeto(r.getString("nome"), r.getString("apelido"), r.getString("telefone"),
                            r.getString("cpf"), r.getString("redesSociais"), r.getString("contato1"),
                            r.getString("contato2"), r.getInt("idPessoa"), r.getString("login"), r.getString("senha"));
                } else if (rs.getBoolean("Morador")) {
                    String subQuery = "SELECT r.nomeRepublica FROM Morador m inner join Republica r on m.idRepublica = r.idRepublica WHERE(idPessoa = ?);";
                    PreparedStatement p = conexao.prepareStatement(subQuery);
                    p.setInt(1, r.getInt("idPessoa"));
                    ResultSet rt = p.executeQuery();
                    RepublicaDAO repDAO = RepublicaDAO.getInstancia();
                    Republica rep = repDAO.read(rt.getString("r.nomeRepublica"));
                    pessoa = new Morador(rep, r.getString("nome"), r.getString("apelido"), r.getString("telefone"),
                            r.getString("cpf"), r.getString("redesSociais"), r.getString("contato1"),
                            r.getString("contato2"), r.getInt("idPessoa"), r.getString("login"), r.getString("senha"));
                } else if (rs.getBoolean("Representante")) {
                    String subQuery = "SELECT r.nomeRepublica, re.dataInicio, re.dataFim FROM Representante re inner join Republica r on m.idRepublica = r.idRepublica WHERE(idPessoa = ?);";
                    PreparedStatement p = conexao.prepareStatement(subQuery);
                    p.setInt(1, r.getInt("idPessoa"));
                    ResultSet rt = p.executeQuery();
                    RepublicaDAO repDAO = RepublicaDAO.getInstancia();
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
                DBConnection.fecharConexao();
            } catch (SQLException e) {
                throw e;
            }
        }
        return tmCollection;
    }

    //Ler todas as tarefas relacionadas a uma pessoa
    public List<TarefaPessoa> buscarTodasAsTarefasDeUmaPessoa(String nome) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        Tarefa tarefa;
        List<TarefaPessoa> tmCollection = new ArrayList<>();
        try {
            pessoa = new PessoaDAO().read(nome);
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
                DBConnection.fecharConexao();
            } catch (SQLException e) {
                throw e;
            }
        }
        return tmCollection;
    }

    //Update idPessoa de TarefaPessoa
    public void updatePessoa(TarefaPessoa tarefaPessoa, String nomeAntigo) throws SQLException {
        PreparedStatement ps = null;
        try {
            Pessoa pessoa = new PessoaDAO().read(nomeAntigo);
            String query = "UPDATE TarefaMorador SET idTarefa = ?, idMorador = ? WHERE(idTarefa = ?) and (idMorador = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1,tarefaPessoa.getTarefa().getIdTarefa());
            ps.setInt(2,tarefaPessoa.getUsuario().getIdPessoa());
            ps.setInt(3,tarefaPessoa.getTarefa().getIdTarefa());
            ps.setInt(4, pessoa.getIdPessoa());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    //Update o idTarefa de TarefaPessoa
    public void updateTarefa(TarefaPessoa tarefaPessoa, LocalDate dataInicioAntiga, String descricaoAntiga) throws SQLException {
        PreparedStatement ps = null;
        try {
            Tarefa tarefa = new TarefasDAO().read(dataInicioAntiga, descricaoAntiga);
            String query = "UPDATE TarefaMorador SET idTarefa = ?, idMorador = ? WHERE(idTarefa = ?) and (idMorador = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1,tarefaPessoa.getTarefa().getIdTarefa());
            ps.setInt(2,tarefaPessoa.getUsuario().getIdPessoa());
            ps.setInt(3,tarefa.getIdTarefa());
            ps.setInt(4,tarefaPessoa.getUsuario().getIdPessoa());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        }
    }
}
