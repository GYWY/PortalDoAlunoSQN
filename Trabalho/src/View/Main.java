package View;

import java.util.Scanner;

public class Main {

    private void imprimirMenu() {
        System.out.println("BEM VINDO AO PORTAL DO ALUNO! \n ESCOLHA A OPÇÃO QUE LHE FOR ULTIL.");
        System.out.println("1- CADASTRAR ALUNO");
        System.out.println("2- CADASTRAR PROFESSOR");
        System.out.println("3- CADASTRAR DISCIPLINA");
        System.out.println("4- CADASTRAR ATIVIDADE");
        System.out.println("5- CADASTRAR TURMA");
        System.out.println("6- CADASTRAR FALTA");
        System.out.println("7- CADASTRAR NOTA");
    }

    public static void main(String[] args) {
        int escolha;
        Main main = new Main();
        Scanner leitor = new Scanner(System.in);
        AlunoView aluno = new AlunoView();
        ProfessorView professor = new ProfessorView();
        DisciplinaView disciplina = new DisciplinaView();
        AtividadeView atividade = new AtividadeView();
        TurmaView turma = new TurmaView();
        
        escolha = leitor.nextInt();
        while(escolha != 0){
            main.imprimirMenu();
            escolha = leitor.nextInt();
            
            switch (escolha) {
                case 1: {
                    aluno.cadastrarAluno();
                    break;
                }

                case 2: {
                    professor.cadastrar();
                    break;
                }

                case 3: {
                    disciplina.cadastrarDisciplina();
                    break;
                }
                case 4: {
                    atividade.cadastrarAtividade();
                    break;
                }
                case 5: {
                    turma.cadastrar();
                    break;
                }
                case 6: {
                    aluno.cadastrarFalta();
                    break;
                }
                case 7: {
                    atividade.cadastrarNota();
                    break;
                }
            }
        }
    }
}
