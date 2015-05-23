package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.ProfessorDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Disciplina;
import Model.POJO.Professor;
import Model.POJO.Turma;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DisciplinaView {
    
    private void certificarQueOProfessorExiste(String nomeDoProfessor){
        GenericoDAO disciplina = DisciplinaDAO.getInstancia();
        GenericoDAO professor = ProfessorDAO.getInstancia();
        
        Scanner leitor = new Scanner(System.in);
        while(professor.buscar(nomeDoProfessor) == null){
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
        Disciplina novaDisciplina = new Disciplina();
        GenericoDAO disciplina = DisciplinaDAO.getInstancia();
        
        System.out.println("\n **************** CADASTRO DISCIPLINA ***************");
        System.out.println("\n DISCIPLINA: ");
        String nomeDisciplina = leitor.nextLine();
        if(!(disciplina.buscar(nomeDisciplina) == null)){
            System.out.println("\nDISCIPLINA JÁ FOI CADASTRADA\n\n");
            return;
        }
        novaDisciplina.setNome(nomeDisciplina);
        System.out.println("\n EMENTA: ");
        novaDisciplina.setEmenta(leitor.nextLine());
        System.out.println("\n CARGA HORÁRIA: ");
        novaDisciplina.setCargaHoraria(Integer.parseInt(leitor.nextLine()));
        disciplina.inserir(novaDisciplina);
    }
    
    public void buscarDisciplina() {
        Disciplina novaDisciplina = new Disciplina();
        Scanner leitor = new Scanner(System.in);
        GenericoDAO disciplina = DisciplinaDAO.getInstancia();
        
        System.out.println("\n **************** PESQUISA DISCIPLINA ****************");
        System.out.println("\n ENTRE COM O NOME DA DISCIPLINA: ");
        Object pesquisa = leitor.nextLine();
        if(disciplina.buscar(pesquisa) == null) {
            System.out.println("DISCIPLINA NÃO ENCONTRADA");
        }
        else if(novaDisciplina == (Disciplina) disciplina.buscar(pesquisa)){
            System.out.println(novaDisciplina);
        }
    }
    
    public void listarDisciplina() {
        GenericoDAO disciplina = DisciplinaDAO.getInstancia();
        
        System.out.println("\n **************** DISCIPLINAS **************** ");
        for (Iterator<Object> it = disciplina.listar().iterator(); it.hasNext();) {
            Object disciplinaLista = it.next();
            disciplinaLista.toString();
        }
    }

    public void listarTurmas() {
        Scanner leitor = new Scanner(System.in);
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        System.out.println("DISCIPLINA: ");
        String nomeDisciplina = leitor.nextLine();
        Disciplina disciplina = (Disciplina) disciplinaDao.buscar(nomeDisciplina);
        ArrayList<Turma> listaTurma = disciplina.getListaTurmas();
        for(Turma turma : listaTurma){
            turma.toString();
        }
            
            
    }

    void listarHistoricoTurmas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}