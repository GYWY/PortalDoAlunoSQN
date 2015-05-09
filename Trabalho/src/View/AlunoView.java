package View;

import Model.DAO.AlunoDAO;
import Model.POJO.AlunoPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlunoView {
    
    private static Scanner leitor = new Scanner(System.in);
    private ArrayList<AlunoPOJO> lista = new ArrayList<>();
    private AlunoPOJO aluno;
    private AlunoDAO alunoDao;
    
    void cadastrar(){
        System.out.println("\n **************** CADASTRO ***************");
        System.out.println("\n ALUNO: ");
        String nome = leitor.nextLine();
        System.out.println("\n CPF: ");
        String cpf = leitor.nextLine();
        aluno= new AlunoPOJO(nome, cpf);
        this.alunoDao.inserir(nome);
    }
    
    public void listarAluno(){
        for (Iterator<Object> it = this.alunoDao.listar(lista).iterator(); it.hasNext();) {
            Object aluno = it.next();
            System.out.println(aluno);
        }             
    }
    
    public void buscarAluno(){
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("\n ENTRE COM O NOME OU MATRICULA: ");
        Object pesquisa = leitor.nextLine();
        if(alunoDao.buscar(pesquisa) == null){
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        else{
            aluno=(AlunoPOJO) alunoDao.buscar(pesquisa);
            System.out.println(aluno);
        }
    }
    
}
