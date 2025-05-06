/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author hever
 */
public class UsuarioDAO {

    PreparedStatement pstmt;
    
    public UsuarioDAO() {
        
    }
    
    public void inserir(Usuario u) throws SQLException, ClassNotFoundException {
        
        String sql = "INSERT INTO usuario (nome, email, senha)"
                + "VALUES (?,?,?)";
        
        pstmt = ConexaoPostgreSQL.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS );
        
        pstmt.setString(1, u.getNome() );
        pstmt.setString(2, u.getEmail());
        pstmt.setString(3, u.getSenha() );
        
        pstmt.execute();
        
        ResultSet res = pstmt.getGeneratedKeys();
        if ( res.next() ) {
            int id = res.getInt(1);
            u.setIdUsuario(id);
        }
        
    }
    
    public Usuario validarLogin(String email, String senha) throws ClassNotFoundException, SQLException {
        
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        
        pstmt = ConexaoPostgreSQL.getConexao().prepareStatement(sql);
        
        pstmt.setString(1, email);
        pstmt.setString(2, senha);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            return usuario;
        }
        
        return null;
        
    }
    
}
