/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tarci
 */
public class TarefaPessoa {
    private Pessoa usuario;
    private Tarefa tarefa;

    public TarefaPessoa(Pessoa usuario, Tarefa tarefa) {
        this.usuario = usuario;
        this.tarefa = tarefa;
    }
    
    
    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
    
    
}
