package View;

import Model.DAO.AlunoDAO;
import Model.DAO.GenericoDAO;
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
                    disciplina.cadastrarDisciplina();
                    break;
                case 2:
                    turma.cadastrarTurma();
                    break;
                case 3:
                    professor.cadastrarProfessor();
                    break;
                case 4:
                    try{
                        AlunoDAO.getInstancia().buscarTodos(aluno);
                        aluno.listarAluno();
                    } catch(IOException e){
                        System.out.println("\tLISTA DE ALUNOS VAZIA");
                    }
                    aluno.cadastrarAluno();
                    break;
                case 5:
                    disciplina.listarTurmas();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\n\t ENTRADA INVÁLIDA \n");                  
            }
        } while(escolha != 6);
    }
    
    private void menuProfessor() throws IOException {
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
                    atividade.cadastrarAtividade();
                    break;
                case 2:
                    atividade.cadastrarNota();
                    break;
                case 3:
                    aluno.cadastrarFalta();
                    break;
                case 4:
                    disciplina.listarTurmas();
                    break;
                case 5:
                    turma.listarAluno();
                    break;
                case 6:
                    disciplina.listarHistoricoTurmas();
                    break;
                case 7:
                    professor.listarHistorico();
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