/*

 SCRIPT CRIAÇÃO TABELAS BANCO DE DADOS

 CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha CHAR(64) NOT NULL
);

CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_admissao DATE NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    status BOOLEAN NOT NULL
);
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
