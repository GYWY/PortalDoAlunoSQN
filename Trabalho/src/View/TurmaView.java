package View;

import Model.DAO.TurmaDAO;
import Model.POJO.TurmaPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TurmaView {
    
    private ArrayList<TurmaPOJO> lista = new ArrayList<>();
    private TurmaDAO turmaDao = new TurmaDAO();
    private TurmaPOJO novaTurma;
    
    void cadastrar(){
        Scanner leitor = new Scanner(System.in);
        novaTurma = new TurmaPOJO();
        System.out.println("\n **************** CADASTRO ALUNO ***************");
        System.out.println("\n ANO: ");
        novaTurma.setAno(leitor.nextLong());
        System.out.println("\n PERíODO: ");
        novaTurma.setPeriodo(leitor.nextInt());
        System.out.println("\n LOCAL: ");
        novaTurma.setLocal(leitor.nextLine());
        System.out.println("\n HORÁRIO: ");
        novaTurma.setHorario(leitor.nextLine());
        System.out.println("\n VAGA: ");
        novaTurma.setVaga(leitor.nextInt());
        turmaDao.inserir(novaTurma);
    }
    
    public void listarAluno(){
        System.out.println("\n **************** ALUNOS ****************");
        for (Iterator<Object> it = this.turmaDao.listar().iterator(); it.hasNext();) {
            Object turma = it.next();
            System.out.println(turma);
        }             
    }
    
    public void buscarAluno(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("\n ENTRE COM O NOME OU MATRICULA: ");
        Object pesquisa = leitor.nextLine();
        if(turmaDao.buscar(pesquisa) == null){
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        else if(novaTurma == (TurmaPOJO) turmaDao.buscar(pesquisa)) {
            System.out.println(novaTurma);
        }
    }
    
}
