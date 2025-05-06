/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author hever
 */
public class FuncionarioDAO {

    PreparedStatement pstmt;
    
    public FuncionarioDAO() {
        
    }
    
    public void inserir(Funcionario f) throws SQLException, ClassNotFoundException {
        
        String sql = "INSERT INTO funcionario (nome, data_admissao, salario, status)"
                + "VALUES (?,?,?,?)";
        
        pstmt = ConexaoPostgreSQL.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS );
        
        pstmt.setString(1, f.getNome() );
        Date datasql = new Date(f.getDtEmissao().getTime());
        pstmt.setDate(2, datasql);
        pstmt.setFloat(3, f.getSalario() );
        pstmt.setBoolean(4, f.getStatus() );
        
        pstmt.execute();
        
    }
    
    public void alterar(Funcionario f) throws SQLException, ClassNotFoundException {
        
        String sql = "UPDATE funcionario SET nome = ?, data_admissao = ?, salario = ?, status = ? "
                + "WHERE id = ?";
        
        pstmt = ConexaoPostgreSQL.getConexao().prepareStatement(sql);
        
        pstmt.setString(1, f.getNome() );
        Date datasql = new Date(f.getDtEmissao().getTime());
        pstmt.setDate(2, datasql);
        pstmt.setFloat(3, f.getSalario() );
        pstmt.setBoolean(4, f.getStatus() );
        pstmt.setInt(5, f.getIdFuncionario());
        
        pstmt.execute();
        
    }
    
     public void deletar(Funcionario f) throws SQLException, ClassNotFoundException {
        
        String sql = "DELETE FROM funcionario WHERE id = ?";
        
        pstmt = ConexaoPostgreSQL.getConexao().prepareStatement(sql);
        
        pstmt.setInt(1, f.getIdFuncionario());
        
        pstmt.execute();
        
    }
    
    public List listarTodos() throws ClassNotFoundException, SQLException{
        
        List lista = new ArrayList();
        
        String sql = "SELECT * FROM funcionario";
        
        pstmt = ConexaoPostgreSQL.getConexao().prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        if (!rs.next()) {
            System.out.println("O ResultSet está vazio.");
            return null;
        } else {
            do {
                    Funcionario f = new Funcionario();
                    f.setIdFuncionario(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setSalario(rs.getFloat("salario"));
                    f.setStatus(rs.getBoolean("status"));
                    f.setDtEmissao(rs.getDate("data_admissao"));
                    System.out.println("ID: "+f.getIdFuncionario()+
                            " NOME: "+f.getNome()+" SALARIO: "+f.getSalario()
                            +" STATUS: "+f.getStatus()+" Dt Emissao: "+f.getDtEmissao());
                    lista.add(f);
                    } while (rs.next());
                }
      
        return lista;
        
    }
    
}
