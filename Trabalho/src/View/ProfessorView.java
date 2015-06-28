
package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.ProfessorDAO;
import Model.POJO.Professor;
import Model.POJO.Turma;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


public class ProfessorView{
    private void lerDados(Professor professor){
        Scanner leitor = new Scanner(System.in);
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        System.out.println("\n **************** CADASTRO PROFESSOR ***************");
        System.out.println("NOME PROFESSOR: ");
        String nomeProfessor = leitor.nextLine().toUpperCase();
        if(!(professorDao.buscar(nomeProfessor)== null)){
            System.out.println("\nPROFESSOR JÁ CADASTRADO\n\n");
            return;
        }
        professor.setNome(nomeProfessor);
        System.out.println("CPF: ");
        professor.setCpf(leitor.nextLine().toUpperCase());
        System.out.println("DEPARTAMENTO: ");
        professor.setDepartamento(leitor.nextLine().toUpperCase());
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
    
    public void buscarProfessor(){
        Professor professor = new Professor();
        Scanner leitor = new Scanner(System.in);
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        System.out.println("\n\t\t PESQUISA PROFESSOR \n");
        System.out.println("\n PROFESSOR: ");
        Object pesquisa = leitor.nextLine().toUpperCase();
        professor = (Professor) professorDao.buscar(pesquisa);
        if(professor == null) {
            System.out.println("\n\t\t DISCIPLINA NÃO ENCONTRADA \n");
        }
        else
            System.out.println("\n"+professor);
    }
    
    public void listarProfessores() {
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        System.out.println("\n\t\t PROFESSORES \n");
        for (Iterator<Object> it = professorDao.listar().iterator(); it.hasNext();) {
            Object listaProfessor = it.next();
            System.out.println(listaProfessor.toString());
        }
    }

    void listarHistorico() {
        Scanner leitor = new Scanner(System.in);
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        System.out.println("\n PROFESSOR: ");
        String nomeProfessor = leitor.nextLine().toUpperCase();
        Professor professor = (Professor) professorDao.buscar(nomeProfessor);
        Integer contador=0;
        String disciplina = "";
        try{ 
            disciplina = professor.getListaTurmasMinistradas().get(0).getDisciplina().getNome();
        } catch(Exception e){
            System.out.println("\n ****************************************************************************** \n");
            System.out.println("\n\t PROFESSOR OU DISCIPLINA NÃO ESTÁ CADASTRADO(A) \n");
            return;
        }
        contador = 1;
            for(Turma turma : professor.getListaTurmasMinistradas()){
                if(!disciplina.equals(turma.getDisciplina().getNome()))
                    contador++;
            }
        System.out.println("\n NUMERO DE DISCIPLINAS TOTAL: " + contador + "\n");
    }
    
    public void alterarProfessor() {
        Scanner leitor = new Scanner(System.in);
        Professor professor = new Professor();
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        
        System.out.println("\n NOME: ");
        String nome = leitor.nextLine().toUpperCase();
        professor = (Professor) professorDao.buscar(nome);
        if(professor == null){
            System.out.println("\n ALUNO NÃO CADASTRADO \n\n");
            return;
        }
        System.out.println("\n DADOS ATUAIS: ");
        System.out.println(professor.toString());
        System.out.println("\n NOVO CPF: ");
        professor.setCpf(leitor.nextLine().toUpperCase());
        System.out.println("\n NOVO DEPARTAMENTO: ");
        professor.setDepartamento(leitor.nextLine().toUpperCase());
        professorDao.alterar(professor);
    }
    
    public void imprimirMenuProfessor() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t PROFESSOR \n");
        System.out.println("1- CADASTRAR PROFESSOR");
        System.out.println("2- PESQUISAR PROFESSOR");
        System.out.println("3- LISTAR PROFESSORES");
        System.out.println("4- HISTÓRICO NÚMERO DE DISCIPLINAS DE PROFESSOR");
        System.out.println("5- ALTERAR PROFESSOR");
        System.out.println("6- SAIR \n");
        System.out.println("OPÇÃO:");
    }
    
    public void menuProfessor() throws FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Scanner leitor = new Scanner(System.in);
        ProfessorView professor = new ProfessorView();
        do{
            professor.imprimirMenuProfessor();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine());
                    flag = 1;
                } catch(Exception e){
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
                    flag = 0;
                    professor.imprimirMenuProfessor();
                } 
            } while(flag == 0);
                switch(escolha) {
                    case 1:
                        try{
                            ProfessorDAO.getInstancia().buscarTodos(professor);
                            professor.cadastrarProfessor();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO CADASTRAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 2:
                        try{
                            ProfessorDAO.getInstancia().buscarTodos(professor);
                            professor.buscarProfessor();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO BUSCAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 3:
                        try{
                            ProfessorDAO.getInstancia().buscarTodos(professor);
                            professor.listarProfessores();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO LISTAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 4:
                        try{
                            ProfessorDAO.getInstancia().buscarTodos(professor);
                            professor.listarHistorico();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO LISTAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break; 
                    case 5:
                        try{
                            ProfessorDAO.getInstancia().buscarTodos(professor);
                            professor.alterarProfessor();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO LISTAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("\n ****************************************************************************** \n");
                        System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                        System.out.println("\n ****************************************************************************** \n");       
                }
        } while(escolha != 6);
    }

}
