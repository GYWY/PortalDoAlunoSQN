package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.ProfessorDAO;
import Model.POJO.DisciplinaPOJO;
import Model.POJO.ProfessorPOJO;
import Model.POJO.TurmaPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DisciplinaView {
    
    private ArrayList<DisciplinaPOJO> lista = new ArrayList<>();
    private DisciplinaDAO disciplinaDao = new DisciplinaDAO();
    private DisciplinaPOJO novaDisciplina;
    
    private void certificarQueOProfessorExiste(String nomeDoProfessor){
        ProfessorDAO professorDAO = new ProfessorDAO();
        Scanner leitor = new Scanner(System.in);
        
        while(professorDAO.buscar(nomeDoProfessor) == null){
            System.out.println("Professor não cadastrado. Digite novamente:   ");
            nomeDoProfessor = leitor.nextLine();
        }
        
    }
    
    private void cadastrarProfessorNaTurma(TurmaPOJO turma){
        Scanner leitor = new Scanner(System.in);
        ProfessorPOJO professor = new ProfessorPOJO();
        
        System.out.println("Digite o nome do professor que irá ministrar a disciplina:   ");
        this.certificarQueOProfessorExiste(leitor.nextLine());
        turma.setProfessor(professor);
    }
    
    private void lerDadosDaTurma(TurmaPOJO turma){
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o periodo da turma:   ");
        turma.setPeriodo(leitor.nextInt());
        System.out.println("Digite o ano da turma:   ");
        turma.setAno(leitor.nextLong());
        System.out.println("Digite o local das aulas da turma:    ");
        turma.setLocal(leitor.nextLine());
        System.out.println("Digite o horario em que a disciplina sera ministrada:   ");
        turma.setHorario(leitor.nextLine());
        System.out.println("Digite a quantidade de vagas ofertadas na disciplina:   ");
        turma.setVaga(leitor.nextInt());
        this.cadastrarProfessorNaTurma(turma);
    }
    
    public void cadastrarTurmaNaDisciplina(DisciplinaPOJO disciplina){
        TurmaPOJO turma = new TurmaPOJO();
        
        this.lerDadosDaTurma(turma);
        disciplina.adicionarTurma(turma);
    }
    
    public void cadastrarDisciplina() {
        Scanner leitor = new Scanner(System.in);
        novaDisciplina = new DisciplinaPOJO();
        System.out.println("\n **************** CADASTRO DISCIPLINA ***************");
        System.out.println("\n DISCIPLINA: ");
        novaDisciplina.setNome(leitor.nextLine());
        System.out.println("\n EMENTA: ");
        novaDisciplina.setEmenta(leitor.nextLine());
        System.out.println("\n CARGA HORÁRIA: ");
        novaDisciplina.setCargaHoraria(Integer.parseInt(leitor.nextLine()));
        disciplinaDao.inserir(novaDisciplina);
    }
    
    public void buscarDisciplina() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA DISCIPLINA ****************");
        System.out.println("\n ENTRE COM O NOME DA DISCIPLINA: ");
        Object pesquisa = leitor.nextLine();
        if(disciplinaDao.buscar(pesquisa) == null) {
            System.out.println("DISCIPLINA NÃO ENCONTRADA");
        }
        else if(novaDisciplina == (DisciplinaPOJO) disciplinaDao.buscar(pesquisa)){
            System.out.println(novaDisciplina);
        }
    }
    
    public void listarDisciplina() {
        System.out.println("\n **************** DISCIPLINAS ****************");
        for (Iterator<Object> it = this.disciplinaDao.listar().iterator(); it.hasNext();) {
            Object disciplinaL = it.next();
            System.out.println(disciplinaL);
        }
    }
    
}