package View;

import Model.DAO.AlunoDAO;
import Model.DAO.AtividadeDAO;
import Model.DAO.DisciplinaDAO;
import Model.DAO.FaltaDAO;
import Model.DAO.NotaDAO;
import Model.DAO.ProfessorDAO;
import Model.DAO.TurmaDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private void imprimirMenuEntrada() {
        System.out.println("\n\t UNIVERSIDADE FEDERAL DE LUGAR NENHUM \n");
        System.out.println("1- PROFESSOR");
        System.out.println("2- ADMINISTRADOR");
        System.out.println("3- SAIR \n");
        System.out.println("OPÇÃO: ");
    }

    private void imprimirMenuAdministrador() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t BEM VINDO AO SISTEMA PRINCIPAL! \n");
        System.out.println("1- DISCIPLINA");
        System.out.println("2- CADASTRAR TURMA");
        System.out.println("3- CADASTRAR PROFESSOR");
        System.out.println("4- CADASTRAR ALUNO");
        System.out.println("5- CONSULTAR TURMAS DE UMA DISCIPLINA");
        System.out.println("6- SAIR \n");
        System.out.println("OPÇÃO: ");
    }
    
    private void imprimirMenuProfessor() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t BEM VINDO AO PORTAL DO PROFESSOR! \n");
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
    
    private void menuDisciplina() throws FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        
        Main menu = new Main();
        Scanner leitor = new Scanner(System.in);
        DisciplinaView disciplina = new DisciplinaView();
        
        do{
            disciplina.imprimirMenuDisciplina();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine());
                    flag = 1;
                } catch(Exception e){
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
                    flag = 0;
                    disciplina.imprimirMenuDisciplina();
                } 
            } while(flag == 0);
                switch(escolha) {
                    case 1:
                        try{
                            DisciplinaDAO.getInstancia().buscarTodos(disciplina);
                            disciplina.cadastrarDisciplina();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO CADASTRAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 2:
                        try{
                            DisciplinaDAO.getInstancia().buscarTodos(disciplina);
                            disciplina.buscarDisciplina();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO BUSCAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 3:
                        try{
                            DisciplinaDAO.getInstancia().buscarTodos(disciplina);
                            disciplina.listarDisciplina();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO LISTAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("\n ****************************************************************************** \n");
                        System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                        System.out.println("\n ****************************************************************************** \n");       
                }
        } while(escolha != 4);
    }
    
    private void menuAdministrador() throws IOException, FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag; 
        
        Main menu = new Main();
        Scanner leitor = new Scanner(System.in);
        DisciplinaView disciplina = new DisciplinaView();
        TurmaView turma = new TurmaView();
        ProfessorView professor = new ProfessorView();
        AlunoView aluno = new AlunoView();
        
        do {
            menu.imprimirMenuAdministrador();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine()); 
                    flag = 1;
                } catch (Exception e){
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
                    flag = 0;
                    menu.imprimirMenuAdministrador();
                }
            } while(flag == 0);
            switch(escolha) {
                case 1:
                    menu.menuDisciplina();
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
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
            }
        } while(escolha != 6);
    }
    
    private void menuProfessor() throws IOException, FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Main menu = new Main();
        Scanner leitor = new Scanner(System.in);
        AtividadeView atividade = new AtividadeView();
        AlunoView aluno = new AlunoView();
        DisciplinaView disciplina = new DisciplinaView();
        TurmaView turma = new TurmaView();
        ProfessorView professor = new ProfessorView();
        FaltaNotaView faltaNota = new FaltaNotaView();
        
        do {
            menu.imprimirMenuProfessor();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine()); 
                    flag = 1;
                } catch (Exception e){
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");
                    flag = 0;
                    menu.imprimirMenuProfessor();
                }
            } while(flag == 0);
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
                        AlunoDAO.getInstancia().buscarTodos(aluno);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ ATIVIDADE CADASTRADA");
                    }
                    faltaNota.cadastrarNota();
                    break;
                case 3:
                    try{
                        AlunoDAO.getInstancia().buscarTodos(aluno);
                        TurmaDAO.getInstancia().buscarTodos(turma);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ ALUNO CADASTRADO");
                    }
                    faltaNota.cadastrarFalta();
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
                        DisciplinaDAO.getInstancia().buscarTodos(disciplina);
                        AlunoDAO.getInstancia().buscarTodos(aluno);
                    } catch(IOException e){
                        System.out.println("\tNÃO HÁ TURMA CADASTRADA");
                    }
                    faltaNota.situacaoNotaAluno();
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
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
            }
        } while(escolha != 8);
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Main menu = new Main();
        Scanner leitor = new Scanner(System.in);
        
        menu.buscarTodos();
        
        do{
            menu.imprimirMenuEntrada();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine()); 
                    flag = 1;
                } catch (Exception e){
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");
                    flag = 0;
                    menu.imprimirMenuEntrada();
                }
            } while(flag == 0);
            switch(escolha) {
                case 1:
                    menu.menuProfessor();
                    break;
                case 2:
                    menu.menuAdministrador();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");
            }
        } while(escolha != 3);
    }

    private void buscarTodos() throws IOException, FileNotFoundException, ClassNotFoundException{
        AlunoView aluno = new AlunoView();
        AtividadeView atividade = new AtividadeView();
        DisciplinaView disciplina = new DisciplinaView();
        ProfessorView professor = new ProfessorView();
        TurmaView turma = new TurmaView();
        FaltaNotaView faltaNota = new FaltaNotaView();
        try{
            DisciplinaDAO.getInstancia().buscarTodos(disciplina);
            ProfessorDAO.getInstancia().buscarTodos(professor);
            TurmaDAO.getInstancia().buscarTodos(turma); 
            AlunoDAO.getInstancia().buscarTodos(aluno);
            AtividadeDAO.getInstancia().buscarTodos(atividade);
            FaltaDAO.getInstancia().buscarTodos(faltaNota);
            NotaDAO.getInstancia().buscarTodos(faltaNota);
        } catch(IOException e){
            System.out.println("\n\t ERRO AO CARREGAR DADOS \n\n");
        }
    }
    
}
