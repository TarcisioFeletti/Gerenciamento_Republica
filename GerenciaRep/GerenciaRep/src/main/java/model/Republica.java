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
    private LocalDate dataExtincao; //Pode ser null
    private String bairro;
    private String pontoReferencia;
    private String localizacaoGeografica;//Pode ser null
    private String vantagens;
    private int numero;
    private double despesasMediasPorMorador;
    private int vagasTotal;
    private int vagasOcupadas;
    private int vagasDisponiveis;
    private int idRepublica;//Pode ser null

    public Republica(String nomeRepublica, String endereco, LocalDate dataFundacao, LocalDate dataExtincao, String bairro, String pontoReferencia, String localizacaoGeografica, String vantagens, int numero, double despesasMediasPorMorador, int vagasTotal, int vagasOcupadas, int vagasDisponiveis, int idRepublica) {
        this.nomeRepublica = nomeRepublica;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.dataExtincao = dataExtincao;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.localizacaoGeografica = localizacaoGeografica;
        this.vantagens = vantagens;
        this.numero = numero;
        this.despesasMediasPorMorador = despesasMediasPorMorador;
        this.vagasTotal = vagasTotal;
        this.vagasOcupadas = vagasOcupadas;
        this.vagasDisponiveis = vagasDisponiveis;
        this.idRepublica = idRepublica;
    }

    public Republica(String nomeRepublica, String endereco, LocalDate dataFundacao, LocalDate dataExtincao, String bairro, String pontoReferencia, String localizacaoGeografica, String vantagens, int numero, double despesasMediasPorMorador, int vagasTotal, int vagasOcupadas, int vagasDisponiveis) {
        this.nomeRepublica = nomeRepublica;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.dataExtincao = dataExtincao;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.localizacaoGeografica = localizacaoGeografica;
        this.vantagens = vantagens;
        this.numero = numero;
        this.despesasMediasPorMorador = despesasMediasPorMorador;
        this.vagasTotal = vagasTotal;
        this.vagasOcupadas = vagasOcupadas;
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public Republica(String nomeRepublica, String endereco, LocalDate dataFundacao, LocalDate dataExtincao, String bairro, String pontoReferencia, String vantagens, int numero, double despesasMediasPorMorador, int vagasTotal, int vagasOcupadas, int vagasDisponiveis) {
        this.nomeRepublica = nomeRepublica;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.dataExtincao = dataExtincao;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.vantagens = vantagens;
        this.numero = numero;
        this.despesasMediasPorMorador = despesasMediasPorMorador;
        this.vagasTotal = vagasTotal;
        this.vagasOcupadas = vagasOcupadas;
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public Republica(String nomeRepublica, String endereco, LocalDate dataFundacao, String bairro, String pontoReferencia, String vantagens, int numero, double despesasMediasPorMorador, int vagasTotal, int vagasOcupadas, int vagasDisponiveis) {
        this.nomeRepublica = nomeRepublica;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.vantagens = vantagens;
        this.numero = numero;
        this.despesasMediasPorMorador = despesasMediasPorMorador;
        this.vagasTotal = vagasTotal;
        this.vagasOcupadas = vagasOcupadas;
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public Republica(String nomeRepublica, String endereco, LocalDate dataFundacao, String bairro, String pontoReferencia, String vantagens, int numero, double despesasMediasPorMorador, int vagasTotal, int vagasOcupadas, int vagasDisponiveis, int idRepublica) {
        this.nomeRepublica = nomeRepublica;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.vantagens = vantagens;
        this.numero = numero;
        this.despesasMediasPorMorador = despesasMediasPorMorador;
        this.vagasTotal = vagasTotal;
        this.vagasOcupadas = vagasOcupadas;
        this.vagasDisponiveis = vagasDisponiveis;
        this.idRepublica = idRepublica;
    }

    public Republica(String nomeRepublica, String endereco, LocalDate dataFundacao, LocalDate dataExtincao, String bairro, String pontoReferencia, String vantagens, int numero, double despesasMediasPorMorador, int vagasTotal, int vagasOcupadas, int vagasDisponiveis, int idRepublica) {
        this.nomeRepublica = nomeRepublica;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.dataExtincao = dataExtincao;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.vantagens = vantagens;
        this.numero = numero;
        this.despesasMediasPorMorador = despesasMediasPorMorador;
        this.vagasTotal = vagasTotal;
        this.vagasOcupadas = vagasOcupadas;
        this.vagasDisponiveis = vagasDisponiveis;
        this.idRepublica = idRepublica;
    }

    public Republica(String nomeRepublica, String endereco, LocalDate dataFundacao, String bairro, String pontoReferencia, String localizacaoGeografica, String vantagens, int numero, double despesasMediasPorMorador, int vagasTotal, int vagasOcupadas, int vagasDisponiveis, int idRepublica) {
        this.nomeRepublica = nomeRepublica;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.localizacaoGeografica = localizacaoGeografica;
        this.vantagens = vantagens;
        this.numero = numero;
        this.despesasMediasPorMorador = despesasMediasPorMorador;
        this.vagasTotal = vagasTotal;
        this.vagasOcupadas = vagasOcupadas;
        this.vagasDisponiveis = vagasDisponiveis;
        this.idRepublica = idRepublica;
    }
    
    
  
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

    public double getDespesasMediasPorMorador() {
        return despesasMediasPorMorador;
    }

    public void setDespesasMediasPorMorador(double despesasMediasPorMorador) {
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

    public int getIdRepublica() {
        return idRepublica;
    }

    public void setIdRepublica(int idRepublica) {
        this.idRepublica = idRepublica;
    }
    
    

}
