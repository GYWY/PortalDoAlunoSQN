package View;

import Model.DAO.AlunoDAO;
import Model.DAO.GenericoDAO;
import Model.POJO.Aluno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlunoView {
    
    public void cadastrarAluno(){
        Scanner leitor = new Scanner(System.in);
        GenericoDAO aluno = AlunoDAO.getInstancia();
        Aluno novoAluno = new Aluno();
        
        System.out.println("\n\t CADASTRO ALUNO ");
        System.out.println("\n NOME DO ALUNO: ");
        String nomeAluno = leitor.nextLine();
        if(!(aluno.buscar(nomeAluno)== null)){
            System.out.println("\nALUNO JÁ CADASTRADO\n\n");
            return;
        }
        novoAluno.setNome(nomeAluno);
        System.out.println("\n CPF: ");
        novoAluno.setCpf(leitor.nextLine());
        aluno.inserir(novoAluno);
    }
    
    public void listarAluno(){
        
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        System.out.println("\n\t\t DISCIPLINAS \n");
        for (Iterator<Object> it = alunoDao.listar().iterator(); it.hasNext();) {
            Object listaAluno = it.next();
            System.out.println(listaAluno.toString());
        }
    }
    
    public void buscarAluno(){
        Aluno novaAluno = new Aluno();
        Scanner leitor = new Scanner(System.in);
        GenericoDAO aluno = AlunoDAO.getInstancia();
        System.out.println("\n\t\t PESQUISA DISCIPLINA \n");
        System.out.println("\n DISCIPLINA: ");
        Object pesquisa = leitor.nextLine().toUpperCase();
        novaAluno = (Aluno) aluno.buscar(pesquisa);
        if(novaAluno == null) {
            System.out.println("\n\t\t DISCIPLINA NÃO ENCONTRADA \n");
        }
        else
            System.out.println("\n"+novaAluno);
    }
    
}
