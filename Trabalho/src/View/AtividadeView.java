
package View;

import Model.DAO.AtividadeDAO;
import Model.POJO.AtividadePOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AtividadeView {
    
    private ArrayList<AtividadePOJO> lista = new ArrayList<>();
    private AtividadeDAO atividadeDao = new AtividadeDAO();
    private AtividadePOJO novaAtividade;
   
    
    public void cadastrarAtividade(){
        Scanner leitor = new Scanner(System.in);
        novaAtividade = new AtividadePOJO();
        System.out.println("\n **************** CADASTRO DE ATIVIDADES ***************");
        System.out.println("digite o nome do aluno: ");
        novaAtividade.setNome(leitor.nextLine());
        System.out.println("digite o tipo da atividade: ");
        novaAtividade.setTipo(leitor.nextLine());
        System.out.println("digite a data no formato dd/mm/aa: ");
        novaAtividade.setData(leitor.nextLine());
        System.out.println("Digite o valor: ");
        novaAtividade.setValor(leitor.nextDouble());
        atividadeDao.inserir(novaAtividade);
        
    }
    
    public void buscarAtividade() {
        
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA ATIVIDADE ****************");
        System.out.println("\n ENTRE COM O TIPO: ");
        Object pesquisa = leitor.nextLine();
        if(atividadeDao.buscar(pesquisa) == null) {
            System.out.println("ATIVIDADE NÃO ENCONTRADA");
        }
        else if(novaAtividade == (AtividadePOJO) atividadeDao.buscar(pesquisa)){
            System.out.println(novaAtividade);
        }
    }
    
    public void listarAtividade() {
        System.out.println("\n **************** ATIVIDADE ****************");
        for (Iterator<Object> it = this.atividadeDao.listar().iterator(); it.hasNext();) {
            Object atividadeL = it.next();
            System.out.println(atividadeL);
        }
    }
    
    public static void main(String[] args) {
        AtividadeView asd = new AtividadeView();
        asd.cadastrarAtividade();
        asd.cadastrarAtividade();
        asd.listarAtividade();
        asd.buscarAtividade();
    }
        
}
