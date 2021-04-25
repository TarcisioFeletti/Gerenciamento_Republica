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
import model.Republica;

/**
 *
 * @author tarci
 */
public class RepublicaDAO {

    private Connection conexao;

    RepublicaDAO() {
        conexao = DBConnection.getConexao();
    }
    
    //Criar uma nova república
    public void create(Republica republica) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO Republica(nomeRepublica, dataFundacao, dataExtincao, endereco, "
                    + "bairro, pontoReferencia, localizacaoGeografica, vantagens, "
                    + "despesasMediaPorMorador, vagasTotal, vagasOcupadas, vagasDisponiveis, numeroDaCasa)  "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
    
    //Deletar uma república
    public void delete(String nome) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM Republica WHERE (nomeRepublica = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, nome);
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
    
    //Ler os dados de uma república
    public Republica read(String nome) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Republica WHERE (nomeRepublica = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            Republica rep = new Republica(rs.getString("nome"), rs.getString("endereco"), 
                        LocalDate.parse(rs.getString("dataFundacao")), LocalDate.parse(rs.getString("dataExtincao")), 
                        rs.getString("bairro"), rs.getString("pontoReferencia"), rs.getString("localizacaoGeografica"),
                        rs.getString("vantagens"), rs.getInt("numeroDaCasa"),  rs.getFloat("despesasMediasPorMorador"), 
                        rs.getInt("vagasTotal"), rs.getInt("vagasOcupadas"), rs.getInt("vagasDisponiveis"), 
                        rs.getInt("idREpublica"));
            return rep;

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
    
    //Ler os dados de todas as repúblicas
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
                Republica rep = new Republica(rs.getString("nome"), rs.getString("endereco"), 
                        LocalDate.parse(rs.getString("dataFundacao")), LocalDate.parse(rs.getString("dataExtincao")), 
                        rs.getString("bairro"), rs.getString("pontoReferencia"), rs.getString("localizacaoGeografica"),
                        rs.getString("vantagens"), rs.getInt("numeroDaCasa"),  rs.getFloat("despesasMediasPorMorador"), 
                        rs.getInt("vagasTotal"), rs.getInt("vagasOcupadas"), rs.getInt("vagasDisponiveis"), 
                        rs.getInt("idREpublica"));
                republicaCollection.add(rep);
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
    
    //Atualizar os dados de uma república
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
}