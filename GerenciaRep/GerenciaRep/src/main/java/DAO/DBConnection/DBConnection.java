/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarci
 */
public class DBConnection {

    private static Connection conexao = null;

    private static void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexao = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tarci\\OneDrive\\Documentos\\Estudos\\2020 2\\PSS\\TrabalhoFinal\\gerenciamento-republica\\GerenciaRep\\GerenciaRep\\src\\main\\java\\DAO\\DBConnection\\gerenciamento-republica.db");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fecharConexao() {
        if (conexao == null) {
            return;
        }
        try {
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }

    public static Connection getConexao() {
        try {
            if(conexao == null){
                conectar();
            }else if(conexao.isClosed()){
                conectar();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return conexao;
    }

}
