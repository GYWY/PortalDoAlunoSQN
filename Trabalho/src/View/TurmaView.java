package View;

import Model.DAO.GenericoDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Turma;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TurmaView {

    void cadastrar(){
        Scanner leitor = new Scanner(System.in);
        Turma novaTurma = new Turma();
        GenericoDAO turma = TurmaDAO.getInstancia();
        
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
        turma.inserir(novaTurma);
        System.out.println("ID da Turma: " + novaTurma.getIdTurma());
    }
    
    public void listarAluno(){
        GenericoDAO turma = TurmaDAO.getInstancia();
        
        System.out.println("\n **************** TURMAS ****************");
        for (Iterator<Object> it = turma.listar().iterator(); it.hasNext();) {
            Object turmaLista = it.next();
            System.out.println(turmaLista);
        }             
    }
    
    public void buscarAluno(){
        Turma novaTurma = new Turma();
        Scanner leitor = new Scanner(System.in);
        GenericoDAO turma = TurmaDAO.getInstancia();
        
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("ENTRE COM O NOME OU MATRICULA: ");
        Object pesquisa = leitor.nextLine();
        if(turma.buscar(pesquisa) == null){
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        else if(novaTurma == (Turma) turma.buscar(pesquisa)) {
            System.out.println(novaTurma);
        }
    }
    
}
