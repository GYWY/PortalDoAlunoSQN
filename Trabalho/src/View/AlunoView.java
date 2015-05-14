package View;

import Model.DAO.AlunoDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Aluno;
import Model.POJO.Falta;
import Model.POJO.Turma;
import java.util.Iterator;
import java.util.Scanner;

public class AlunoView {
    
    public void cadastrarAluno(){
        Scanner leitor = new Scanner(System.in);
        GenericoDAO aluno = AlunoDAO.getInstancia();
        Aluno novoAluno = new Aluno();
        
        System.out.println("\n\t CADASTRO ALUNO ");
        System.out.println("\n NOME DO ALUNO: ");
        novoAluno.setNome(leitor.nextLine());
        System.out.println("\n CPF: ");
        novoAluno.setCpf(leitor.nextLine());
        aluno.inserir(novoAluno);
    }
    
    public void cadastrarFalta() {
        Scanner leitor = new Scanner(System.in);
        Falta falta = new Falta();
        GenericoDAO aluno = AlunoDAO.getInstancia();
        GenericoDAO turma = TurmaDAO.getInstancia();
        
        System.out.println("\n\t CADASTRO DE FALTAS ");
        System.out.println("\n ID DA TURMA: ");
        Turma turmaFalta = (Turma) turma.buscar(Integer.parseInt(leitor.nextLine()));     
        if(turmaFalta == null) {
            System.out.println("\n TURMA NÃO CADASTRADA");
            cadastrarFalta();
        }
        falta.setTurma(turmaFalta);
        
        System.out.println("\n NOME DO ALUNO: ");
        Aluno novoAluno = (Aluno) aluno.buscar(leitor.nextLine());
        if(novoAluno == null) {
            System.out.println("\n ALUNO NÃO CADASTRADO");
            cadastrarFalta();
        }
        falta.setAluno(novoAluno);
        
        System.out.println("\n NÚMERO DE FALTAS: ");
        falta.setFaltas(Integer.parseInt(leitor.nextLine()));
        novoAluno.setFalta(falta);

    }
    
    public void listarAluno(){
        GenericoDAO aluno = AlunoDAO.getInstancia();
        
        System.out.println("\n\t LISTA DE ALUNOS ");
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
