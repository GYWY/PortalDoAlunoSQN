package View;

import Model.DAO.DisciplinaDAO;
import Model.POJO.DisciplinaPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DisciplinaView {
    
    private static Scanner leitor = new Scanner(System.in);
    private ArrayList<DisciplinaPOJO> lista = new ArrayList<>();
    private DisciplinaDAO disciplinaDao;
    private DisciplinaPOJO novaDisciplina;
    
    public void cadastrar() {
        System.out.println("\n **************** CADASTRO DISCIPLINA ***************");
        System.out.println("\n DISCIPLINA: ");
        String nomeDisciplina = leitor.nextLine();
        System.out.println("\n EMENTA: ");
        String ementa = leitor.nextLine();
        System.out.println("\n CARGA HORÁRIA: ");
        Integer cargaHoraria = leitor.nextInt();
        novaDisciplina = new DisciplinaPOJO(nomeDisciplina,ementa,cargaHoraria);
        this.disciplinaDao.inserir(novaDisciplina);
    }
    
    public void buscarDisciplina() {
        System.out.println("\n **************** PESQUISA DISCIPLINA ****************");
        System.out.println("\n ENTRE COM O NOME DA DISCIPLINA: ");
        Object pesquisa = leitor.nextLine();
        if(disciplinaDao.buscar(pesquisa) == null) {
            System.out.println("DISCIPLINA NÃO ENCONTRADA");
        }
        else {
            novaDisciplina = (DisciplinaPOJO) disciplinaDao.buscar(pesquisa);
            System.out.println(novaDisciplina);
        }
    }
    
    public void listarDisciplina() {
        for (Iterator<Object> it = this.disciplinaDao.listar(lista).iterator(); it.hasNext();) {
            Object disciplinaL = it.next();
            System.out.println(disciplinaL);
        }
    }
    
    public static void main(String[] args) {
        DisciplinaView asd = new DisciplinaView();
        asd.cadastrar();
        asd.cadastrar();
        asd.listarDisciplina();
    }
    
}