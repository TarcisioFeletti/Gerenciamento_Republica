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

/**
 *
 * @author tarci
 */
public class TarefasMoradorDAO {

    private TarefasDAO functions = new TarefasDAO();

    //Create
    public void adicionar(List<Pessoa> moradorCollection, Tarefa tarefa) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        try {
            for (Pessoa pessoa : moradorCollection) {
                String query = "INSERT INTO TarefaMorador(idTarefa, idPessoa)  Values(?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, tarefa.getIdTarefa());
                ps.setInt(2, pessoa.getIdPessoa());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        }
    }

    //Delete
    public void removerPorTarefa(int idTarefa) throws SQLException {
        //Excluir todas as relações entre a tarefa com idTarefa e os moradores
        //pertencentes àquela tarefa
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM TarefaMorador WHERE (idTarefa = ?);";
            ps = con.prepareStatement(query);
            ps.setInt(1, idTarefa);
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            DBConnection.fecharConexao();
        }
    }

    public void removerPorPessoa(int idPessoa) throws SQLException {
        //Excluir todas as relações entre a pessoa com idPessoa e as tarefas
        //atribuídas a ele
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM TarefaMorador WHERE (idPessoa = ?);";
            ps = con.prepareStatement(query);
            ps.setInt(1, idPessoa);
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            DBConnection.fecharConexao();
        }
    }

    //Read
    //Read Line
    public List<Object> buscarLinhaSemTeto(int idTarefa, int idPessoa) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tarefa tarefa = new Tarefa();
        Pessoa pessoa;
        int[] ids = new int[2];
        List<Object> lista = new ArrayList<>();

        try {
            String query = "SELECT * FROM TarefaMorador WHERE (idTarefa = ?) and (idPessoa = ?);";
            ps = con.prepareStatement(query);
            ps.setInt(1, idTarefa);
            ps.setInt(2, idPessoa);
            rs = ps.executeQuery();
            ids[0] = rs.getInt("idTarefa");
            ids[1] = rs.getInt("idPessoa");

            this.functions.read(ids[0]);
            lista.add(tarefa);

            String sql = "SELECT * FROM SemTeto s inner join Pessoa p on p.idPessoa = s.idSemTeto "
                    + "WHERE (s.idSemTeto = ?);";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ids[1]);
            rs = ps.executeQuery();
            pessoa = new SemTeto(rs.getString("p.nome"), rs.getString("p.apelido"), rs.getInt("p.telefone"),
                    rs.getInt("p.cpf"), rs.getString("p.redesSociais"), rs.getInt("p.contato1"),
                    rs.getInt("p.contato2"), rs.getInt("p.idSemTeto"));
            lista.add(pessoa);
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
        return lista;
    }

    public List<Object> buscarLinhaMorador(int idTarefa, int idPessoa) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tarefa tarefa = new Tarefa();
        Pessoa pessoa;
        int[] ids = new int[2];
        List<Object> lista = new ArrayList<>();

        try {
            String query = "SELECT * FROM TarefaMorador WHERE (idTarefa = ?) and (idPessoa = ?);";
            ps = con.prepareStatement(query);
            ps.setInt(1, idTarefa);
            ps.setInt(2, idPessoa);
            rs = ps.executeQuery();
            ids[0] = rs.getInt("idTarefa");
            ids[1] = rs.getInt("idPessoa");

            this.functions.read(ids[0]);
            lista.add(tarefa);

            String sql = "SELECT * FROM Morador m inner join Pessoa p on p.idPessoa = m.idPessoa "
                    + "inner join Republica r on m.idRepublica = r.idRepublica WHERE (s.idMorador = ?);";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ids[1]);
            rs = ps.executeQuery();
            Republica rep = new Republica();
            rep.setBairro(rs.getString("r.bairro"));
            rep.setDataExtincao(LocalDate.parse(rs.getString("r.dataExtincao")));
            rep.setDataFundacao(LocalDate.parse(rs.getString("r.dataFundacao")));
            rep.setDespesasMediasPorMorador(rs.getFloat("r.despesasMediasPorMorador"));
            rep.setEndereco(rs.getString("r.endereco"));
            rep.setLocalizacaoGeografica(rs.getString("r.localizacaoGeografica"));
            rep.setNomeRepublica(rs.getString("r.nome"));
            rep.setNumero(rs.getInt("r.numeroDaCasa"));
            rep.setPontoReferencia(rs.getString("r.pontoReferencia"));
            rep.setVagasDisponiveis(rs.getInt("r.vagasDisponiveis"));
            rep.setVagasOcupadas(rs.getInt("vagasOcupadas"));
            rep.setVagasTotal(rs.getInt("vagasTotal"));
            rep.setVantagens(rs.getString("vantagens"));
            pessoa = new Morador(rep, rs.getString("p.nome"), rs.getString("p.apelido"),
                    rs.getInt("p.telefone"), rs.getInt("p.cpf"), rs.getString("p.redesSociais"),
                    rs.getInt("p.contato1"), rs.getInt("p.contato2"), rs.getInt("p.idPessoa"));
            lista.add(pessoa);
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
        return lista;
    }

    public List<Object> buscarLinhaRepresentante(int idTarefa, int idPessoa) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tarefa tarefa = new Tarefa();
        Pessoa pessoa;
        int[] ids = new int[2];
        List<Object> lista = new ArrayList<>();

        try {
            String query = "SELECT * FROM TarefaMorador WHERE (idTarefa = ?) and (idPessoa = ?);";
            ps = con.prepareStatement(query);
            ps.setInt(1, idTarefa);
            ps.setInt(2, idPessoa);
            rs = ps.executeQuery();
            ids[0] = rs.getInt("idTarefa");
            ids[1] = rs.getInt("idPessoa");

            tarefa = this.functions.read(ids[0]);
            lista.add(tarefa);

            String sql = "SELECT * FROM Representante re inner join Pessoa p on p.idPessoa = re.idPessoa "
                    + "inner join Republica r on re.idRepublica = r.idRepublica WHERE (s.idMorador = ?);";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ids[1]);
            rs = ps.executeQuery();
            Republica rep = new Republica();
            rep.setBairro(rs.getString("r.bairro"));
            rep.setDataExtincao(LocalDate.parse(rs.getString("r.dataExtincao")));
            rep.setDataFundacao(LocalDate.parse(rs.getString("r.dataFundacao")));
            rep.setDespesasMediasPorMorador(rs.getFloat("r.despesasMediasPorMorador"));
            rep.setEndereco(rs.getString("r.endereco"));
            rep.setLocalizacaoGeografica(rs.getString("r.localizacaoGeografica"));
            rep.setNomeRepublica(rs.getString("r.nome"));
            rep.setNumero(rs.getInt("r.numeroDaCasa"));
            rep.setPontoReferencia(rs.getString("r.pontoReferencia"));
            rep.setVagasDisponiveis(rs.getInt("r.vagasDisponiveis"));
            rep.setVagasOcupadas(rs.getInt("vagasOcupadas"));
            rep.setVagasTotal(rs.getInt("vagasTotal"));
            rep.setVantagens(rs.getString("vantagens"));
            pessoa = new Representante(rep, LocalDate.parse(rs.getString("dataInicio")),
                    LocalDate.parse(rs.getString("dataTermino")), rs.getString("p.nome"),
                    rs.getString("p.apelido"), rs.getInt("p.telefone"), rs.getInt("p.cpf"),
                    rs.getString("p.redesSociais"), rs.getInt("p.contato1"), rs.getInt("p.contato2"),
                    rs.getInt("p.idPessoa"));
            lista.add(pessoa);
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
        return lista;
    }

    //Read all
    public List<Pessoa> lerTodasAsPessoasEmUmaTarefa(int idTarefa) throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData r = null;
        Pessoa pessoa;
        int[] ids = new int[2];
        List<Pessoa> lista = new ArrayList<>();

        try {
            String query = "SELECT * FROM TarefaMorador WHERE (idTarefa = ?);";
            ps = con.prepareStatement(query);
            ps.setInt(1, idTarefa);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = rs.getMetaData();
                
            }

            String sql = "SELECT * FROM Representante re inner join Pessoa p on p.idPessoa = re.idPessoa "
                    + "inner join Republica r on re.idRepublica = r.idRepublica WHERE (s.idMorador = ?);";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ids[1]);
            rs = ps.executeQuery();
            Republica rep = new Republica();
            rep.setBairro(rs.getString("r.bairro"));
            rep.setDataExtincao(LocalDate.parse(rs.getString("r.dataExtincao")));
            rep.setDataFundacao(LocalDate.parse(rs.getString("r.dataFundacao")));
            rep.setDespesasMediasPorMorador(rs.getFloat("r.despesasMediasPorMorador"));
            rep.setEndereco(rs.getString("r.endereco"));
            rep.setLocalizacaoGeografica(rs.getString("r.localizacaoGeografica"));
            rep.setNomeRepublica(rs.getString("r.nome"));
            rep.setNumero(rs.getInt("r.numeroDaCasa"));
            rep.setPontoReferencia(rs.getString("r.pontoReferencia"));
            rep.setVagasDisponiveis(rs.getInt("r.vagasDisponiveis"));
            rep.setVagasOcupadas(rs.getInt("vagasOcupadas"));
            rep.setVagasTotal(rs.getInt("vagasTotal"));
            rep.setVantagens(rs.getString("vantagens"));
            pessoa = new Representante(rep, LocalDate.parse(rs.getString("dataInicio")),
                    LocalDate.parse(rs.getString("dataTermino")), rs.getString("p.nome"),
                    rs.getString("p.apelido"), rs.getInt("p.telefone"), rs.getInt("p.cpf"),
                    rs.getString("p.redesSociais"), rs.getInt("p.contato1"), rs.getInt("p.contato2"),
                    rs.getInt("p.idPessoa"));
            lista.add(pessoa);
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
        return lista;
    }

}
