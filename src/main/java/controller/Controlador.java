/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Usuario;

/**
 *
 * @author hever
 */
public class Controlador {
    
    UsuarioDAO usuarioDAO;
    FuncionarioDAO funcionarioDAO;

    public Controlador() throws ClassNotFoundException, SQLException {
        
        usuarioDAO = new UsuarioDAO();
        funcionarioDAO = new FuncionarioDAO();
        
    }
    
    /*######################################USUARIO###################################################*/
    
    public void cadastrarUsuario(Usuario u) throws SQLException, ClassNotFoundException{
        
            usuarioDAO.inserir(u);
            
    }
    
    
    public Usuario validarLogin(String email, String senha) throws ClassNotFoundException, SQLException{
        
            return usuarioDAO.validarLogin(email, senha);
            
    }
    
    /*######################################FUNCIONARIO###################################################*/
    
    
    public void cadastrarFuncionario(Funcionario f) throws SQLException, ClassNotFoundException{
        
            funcionarioDAO.inserir(f);
    }
    
    public void alterarFuncionario(Funcionario f) throws SQLException, ClassNotFoundException{
        
            funcionarioDAO.alterar(f);
    }
    
    public void deletarFuncionario(Funcionario f) throws SQLException, ClassNotFoundException{
        
            funcionarioDAO.deletar(f);
    }
    
    public void listarTodosFuncionarios(JTable tabela) throws ClassNotFoundException, SQLException{
    
        List listaFuncionarios = null;
        Funcionario f;
        
        listaFuncionarios = funcionarioDAO.listarTodos();
        
        if(listaFuncionarios != null){
            
            ((DefaultTableModel) tabela.getModel()).setRowCount(0);

            Iterator<Funcionario> itFun = listaFuncionarios.iterator();
            SimpleDateFormat saidaBanco = new SimpleDateFormat ("dd/MM/yyyy");
            
            while (itFun.hasNext()) {
            
                f = itFun.next();
            
                ((DefaultTableModel) tabela.getModel()).addRow( new Object[] {f.getIdFuncionario(), f, saidaBanco.format(f.getDtEmissao()),
                f.getSalario(), f.getStatus()});
            }
        }
    }    
}
