
package View;

import Model.DAO.AtividadeDAO;
import Model.POJO.AtividadePOJO;
import Model.DAO.AlunoDAO;
import Model.POJO.NotaPOJO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AtividadeView {
    
    private ArrayList<AtividadePOJO> lista = new ArrayList<>();
    private AtividadePOJO novaAtividade;
   
    
    public void cadastrarAtividade(){
        Scanner leitor = new Scanner(System.in);
        novaAtividade = new AtividadePOJO();
        System.out.println("\n **************** CADASTRO DE ATIVIDADES ***************");
        System.out.println("NOME DO ALUNO ");
        AlunoDAO.getInstancia().buscar(leitor.nextLine());
        System.out.println("TIPO DA ATIVIDADE: ");
        novaAtividade.setTipo(leitor.nextLine());
        System.out.println("DATA (FORMATO: dd/mm/aa): ");
        novaAtividade.setData(leitor.nextLine());
        System.out.println("VALOR: ");
        novaAtividade.setValor(Double.parseDouble(leitor.nextLine()));
        AtividadeDAO.getInstancia().inserir(novaAtividade);
        
    }
    
    public void cadastrarNota() {
        Scanner leitor = new Scanner(System.in);
        NotaPOJO nota = new NotaPOJO();
        novaAtividade = new AtividadePOJO();
        System.out.println("\n **************** CADASTRO DE NOTAS ***************");
        System.out.println("NOME DO ALUNO: ");
        novaAtividade = (AtividadePOJO) AtividadeDAO.getInstancia().buscar(leitor.nextLine());
        System.out.println("CÓDIGO DA ATIVIDADE: ");
        nota.setAtividade((AtividadePOJO) AtividadeDAO.getInstancia().buscar(Integer.parseInt(leitor.nextLine())));
        System.out.println("NOTA: ");
        nota.setNota(Double.parseDouble(leitor.nextLine()));
        AtividadeDAO.getInstancia().inserir(novaAtividade);
    }
    
    public void buscarAtividade() {
        
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA ATIVIDADE ****************");
        System.out.println("ENTRE COM O TIPO: ");
        Object pesquisa = leitor.nextLine();
        if(AtividadeDAO.getInstancia().buscar(pesquisa) == null) {
            System.out.println("ATIVIDADE NÃO ENCONTRADA");
        }
        else if(novaAtividade == (AtividadePOJO) AtividadeDAO.getInstancia().buscar(pesquisa)){
            System.out.println(novaAtividade);
        }
    }
    
    public void listarAtividade() {
        System.out.println("\n **************** ATIVIDADES ****************");
        this.lista = (ArrayList<AtividadePOJO>) AtividadeDAO.getInstancia().listar().iterator();
        for (int i = 0;i<this.lista.size();i++) {
            System.out.println(this.lista.get(i));
        }
    }
    
}