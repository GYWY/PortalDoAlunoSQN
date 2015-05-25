/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


import Model.POJO.Professor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author linhares
 */
public class ProfessorDAOTest {
    
    public ProfessorDAOTest() {
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

    /**
     * Teste da busca dos professores
     */
    
    @Test
    public void testarBusca(){  
        
        ProfessorDAO professorDao = ProfessorDAO.getInstancia();
        
        assertEquals(null,professorDao.buscar(null));
    }
    
    /*Teste de inserção. Com a comparação final sendo realizada através dos nomes
    *
    */
    
    @Test
    public void testarInsercao(){
        ProfessorDAO professorDao = ProfessorDAO.getInstancia();
        Professor professor = new Professor();
        
        professor.setNome("Teste");
        professorDao.inserir(professor);
        Professor professorTeste = (Professor) professorDao.buscar("Teste");
        assertEquals(professorTeste.getNome(), professor.getNome());
    }
    
    /*
    *Teste do método listar para exibição dos professores
    */
    
    @Test
    public void testarListar(){
        ProfessorDAO professorDao = ProfessorDAO.getInstancia();
        
        if(professorDao.listar() == null){
            fail("Deu ruim na listagem");
        }
        else assertEquals(true,true);
    }
    
    /*
    *TEste do método estático de instanciação
    */
    
    public void testarGetInstancia(){
        ProfessorDAO professorDao = ProfessorDAO.getInstancia();
        
        if(professorDao == null){
            fail("Deu ruim na instanciação do professor");
        }
        else{
            assertTrue(true);
        }
    }
    
    /*
    *Teste do carregamento dos dados dos professores
    */
    
    @Test
    public void testarBuscarTodos() throws IOException, FileNotFoundException, ClassNotFoundException{
        ProfessorDAO professorDao = ProfessorDAO.getInstancia();
        
        if((professorDao.listar() == null) || (professorDao.listar().isEmpty())){
            assertEquals(true,professorDao.buscarTodos(null));
        }
        
        else if(professorDao.listar().size() > 0){
            assertEquals(false , professorDao.buscarTodos(null));
        }
    }
}