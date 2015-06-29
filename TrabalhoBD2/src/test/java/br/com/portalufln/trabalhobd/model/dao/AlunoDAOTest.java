package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Aluno;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AlunoDAOTest {
    
    AlunoDAO alunoDAO = new AlunoDAO();
    
    @Test
    public void salvarAluno() {
        Aluno aluno = new Aluno("Yan","12155458789");
        alunoDAO.salvar(aluno);
        assertEquals(true, aluno.equals(aluno));
    }
    
}