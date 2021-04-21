/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Davidson
 */
public abstract class Pessoa {
    
    private String nome;
    private String apelido;
    private int telefone;
    private int cpf;
    private String redesSociais;
    private int contato1;
    private int contat2;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(String redesSociais) {
        this.redesSociais = redesSociais;
    }

    public int getContato1() {
        return contato1;
    }

    public void setContato1(int contato1) {
        this.contato1 = contato1;
    }

    public int getContat2() {
        return contat2;
    }

    public void setContat2(int contat2) {
        this.contat2 = contat2;
    }

    public Pessoa(String nome, String apelido, int telefone, int cpf, String redesSociais, int contato1, int contat2) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.cpf = cpf;
        this.redesSociais = redesSociais;
        this.contato1 = contato1;
        this.contat2 = contat2;
    }
     
    
    
}
