package View;

import Model.DAO.DisciplinaDAO;
import Model.DAO.GenericoDAO;
import Model.POJO.Disciplina;
import Model.POJO.Turma;
import java.util.ArrayList;
import java.util.Scanner;

public class DisciplinaView {
    
    public void cadastrarDisciplina() {
        Scanner leitor = new Scanner(System.in);
        Disciplina novaDisciplina = new Disciplina();
        GenericoDAO disciplina = DisciplinaDAO.getInstancia();
        
        System.out.println("\n **************** CADASTRO DISCIPLINA ***************");
        System.out.println("\n DISCIPLINA: ");
        String nomeDisciplina = leitor.nextLine();
        if(!(disciplina.buscar(nomeDisciplina) == null)){
            System.out.println("\nDISCIPLINA JÁ FOI CADASTRADA\n\n");
            return;
        }
        novaDisciplina.setNome(nomeDisciplina);
        System.out.println("\n EMENTA: ");
        novaDisciplina.setEmenta(leitor.nextLine());
        System.out.println("\n CARGA HORÁRIA: ");
        novaDisciplina.setCargaHoraria(Integer.parseInt(leitor.nextLine()));
        disciplina.inserir(novaDisciplina);
    }
    
    public void buscarDisciplina() {
        Disciplina novaDisciplina = new Disciplina();
        Scanner leitor = new Scanner(System.in);
        GenericoDAO disciplina = DisciplinaDAO.getInstancia();
        
        System.out.println("\n **************** PESQUISA DISCIPLINA ****************");
        System.out.println("\n ENTRE COM O NOME DA DISCIPLINA: ");
        Object pesquisa = leitor.nextLine();
        if(disciplina.buscar(pesquisa) == null) {
            System.out.println("DISCIPLINA NÃO ENCONTRADA");
        }
        else if(novaDisciplina == (Disciplina) disciplina.buscar(pesquisa)){
            System.out.println(novaDisciplina);
        }
    }
    
    public void listarDisciplina() {
        GenericoDAO disciplina = DisciplinaDAO.getInstancia();
        
        System.out.println("\n **************** DISCIPLINAS **************** ");
        disciplina.listar().stream().forEach((disciplinaLista) -> {
            disciplinaLista.toString();
        });
    }

    public void listarTurmas(String nomeDisciplina) {
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        Disciplina disciplina = (Disciplina) disciplinaDao.buscar(nomeDisciplina);
        ArrayList<Turma> listaTurma = disciplina.getListaTurmas();
        listaTurma.stream().forEach((turma) -> {
            turma.toString();
        });
            
            
    }

    void listarHistoricoTurmas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}