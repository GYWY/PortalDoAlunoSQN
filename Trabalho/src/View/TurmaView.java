package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.ProfessorDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Disciplina;
import Model.POJO.Professor;
import Model.POJO.Turma;
import java.util.Iterator;
import java.util.Scanner;

public class TurmaView {

    void cadastrarTurma(){
        Scanner leitor = new Scanner(System.in);
        Turma novaTurma = new Turma();
        GenericoDAO turma = TurmaDAO.getInstancia();
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        
        System.out.println("\n **************** CADASTRO TURMA ***************");
        System.out.println("LOCAL: ");
        novaTurma.setLocal(leitor.nextLine().toUpperCase());
        System.out.println("ANO: ");
        novaTurma.setAno(Long.parseLong(leitor.nextLine()));
        System.out.println("PERíODO: ");
        novaTurma.setPeriodo(Integer.parseInt(leitor.nextLine()));
        System.out.println("HORÁRIO: ");
        novaTurma.setHorario(leitor.nextLine().toUpperCase());
        System.out.println("QUANTIDADE DE VAGAS: ");
        novaTurma.setVaga(Integer.parseInt(leitor.nextLine()));
        System.out.println("DISCIPLINA: ");        
        String nomeDisciplina = leitor.nextLine().toUpperCase();
        Disciplina disciplina = (Disciplina) disciplinaDao.buscar(nomeDisciplina);
        if(disciplina==null){
            System.out.println("\n\nDISCIPLINA NÃO CADASTRADA\nNAO FOI POSSIVEL O CADASTRO DA TURMA!\n\n");
            return;
        }
        novaTurma.setDisciplina(disciplina);
        System.out.println("PROFESSOR: ");
        String nomeProfessor = leitor.nextLine().toUpperCase();
        Professor professor = (Professor) professorDao.buscar(nomeProfessor);
        if(professor==null){
            System.out.println("\n\nPROFESSOR NÃO CADASTRADO\nNÃO FOI POSSIVEL O CADASTRO DA TURMA!\n\n");
            return;
        }
        novaTurma.setProfessor(professor);
        turma.inserir(novaTurma);
        disciplina.setListaTurmas(novaTurma);
        professor.setListaTurmasMinistradas(novaTurma);
        
    }
    
    public void listarTurma(){
        
        GenericoDAO turmaDao = TurmaDAO.getInstancia();
        System.out.println("\n\t\t TURMAS \n");
        for (Iterator<Object> it = turmaDao.listar().iterator(); it.hasNext();) {
            Object listaTurma = it.next();
            System.out.println(listaTurma.toString());
        }             
    }
    
    public void buscarTurma(){
        Turma novaTurma = new Turma();
        Scanner leitor = new Scanner(System.in);
        GenericoDAO turma = TurmaDAO.getInstancia();
        
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("ENTRE COM O NOME OU MATRICULA: ");
        Object pesquisa = leitor.nextLine().toUpperCase();
        if(turma == null) {
            System.out.println("\n\t\t TURMA NÃO ENCONTRADA \n");
        }
        else
            System.out.println("\n"+turma);
    }
    
}
