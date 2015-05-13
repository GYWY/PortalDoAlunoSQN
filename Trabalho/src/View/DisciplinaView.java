package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.ProfessorDAO;
import Model.POJO.Disciplina;
import Model.POJO.Professor;
import Model.POJO.Turma;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DisciplinaView {
    
    private ArrayList<Disciplina> lista = new ArrayList<>();
    private Disciplina novaDisciplina;
    
    private void certificarQueOProfessorExiste(String nomeDoProfessor){
        Scanner leitor = new Scanner(System.in);
        
        while(ProfessorDAO.getInstancia().buscar(nomeDoProfessor) == null){
            System.out.println("Professor não cadastrado. Digite novamente:   ");
            nomeDoProfessor = leitor.nextLine();
        }
        
    }
    
    private void cadastrarProfessorNaTurma(Turma turma){
        Scanner leitor = new Scanner(System.in);
        Professor professor = new Professor();
        
        System.out.println("Digite o nome do professor que irá ministrar a disciplina:   ");
        this.certificarQueOProfessorExiste(leitor.nextLine());
        turma.setProfessor(professor);
    }
    
    private void lerDadosDaTurma(Turma turma){
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
    
    public void cadastrarTurmaNaDisciplina(Disciplina disciplina){
        Turma turma = new Turma();
        
        this.lerDadosDaTurma(turma);
        disciplina.adicionarTurma(turma);
    }
    
    public void cadastrarDisciplina() {
        Scanner leitor = new Scanner(System.in);
        novaDisciplina = new Disciplina();
        System.out.println("\n **************** CADASTRO DISCIPLINA ***************");
        System.out.println("\n DISCIPLINA: ");
        novaDisciplina.setNome(leitor.nextLine());
        System.out.println("\n EMENTA: ");
        novaDisciplina.setEmenta(leitor.nextLine());
        System.out.println("\n CARGA HORÁRIA: ");
        novaDisciplina.setCargaHoraria(Integer.parseInt(leitor.nextLine()));
        DisciplinaDAO.getInstancia().inserir(novaDisciplina);
    }
    
    public void buscarDisciplina() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA DISCIPLINA ****************");
        System.out.println("\n ENTRE COM O NOME DA DISCIPLINA: ");
        Object pesquisa = leitor.nextLine();
        if(DisciplinaDAO.getInstancia().buscar(pesquisa) == null) {
            System.out.println("DISCIPLINA NÃO ENCONTRADA");
        }
        else if(novaDisciplina == (Disciplina) DisciplinaDAO.getInstancia().buscar(pesquisa)){
            System.out.println(novaDisciplina);
        }
    }
    
    public void listarDisciplina() {
        System.out.println("\n **************** DISCIPLINAS ****************");
        for (Iterator<Object> it = DisciplinaDAO.getInstancia().listar().iterator(); it.hasNext();) {
            Object disciplinaL = it.next();
            System.out.println(disciplinaL);
        }
    }
    
}