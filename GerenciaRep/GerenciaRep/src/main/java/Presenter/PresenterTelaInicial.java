/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import view.TelaInicial;
import Presenter.PresenterP0101;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Davidson
 */
public class PresenterTelaInicial {
    
    private static TelaInicial tela = new TelaInicial();

    public static TelaInicial getTela() {
        return tela;
    }

    public static void main(String[] args) {
        tela.setVisible(true);

        //CRIAR REPUBLICA - P0101
        tela.getCriarRepublica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                PresenterP0101 presenterP0101 = new PresenterP0101();
                presenterP0101.criarRepublica();
            }
        });
        
        //MANTER REPUBLICA - P0102
        tela.getManterRepublica().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                PresenterP0102 presenterP0102 = new PresenterP0102();
                presenterP0102.manterRepublica(); //funcao do botão de editar republica
            }
        });

        /*
        // UC 1
        JOptionPane.showMessageDialog(null, "República cadastrada com sucesso!");
        JOptionPane.showMessageDialog(null, "República editada com sucesso!");
        JOptionPane.showConfirmDialog(null, "Deseja excluir a república?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "República excluída com sucesso!");
        
        
        // UC 2 
        JOptionPane.showConfirmDialog(null, "Deseja remover o morador da república?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
        
        // UC 3
        JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
        JOptionPane.showMessageDialog(null, "Tarefa não encontrada!");
        JOptionPane.showConfirmDialog(null, "Deseja excluir a tarefa?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "Tarefa excluída com sucesso!");
        
        
        // UC 4  
        JOptionPane.showMessageDialog(null, "Receita / Despesa cadastrada com sucesso!");
        JOptionPane.showMessageDialog(null, "Receita / Despesa alterada com sucesso!");
        JOptionPane.showMessageDialog(null, "Receita / Despesa não encontrada!");
        JOptionPane.showMessageDialog(null, "Receita / Despesa com registro de pagamento!");
        

        // UC 5
        JOptionPane.showConfirmDialog(null, "Deseja mesmo convidar este usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "Convite enviado!");
        JOptionPane.showConfirmDialog(null, "Deseja mesmo confirmar a solicitação?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "Solicitação confirmada!");
        JOptionPane.showConfirmDialog(null, "Deseja mesmo recusar a solicitação?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "Solicitação recusada!");
        
        // UC 6
        JOptionPane.showMessageDialog(null, "Reclamação / sugestão resolvida!");
        JOptionPane.showConfirmDialog(null, "Deseja mesmo confirmar a solução?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "Solução confirmada!");
        JOptionPane.showMessageDialog(null, "A Reclamação / Sugestão já está resolvida!");
        JOptionPane.showMessageDialog(null, "A Solução já está confirmada!");
        
        // UC 7
        JOptionPane.showConfirmDialog(null, "Deseja mesmo editar seus dados?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir seu perfil?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "Perfil do Morador editado com sucesso!");
        JOptionPane.showMessageDialog(null, "Perfil do Morador excluído com sucesso!");

        // UC 8
        JOptionPane.showMessageDialog(null, "Reclamação / sugestão cadastrada com sucesso!");
        JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir a reclamação/sugestão?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "Reclamação / sugestão excluída com sucesso!");
        JOptionPane.showMessageDialog(null, "Reclamação / sugestão não encontrada!");
        JOptionPane.showMessageDialog(null, "Reclamação / sugestão editada com sucesso!");
        
        // UC 9
        JOptionPane.showConfirmDialog(null, "Deseja mesmo registrar o pagamento?", "Atenção", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "Receita ou despesa paga!");
        JOptionPane.showMessageDialog(null, "Não há pagamentos referente ao usuário!");

        // UC 10
        JOptionPane.showMessageDialog(null, "Não há receitas e despesas cadastradas!");

        // UC 11
        JOptionPane.showMessageDialog(null, "Não há receitas e despesas cadastradas!");

        // UC 12
        JOptionPane.showConfirmDialog(null, "Deseja mesmo marcar a tarefa como resolvida?", "Atenção", JOptionPane.YES_NO_OPTION);      
        JOptionPane.showMessageDialog(null, "Tarefa Concluída!");

        // UC 13
        JOptionPane.showMessageDialog(null, "Não foram encontradas repúblicas com vagas disponíveis.");

        // UC 14
        JOptionPane.showConfirmDialog(null, "Deseja enviar a solicitação?", "Atenção", JOptionPane.YES_NO_OPTION);      
        JOptionPane.showMessageDialog(null, "Solicitação enviada!");
        
        // UC 15
        JOptionPane.showConfirmDialog(null, "Deseja realizar o estorno?", "Atenção", JOptionPane.YES_NO_OPTION);      
        JOptionPane.showMessageDialog(null, "Estorno realizado com sucesso!");
        
        // UC 16
        
        // UC 17
        JOptionPane.showConfirmDialog(null, "Deseja mesmo aceitar o convite?", "Atenção", JOptionPane.YES_NO_OPTION);      
        JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o convite?", "Atenção", JOptionPane.YES_NO_OPTION);      
        JOptionPane.showMessageDialog(null, "Convite aceito!");
        JOptionPane.showMessageDialog(null, "Convite excluido!");
        
        // UC 18
        JOptionPane.showMessageDialog(null, "Não há receitas e despesas cadastradas!");
         */
    }

}
