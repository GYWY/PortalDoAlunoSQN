package View.Cadastro;

import Model.DAO.DisciplinaDAOImpl;
import Model.POJO.AlunoPOJO;
import Model.POJO.DisciplinaPOJO;
import java.util.Scanner;


public class CadastroDisciplina {
    
    public void coletarDados(DisciplinaPOJO disciplina,Scanner leitor){
        System.out.println("Digite o nome da disciplina:   ");
        disciplina.setNome(leitor.nextLine());
        
        System.out.println("Digite a ementa da disciplina:   ");
        disciplina.setEmenta(leitor.nextLine());
        
        System.out.println("Digite a carga horária da matéria:  ");
        disciplina.setCargaHoraria(leitor.nextInt());
        
        System.out.println("Digite o professor da discipina:  ");
        disciplina.setProfessor(leitor.nextLine());
        
        System.out.println("Digite a turma:  ");
        disciplina.setTurma(leitor.nextLine());
    
    }
}
