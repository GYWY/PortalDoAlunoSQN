
package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.ProfessorDAO;
import Model.POJO.ProfessorPOJO;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorView{
    ProfessorDAO professorDao = new ProfessorDAO();
    
    private void tratarDisciplinaInexistente(String nomeDaDisciplina, DisciplinaDAO disciplinaDAO){
        
        while(disciplinaDAO.buscar(nomeDaDisciplina) == null){
                System.out.println("A DISCIPLINA NÃO ESTÁ CADASTRADA. DIGITE NOVAMENTE!");
        }
    }
    
    private void cadastrarDisciplinasElegiveis(ProfessorPOJO professor){
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
    
    private void lerDados(ProfessorPOJO professor){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** CADASTRO PROFESSOR ***************");
        System.out.println("NOME PROFESSOR: ");
        professor.setNome(leitor.nextLine());
        
        System.out.println("CPF: ");
        professor.setCpf(leitor.nextLine());
        
        System.out.println("DEPARTAMENTO: ");
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
            System.out.println("PROFESSOR NÃO ENCONTRADO!!");
        }
        else{
            System.out.println(professor);
        }
    }
    
    public void buscar(){
        Scanner leitor = new Scanner(System.in);
        ProfessorPOJO professor;
        System.out.println("\n **************** PESQUISA ****************");
        System.out.println("ENTRE COM O NOME DO PROFESSOR: ");
        professor = (ProfessorPOJO) this.professorDao.buscar(leitor.nextLine());
        this.imprimirBusca(professor);
    }
    
    public void listarProfessores() {
        for (Object professor : this.professorDao.listar()) {
            System.out.println(professor);
        }
    }
}