
package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.ProfessorDAO;
import Model.POJO.Professor;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorView{
    
    private void tratarDisciplinaInexistente(String nomeDaDisciplina, DisciplinaDAO disciplinaDAO){
        
        while(disciplinaDAO.buscar(nomeDaDisciplina) == null){
                System.out.println("A DISCIPLINA NÃO ESTÁ CADASTRADA. DIGITE NOVAMENTE!");
        }
    }
    
    private void cadastrarDisciplinasElegiveis(Professor professor){
        Scanner leitor = new Scanner(System.in);
        String nomeDaDisciplina;
        System.out.println("NOME DA DISCIPLINA OU 0 CASO CONTRÁRIO:  ");
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        
        do{
            nomeDaDisciplina = leitor.nextLine();
            
            this.tratarDisciplinaInexistente(nomeDaDisciplina, disciplinaDAO);
            professor.adicionarDisciplina(nomeDaDisciplina);
        }while(nomeDaDisciplina.equals("0"));
    }
    
    private void lerDados(Professor professor){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** CADASTRO PROFESSOR ***************");
        System.out.println("NOME PROFESSOR: ");
        professor.setNome(leitor.nextLine());
        
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
        
        for (Object professor : professorDao.listar()) {
            System.out.println(professor);
        }
    }

    void listarHistorico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}