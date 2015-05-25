/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


import Model.POJO.Aluno;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class AlunoDAOTest {
    
    public AlunoDAOTest() {
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
     * Test of getInstancia method, of class AlunoDAO.
     */
    
    @Test
    public void testarBusca(){  
        
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        
        assertEquals(null,alunoDao.buscar(null));
    }
    
    @Test
    public void testarListar(){
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        
        if(alunoDao.listar() == null){
            fail("Deu ruim na listagem");
        }
        else assertEquals(true,true);
    }
    
    @Test
    public void testarInsercao(){
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        Aluno aluno = new Aluno();
        
        aluno.setNome("Teste");
        alunoDao.inserir(aluno);
        Aluno alunoTeste = (Aluno) alunoDao.buscar("Teste");
        assertEquals(alunoTeste.getNome(), aluno.getNome());
    }
    
    public void testarGetInstancia(){
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        
        if(alunoDao == null){
            assertEquals(true,false);
        }
        else{
            assertEquals(true,true);
        }
    }
    
    @Test
    public void testarBuscarTodos() throws IOException, FileNotFoundException, ClassNotFoundException{
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        
        if((alunoDao.listar() == null) || (alunoDao.listar().isEmpty())){
            assertEquals(true,alunoDao.buscarTodos(null));
        }
        
        else if(alunoDao.listar().size() > 0){
            assertEquals(false , alunoDao.buscarTodos(null));
        }
    }
}