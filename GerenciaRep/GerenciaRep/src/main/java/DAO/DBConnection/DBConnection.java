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

    private static Connection conexao;

    private static void conectar() {
        try {
            Connection con = null;
            Class.forName("org.sqlite.JDBC");
            conexao = DriverManager.getConnection("jdbc:sqlite:gerenciamento-republica.db");
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
            if (conexao.isClosed()) {
                conectar();
            }else if(conexao == null){
                conectar();
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return conexao;
    }
}
