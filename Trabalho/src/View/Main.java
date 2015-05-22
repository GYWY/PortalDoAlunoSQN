package View;

import Model.DAO.AlunoDAO;
import Model.DAO.AtividadeDAO;
import Model.DAO.DisciplinaDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.ProfessorDAO;
import Model.DAO.TurmaDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private void imprimirMenuEntrada() {
        System.out.println("BEM VINDO AO PORTAL DA FACULDADE! \n\n\t O QUE VOCÊ É?");
        System.out.println("1- PROFESSOR");
        System.out.println("2- ADMINISTRADOR");
        System.out.println("3- SAIR \n");
        System.out.println("OPÇÃO: ");
    }

    private void imprimirMenuAdministrador() {
        System.out.println("BEM VINDO AO SISTEMA PRINCIPAL! \n\n\t ESCOLHA A OPÇÃO QUE LHE FOR ÚTIL.");
        System.out.println("1- CADASTRAR DISCIPLINA");
        System.out.println("2- CADASTRAR TURMA");
        System.out.println("3- CADASTRAR PROFESSOR");
        System.out.println("4- CADASTRAR ALUNO");
        System.out.println("5- CONSULTAR TURMAS DE UMA DISCIPLINA");
        System.out.println("6- SAIR \n");
        System.out.println("OPÇÃO: ");
    }
    
    private void imprimirMenuProfessor() {
        System.out.println("BEM VINDO AO PORTAL DO PROFESSOR! \n\n\t ESCOLHA A OPÇÃO QUE LHE FOR ÚTIL.");
        System.out.println("1- CADASTRAR ATIVIDADE");
        System.out.println("2- LANÇAR NOTA");
        System.out.println("3- LANÇAR FALTA");
        System.out.println("4- CONSULTAR TURMAS DE UMA DISCIPLINA");
        System.out.println("5- CONSULTAR ALUNO DE UMA DISCIPLINA");
        System.out.println("6- CONSULTAR HISTÓRICO DE UMA DISCIPLINA");
        System.out.println("7- CONSULTAR HISTÓRICO DE UM PROFESSOR");
        System.out.println("8- SAIR \n");
        System.out.println("OPÇÃO: ");
    }
    
    private void menuAdministrador() throws IOException, FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag; 
        
        Main main = new Main();
        Scanner leitor = new Scanner(System.in);
        DisciplinaView disciplina = new DisciplinaView();
        TurmaView turma = new TurmaView();
        ProfessorView professor = new ProfessorView();
        AlunoView aluno = new AlunoView();
        
        do {
            main.imprimirMenuAdministrador();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine()); 
                    flag = 1;
                } catch (Exception e){
                    System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE.");
                    flag = 0;
                }
            } while(flag == 0);
            System.out.println("\n ****************************************************************************** \n");
            switch(escolha) {
                case 1:
                    try{
                        DisciplinaDAO.getInstancia().buscarTodos(disciplina);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ DISCIPLINA CADASTRADA");
                    }
                    disciplina.cadastrarDisciplina();
                    break;
                case 2:
                    try{
                        TurmaDAO.getInstancia().buscarTodos(turma);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ TURMA CADASTRADA");
                    }
                    turma.cadastrarTurma();
                    break;
                case 3:
                    try{
                        ProfessorDAO.getInstancia().buscarTodos(professor);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ PROFESSOR CADASTRADO");
                    }
                    professor.cadastrarProfessor();
                    break;
                case 4:
                    try{
                        AlunoDAO.getInstancia().buscarTodos(aluno);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ ALUNO CADASTRADO");
                    }
                    aluno.cadastrarAluno();
                    break;
                case 5:
                    try{
                        DisciplinaDAO.getInstancia().buscarTodos(disciplina);
                        disciplina.listarTurmas();
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ DISCIPLINA CADASTRADA");
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\n\t ENTRADA INVÁLIDA \n");                  
            }
        } while(escolha != 6);
    }
    
    private void menuProfessor() throws IOException, FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Main main = new Main();
        Scanner leitor = new Scanner(System.in);
        AtividadeView atividade = new AtividadeView();
        AlunoView aluno = new AlunoView();
        DisciplinaView disciplina = new DisciplinaView();
        TurmaView turma = new TurmaView();
        ProfessorView professor = new ProfessorView();
        
        do {
            main.imprimirMenuProfessor();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine()); 
                    flag = 1;
                } catch (Exception e){
                    System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE.");
                    flag = 0;
                }
            } while(flag == 0);
            System.out.println("\n ****************************************************************************** \n");
            switch(escolha) {
                case 1:
                    try{
                        AtividadeDAO.getInstancia().buscarTodos(atividade);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ ATIVIDADE CADASTRADA");
                    }
                    atividade.cadastrarAtividade();
                    break;
                case 2:
                    try{
                        AtividadeDAO.getInstancia().buscarTodos(atividade);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ ATIVIDADE CADASTRADA");
                    }
                    atividade.cadastrarNota();
                    break;
                case 3:
                    try{
                        AlunoDAO.getInstancia().buscarTodos(aluno);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ ALUNO CADASTRADO");
                    }
                    aluno.cadastrarFalta();
                    break;
                case 4:
                    try{
                        DisciplinaDAO.getInstancia().buscarTodos(disciplina);
                        disciplina.listarTurmas();
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ DISCIPLINA CADASTRADA");
                    }
                    break;
                case 5:
                    try{
                        TurmaDAO.getInstancia().buscarTodos(turma);
                        turma.listarAluno();
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ TURMA CADASTRADA");
                    }
                    break;
                case 6:
                    try{
                        DisciplinaDAO.getInstancia().buscarTodos(disciplina);
                        disciplina.listarHistoricoTurmas();
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ DISCIPLINA CADASTRADA");
                    }
                    break;
                case 7:
                    try{
                        ProfessorDAO.getInstancia().buscarTodos(professor);
                        professor.listarHistorico();
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ PROFESSOR CADASTRADO");
                    }
                    break;
                case 8:
                    break;
                default:
                    System.out.println("\n\t ENTRADA INVÁLIDA \n");                  
            }
        } while(escolha != 8);
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Main main = new Main();
        Scanner leitor = new Scanner(System.in);
        
        do{
            main.imprimirMenuEntrada();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine()); 
                    flag = 1;
                } catch (Exception e){
                    System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE. \n\n OPÇÃO: ");
                    flag = 0;
                }
            } while(flag == 0);
            System.out.println("\n ****************************************************************************** \n");
            switch(escolha) {
                case 1:
                    main.menuProfessor();
                    break;
                case 2:
                    main.menuAdministrador();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\n\t ENTRADA INVÁLIDA \n");
            }
        } while(escolha != 3);
    }

}