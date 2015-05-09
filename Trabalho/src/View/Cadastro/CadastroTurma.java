
package View.Cadastro;

import Model.DAO.DisciplinaDAOImpl;
import Model.DAO.GenericDAO;
import Model.DAO.ProfessorDAOImpl;
import Model.DAO.TurmaDAOImpl;
import Model.POJO.DisciplinaPOJO;
import Model.POJO.ProfessorPOJO;
import Model.POJO.TurmaPOJO;
import java.util.Scanner;

public class CadastroTurma {
    
    public void coletarDados(TurmaPOJO turma,Scanner leitor){
        
        System.out.println("Digite o NUMERO da turma: ");
        turma.setIdTurma(leitor.nextInt());
        System.out.println("Digite o ANO da turma: ");
        turma.setAno(leitor.nextLong());
        System.out.println("Digite o PERIODO da turma: ");
        turma.setPeriodo(leitor.nextInt());
        System.out.println("Digite o LOCAL da turma: ");
        turma.setLocal(leitor.nextLine());
        System.out.println("Digite o HORARIO da turma: ");
        turma.setHorario(leitor.next());
        System.out.println("Digite a QUANTIDADE DE VAGAS da turma: ");
        turma.setVaga(leitor.nextInt());
        System.out.println("Digite a DISCIPLINA da turma: ");
        turma.setDisciplina( (DisciplinaPOJO) DisciplinaDAOImpl.getInstancia().buscarPorId(leitor.nextLine()));
        System.out.println("Digite o PROFESSORES: ");
        
    }   
    
    public void cadastrarAluno(){
        TurmaPOJO turma = new TurmaPOJO();
        Scanner leitor = new Scanner(System.in);
        TurmaDAOImpl turmaDao = new TurmaDAOImpl();
 
        
    }
    
    
    
        
}
