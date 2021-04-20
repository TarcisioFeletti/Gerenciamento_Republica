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
public class Republica {

    private String nomeRepublica;
    private String endereco;
    private LocalDate dataFundacao;
    private LocalDate dataExtincao;
    private String bairro;
    private String pontoReferencia;
    private String localizacaoGeografica;
    private String vantagens;
    private int numero;
    private float despesasMediasPorMorador;
    private int vagasTotal;
    private int vagasOcupadas;
    private int vagasDisponiveis;

    public String getNomeRepublica() {
        return nomeRepublica;
    }

    public void setNomeRepublica(String nomeRepublica) {
        this.nomeRepublica = nomeRepublica;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public LocalDate getDataExtincao() {
        return dataExtincao;
    }

    public void setDataExtincao(LocalDate dataExtincao) {
        this.dataExtincao = dataExtincao;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getLocalizacaoGeografica() {
        return localizacaoGeografica;
    }

    public void setLocalizacaoGeografica(String localizacaoGeografica) {
        this.localizacaoGeografica = localizacaoGeografica;
    }

    public String getVantagens() {
        return vantagens;
    }

    public void setVantagens(String vantagens) {
        this.vantagens = vantagens;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getDespesasMediasPorMorador() {
        return despesasMediasPorMorador;
    }

    public void setDespesasMediasPorMorador(float despesasMediasPorMorador) {
        this.despesasMediasPorMorador = despesasMediasPorMorador;
    }

    public int getVagasTotal() {
        return vagasTotal;
    }

    public void setVagasTotal(int vagasTotal) {
        this.vagasTotal = vagasTotal;
    }

    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    public void setVagasOcupadas(int vagasOcupadas) {
        this.vagasOcupadas = vagasOcupadas;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
    
    

}
