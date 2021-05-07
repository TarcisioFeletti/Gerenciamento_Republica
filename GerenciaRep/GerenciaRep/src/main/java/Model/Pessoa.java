/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Davidson
 */
public abstract class Pessoa {
    
    private String nome;
    private String apelido;
    private String telefone;
    private String cpf;
    private String redesSociais;
    private String contato1;
    private String contat2;
    private int idPessoa;
    private boolean semTeto;
    private boolean morador;
    private boolean representante;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(String redesSociais) {
        this.redesSociais = redesSociais;
    }

    public String getContato1() {
        return contato1;
    }

    public void setContato1(String contato1) {
        this.contato1 = contato1;
    }

    public String getContat2() {
        return contat2;
    }

    public void setContat2(String contat2) {
        this.contat2 = contat2;
    }

    public boolean isSemTeto() {
        return semTeto;
    }

    public void setSemTeto(boolean semTeto) {
        this.semTeto = semTeto;
    }

    public boolean isMorador() {
        return morador;
    }

    public void setMorador(boolean morador) {
        this.morador = morador;
    }

    public boolean isRepresentante() {
        return representante;
    }

    public void setRepresentante(boolean representante) {
        this.representante = representante;
    }

    public Pessoa(String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, int idPessoa, boolean semTeto, boolean morador, boolean representante) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.cpf = cpf;
        this.redesSociais = redesSociais;
        this.contato1 = contato1;
        this.contat2 = contat2;
        this.idPessoa = idPessoa;
        this.semTeto = semTeto;
        this.morador = morador;
        this.representante = representante;
    }

    public Pessoa(String nome, String apelido, String telefone, String cpf, String redesSociais, String contato1, String contat2, boolean semTeto, boolean morador, boolean representante) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.cpf = cpf;
        this.redesSociais = redesSociais;
        this.contato1 = contato1;
        this.contat2 = contat2;
        this.semTeto = semTeto;
        this.morador = morador;
        this.representante = representante;
    }

    public Pessoa() {
    }
}
