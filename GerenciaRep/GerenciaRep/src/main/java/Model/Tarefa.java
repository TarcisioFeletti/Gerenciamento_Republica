/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Davidson
 */
public class Tarefa {
    private int idTarefa;
    private LocalDate dataInicio;
    private String descricao;
    private LocalDate dataTermino;
    private boolean terminada;

    public Tarefa(int idTarefa, LocalDate dataInicio, String descricao, LocalDate dataTermino, boolean terminada) {
        this.idTarefa = idTarefa;
        this.dataInicio = dataInicio;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.terminada = terminada;
    }

    public Tarefa(LocalDate dataInicio, String descricao, LocalDate dataTermino, boolean terminada) {
        this.dataInicio = dataInicio;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.terminada = terminada;
    }

    public Tarefa(LocalDate dataInicio, String descricao, boolean terminada) {
        this.dataInicio = dataInicio;
        this.descricao = descricao;
        this.terminada = terminada;
    }

    public Tarefa(int idTarefa, LocalDate dataInicio, String descricao, boolean terminada) {
        this.idTarefa = idTarefa;
        this.dataInicio = dataInicio;
        this.descricao = descricao;
        this.terminada = terminada;
    }
    
    

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

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
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

}
