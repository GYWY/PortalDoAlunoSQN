package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.ProfessorDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Disciplina;
import Model.POJO.Professor;
import Model.POJO.Turma;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class TurmaView {

    void cadastrarTurma(){
        Scanner leitor = new Scanner(System.in);
        Turma novaTurma = new Turma();
        GenericoDAO turma = TurmaDAO.getInstancia();
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        GenericoDAO professorDao = ProfessorDAO.getInstancia();
        
        System.out.println("\n\t\t CADASTRO TURMA \n");
        System.out.println("\n LOCAL: ");
        novaTurma.setLocal(leitor.nextLine().toUpperCase());
        System.out.println("\n ANO: ");
        novaTurma.setAno(Long.parseLong(leitor.nextLine()));
        System.out.println("\n PERíODO: ");
        novaTurma.setPeriodo(Integer.parseInt(leitor.nextLine()));
        System.out.println("\n HORÁRIO: ");
        novaTurma.setHorario(leitor.nextLine().toUpperCase());
        System.out.println("\n QUANTIDADE DE VAGAS: ");
        novaTurma.setVaga(Integer.parseInt(leitor.nextLine()));
        System.out.println("\n DISCIPLINA: ");        
        String nomeDisciplina = leitor.nextLine().toUpperCase();
        Disciplina disciplina = (Disciplina) disciplinaDao.buscar(nomeDisciplina);
        if(disciplina==null){
            System.out.println("\n ****************************************************************************** \n");
            System.out.println("\n\t DISCIPLINA NÃO ESTÁ CADASTRADA \n");
            return;
        }
        novaTurma.setDisciplina(disciplina);
        System.out.println("PROFESSOR: ");
        String nomeProfessor = leitor.nextLine().toUpperCase();
        Professor professor = (Professor) professorDao.buscar(nomeProfessor);
        if(professor==null){
            System.out.println("\n ****************************************************************************** \n");
            System.out.println("\n\t PROFESSOR NÃO ESTÁ CADASTRADO \n");
            return;
        }
        novaTurma.setProfessor(professor);
        turma.inserir(novaTurma);
        disciplina.setListaTurmas(novaTurma);
        professor.setListaTurmasMinistradas(novaTurma);
        
    }
    
    public void listarTurma(){
        GenericoDAO turmaDao = TurmaDAO.getInstancia();
        System.out.println("\n\t\t TURMAS \n");
        for (Iterator<Object> it = turmaDao.listar().iterator(); it.hasNext();) {
            Object listaTurma = it.next();
            System.out.println(listaTurma.toString());
        }            
    }
    
    public void imprimirMenuTurma() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t TURMA \n");
        System.out.println("1- CADASTRAR TURMA");
        System.out.println("2- LISTAR TURMAS");
        System.out.println("3- LISTAR TURMAS DE UMA DISCIPLINA");
        System.out.println("4- SAIR \n");
        System.out.println("OPÇÃO:");
    }
    
    public void menuTurma() throws FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Scanner leitor = new Scanner(System.in);
        TurmaView turma = new TurmaView();
        DisciplinaView disciplina = new DisciplinaView();
        GenericoDAO turmaDao = TurmaDAO.getInstancia();
        
        do{
            turma.imprimirMenuTurma();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine());
                    flag = 1;
                } catch(Exception e){
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
                    flag = 0;
                    turma.imprimirMenuTurma();
                } 
            } while(flag == 0);
                switch(escolha) {
                    case 1:
                        try{
                            turmaDao.buscarTodos(turma);
                            turma.cadastrarTurma();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO CADASTRAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 2:
                        try{
                            turmaDao.buscarTodos(turma);
                            turma.listarTurma();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO LISTAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 3:
                        try{
                            turmaDao.buscarTodos(turma);
                            disciplina.listarTurmas();
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
}
