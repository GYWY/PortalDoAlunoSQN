package View;

import Model.DAO.AlunoDAO;
import Model.POJO.AlunoPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlunoView {
    
    private ArrayList<AlunoPOJO> lista = new ArrayList<>();
    private AlunoDAO alunoDao = new AlunoDAO();
    private AlunoPOJO novoAluno;
    
    void cadastrar(){
        Scanner leitor = new Scanner(System.in);
        novoAluno = new AlunoPOJO();
        System.out.println("\n **************** CADASTRO ALUNO ***************");
        System.out.println("\n NOME DO ALUNO: ");
        novoAluno.setNome(leitor.nextLine());
        System.out.println("\n CPF: ");
        novoAluno.setCpf(leitor.nextLine());
        alunoDao.inserir(novoAluno);
    }
    
    public void listarAluno(){
        System.out.println("\n **************** ALUNOS ****************");
        for (Iterator<Object> it = this.alunoDao.listar(lista).iterator(); it.hasNext();) {
            Object aluno = it.next();
            System.out.println(aluno);
        }             
    }
    
    public void buscarAluno(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("\n ENTRE COM O NOME OU MATRICULA: ");
        Object pesquisa = leitor.nextLine();
        if(alunoDao.buscar(pesquisa) == null){
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        else if(novoAluno == (AlunoPOJO) alunoDao.buscar(pesquisa)) {
            System.out.println(novoAluno);
        }
    }
 
    public static void main(String[] args) {
        AlunoView asd = new AlunoView();
        asd.cadastrar();
    }
    
}
