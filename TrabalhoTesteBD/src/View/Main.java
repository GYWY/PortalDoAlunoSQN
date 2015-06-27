package View;

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
        System.out.println("2- PROFESSOR");
        System.out.println("3- TURMA");
        System.out.println("4- ALUNO");
        System.out.println("5- SAIR \n");
        System.out.println("OPÇÃO: ");
    }
    
    private void imprimirMenuProfessor() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t BEM VINDO AO PORTAL DO PROFESSOR! \n");
        System.out.println("1- ATIVIDADE");
        System.out.println("2- LANÇAR NOTA");
        System.out.println("3- LANÇAR FALTA");
        System.out.println("4- ALTERAR NOTA");
        System.out.println("5- CONSULTAR TURMAS DE UMA DISCIPLINA");
        System.out.println("6- CONSULTAR ALUNO DE UMA DISCIPLINA");
        System.out.println("7- CONSULTAR HISTÓRICO DE UMA DISCIPLINA");
        System.out.println("8- CONSULTAR HISTÓRICO DE UM PROFESSOR");
        System.out.println("9- SAIR \n");
        System.out.println("OPÇÃO: ");
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
                    disciplina.menuDisciplina();
                    break;
                case 2:
                    professor.menuProfessor();
                    break;
                case 3:
                    turma.menuTurma();
                    break;
                case 4:
                    aluno.menuAluno();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
            }
        } while(escolha != 5);
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
                    atividade.menuAtividade();
                    break;
                case 2:
                    faltaNota.cadastrarNota();
                    break;
                case 3:
                    faltaNota.cadastrarFalta();
                    break;
                case 4:
                    faltaNota.alterarNota();
                    break;
                case 5:
                    disciplina.listarTurmas();
                    break;
                case 6:
                    faltaNota.situacaoNotaAluno();
                    break;
                case 7:
                    disciplina.listarHistoricoTurmas();
                    break;
                case 8:
                    professor.listarHistorico();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
            }
        } while(escolha != 9);
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Main menu = new Main();
        Scanner leitor = new Scanner(System.in);
        
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

}
