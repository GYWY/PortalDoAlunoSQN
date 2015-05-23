
package View;

import Model.DAO.GenericoDAO;
import Model.DAO.ProfessorDAO;
import Model.POJO.Professor;
import java.util.Scanner;

public class ProfessorView{
    private void lerDados(Professor professor){
        Scanner leitor = new Scanner(System.in);
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        System.out.println("\n **************** CADASTRO PROFESSOR ***************");
        System.out.println("NOME PROFESSOR: ");
        String nomeProfessor = leitor.nextLine();
        if(!(professorDao.buscar(nomeProfessor)== null)){
            System.out.println("\nPROFESSOR JÁ CADASTRADO\n\n");
            return;
        }
        professor.setNome(nomeProfessor);
  
        System.out.println("CPF: ");
        professor.setCpf(leitor.nextLine());
        
        System.out.println("DEPARTAMENTO: ");
        professor.setDepartamento(leitor.nextLine());
    }
    
    public void cadastrarProfessor(){
        Scanner leitor = new Scanner(System.in);
        Professor professor = new Professor();
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        
        this.lerDados(professor);
        professorDao.inserir(professor);
    }
    
    private void imprimirBusca(Professor professor){
        if(professor == null){
            System.out.println("PROFESSOR NÃO ENCONTRADO!!");
        }
        else{
            System.out.println(professor);
        }
    }
    
    public void buscar(){
        Scanner leitor = new Scanner(System.in);
        Professor professor;
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("ENTRE COM O NOME DO PROFESSOR: ");
        professor = (Professor) professorDao.buscar(leitor.nextLine());
        this.imprimirBusca(professor);
    }
    
    public void listarProfessores() {
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        
        professorDao.listar().stream().forEach((professor) -> {
            System.out.println(professor);
        });
    }

    void listarHistorico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}