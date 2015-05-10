
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
        novaAtividade.setValor(Double.parseDouble(leitor.nextLine()));
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
        System.out.println("\n **************** ATIVIDADES ****************");
        this.lista = (ArrayList<AtividadePOJO>) this.atividadeDao.listar().iterator();
        for (int i = 0;i<this.lista.size();i++) {
            System.out.println(this.lista.get(i));
        }
    }
    
}