/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBConnection.DBConnection;
import Model.Morador;
import Model.Pessoa;
import Model.Representante;
import Model.Republica;
import Model.SemTeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author tarci
 */
public class LoginDAO {

    private Connection conexao;

    public LoginDAO() {
        this.conexao = DBConnection.getConexao();

    }

    public void create(Pessoa pessoa, String login, String senha) throws SQLException {
        PreparedStatement ps = null;
        try {
            Pessoa temp = new PessoaDAO().read(pessoa.getNome());
            String query = "INSERT INTO Login\n"
                    + "(login, senha, idPessoa)\n"
                    + "VALUES(?,?,?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            ps.setInt(3, temp.getIdPessoa());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public void delete(String login) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM Login WHERE (login = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, login);
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public Pessoa read(String login, String senha) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rst = null;
        Pessoa pessoa = null;
        try {
            String query = "SELECT * FROM Login l INNER JOIN Pessoa p ON l.idPessoa = p.idPessoa"
                    + " WHERE (login = ?) AND (senha = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if (rs.getBoolean("SemTeto")) {
                pessoa = new SemTeto(rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                        rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                        rs.getInt("idPessoa"));
            } else if (rs.getBoolean("Morador")) {
                query = "SELECT * FROM Morador WHERE (idPessoa = ?);";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, rs.getInt("idPessoa"));
                rst = ps.executeQuery();
                Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                pessoa = new Morador(republica, rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                        rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                        rs.getInt("idPessoa"));
            } else if (rs.getBoolean("Representante")) {
                query = "SELECT * FROM Representante WHERE (idPessoa = ?);";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, rs.getInt("idPessoa"));
                rst = ps.executeQuery();
                Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                pessoa = new Representante(republica, LocalDate.parse(rst.getString("dataInicio")),
                        LocalDate.parse(rst.getString("dataFim")), rs.getString("nome"), rs.getString("apelido"),
                        rs.getString("telefone"), rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"),
                        rs.getString("contato2"), rs.getInt("idPessoa"));
            } else {
                throw new RuntimeException("Usuário inválido");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                rs.close();
                rst.close();
                ps.close();
                DBConnection.fecharConexao();
            } catch (SQLException e) {
                throw e;
            }
        }
        return pessoa;
    }

    public void update(Pessoa pessoa, String login, String senha) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE Login\n"
                    + "SET dataAbertura = ?, idPessoa = ?\n"
                    + "WHERE (idPessoa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, pessoa.getIdPessoa());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
}
