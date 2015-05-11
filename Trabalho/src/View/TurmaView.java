package View;

import Model.DAO.TurmaDAO;
import Model.POJO.TurmaPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TurmaView {
    
    private ArrayList<TurmaPOJO> lista = new ArrayList<>();
    private TurmaPOJO novaTurma;
    
    void cadastrar(){
        Scanner leitor = new Scanner(System.in);
        novaTurma = new TurmaPOJO();
        System.out.println("\n **************** CADASTRO TURMA ***************");
        System.out.println("ANO: ");
        novaTurma.setAno(Long.parseLong(leitor.nextLine()));
        System.out.println("PERíODO: ");
        novaTurma.setPeriodo(Integer.parseInt(leitor.nextLine()));
        System.out.println("LOCAL: ");
        novaTurma.setLocal(leitor.nextLine());
        System.out.println("HORÁRIO: ");
        novaTurma.setHorario(leitor.nextLine());
        System.out.println("qUANTIDADE DE VAGAS: ");
        novaTurma.setVaga(Integer.parseInt(leitor.nextLine()));
        TurmaDAO.getInstancia().inserir(novaTurma);
        System.out.println("ID da Turma: " + novaTurma.getIdTurma());
    }
    
    public void listarAluno(){
        System.out.println("\n **************** TURMAS ****************");
        for (Iterator<Object> it = TurmaDAO.getInstancia().listar().iterator(); it.hasNext();) {
            Object turma = it.next();
            System.out.println(turma);
        }             
    }
    
    public void buscarAluno(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("ENTRE COM O NOME OU MATRICULA: ");
        Object pesquisa = leitor.nextLine();
        if(TurmaDAO.getInstancia().buscar(pesquisa) == null){
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        else if(novaTurma == (TurmaPOJO) TurmaDAO.getInstancia().buscar(pesquisa)) {
            System.out.println(novaTurma);
        }
    }
    
}
