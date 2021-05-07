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
import java.util.ArrayList;
import java.util.List;
import Model.Historico;
import Model.Pessoa;
import Model.Republica;

/**
 *
 * @author tarci
 */
public class HistoricoDAO {

    private Connection conexao;

    public HistoricoDAO() {
        conexao = DBConnection.getConexao();
    }

    public void create(Historico historico) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO Historico(idPessoa, idRepublica, referenciaData, NR, NRR, TAM, TCM, DPPD, DDPD, ISR, IRT, ICP)  "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, historico.getPessoa().getIdPessoa());
            ps.setInt(2, historico.getRepublica().getIdRepublica());
            ps.setDate(3, Date.valueOf(historico.getReferenciaData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setInt(4, historico.getNr());
            ps.setInt(5, historico.getNrr());
            ps.setInt(6, historico.getTam());
            ps.setInt(7, historico.getTcm());
            ps.setInt(8, historico.getDppd());
            ps.setInt(9, historico.getDdpd());
            ps.setFloat(10, historico.getIsr());
            ps.setFloat(11, historico.getIrt());
            ps.setFloat(12, historico.getIcp());
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    //Delete
    public void remover(Historico historico) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM Historico WHERE (idPessoa = ?) AND (idRepublica = ?) AND (referenciaData = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, historico.getPessoa().getIdPessoa());
            ps.setInt(2, historico.getRepublica().getIdRepublica());
            ps.setDate(3, Date.valueOf(historico.getReferenciaData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.execute();
        } catch (SQLException e) {
            throw new SQLException(e.toString());
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }

    public Historico read(String nomePessoa, String nomeRepublica, LocalDate referenciaData) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Historico historico = null;
        try {

            String query = "SELECT * FROM Historico h INNER JOIN Pessoa p ON h.idPessoa = p.idPessoa "
                    + "INNER JOIN Republica r ON h.idRepublica = r.idRepublica"
                    + " WHERE (p.nome = ?) AND (r.nome = ?) AND (h.referenciaData = ?);";
            ps = conexao.prepareStatement(query);
            ps.setString(1, nomePessoa);
            ps.setString(2, nomeRepublica);
            ps.setDate(3, Date.valueOf(referenciaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            rs = ps.executeQuery();
            Pessoa pessoa = new PessoaDAO().read(rs.getInt("idPessoa"));
            Republica republica = new RepublicaDAO().read(rs.getInt("idRepublica"));
            historico = new Historico(pessoa, republica, LocalDate.parse(rs.getString("referenciaData")), rs.getInt("NR"), rs.getInt("NRR"), rs.getInt("TAM"),
                    rs.getInt("TCM"), rs.getInt("DPPD"), rs.getInt("DDPD"), rs.getFloat("ISR"), rs.getFloat("IRT"),
                    rs.getFloat("ICP"));
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
        return historico;
    }

    public List<Historico> readHistoricoPessoa(Pessoa pessoa) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Historico> historicoCollection = new ArrayList<>();
        try {
            String query = "SELECT * FROM Historico WHERE (idPessoa = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, pessoa.getIdPessoa());
            rs = ps.executeQuery();
            while (rs.next()) {
                Republica republica = new RepublicaDAO().read(rs.getInt("IdRepublica"));
                historicoCollection.add(new Historico(pessoa, republica, LocalDate.parse(rs.getString("referenciaData")),
                        rs.getInt("NR"), rs.getInt("NRR"), rs.getInt("TAM"), rs.getInt("TCM"), rs.getInt("DPPD"),
                        rs.getInt("DDPD"), rs.getFloat("ISR"), rs.getFloat("IRT"), rs.getFloat("ICP")));
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
        return historicoCollection;
    }

    public List<Historico> readHistoricoRepublica(Republica republica) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Historico> historicoCollection = new ArrayList<>();
        try {
            String query = "SELECT * FROM Historico WHERE (idRepublica = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, republica.getIdRepublica());
            rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new PessoaDAO().read(rs.getInt("isPessoa"));
                historicoCollection.add(new Historico(pessoa, republica, LocalDate.parse(rs.getString("referenciaData")),
                        rs.getInt("NR"), rs.getInt("NRR"), rs.getInt("TAM"), rs.getInt("TCM"), rs.getInt("DPPD"),
                        rs.getInt("DDPD"), rs.getFloat("ISR"), rs.getFloat("IRT"), rs.getFloat("ICP")));
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
        return historicoCollection;
    }

    public void update(Historico historico, String nomePessoa, String nomeRepublica, LocalDate referenciaData) throws SQLException {
        PreparedStatement ps = null;
        try {
            Pessoa pessoa = new PessoaDAO().read(nomePessoa);
            Republica republica = new RepublicaDAO().read(nomeRepublica);
            String query = "UPDATE Historico SET idPessoa = ?, idRepublica = ?, referenciaData = ?, NR = ?, NRR = ?, "
                    + "TAM = ?, TCM = ?, DPPD = ?, DDPD = ?, ISR = ?, IRT = ?, ICP = ?"
                    + "WHERE (idPessoa = ?) AND (idRepublica = ?) AND (referenciaData = ?);";
            ps = conexao.prepareStatement(query);
            ps.setInt(1, historico.getPessoa().getIdPessoa());
            ps.setInt(2, historico.getRepublica().getIdRepublica());
            ps.setDate(3, Date.valueOf(historico.getReferenciaData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.setInt(4, historico.getNr());
            ps.setInt(5, historico.getNrr());
            ps.setInt(6, historico.getTam());
            ps.setInt(7, historico.getTcm());
            ps.setInt(8, historico.getDppd());
            ps.setInt(9, historico.getDdpd());
            ps.setFloat(10, historico.getIsr());
            ps.setFloat(11, historico.getIrt());
            ps.setFloat(12, historico.getIcp());
            ps.setInt(13, pessoa.getIdPessoa());
            ps.setInt(14, republica.getIdRepublica());
            ps.setDate(3, Date.valueOf(referenciaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            ps.close();
            DBConnection.fecharConexao();
        }
    }
}
