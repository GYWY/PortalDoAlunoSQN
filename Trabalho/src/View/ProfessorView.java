
package View;

import Model.DAO.ProfessorDAO;
import Model.POJO.ProfessorPOJO;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorView{
    ProfessorDAO professorDao = new ProfessorDAO();
    
    private void lerDados(ProfessorPOJO professor){
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o nome do professor:    ");
        professor.setNome(leitor.nextLine());
        
        System.out.println("Digite o C.P.F. do professor:    ");
        professor.setCpf(leitor.nextLine());
        
        System.out.println("Digite o departamento o qual o professor pertence::    ");
        professor.setDepartamento(leitor.nextLine());
    }
    
    public void cadastrar(){
        Scanner leitor = new Scanner(System.in);
        ProfessorPOJO professor = new ProfessorPOJO();
        
        this.lerDados(professor);
        this.professorDao.inserir(professor);
    }
    
    private void imprimirBusca(ProfessorPOJO professor){
        if(professor == null){
            System.out.println("Professor não encontrado!!");
        }
        else{
            System.out.println(professor);
        }
    }
    
    public void buscar(){
        Scanner leitor = new Scanner(System.in);
        ProfessorPOJO professor;
        
        System.out.println("Digite o nome do professor procurado:   ");
        professor = (ProfessorPOJO) this.professorDao.buscar(leitor.nextLine());
        this.imprimirBusca(professor);
    }
    
    public void listarProfessores() {
        for (Object professor : this.professorDao.listar()) {
            System.out.println(professor);
        }
    }
}