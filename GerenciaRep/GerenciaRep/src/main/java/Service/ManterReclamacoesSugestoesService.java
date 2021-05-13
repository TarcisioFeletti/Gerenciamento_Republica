/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Pessoa;
import Model.ReclamacaoSugestao;
import java.util.List;

/**
 *
 * @author Lucas Carvalho
 */
public class ManterReclamacoesSugestoesService {

    public List<ReclamacaoSugestao> getAllReclamacoesSugestoes(Pessoa usuario) /*throws SQLException*/ {
        /*try {
            Republica republica = new RepublicaDAO().getRepublicaPorIdUsuario(usuario.getIdPessoa());
            return new ReclamacaoSugestaoDAO().getAllRepublicaId(republica.getIdRepublica());
        } catch (SQLException e) {
            throw e;
        }*/return null;
    }

    public List<ReclamacaoSugestao> getReclamacoesSugestoesPorPessoa(String pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ReclamacaoSugestao> getReclamacoesSugestoesPorDescricao(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
