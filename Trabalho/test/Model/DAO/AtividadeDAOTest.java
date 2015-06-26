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
     * Teste do método getInstancia, da classe AtividadeDAO.
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
    
    /**
     *Teste do retorno da lista de atividades
     */
    @Test
    public void testarListar(){
        AtividadeDAO atividadeDao = AtividadeDAO.getInstancia();
        
        if(atividadeDao.listar() == null){
            fail("Deu ruim na listagem");
        }
        else assertEquals(true,true);
    }
    
    /**
     * Teste da inserção na lista. É um teste que cria uma atividade fictícia, 
     * Utilizando uma turma já cadastrada(Requisito fundamental) para realizar a inserção.
     * A idéia é, como um novo elemento é sempre adicionado por default na última posição da lista,
     * comparar o elemento que eu criei com o último elemento da lista. Se os id's forem iguais, a inserção
     * foi um sucesso. Esta estratégia é utilizada em TODAS as demais classes de teste
     */
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
    
    /*
    Teste da busca em lista. Passo um parâmetro null e o resultado também deve ser null
    Na prática, a busca é testada no teste de inserção
    */
    
    @Test
    public void testarBusca(){
        AtividadeDAO atividadeDao = AtividadeDAO.getInstancia();
        
        assertEquals(null,atividadeDao.buscar(null));
    }
    
    /*
    *Teste da buscaParaTodos (leitura geral). Segue o mesmo princípio da classe 
    *de testes para aluno
    */
    
    @Test
    public void testarBuscarTodos() throws IOException{
        AtividadeDAO atividadeDao = AtividadeDAO.getInstancia();
        
        if((atividadeDao.listar().isEmpty())){
            assertEquals(true,atividadeDao.buscarTodos(null));
        }
        
        else if(atividadeDao.listar().size() > 0){
            assertEquals(false , atividadeDao.buscarTodos(null));
        }
    }
}
