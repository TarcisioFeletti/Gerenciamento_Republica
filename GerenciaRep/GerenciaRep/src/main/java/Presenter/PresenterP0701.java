/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Pessoa;
import view.ManterPerfil.P0701;

/**
 *
 * @author gabri
 */
public class PresenterP0701 {
    
    private P0701 viewModificarPerfil;
    private Pessoa pessoa;

    public PresenterP0701() {
        viewModificarPerfil = new P0701();
    }
    
    private void preencherCampos(Pessoa pessoa) {
        this.viewModificarPerfil.getNome().setText(pessoa.getNome());
        this.viewModificarPerfil.getApelido().setText(pessoa.getApelido());
        this.viewModificarPerfil.getTelefone().setText(pessoa.getTelefone());
        //this.viewModificarPerfil.getCpf().setText(pessoa.getCpf());
        this.viewModificarPerfil.getLinkRedeSocial().setText(pessoa.getRedesSociais());
        this.viewModificarPerfil.getTelefoneResponsavel1().setText(pessoa.getContato1());
        this.viewModificarPerfil.getTelefoneResponsavel2().setText(pessoa.getContat2());
        
    }
    
    public void modificarPerfil() {
        P0000 Desktop = PresenterP0000.getTela();
        Desktop.add(viewModificarPerfil);
        viewModificarPerfil.setVisible(true);
        viewModificarPerfil.getExcluirPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE EXCLUIR PERFIL
                excluirPerfil();
            }
        });
        viewModificarPerfil.getHistoricoPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE VISUALIZAR HISTORICO DE REPUBLICAS DO PERFIL
                historicoPerfil();
            }
        });
        viewModificarPerfil.getEditarPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOTÃO DE EDITAR PERFIL
                editarPerfil();
            }
        });
        
    }
    
    
    private void editarPerfil() {
        if (this.viewModificarPerfil.getNome().getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "O campo nome não pode ficar vazio.");
            return;
        }
        //edição da republica com os campos//
        this.pessoa.setNome(this.viewModificarPerfil.getNome().getText());
        this.pessoa.setApelido(this.viewModificarPerfil.getApelido().getText());
        this.pessoa.setTelefone(this.viewModificarPerfil.getTelefone().getText());
        this.pessoa.setRedesSociais(this.viewModificarPerfil.getLinkRedeSocial().getText());
        this.pessoa.setContato1(this.viewModificarPerfil.getTelefoneResponsavel1().getText());
        this.pessoa.setContat2(this.viewModificarPerfil.getTelefoneResponsavel2().getText());
        //chamar a Presenter<->Service<->DAO pra salvar//
        try {
            this.serviceP0701.editarPerfil(this.pessoa);
            JOptionPane.showMessageDialog(null, "SUCESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    }
    
    
    private void historicoPerfil() {
        
    }
    
    
    private void excluirPerfil() {
        
    }
}
