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
        GenericoDAO aluno = AlunoDAO.getInstancia();
        
        System.out.println("\n **************** ALUNOS ****************");
        for (Iterator<Object> it = aluno.listar().iterator(); it.hasNext();) {
            Object alunoLista = it.next();
            System.out.println(alunoLista);
        }              
    }
    
    public void buscarAluno(){
        Scanner leitor = new Scanner(System.in);
        Aluno novoAluno = new Aluno();
        GenericoDAO aluno = AlunoDAO.getInstancia();
        
        System.out.println("\n\t PESQUISAR ALUNO ");
        System.out.println("\n ENTRE COM O NOME OU ID: ");
        Object pesquisa = leitor.nextLine();
        if(aluno.buscar(pesquisa) == null){
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        else if(novoAluno == (Aluno) aluno.buscar(pesquisa)) {
            System.out.println(novoAluno);
        }
    }
    
}
