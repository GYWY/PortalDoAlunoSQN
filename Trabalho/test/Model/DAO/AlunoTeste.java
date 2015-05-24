/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Aluno;
import java.io.FileNotFoundException;
import java.io.IOException;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author linhares
 */
public class AlunoTeste {
    public void testarBusca(){    
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        
        assertEquals(null,alunoDao.buscar(""));
    }
    
    public void testarInsercao(){
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        Aluno aluno = new Aluno();
        
        aluno.setNome("Teste");
        alunoDao.inserir(aluno);
        assertEquals(alunoDao.buscar(aluno),aluno);
    }
    
    public void testarBuscarTodos() throws IOException, FileNotFoundException, ClassNotFoundException{
        AlunoDAO alunoDao = AlunoDAO.getInstancia();
        
        assertEquals(alunoDao.buscarTodos(null),true);
    }
}