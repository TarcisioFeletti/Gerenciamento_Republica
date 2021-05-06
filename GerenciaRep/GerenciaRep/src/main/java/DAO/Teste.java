/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import model.Morador;
import model.Pessoa;
import model.Representante;
import model.Republica;

import model.SemTeto;

/**
 *
 * @author tarci
 */
public class Teste {
    public static void main(String[] args){
        RepublicaDAO repDAO = new RepublicaDAO();
        PessoaDAO teste = new PessoaDAO();
        SemTeto semTeto = new SemTeto("Tarcísio Feletti", "tarcisio", "28999340833", "16967503774", "@FelettiT", "28999156489", "28999193884", "tarcisio.feletti", "tarcisio123");
        Pessoa morador;
        Pessoa repre;
        try {
            teste.create(semTeto);
            semTeto.setApelido("apelido2");
            teste.update(semTeto, semTeto.getNome());
            LocalDate dataCriacao = LocalDate.now();
            Republica republica = new Republica("republica", "alegre", dataCriacao, null, "guararema", "Biruta",null, "barato","qlq codigo de etica", 122, 210.5, 3, 1, 2, 29500000,0);
//            repDAO.create(republica);
            teste.promocaoDe(semTeto, republica.getNomeRepublica());
            morador = teste.read("Tarcísio Feletti");
            Morador mor = (Morador) morador;
            teste.promocaoDe(mor, dataCriacao);
            repre = teste.read("Tarcísio Feletti");
            Representante representante = (Representante) repre;
            teste.depromocaoDe(representante, republica.getNomeRepublica());
            teste.depromocaoDe(mor);
            teste.promocaoDe(semTeto, republica.getNomeRepublica(), dataCriacao);
            teste.depromocaoDe(representante);
            teste.delete("Tarcísio Feletti");
            repDAO.delete("republica");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
