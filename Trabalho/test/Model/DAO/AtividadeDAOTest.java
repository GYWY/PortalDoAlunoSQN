/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Atividade;
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
public class AtividadeDAOTest {
    
    public AtividadeDAOTest() {
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
     * Test of getInstancia method, of class AtividadeDAO.
     */
    
    @Test
    public void testarGetInstancia(){
        AtividadeDAO atividadeDao = AtividadeDAO.getInstancia();
        
        if(atividadeDao == null){
            fail("Deu ruim na instanciação da atividade");
        }
        else{
            assertEquals(true,true);
        }
    }
    
    public void testarListar(){
        AtividadeDAO atividadeDao = AtividadeDAO.getInstancia();
        
        if(atividadeDao.listar() == null){
            fail("Deu ruim na listagem");
        }
        else assertEquals(true,true);
    }
    
    @Test
    public void testarInsercao(){
        AtividadeDAO atividadeDao = AtividadeDAO.getInstancia();
        TurmaDAO turmaDao = TurmaDAO.getInstancia();
        Atividade atividade = new Atividade();
        
        
        atividade.setId((Integer) atividadeDao.listar().get(atividadeDao.listar().size()) + 1);
        atividade.setNome("Teste atividade");
        atividade.setData("Data de teste");
        atividade.setTipo("Tipo");
        atividade.setValor(-1.1);
        atividade.setTurma((Turma) turmaDao.listar().get(0));
        
        atividadeDao.inserir(atividade);
        Atividade atividadeTeste = (Atividade) atividadeDao.listar().get(atividadeDao.listar().size() - 1);
        //último elemento adicionado
        assertEquals(atividadeTeste.getNome(), atividade.getNome());
    }
    
    @Test
    public void testarBusca(){
        AtividadeDAO atividadeDao = AtividadeDAO.getInstancia();
        
        assertEquals(null,atividadeDao.buscar(null));
    }
    
    @Test
    public void testarBuscarTodos() throws IOException{
        AtividadeDAO atividadeDao = AtividadeDAO.getInstancia();
        
        if((atividadeDao.listar() == null) || (atividadeDao.listar().isEmpty())){
            assertEquals(true,atividadeDao.buscarTodos(null));
        }
        
        else if(atividadeDao.listar().size() > 0){
            assertEquals(false , atividadeDao.buscarTodos(null));
        }
    }
}
