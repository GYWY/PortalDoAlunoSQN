package View;

import Model.DAO.DisciplinaDAO;
import Model.POJO.DisciplinaPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DisciplinaView {
    
    private static Scanner leitor = new Scanner(System.in);
    private ArrayList<DisciplinaPOJO> lista = new ArrayList<>();
    private DisciplinaPOJO disciplina;
    private DisciplinaDAO disciplinaDao;
    
    void cadastrar() {
        System.out.println("\n **************** CADASTRO DISCIPLINA ***************");
        System.out.println("\n DISCIPLINA: ");
        String nomeDisciplina = leitor.nextLine();
        System.out.println("\n EMENTA: ");
        String ementa = leitor.nextLine();
        System.out.println("\n CARGA HORÁRIA: ");
        Integer cargaHoraria = leitor.nextInt();
        disciplina = new DisciplinaPOJO(nomeDisciplina,ementa,cargaHoraria);
        this.disciplinaDao.inserir(nomeDisciplina);
    }
    
    public void listarDisciplina() {
        for (Iterator<Object> it = this.disciplinaDao.listar(lista).iterator(); it.hasNext();) {
            Object disciplina = it.next();
            System.out.println(disciplina);
        }
    }
    
    public void buscarDisciplina() {
        System.out.println("\n **************** PESQUISA DISCIPLINA ****************");
        System.out.println("\n ENTRE COM O NOME DA DISCIPLINA: ");
        Object pesquisa = leitor.nextLine();
        if(disciplinaDao.buscar(pesquisa) == null) {
            System.out.println("DISCIPLINA NÃO ENCONTRADA");
        }
        else {
            disciplina = (DisciplinaPOJO) disciplinaDao.buscar(pesquisa);
            System.out.println(disciplina);
        }
    }
    
}
