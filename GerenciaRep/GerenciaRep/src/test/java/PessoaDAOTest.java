/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.PessoaDAO;
import java.sql.SQLException;
import model.SemTeto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author tarci
 */
public class PessoaDAOTest {
    
    public PessoaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    /*
    @Test
    public void CT001() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        SemTeto pessoa = new SemTeto("Tarcisio Feletti", "Tarcisio", "28999340833", "16967503774", "@felettiT", 
                "28999156489", "28999193884", true, false, false, "tarcisio.feletti", "tarcisio123");
        try {
            pessoaDAO.create(pessoa);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }*/
}
