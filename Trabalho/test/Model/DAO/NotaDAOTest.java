/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Atividade;
import Model.POJO.Nota;
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
public class NotaDAOTest {
    
    public NotaDAOTest() {
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
     *Teste da busca pro caso nulo
     */
    
    @Test
    public void testarBusca(){  
        NotaDAO notaDao = NotaDAO.getInstancia();   
        assertEquals(null,notaDao.buscar(null));
    }
    
    /**
     *Teste da listagem de todas as nostas do aluno
     */
    
    @Test
    public void testarListar(){
        NotaDAO notaDao = NotaDAO.getInstancia();
        
        if(notaDao.listar() == null){
            fail("Deu ruim na listagem");
        }
        else assertEquals(true,true);
    }
    
    /**
     *Teste de inserção de uma nova nota. O teste é feito seguindo os testes de
     * inserção anteriores. Desta vez os requisitos são um aluno e uma atividade pré
     * cadastradas
     */
    
    @Test
    public void testarInsercao(){
        NotaDAO notaDao = NotaDAO.getInstancia();
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        AtividadeDAO atividadeDao = AtividadeDAO.getInstancia();
        
        Nota nota = new Nota();
        
        nota.setNota(-1.0);
        nota.setId(notaDao.listar().size() + 1);
        nota.setAtividade((Atividade) atividadeDao.listar().get(0));
        nota.setAluno((Aluno) alunoDao.listar().get(0));
        notaDao.inserir(nota);
        
        Nota notaTeste = (Nota) notaDao.buscar("Teste");
        assertEquals(notaTeste.getId(), nota.getId());
    }
    
    /*
    *Teste do método de instanciação getInstância
    */
    
    public void testarGetInstancia(){
        NotaDAO notaDao = NotaDAO.getInstancia();
        
        if(notaDao == null){
            fail("Deu ruim na instanciação");
        }
        else{
            assertTrue(true);
        }
    }
    
    /**
     *Teste do carregamento das notas
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    
    @Test
    public void testarBuscarTodos() throws IOException, FileNotFoundException, ClassNotFoundException{
        NotaDAO notaDao = NotaDAO.getInstancia();
        
        if((notaDao.listar() == null) || (notaDao.listar().isEmpty())){
            assertEquals(true,notaDao.buscarTodos(null));
        }
        
        else if(notaDao.listar().size() > 0){
            assertEquals(false , notaDao.buscarTodos(null));
        }
    }
}