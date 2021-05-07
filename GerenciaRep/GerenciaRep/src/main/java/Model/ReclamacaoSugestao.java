/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author Davidson
 */
public class ReclamacaoSugestao {
    private LocalDate dataAbertura;
    private String descricao;
    private LocalDate dataSolucao;
    private int idade;
    private boolean excluida;
    private Pessoa morador;
    private int idReclamacaoSugestao;

    public ReclamacaoSugestao(LocalDate dataAbertura, String descricao, LocalDate dataSolucao, int idade, boolean excluida, Pessoa morador) {
        this.dataAbertura = dataAbertura;
        this.descricao = descricao;
        this.dataSolucao = dataSolucao;
        this.idade = idade;
        this.excluida = excluida;
        this.morador = morador;
    }

    public ReclamacaoSugestao(LocalDate dataAbertura, String descricao, LocalDate dataSolucao, int idade, boolean excluida) {
        this.dataAbertura = dataAbertura;
        this.descricao = descricao;
        this.dataSolucao = dataSolucao;
        this.idade = idade;
        this.excluida = excluida;
        this.morador = null;
    }

    public ReclamacaoSugestao(LocalDate dataAbertura, String descricao, LocalDate dataSolucao, int idade, boolean excluida, Pessoa morador, int idReclamacaoSugestao) {
        this.dataAbertura = dataAbertura;
        this.descricao = descricao;
        this.dataSolucao = dataSolucao;
        this.idade = idade;
        this.excluida = excluida;
        this.morador = morador;
        this.idReclamacaoSugestao = idReclamacaoSugestao;
    }
    
    
    
    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataSolucao() {
        return dataSolucao;
    }

    public void setDataSolucao(LocalDate dataSolucao) {
        this.dataSolucao = dataSolucao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean getExcluida() {
        return excluida;
    }

    public boolean isExcluida() {
        return excluida;
    }

    public void setExcluida(boolean excluida) {
        this.excluida = excluida;
    }

    public Pessoa getMorador() {
        if (morador == null){
            throw new RuntimeException("Morador anonimo");
        }
        return morador;
    }

    public void setMorador(Pessoa morador) {
        this.morador = morador;
    }
    
    
   
    
    
}
