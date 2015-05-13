package View;

import Model.DAO.AlunoDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Aluno;
import Model.POJO.Falta;
import Model.POJO.Turma;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlunoView {
    
    public void cadastrarAluno(){
        Scanner leitor = new Scanner(System.in);
        GenericoDAO aluno = AlunoDAO.getInstancia();
        Aluno novoAluno = new Aluno();
        
        System.out.println("\n **************** CADASTRO ALUNO ***************");
        System.out.println("\n NOME DO ALUNO: ");
        novoAluno.setNome(leitor.nextLine());
        System.out.println("\n CPF: ");
        novoAluno.setCpf(leitor.nextLine());
        aluno.inserir(novoAluno);
    }
    
    public void cadastrarFalta() {
        Scanner leitor = new Scanner(System.in);
        Falta falta = new Falta();
        Aluno novoAluno = new Aluno();
        GenericoDAO aluno = AlunoDAO.getInstancia();
        GenericoDAO turma = TurmaDAO.getInstancia();
        
        System.out.println("\n **************** CADASTRO DE FALTAS ***************");
        System.out.println("NOME DO ALUNO: ");
        novoAluno = (Aluno) aluno.buscar(leitor.nextLine());
        System.out.println("TURMA: ");
        falta.setTurma((Turma) turma.buscar(Integer.parseInt(leitor.nextLine())));
        System.out.println("NÚMERO DE FALTAS: ");
        falta.setFaltas(leitor.nextInt());
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
        
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("ENTRE COM O NOME OU MATRICULA: ");
        Object pesquisa = leitor.nextLine();
        if(aluno.buscar(pesquisa) == null){
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        else if(novoAluno == (Aluno) aluno.buscar(pesquisa)) {
            System.out.println(novoAluno);
        }
    }
    
}
