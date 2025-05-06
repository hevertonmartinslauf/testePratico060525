/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hever
 */
public class ConexaoPostgreSQL {
   
    static String servidor = "127.0.0.1";
    static String nomeBanco = "testepratico";
    static String porta = "5432";
    static String usuario = "postgres";
    static String senha = "admin";
    static Connection conexao;
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
                        
        String url = "jdbc:postgresql://" + servidor + ":" + porta + "/" + nomeBanco;
        conexao = null;
        // Definir os DRIVERS de conexão
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection(url, usuario, senha);
        return conexao;   
    }
    
}
