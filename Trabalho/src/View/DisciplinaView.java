package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.GenericoDAO;
import Model.POJO.Disciplina;
import Model.POJO.Turma;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DisciplinaView {    
    public void cadastrarDisciplina() {
        Scanner leitor = new Scanner(System.in);
        Disciplina novaDisciplina = new Disciplina();
        GenericoDAO disciplina = DisciplinaDAO.getInstancia();
        
        System.out.println("\n\t\t CADASTRO DISCIPLINA \n");
        System.out.println("\n DISCIPLINA: ");
        String nomeDisciplina = leitor.nextLine().toUpperCase();
        if(!(disciplina.buscar(nomeDisciplina) == null)){
            System.out.println("\n ****************************************************************************** \n");
            System.out.println("\n\t DISCIPLINA JÁ ESTÁ CADASTRADA \n");
            return;
        }
        novaDisciplina.setNome(nomeDisciplina);
        System.out.println("\n EMENTA: ");
        novaDisciplina.setEmenta(leitor.nextLine().toUpperCase());
        System.out.println("\n CARGA HORÁRIA: ");
        novaDisciplina.setCargaHoraria(Integer.parseInt(leitor.nextLine()));
        disciplina.inserir(novaDisciplina);
    }
    
    public void buscarDisciplina() {
        Disciplina disciplina = new Disciplina();
        Scanner leitor = new Scanner(System.in);
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        System.out.println("\n\t\t PESQUISA DISCIPLINA \n");
        System.out.println("\n DISCIPLINA: ");
        Object pesquisa = leitor.nextLine().toUpperCase();
        disciplina = (Disciplina) disciplinaDao.buscar(pesquisa);
        if(disciplina == null) {
            System.out.println("\n\t\t DISCIPLINA NÃO ENCONTRADA \n");
        }
        else
            System.out.println("\n"+disciplina);
    }
    
    public void listarDisciplina() {
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        System.out.println("\n\t\t DISCIPLINAS \n");
        for (Iterator<Object> it = disciplinaDao.listar().iterator(); it.hasNext();) {
            Object listaDisciplina = it.next();
            System.out.println(listaDisciplina.toString());
        }
    }

    public void listarTurmas() {
        Scanner leitor = new Scanner(System.in);
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        System.out.println("\nDISCIPLINA: ");
        String nomeDisciplina = leitor.nextLine().toUpperCase();
        Disciplina disciplina = (Disciplina) disciplinaDao.buscar(nomeDisciplina);
        ArrayList<Turma> listaTurma = disciplina.getListaTurmas();
        System.out.println("ANO: ");
        Long ano = Long.parseLong(leitor.nextLine());
        System.out.println("PERÍODO: ");
        Integer periodo = Integer.parseInt(leitor.nextLine());
        for(Turma turma : listaTurma){
            if(ano.equals(turma.getAno()) && periodo.equals(turma.getPeriodo())){
                System.out.println(turma.getIdTurma());
                System.out.println(turma.getDisciplina().getNome());
                System.out.println(turma.getProfessor().getNome());
            }
        }
    }

    public void listarHistoricoTurmas() {
        
        Scanner leitor = new Scanner(System.in);
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        System.out.println("DISCIPLINA: ");
        String nomeDisciplina = leitor.nextLine().toUpperCase();
        Disciplina disciplina = (Disciplina) disciplinaDao.buscar(nomeDisciplina);
        if(nomeDisciplina.equals(disciplina.getNome())){  
            System.out.println(disciplina.getListaTurmas().size());  
        }
    }
    
    public void imprimirMenuDisciplina() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t DISCIPLINA \n");
        System.out.println("1- CADASTRAR DISCIPLINA");
        System.out.println("2- PESQUISAR DISCIPLINA");
        System.out.println("3- LISTAR DISCIPLINAS");
        System.out.println("4- SAIR \n");
        System.out.println("OPÇÃO:");
    }
    
    public void menuDisciplina() throws FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Scanner leitor = new Scanner(System.in);
        DisciplinaView disciplina = new DisciplinaView();
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
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
                            disciplinaDao.buscarTodos(disciplina);
                            disciplina.cadastrarDisciplina();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO CADASTRAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 2:
                        try{
                            disciplinaDao.buscarTodos(disciplina);
                            disciplina.buscarDisciplina();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO BUSCAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 3:
                        try{
                            disciplinaDao.buscarTodos(disciplina);
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
    
}
