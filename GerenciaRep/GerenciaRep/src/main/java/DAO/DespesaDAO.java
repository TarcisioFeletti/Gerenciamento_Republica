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
import java.util.List;
import model.Despesa;
import model.DespesaMorador;
import model.Pessoa;
import model.Republica;

/**
 *
 * @author tarci
 */
public class DespesaDAO {

    private Connection conexao;

    public DespesaDAO() {
        conexao = DBConnection.getConexao();
    }

    //Criar uma despesa
    public void create(Despesa despesa, Pessoa pessoa) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO Lancamento(descricao, valor, periodicidade, idRepublica)"
                    + "VALUES(?,?,?,?)";
            ps = conexao.prepareStatement(query);
            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setString(3, despesa.getPeriocidade());
            ps.setInt(4, despesa.getRepublica().getIdRepublica());
            ps.execute();
            Despesa temp = this.read(despesa.getDescricao(), despesa.getDataVencimento());
            query = "INSERT INTO Despesa(idDespesa, dataVencimento)  "
                    + "VALUES(?,?)";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, temp.getIdLancamento());
            ps.setDate(2, Date.valueOf(despesa.getDataVencimento().format(DateTimeFormatter.ISO_DATE)));
            ps.execute();
            new DespesaMoradorDAO().create(despesa, pessoa);
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
        }
    }

    public void create(List<DespesaMorador> despesaMoradorCollection) throws SQLException {
        PreparedStatement ps = null;
        try {
                String query = "INSERT INTO Lancamento(descricao, valor, periodicidade, idRepublica)"
                        + "VALUES(?,?,?,?)";
                ps = conexao.prepareStatement(query);
                ps.setString(1, despesaMoradorCollection.get(1).getDespesa().getDescricao());
                ps.setDouble(2, despesaMoradorCollection.get(1).getDespesa().getValor());
                ps.setString(3, despesaMoradorCollection.get(1).getDespesa().getPeriocidade());
                ps.setInt(4, despesaMoradorCollection.get(1).getDespesa().getRepublica().getIdRepublica());
                ps.execute();
                Despesa temp = this.read(despesaMoradorCollection.get(1).getDespesa().getDescricao(), 
                        despesaMoradorCollection.get(1).getDespesa().getDataVencimento());
                query = "INSERT INTO Despesa(idDespesa, dataVencimento)  "
                        + "VALUES(?,?)";
                ps = conexao.prepareStatement(query);
                ps.setInt(1, temp.getIdLancamento());
                ps.setDate(2, Date.valueOf(despesaMoradorCollection.get(1).getDespesa().getDataVencimento().format(DateTimeFormatter.ISO_DATE)));
                ps.execute();
                new DespesaMoradorDAO().create(despesaMoradorCollection);
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
        }
    }

    //Ler uma despesa pela descricao e data de vencimento
    public Despesa read(String descricao, LocalDate dataVencimento) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Despesa despesa = null;

        try {
            String query = "SELECT * FROM Despesa d inner join Lancamento l on d.idLancamento = l.idLancamento WHERE (dataVencimento = ?) and (descricao = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(dataVencimento.format(DateTimeFormatter.ISO_DATE)));
            ps.setString(2, descricao);
            rs = ps.executeQuery();
            Republica republica = new RepublicaDAO().read(rs.getInt("idRepublica"));
            despesa = new Despesa(LocalDate.parse(rs.getString("dataVencimento")), rs.getString("descricao"),
                    rs.getDouble("valor"), rs.getString("periodicidade"), republica, rs.getInt("idDespesa"));
            return despesa;
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
    
    //Ler uma despesa pelo id
    public Despesa read(int idLancamento) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Despesa despesa = null;

        try {
            String query = "SELECT * FROM Despesa d inner join Lancamento l on d.idLancamento = l.idLancamento WHERE (idLancamento = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, idLancamento);
            rs = ps.executeQuery();
            Republica republica = new RepublicaDAO().read(rs.getInt("idRepublica"));
            despesa = new Despesa(LocalDate.parse(rs.getString("dataVencimento")), rs.getString("descricao"),
                    rs.getDouble("valor"), rs.getString("periodicidade"), republica, rs.getInt("idDespesa"));
            return despesa;
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

    //Excluir uma despesa
    public void delete(String descricao, LocalDate dataVencimento) throws SQLException {
        PreparedStatement ps = null;
        try {
            Despesa despesa = this.read(descricao, dataVencimento);
            String query = "DELETE FROM Lancamento WHERE (idLancamento = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, despesa.getIdLancamento());
            ps.execute();
            query = "DELETE FROM Despesa WHERE (idDespesa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, despesa.getIdLancamento());
            ps.execute();
            new DespesaMoradorDAO().removerPorDespesa(despesa);
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
    
    //Atualizar uma despesa
    public void update(Despesa despesa, String descricaoAntiga, LocalDate dataVencimentoAntiga) throws SQLException {
        PreparedStatement ps = null;
        try {
            Despesa despesaAntiga = this.read(descricaoAntiga, dataVencimentoAntiga);
            String query = "UPDATE Lancamento SET descricao = ?, valor = ?, periodicidade = ?, idRepublica = ? "
                    + "WHERE(idLancamento = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setString(3, despesa.getPeriocidade());
            ps.setInt(4, despesa.getRepublica().getIdRepublica());
            ps.setInt(5, despesa.getIdLancamento());
            ps.execute();
            query = "UPDATE Despesa SET dataVencimento = ?"
                    + "WHERE(idDespesa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setDate(1, Date.valueOf(despesa.getDataVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setInt(2, despesa.getIdLancamento());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
}
