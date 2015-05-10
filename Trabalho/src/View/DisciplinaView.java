package View;

import Model.DAO.DisciplinaDAO;
import Model.POJO.DisciplinaPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DisciplinaView {
    
    private ArrayList<DisciplinaPOJO> lista = new ArrayList<>();
    private DisciplinaDAO disciplinaDao = new DisciplinaDAO();
    private DisciplinaPOJO novaDisciplina;
    
    public void cadastrar() {
        Scanner leitor = new Scanner(System.in);
        novaDisciplina = new DisciplinaPOJO();
        System.out.println("\n **************** CADASTRO DISCIPLINA ***************");
        System.out.println("\n DISCIPLINA: ");
        novaDisciplina.setNome(leitor.nextLine());
        System.out.println("\n EMENTA: ");
        novaDisciplina.setEmenta(leitor.nextLine());
        System.out.println("\n CARGA HORÁRIA: ");
        novaDisciplina.setCargaHoraria(leitor.nextInt());
        disciplinaDao.inserir(novaDisciplina);
    }
    
    public void buscarDisciplina() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA DISCIPLINA ****************");
        System.out.println("\n ENTRE COM O NOME DA DISCIPLINA: ");
        Object pesquisa = leitor.nextLine();
        if(disciplinaDao.buscar(pesquisa) == null) {
            System.out.println("DISCIPLINA NÃO ENCONTRADA");
        }
        else if(novaDisciplina == (DisciplinaPOJO) disciplinaDao.buscar(pesquisa)){
            System.out.println(novaDisciplina);
        }
    }
    
    public void listarDisciplina() {
        System.out.println("\n **************** DISCIPLINAS ****************");
        for (Iterator<Object> it = this.disciplinaDao.listar().iterator(); it.hasNext();) {
            Object disciplinaL = it.next();
            System.out.println(disciplinaL);
        }
    }
    
}