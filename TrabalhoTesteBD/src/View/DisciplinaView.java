package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.GenericoDAO;
import Model.POJO.Disciplina;
import Model.POJO.Turma;
import java.io.FileNotFoundException;
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
            System.out.println("\n NÚMERO DE TURMAS TOTAL: " + disciplina.getListaTurmas().size());  
        }
    }
    
    public void alterarDisciplina() {
        Scanner leitor = new Scanner(System.in);
        Disciplina disciplina = new Disciplina();
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        System.out.println("\n NOME: ");
        String nome = leitor.nextLine().toUpperCase();
        disciplina = (Disciplina) disciplinaDao.buscar(nome);
        if(disciplina == null){
            System.out.println("\n DISCIPLINA NÃO CADASTRADA \n\n");
            return;
        }
        System.out.println("\n DADOS ATUAIS: ");
        System.out.println(disciplina.toString());
        System.out.println("\n NOVA EMENTA: ");
        disciplina.setEmenta(leitor.nextLine().toUpperCase());
        System.out.println("\n NOVO CARGA HORÁRIA: ");
        Integer cargaHoraria = Integer.parseInt(leitor.nextLine().toUpperCase());
        disciplina.setCargaHoraria(cargaHoraria);
        disciplinaDao.alterar(disciplina);
    }
    
    public void imprimirMenuDisciplina() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t DISCIPLINA \n");
        System.out.println("1- CADASTRAR DISCIPLINA");
        System.out.println("2- PESQUISAR DISCIPLINA");
        System.out.println("3- LISTAR DISCIPLINAS");
        System.out.println("4- HISTÓRICO NÚMERO DE TURMAS DE UMA DISCIPLINA");
        System.out.println("5- ALTERAR DISCIPLINA");
        System.out.println("6- SAIR \n");
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
                        disciplina.cadastrarDisciplina();
                        break;
                    case 2:
                        disciplina.buscarDisciplina();
                        break;
                    case 3:
                        disciplina.listarDisciplina();
                        break;
                    case 4:
                        disciplina.listarHistoricoTurmas();
                        break;
                    case 5:
                        disciplina.alterarDisciplina();
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
