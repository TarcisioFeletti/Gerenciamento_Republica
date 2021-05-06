/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter.P0000State;

import Presenter.P0000Presenter;

/**
 *
 * @author Lucas Carvalho
 */
public abstract class P0000AbstractState {
    
    private final P0000Presenter presenter;
    
    public P0000AbstractState(P0000Presenter presenter){
        this.presenter = presenter;
    }

    public P0000Presenter getPresenter() {
        return presenter;
    }
    
    //SEM TETO
    
    public void criarRepublica(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void buscarRepublica(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    //MORADOR
    
    public void consultarResultadoMensal(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void manterReclamacoesSugestoes(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void manterPerfil(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void aceitarConvite(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void registrarConclusaoDaTarefa(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void consultarMinhasReceitasEDespesas(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void registrarPagamentoDeReceitaOuDespesa(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    //REPRESENTANTE
    
    public void manterRepublica(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void manterMoradores(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void confirmarSolucaoDeReclamacaoSugestao(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void convidarMoradoeresAceitarConvite(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void manterTarefas(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void manterReceitasEDespesas(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void fazerEstornoDeLancamentos(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    //LOGIN USUARIO
    
    public void logar(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    public void cadastrarNovo(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    //CADASTRO NOVO USUARIO
    
    public void confirmarCadastro(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
    
    //GERAL
    
    public void sair(){
        throw new RuntimeException("Não é possivel usar esse metodo neste estado.");
    }
}
