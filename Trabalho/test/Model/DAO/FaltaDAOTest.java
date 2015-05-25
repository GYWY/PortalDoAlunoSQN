/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Falta;
import Model.POJO.Turma;
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
public class FaltaDAOTest {
    
    public FaltaDAOTest() {
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
     * Test of getInstancia method, of class FaltaDAO.
     */
    
    
    @Test
    public void testarGetInstancia(){
        FaltaDAO faltaDao = FaltaDAO.getInstancia();
        
        if(faltaDao == null){
            fail("Deu ruim na instanciação da falta");
        }
        else{
            assertEquals(true,true);
        }
    }
    
    @Test
    public void testarInsercao(){
        FaltaDAO faltaDao = FaltaDAO.getInstancia();
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        TurmaDAO turmaDao = TurmaDAO.getInstancia();
        Falta falta = new Falta();
        
        falta.setId(faltaDao.listar().size() + 1);
        falta.setAluno((Aluno) alunoDao.listar().get(0));//pega o primeiro aluno
        falta.setTurma((Turma) turmaDao.listar().get(0));//pega a primeira turma
        faltaDao.inserir(falta);
        Falta faltaTeste = (Falta) faltaDao.listar().get(faltaDao.listar().size() - 1);
        //último elemento adicionado
        assertEquals(faltaTeste.getId(), falta.getId());
    }
    
    @Test
    public void testarListar(){
        FaltaDAO faltaDao = FaltaDAO.getInstancia();
        
        if(faltaDao.listar() == null){
            fail("Deu ruim na listagem");
        }
        else assertEquals(true,true);
    }

    
    @Test
    public void testarBusca(){
        FaltaDAO faltaDao = FaltaDAO.getInstancia();
        
        assertEquals(null,faltaDao.buscar(null));
    }
    
    /**
     * Test of buscarTodos method, of class FaltaDAO.
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    
    @Test
    public void testarBuscarTodos() throws IOException, FileNotFoundException, ClassNotFoundException{
        FaltaDAO faltaDao = FaltaDAO.getInstancia();
        
        if((faltaDao.listar() == null) || (faltaDao.listar().isEmpty())){
            assertEquals(true,faltaDao.buscarTodos(null));
        }
        
        else if(faltaDao.listar().size() > 0){
            assertEquals(false , faltaDao.buscarTodos(null));
        }
    }

}