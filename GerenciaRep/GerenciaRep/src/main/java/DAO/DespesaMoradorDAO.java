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
import model.DespesaMorador;
import model.Pessoa;
import model.Republica;

/**
 *
 * @author tarci
 */
public class DespesaMoradorDAO {
    private Connection conexao;

    DespesaMoradorDAO() {
        conexao = DBConnection.getConexao();
    }

    public void create(String nomePessoa, String descricao, LocalDate data) throws SQLException {
        PreparedStatement ps = null;
        try {
            PessoaDAO subQuery = new PessoaDAO();
            Pessoa pessoa = subQuery.read(nomePessoa);
            String query = "INSERT INTO DespesaMorador(idDespesa, idMorador, porcentagemDoValorTotal)  "
                    + "VALUES(?,?,?)";
            ps = conexao.prepareStatement(query);
            
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public void delete(String nome) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM Republica WHERE (nomeRepublica = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, nome);
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
        }
    }

    public DespesaMorador readAllPorMorador(String nomePessoa, String descricao, LocalDate data) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DespesaMorador dado;

        try {
            String query = "SELECT * FROM Republica WHERE (nomeRepublica = ?);";
            ps = conexao.prepareStatement(query);
            
            rs = ps.executeQuery();
            

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
        return null;
    }
/*
    public List<Republica> getAll() throws SQLException {
        Connection con = DBConnection.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Republica> republicaCollection = new ArrayList<>();

        try {
            String query = "SELECT * FROM Republica";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                republica.setNomeRepublica(rs.getString("nomeRepublica"));
                republica.setDataFundacao(LocalDate.parse(rs.getString("dataFundacao")));
                republica.setDataExtincao(LocalDate.parse(rs.getString("dataExtincao")));
                republica.setEndereco(rs.getString("endereco"));
                republica.setBairro(rs.getString("bairro"));
                republica.setPontoReferencia(rs.getString("pontoReferencia"));
                republica.setLocalizacaoGeografica(rs.getString("localizacaoGeografica"));
                republica.setVantagens(rs.getString("vantagens"));
                republica.setDespesasMediasPorMorador(rs.getFloat("despesasMediasPorMorador"));
                republica.setVagasTotal(rs.getInt("vagasTotal"));
                republica.setVagasOcupadas(rs.getInt("vagasOcupadas"));
                republica.setVagasDisponiveis(rs.getInt("vagasDisponiveis"));
                republica.setNumero(rs.getInt("numeroDaCasa"));
                republicaCollection.add(republica);
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
        return republicaCollection;
    }

    public void update(Republica republica, String nome) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE Republica SET nomeRepublica = ?, dataFundacao = ?, dataExtincao = ?, endereco = ?, "
                    + "bairro = ?, pontoReferencia = ?, localizacaoGeografica = ?, vantagens = ?, despesasMedisPorMorador = ?, "
                    + "vagasTotal = ?, vagasOcupadas = ?, vagasDisponiveis = ?, numeroDaCasa = ? "
                    + "WHERE (nomeRepublica = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, republica.getNomeRepublica());
            ps.setDate(2, Date.valueOf(republica.getDataFundacao()));
            ps.setDate(3, Date.valueOf(republica.getDataExtincao()));
            ps.setString(4, republica.getEndereco());
            ps.setString(5, republica.getBairro());
            ps.setString(6, republica.getPontoReferencia());
            ps.setString(7, republica.getLocalizacaoGeografica());
            ps.setString(8, republica.getVantagens());
            ps.setFloat(9, republica.getDespesasMediasPorMorador());
            ps.setInt(10, republica.getVagasTotal());
            ps.setInt(11, republica.getVagasOcupadas());
            ps.setInt(12, republica.getVagasDisponiveis());
            ps.setInt(13, republica.getNumero());
            ps.setString(14, nome);
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
*/
}
