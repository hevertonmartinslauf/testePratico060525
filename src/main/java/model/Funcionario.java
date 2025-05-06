/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author hever
 */
public class Funcionario {
    
    private int idFuncionario;
    private String nome;
    private Date dtEmissao;
    private Float salario;
    private Boolean status;

    public Funcionario(int idFuncionario, String nome, Date dtEmissao, Float salario, Boolean status) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.dtEmissao = dtEmissao;
        this.salario = salario;
        this.status = status;
    }

    public Funcionario() {
    }

    public Funcionario(String nome, Date dtEmissao, Float salario, Boolean status) {
        this.nome = nome;
        this.dtEmissao = dtEmissao;
        this.salario = salario;
        this.status = status;
    }

    @Override
    public String toString() {
        return nome;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
