/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Disciplina;
import Model.POJO.Professor;
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
public class TurmaDAOTest {
    
    public TurmaDAOTest() {
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

    @Test
    public void testarGetInstancia(){
        TurmaDAO turmaDao = TurmaDAO.getInstancia();
        
        if(turmaDao == null){
            fail("Deu ruim na instanciação da turma");
        }
        else{
            assertEquals(true,true);
        }
    }
    
    @Test
    public void testarInsercao(){
        TurmaDAO turmaDao = TurmaDAO.getInstancia();
        DisciplinaDAO disciplinaDao = DisciplinaDAO.getInstancia();
        ProfessorDAO professorDao = ProfessorDAO.getInstancia();
        Turma turma = new Turma();
        
        turma.setIdTurma(turmaDao.listar().size() + 1);
        turma.setLocal("Local de testes");
        turma.setAno(Long.MIN_VALUE -1);
        turma.setPeriodo(Integer.SIZE -1);
        turma.setDisciplina((Disciplina) disciplinaDao.listar().get(0));
        turma.setProfessor((Professor) professorDao.listar().get(0));
        
        turmaDao.inserir(turma);
        Turma turmaTeste = (Turma) turmaDao.listar().get(turmaDao.listar().size() - 1);
        //último elemento adicionado
        assertEquals(turmaTeste.getIdTurma(), turma.getIdTurma());
    }
    
    @Test
    public void testarListar(){
        TurmaDAO turmaDao = TurmaDAO.getInstancia();
        
        if(turmaDao.listar() == null){
            fail("Deu ruim na listagem");
        }
        else assertEquals(true,true);
    }

    
    @Test
    public void testarBusca(){
        TurmaDAO turmaDao = TurmaDAO.getInstancia();
        
        assertEquals(null,turmaDao.buscar(null));
    }
    
    /**
     * Test of buscarTodos method, of class TurmaDAO.
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    
    @Test
    public void testarBuscarTodos() throws IOException, FileNotFoundException, ClassNotFoundException{
        TurmaDAO turmaDao = TurmaDAO.getInstancia();
        
        if((turmaDao.listar() == null) || (turmaDao.listar().isEmpty())){
            assertEquals(true,turmaDao.buscarTodos(null));
        }
        
        else if(turmaDao.listar().size() > 0){
            assertEquals(false , turmaDao.buscarTodos(null));
        }
    }
}
