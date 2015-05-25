/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Disciplina;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
public class DisciplinaDAOTest {
    
    public DisciplinaDAOTest() {
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
     * Test da busca, que na prática é testado logo na inserção
     */
    
    @Test
    public void testarBusca(){  
        
        DisciplinaDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        assertEquals(null,disciplinaDao.buscar(null));
    }
    
    /*
    *Teste da listagem de todas as disciplinas existentes
    */
    
    @Test
    public void testarListar(){
        DisciplinaDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        if(disciplinaDao.listar() == null){
            fail("Deu ruim na listagem");
        }
        else assertEquals(true,true);
    }
    
    /**
     *Segue o mesmo princípio do teste de inserção do AlunoDAO
     */
    @Test
    public void testarInsercao(){
        DisciplinaDAO disciplinaDao = DisciplinaDAO.getInstancia();
        Disciplina disciplina = new Disciplina();
        
        disciplina.setNome("Teste");
        disciplina.setEmenta("Ementa Teste");
        disciplina.setCargaHoraria(Integer.MIN_VALUE);
        disciplinaDao.inserir(disciplina);
        Disciplina disciplinaTeste = (Disciplina) disciplinaDao.buscar("Teste");
        assertEquals(disciplinaTeste.getNome(), disciplina.getNome());
    }
    
    /*
    *Teste para o getInstância da DisciplinaDAO
    */
    
    public void testarGetInstancia(){
        DisciplinaDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        if(disciplinaDao == null){
            fail("Deu ruim na instanciação");
        }
        else{
            assertTrue(true);
        }
    }
    
    /*
    *Teste da busca (carregamento) das Disciplinas
    */
    
    @Test
    public void testarBuscarTodos() throws IOException, FileNotFoundException, ClassNotFoundException{
        DisciplinaDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        if((disciplinaDao.listar() == null) || (disciplinaDao.listar().isEmpty())){
            assertEquals(true,disciplinaDao.buscarTodos(null));
        }
        
        else if(disciplinaDao.listar().size() > 0){
            assertEquals(false , disciplinaDao.buscarTodos(null));
        }
    }

}
