package View;

import Model.DAO.AlunoDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.AlunoPOJO;
import Model.POJO.FaltaPOJO;
import Model.POJO.TurmaPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlunoView {
    
    private ArrayList<AlunoPOJO> lista = new ArrayList<>();
    private AlunoPOJO novoAluno;
    
    public void cadastrarAluno(){
        Scanner leitor = new Scanner(System.in);
        novoAluno = new AlunoPOJO();
        System.out.println("\n **************** CADASTRO ALUNO ***************");
        System.out.println("\n NOME DO ALUNO: ");
        novoAluno.setNome(leitor.nextLine());
        System.out.println("\n CPF: ");
        novoAluno.setCpf(leitor.nextLine());
        AlunoDAO.getInstancia().inserir(novoAluno);
    }
    
    public void cadastrarFalta() {
        Scanner leitor = new Scanner(System.in);
        FaltaPOJO falta = new FaltaPOJO();
        novoAluno = new AlunoPOJO();
        System.out.println("\n **************** CADASTRO DE FALTAS ***************");
        System.out.println("NOME DO ALUNO: ");
        novoAluno = (AlunoPOJO) AlunoDAO.getInstancia().buscar(leitor.nextLine());
        System.out.println("TURMA: ");
        falta.setTurma((TurmaPOJO) TurmaDAO.getInstancia().buscar(Integer.parseInt(leitor.nextLine())));
        System.out.println("NÚMERO DE FALTAS: ");
        falta.setFaltas(leitor.nextInt());
        AlunoDAO.getInstancia().inserir(novoAluno);
    }
    
    public void listarAluno(){
        System.out.println("\n **************** ALUNOS ****************");
        for (Iterator<Object> it = AlunoDAO.getInstancia().listar().iterator(); it.hasNext();) {
            Object aluno = it.next();
            System.out.println(aluno);
        }             
    }
    
    public void buscarAluno(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("ENTRE COM O NOME OU MATRICULA: ");
        Object pesquisa = leitor.nextLine();
        if(AlunoDAO.getInstancia().buscar(pesquisa) == null){
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        else if(novoAluno == (AlunoPOJO) AlunoDAO.getInstancia().buscar(pesquisa)) {
            System.out.println(novoAluno);
        }
    }
    
}
