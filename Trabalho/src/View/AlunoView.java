package View;

import Model.DAO.AlunoDAO;
import Model.DAO.GenericoDAO;
import Model.POJO.Aluno;
import java.util.Iterator;
import java.util.Scanner;

public class AlunoView {
    
    public void cadastrarAluno(){
        Scanner leitor = new Scanner(System.in);
        GenericoDAO aluno = AlunoDAO.getInstancia();
        Aluno novoAluno = new Aluno();
        
        System.out.println("\n\t CADASTRO ALUNO ");
        System.out.println("\n NOME DO ALUNO: ");
        String nomeAluno = leitor.nextLine().toUpperCase();
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
        System.out.println("\n\t\t ALUNOS \n");
        for (Iterator<Object> it = alunoDao.listar().iterator(); it.hasNext();) {
            Object listaAluno = it.next();
            System.out.println(listaAluno.toString());
        }
    }
    
    public void buscarAluno(){
        Aluno novaAluno = new Aluno();
        Scanner leitor = new Scanner(System.in);
        GenericoDAO aluno = AlunoDAO.getInstancia();
        System.out.println("\n\t\t PESQUISA ALUNO \n");
        System.out.println("\n ALUNO: ");
        Object pesquisa = leitor.nextLine().toUpperCase();
        novaAluno = (Aluno) aluno.buscar(pesquisa);
        if(novaAluno == null) {
            System.out.println("\n\t\t ALUNO NÃO ENCONTRADA \n");
        }
        else
            System.out.println("\n"+novaAluno);
    }
    
    public void imprimirMenuAluno() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t DISCIPLINA \n");
        System.out.println("1- CADASTRAR ALUNO");
        System.out.println("2- PESQUISAR ALUNO");
        System.out.println("3- LISTAR ALUNOS");
        System.out.println("4- SAIR \n");
        System.out.println("OPÇÃO:");
    }
    
}
