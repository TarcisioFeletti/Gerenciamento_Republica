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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tarci
 */
public class PessoaDAO {

    private Connection conexao;

    public PessoaDAO() {
        this.conexao = DBConnection.getConexao();
    }

    //Somente SemTeto terá a função create, pois todos os usuários que forem ser inseridos no sistema
    //inicialmente eles serão SemTeto
    public void create(SemTeto semTeto) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO Pessoa(nome, apelido, telefone, cpf, redesSociais, contato1, contato2, SemTeto, "
                    + "Morador, Representante)  "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            ps = conexao.prepareStatement(query);
            ps.setString(1, semTeto.getNome());
            ps.setString(2, semTeto.getApelido());
            ps.setString(3, semTeto.getTelefone());
            ps.setString(4, semTeto.getCpf());
            ps.setString(5, semTeto.getRedesSociais());
            ps.setString(6, semTeto.getContato1());
            ps.setString(7, semTeto.getContat2());
            ps.setBoolean(8, true);
            ps.setBoolean(9, false);
            ps.setBoolean(10, false);
            ps.execute();
            Pessoa pessoa = this.read(semTeto.getNome());
            query = "INSERT INTO SemTeto(idPessoa)  "
                    + "VALUES(?)";
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

    //Delete para todos os tipos de pessoa
    public void delete(String nome) throws SQLException {
        PreparedStatement ps = null;
        try {
            Pessoa pessoa = this.read(nome);
            String query = "DELETE FROM Pessoa WHERE (nome = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, nome);
            ps.execute();
            if (pessoa.isSemTeto()) {
                query = "DELETE FROM SemTeto WHERE (idSemTeto = ?);";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, pessoa.getIdPessoa());
                ps.execute();
            } else if (pessoa.isMorador()) {
                query = "DELETE FROM Morador WHERE (idPessoa = ?);";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, pessoa.getIdPessoa());
                ps.execute();
            } else if (pessoa.isRepresentante()) {
                query = "DELETE FROM Representante WHERE (idPessoa = ?);";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, pessoa.getIdPessoa());
                ps.execute();
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Read para todos os tipos de Pessoa
    public Pessoa read(String nome) throws SQLException, RuntimeException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rst = null;
        Pessoa pessoa = null;

        try {
            String query = "SELECT * FROM Pessoa WHERE (nome = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, nome);
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
                ps.close();
                DBConnection.fecharConexao();
            } catch (SQLException e) {
                throw new SQLException(e.toString());
            }
        }
        return pessoa;
    }

    public Pessoa read(int idPessoa) throws SQLException, RuntimeException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rst = null;
        Pessoa temp;

        try {
            String query = "SELECT * FROM Pessoa WHERE (nome = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, idPessoa);
            rs = ps.executeQuery();
            if (rs.getBoolean("SemTeto")) {
                temp = new SemTeto(rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                        rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                        rs.getInt("idPessoa"));
                return temp;
            } else if (rs.getBoolean("Morador")) {
                query = "SELECT * FROM Morador WHERE (idPessoa = ?);";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, rs.getInt("idPessoa"));
                rst = ps.executeQuery();
                Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                temp = new Morador(republica, rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                        rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                        rs.getInt("idPessoa"));
                return temp;
            } else if (rs.getBoolean("Representante")) {
                query = "SELECT * FROM Representante WHERE (idPessoa = ?);";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, rs.getInt("idPessoa"));
                rst = ps.executeQuery();
                Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                temp = new Representante(republica, LocalDate.parse(rst.getString("dataInicio")),
                        LocalDate.parse(rst.getString("dataFim")), rs.getString("nome"), rs.getString("apelido"),
                        rs.getString("telefone"), rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"),
                        rs.getString("contato2"), rs.getInt("idPessoa"));
                return temp;
            } else {
                throw new RuntimeException("Usuário inválido");
            }

        } catch (SQLException e) {
            throw e;
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

    //Retorna uma lista com todas as pessoas e suas respectiva republicas (se existirem)
    public List<Pessoa> getAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa;
        List<Pessoa> pessoaCollection = new ArrayList<>();

        try {
            String query = "SELECT * FROM Pessoa";
            ps = conexao.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("SemTeto")) {
                    pessoa = new SemTeto(rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                            rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                            rs.getInt("idPessoa"));
                    pessoaCollection.add(pessoa);
                } else if (rs.getBoolean("Morador")) {
                    query = "SELECT * FROM Morador WHERE (idPessoa = ?);";
                    ps = conexao.prepareStatement(query);
                    ps.setInt(1, rs.getInt("idPessoa"));
                    ResultSet rst = ps.executeQuery();
                    Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                    pessoa = new Morador(republica, rs.getString("nome"), rs.getString("apelido"), rs.getString("telefone"),
                            rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"), rs.getString("contato2"),
                            rs.getInt("idPessoa"));
                    pessoaCollection.add(pessoa);
                } else if (rs.getBoolean("Representante")) {
                    query = "SELECT * FROM Representante WHERE (idPessoa = ?);";
                    ps = conexao.prepareStatement(query);
                    ps.setInt(1, rs.getInt("idPessoa"));
                    ResultSet rst = ps.executeQuery();
                    Republica republica = new RepublicaDAO().read(rst.getInt("idRepublica"));
                    pessoa = new Representante(republica, LocalDate.parse(rst.getString("dataInicio")),
                            LocalDate.parse(rst.getString("dataFim")), rs.getString("nome"), rs.getString("apelido"),
                            rs.getString("telefone"), rs.getString("cpf"), rs.getString("redesSociais"), rs.getString("contato1"),
                            rs.getString("contato2"), rs.getInt("idPessoa"));
                    pessoaCollection.add(pessoa);
                }
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
        return pessoaCollection;
    }

    //Update de Sem teto
    //Detalhe: Caso a pessoa mude de nome no campo nome deve-se passar o nome antigo da pessoa
    public void update(SemTeto pessoa, String nome) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE Pessoa SET nome = ?, apelido = ?, telefone = ?, cpf = ?, "
                    + "redesSociais = ?, contato1 = ?, contato2 = ?, SemTeto = ?, Morador = ?, "
                    + "Representante = ?"
                    + "WHERE (nome = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getApelido());
            ps.setString(3, pessoa.getTelefone());
            ps.setString(4, pessoa.getCpf());
            ps.setString(5, pessoa.getRedesSociais());
            ps.setString(6, pessoa.getContato1());
            ps.setString(7, pessoa.getContat2());
            ps.setBoolean(8, pessoa.isSemTeto());
            ps.setBoolean(9, pessoa.isMorador());
            ps.setBoolean(10, pessoa.isRepresentante());
            ps.setString(13, nome);
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Update de Morador
    //Detalhe: Caso a pessoa mude de nome no campo nome deve-se passar o nome antigo da pessoa
    public void update(Morador pessoa, String nome) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE Pessoa SET nome = ?, apelido = ?, telefone = ?, cpf = ?, "
                    + "redesSociais = ?, contato1 = ?, contato2 = ?, SemTeto = ?, Morador = ?, "
                    + "Representante = ?"
                    + "WHERE (nome = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getApelido());
            ps.setString(3, pessoa.getTelefone());
            ps.setString(4, pessoa.getCpf());
            ps.setString(5, pessoa.getRedesSociais());
            ps.setString(6, pessoa.getContato1());
            ps.setString(7, pessoa.getContat2());
            ps.setBoolean(8, pessoa.isSemTeto());
            ps.setBoolean(9, pessoa.isMorador());
            ps.setBoolean(10, pessoa.isRepresentante());
            ps.setString(13, nome);
            ps.execute();
            Republica republica = new RepublicaDAO().read(pessoa.getRepublicaAtual().getNomeRepublica());
            query = "UPDATE Morador SET idRepublica = ? WHERE (idPessoa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, republica.getIdRepublica());
            ps.setInt(2, pessoa.getIdPessoa());
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Update de Representante
    //Detalhe: Caso a pessoa mude de nome no campo nome deve-se passar o nome antigo da pessoa
    public void update(Representante pessoa, String nome) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE Pessoa SET nome = ?, apelido = ?, telefone = ?, cpf = ?, "
                    + "redesSociais = ?, contato1 = ?, contato2 = ?, SemTeto = ?, Morador = ?, "
                    + "Representante = ?"
                    + "WHERE (nome = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getApelido());
            ps.setString(3, pessoa.getTelefone());
            ps.setString(4, pessoa.getCpf());
            ps.setString(5, pessoa.getRedesSociais());
            ps.setString(6, pessoa.getContato1());
            ps.setString(7, pessoa.getContat2());
            ps.setBoolean(8, pessoa.isSemTeto());
            ps.setBoolean(9, pessoa.isMorador());
            ps.setBoolean(10, pessoa.isRepresentante());
            ps.setString(13, nome);
            ps.execute();
            Republica republica = new RepublicaDAO().read(pessoa.getRepublicaAtual().getNomeRepublica());
            query = "UPDATE Morador SET idRepublica = ?, dataInicio = ?, dataFim = ? WHERE (idPessoa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, republica.getIdRepublica());
            ps.setDate(2, Date.valueOf(pessoa.getDataInicio()));
            ps.setDate(3, Date.valueOf(pessoa.getDataFinal()));
            ps.setInt(4, pessoa.getIdPessoa());
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Promoção de Sem teto para Morador
    public void promocaoDe(SemTeto st, String nomeRepublica) throws SQLException, RuntimeException {
        PreparedStatement ps = null;
        try {
            Republica republica = new RepublicaDAO().read(nomeRepublica);
            Pessoa temp = this.read(st.getNome());
            String query = "DELETE FROM SemTeto WHERE(idSemTeto = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.execute();
            ps.close();
            query = "INSERT INTO Morador(idPessoa, idRepublica)"
                    + "VALUES(?,?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.setInt(2, republica.getIdRepublica());
            ps.execute();
        } catch (SQLException ex) {
            throw ex;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Promoção de Sem teto para Representante
    public void promocaoDe(SemTeto st, String nomeRepublica, LocalDate dataInicio) throws SQLException, RuntimeException {
        PreparedStatement ps = null;
        try {
            Republica republica = new RepublicaDAO().read(nomeRepublica);
            Pessoa temp = this.read(st.getNome());
            String query = "DELETE FROM SemTeto WHERE(idSemTeto = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.execute();
            ps.close();
            query = "INSERT INTO Representante(idPessoa, idRepublica, dataInicio)"
                    + "VALUES(?,?,?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.setInt(2, republica.getIdRepublica());
            ps.setDate(3, Date.valueOf(dataInicio));
            ps.execute();
        } catch (SQLException ex) {
            throw ex;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Promoção de Morador para Representante
    public void promocaoDe(Morador m, LocalDate dataInicio) throws SQLException, RuntimeException {
        PreparedStatement ps = null;
        try {
            Republica republica = new RepublicaDAO().read(m.getRepublicaAtual().getNomeRepublica());
            Pessoa temp = this.read(m.getNome());
            String query = "DELETE FROM Morador WHERE(idSemTeto = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.execute();
            ps.close();
            query = "INSERT INTO Representante(idPessoa, idRepublica, dataInicio)"
                    + "VALUES(?,?,?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.setInt(2, republica.getIdRepublica());
            ps.setDate(3, Date.valueOf(dataInicio));
            ps.execute();
        } catch (SQLException ex) {
            throw ex;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Depromoção de Representante para Morador
    public void depromocaoDe(Representante r, String nomeRepublica) throws SQLException, RuntimeException {
        PreparedStatement ps = null;
        try {
            Republica republica = new RepublicaDAO().read(nomeRepublica);
            Pessoa temp = this.read(r.getNome());
            String query = "DELETE FROM Representante WHERE(idSemTeto = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.execute();
            ps.close();
            query = "INSERT INTO Morador(idPessoa, idRepublica)"
                    + "VALUES(?,?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.setInt(2, republica.getIdRepublica());
            ps.execute();
        } catch (SQLException ex) {
            throw ex;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Depromoção de Representante para Sem teto
    public void depromocaoDe(Representante r) throws SQLException, RuntimeException {
        PreparedStatement ps = null;
        try {
            Pessoa temp = this.read(r.getNome());
            String query = "DELETE FROM Representante WHERE(idSemTeto = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.execute();
            ps.close();
            query = "INSERT INTO SemTeto(idPessoa)"
                    + "VALUES(?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.execute();
        } catch (SQLException ex) {
            throw ex;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Depromoção de Morador para Sem teto
    public void depromocaoDe(Morador m) throws SQLException, RuntimeException {
        PreparedStatement ps = null;
        try {
            Pessoa temp = this.read(m.getNome());
            String query = "DELETE FROM Morador WHERE(idSemTeto = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.execute();
            ps.close();
            query = "INSERT INTO SemTeto(idPessoa)"
                    + "VALUES(?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdPessoa());
            ps.execute();
        } catch (SQLException ex) {
            throw ex;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
}
