/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alber
 */
public class conectaBD {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/crud2?zeroDateTimeBehavior=convert_To_Null";
    private static final String USER = "crud";
    private static final String PASS = "1234";
    private static final String USESSL = "false";
    
    public static Connection AbreConexao(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
                               
        } catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException("Erro na conexão: ",ex);
        }
    }
    
    public static void FechaConexao(Connection IdConexao){     
        try {
            if (IdConexao != null) {
                IdConexao.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro para fechar conexão: ",ex);
        }
    }
    
    public static void FechaConexao(Connection IdConexao, PreparedStatement Stmt) {
        FechaConexao(IdConexao);
        try {
            if (Stmt != null) {
                Stmt.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro para fechar conexão: ",ex);
        }
    }
    
    public static void FechaConexao(Connection IdConexao, PreparedStatement Stmt, ResultSet rs) {
        FechaConexao(IdConexao, Stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro para fechar conexão: ",ex);
        }
    }

}
