/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Davidson
 */
public class Representante extends Pessoa {
    private Republica republicaAtual;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public Representante(Republica republicaAtual, LocalDate dataInicio, LocalDate dataFinal, String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, int idPessoa, String login, String senha) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, idPessoa, false, false, true, login, senha);
        this.republicaAtual = republicaAtual;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public Representante(Republica republicaAtual, LocalDate dataInicio, LocalDate dataFinal, String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, String login, String senha) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, false, false, true, login, senha);
        this.republicaAtual = republicaAtual;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public Representante(Republica republicaAtual, LocalDate dataInicio, String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, int idPessoa, String login, String senha) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, idPessoa, false, false, true, login, senha);
        this.republicaAtual = republicaAtual;
        this.dataInicio = dataInicio;
    }

    public Representante(Republica republicaAtual, LocalDate dataInicio, String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, String login, String senha) {
        super(nome, apelido, telefone, cpf, redesSociais, contato1, contat2, false, false, true, login, senha);
        this.republicaAtual = republicaAtual;
        this.dataInicio = dataInicio;
    }
    
    

    

    public Republica getRepublicaAtual() {
        return republicaAtual;
    }

    public void setRepublicaAtual(Republica republicaAtual) {
        this.republicaAtual = republicaAtual;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    
    
}
