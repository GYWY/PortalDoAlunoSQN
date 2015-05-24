
package View;

import Model.DAO.AlunoDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Aluno;
import Model.POJO.Falta;
import Model.POJO.Turma;
import java.util.Scanner;


public class FaltaView {
    
    public void cadastrarFalta() {
        Scanner leitor = new Scanner(System.in);
        Falta falta = new Falta();
        GenericoDAO aluno = AlunoDAO.getInstancia();
        GenericoDAO turma = TurmaDAO.getInstancia();
        
        System.out.println("\n\t CADASTRO DE FALTAS ");
        System.out.println("\n ID DA TURMA: ");
        Turma turmaFalta = (Turma) turma.buscar(Integer.parseInt(leitor.nextLine()));     
        if(turmaFalta == null) {
            System.out.println("\n TURMA NÃO CADASTRADA");
            cadastrarFalta();
        }
        falta.setTurma(turmaFalta);
        
        System.out.println("\n NOME DO ALUNO: ");
        Aluno novoAluno = (Aluno) aluno.buscar(leitor.nextLine());
        if(novoAluno == null) {
            System.out.println("\n ALUNO NÃO CADASTRADO");
            cadastrarFalta();
        }
        falta.setAluno(novoAluno);
        
        System.out.println("\n NÚMERO DE FALTAS: ");
        falta.setFaltas(Integer.parseInt(leitor.nextLine()));
        novoAluno.getListaFaltas().add(falta);
        turmaFalta.getListaDeFalta().add(falta);

    }
    
}
