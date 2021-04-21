/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Davidson
 */
public class Tarefa {
    private LocalDate dataInicio;
    private String descricao;
    private LocalDate dataTermino;
    private boolean terminada;
    private List<Pessoa> pessoaCollection;

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }

    public List<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(List<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

}
