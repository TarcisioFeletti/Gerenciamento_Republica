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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Despesa;
import model.DespesaMorador;
import model.Morador;
import model.Pessoa;
import model.Representante;
import model.Republica;
import model.SemTeto;

/**
 *
 * @author tarci
 */
public class DespesaMoradorDAO {

    private Connection conexao;
    
    public DespesaMoradorDAO() {
        conexao = DBConnection.getConexao();
    }

    public void create(Despesa despesa, Pessoa pessoa) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO DespesaMorador(idDespesa, idMorador, porcentagemDoValorTotal)  "
                    + "VALUES(?,?,?)";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, despesa.getIdLancamento());
            ps.setInt(2, pessoa.getIdPessoa());
            ps.setFloat(3, 100);
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public void create(List<DespesaMorador> despesaMoradorCollection) throws SQLException {
        PreparedStatement ps = null;
        try {
            for (DespesaMorador despesaMorador : despesaMoradorCollection) {
                String query = "INSERT INTO DespesaMorador(idDespesa, idMorador, porcentagemDoValorTotal)  "
                        + "VALUES(?,?,?)";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, despesaMorador.getDespesa().getIdLancamento());
                ps.setInt(2, despesaMorador.getPessoa().getIdPessoa());
                ps.setFloat(3, despesaMorador.getPorcentagem());
                ps.execute();
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Delete
    public void removerPorDespesa(Despesa despesa) throws SQLException {
        //Excluir todas as relações entre a tarefa com idTarefa e os moradores
        //pertencentes àquela tarefa
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM DespesaMorador WHERE (idLancamento = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, despesa.getIdLancamento());
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
            String query = "DELETE FROM DespesaMorador WHERE (idMorador = ?);";
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

    public List<DespesaMorador> readAllPorMorador(Morador morador) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DespesaMorador> despesaMoradorCollection = new ArrayList<>();
        try {

            String query = "SELECT * FROM DespesaMorador WHERE (idMorador = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, morador.getIdPessoa());
            rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new PessoaDAO().read(rs.getInt("idPessoa"));
                if (rs.getBoolean("SemTeto")) {
                    pessoa = new SemTeto(rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                            rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                            rs.getInt("idPessoa"), rs.getString("login"), rs.getString("senha"));
                } else if (rs.getBoolean("Morador")) {
                    query = "SELECT * FROM Morador WHERE (idPessoa = ?);";
                    ps = conexao.prepareStatement(query);
                    ps.setInt(1, rs.getInt("idPessoa"));
                    ResultSet rst = ps.executeQuery();
                    Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                    pessoa = new Morador(republica, rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                            rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                            rs.getInt("idPessoa"), rs.getString("login"), rs.getString("senha"));
                } else if (rs.getBoolean("Representante")) {
                    query = "SELECT * FROM Representante WHERE (idPessoa = ?);";
                    ps = conexao.prepareStatement(query);
                    ps.setInt(1, rs.getInt("idPessoa"));
                    ResultSet rst = ps.executeQuery();
                    Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                    pessoa = new Representante(republica, LocalDate.parse(rst.getString("dataInicio")),
                            LocalDate.parse(rst.getString("dataFim")), rs.getString("nome"), rs.getString("apelido"),
                            rs.getString("telefone"), rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"),
                            rs.getString("contato2"), rs.getInt("idPessoa"), rs.getString("login"), rs.getString("senha"));
                }
                Despesa despesa = new DespesaDAO().read(rs.getInt("idDespesa"));
                DespesaMorador despesaMorador = new DespesaMorador(pessoa, despesa, rs.getFloat("porcentagemDoValorTotal"));
                despesaMoradorCollection.add(despesaMorador);
            }
            return despesaMoradorCollection;
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

    public List<DespesaMorador> readAllPorDespesa(Despesa despesa) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DespesaMorador> despesaMoradorCollection = new ArrayList<>();
        try {
            String query = "SELECT * FROM DespesaMorador WHERE (idDespesa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, despesa.getIdLancamento());
            rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new PessoaDAO().read(rs.getInt("idPessoa"));
                if (rs.getBoolean("SemTeto")) {
                    pessoa = new SemTeto(rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                            rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                            rs.getInt("idPessoa"), rs.getString("login"), rs.getString("senha"));
                } else if (rs.getBoolean("Morador")) {
                    query = "SELECT * FROM Morador WHERE (idPessoa = ?);";
                    ps = conexao.prepareStatement(query);
                    ps.setInt(1, rs.getInt("idPessoa"));
                    ResultSet rst = ps.executeQuery();
                    Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                    pessoa = new Morador(republica, rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                            rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                            rs.getInt("idPessoa"), rs.getString("login"), rs.getString("senha"));
                } else if (rs.getBoolean("Representante")) {
                    query = "SELECT * FROM Representante WHERE (idPessoa = ?);";
                    ps = conexao.prepareStatement(query);
                    ps.setInt(1, rs.getInt("idPessoa"));
                    ResultSet rst = ps.executeQuery();
                    Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                    pessoa = new Representante(republica, LocalDate.parse(rst.getString("dataInicio")),
                            LocalDate.parse(rst.getString("dataFim")), rs.getString("nome"), rs.getString("apelido"),
                            rs.getString("telefone"), rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"),
                            rs.getString("contato2"), rs.getInt("idPessoa"), rs.getString("login"), rs.getString("senha"));
                }
                Despesa despesaTemp = new DespesaDAO().read(rs.getInt("idDespesa"));
                DespesaMorador despesaMorador = new DespesaMorador(pessoa, despesaTemp, rs.getFloat("porcentagemDoValorTotal"));
                despesaMoradorCollection.add(despesaMorador);
            }
            return despesaMoradorCollection;
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
    
    public List<DespesaMorador> readAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DespesaMorador> despesaMoradorCollection = new ArrayList<>();
        try {
            String query = "SELECT * FROM DespesaMorador;";
            ps = conexao.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new PessoaDAO().read(rs.getInt("idPessoa"));
                if (rs.getBoolean("SemTeto")) {
                    pessoa = new SemTeto(rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                            rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                            rs.getInt("idPessoa"), rs.getString("login"), rs.getString("senha"));
                } else if (rs.getBoolean("Morador")) {
                    query = "SELECT * FROM Morador WHERE (idPessoa = ?);";
                    ps = conexao.prepareStatement(query);
                    ps.setInt(1, rs.getInt("idPessoa"));
                    ResultSet rst = ps.executeQuery();
                    Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                    pessoa = new Morador(republica, rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                            rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                            rs.getInt("idPessoa"), rs.getString("login"), rs.getString("senha"));
                } else if (rs.getBoolean("Representante")) {
                    query = "SELECT * FROM Representante WHERE (idPessoa = ?);";
                    ps = conexao.prepareStatement(query);
                    ps.setInt(1, rs.getInt("idPessoa"));
                    ResultSet rst = ps.executeQuery();
                    Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                    pessoa = new Representante(republica, LocalDate.parse(rst.getString("dataInicio")),
                            LocalDate.parse(rst.getString("dataFim")), rs.getString("nome"), rs.getString("apelido"),
                            rs.getString("telefone"), rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"),
                            rs.getString("contato2"), rs.getInt("idPessoa"), rs.getString("login"), rs.getString("senha"));
                }
                Despesa despesaTemp = new DespesaDAO().read(rs.getInt("idDespesa"));
                DespesaMorador despesaMorador = new DespesaMorador(pessoa, despesaTemp, rs.getFloat("porcentagemDoValorTotal"));
                despesaMoradorCollection.add(despesaMorador);
            }
            return despesaMoradorCollection;
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
    
    public void update(DespesaMorador despesaMorador, Despesa despesaAntiga){
        
    }
}
