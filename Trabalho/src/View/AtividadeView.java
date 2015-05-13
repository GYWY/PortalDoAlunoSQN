
package View;

import Model.DAO.AtividadeDAO;
import Model.POJO.Atividade;
import Model.DAO.AlunoDAO;
import Model.POJO.Nota;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AtividadeView {

    public void cadastrarAtividade(){
        Scanner leitor = new Scanner(System.in);
        Atividade novaAtividade = new Atividade();
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
        Nota nota = new Nota();
        Atividade novaAtividade = new Atividade();
        System.out.println("\n **************** CADASTRO DE NOTAS ***************");
        System.out.println("NOME DO ALUNO: ");
        novaAtividade = (Atividade) AtividadeDAO.getInstancia().buscar(leitor.nextLine());
        System.out.println("CÓDIGO DA ATIVIDADE: ");
        nota.setAtividade((Atividade) AtividadeDAO.getInstancia().buscar(Integer.parseInt(leitor.nextLine())));
        System.out.println("NOTA: ");
        nota.setNota(Double.parseDouble(leitor.nextLine()));
        AtividadeDAO.getInstancia().inserir(novaAtividade);
    }
    
    public void buscarAtividade() {
        Atividade novaAtividade = new Atividade();
        Scanner leitor = new Scanner(System.in);
        System.out.println("\n **************** PESQUISA ATIVIDADE ****************");
        System.out.println("ENTRE COM O TIPO: ");
        Object pesquisa = leitor.nextLine();
        if(AtividadeDAO.getInstancia().buscar(pesquisa) == null) {
            System.out.println("ATIVIDADE NÃO ENCONTRADA");
        }
        else if(novaAtividade == (Atividade) AtividadeDAO.getInstancia().buscar(pesquisa)){
            System.out.println(novaAtividade);
        }
    }
    
    public void listarAtividade() {
        System.out.println("\n **************** ALUNOS ****************");
        for (Iterator<Object> it = AtividadeDAO.getInstancia().listar().iterator(); it.hasNext();) {
            Object atividade = it.next();
            System.out.println(atividade);
        }     
    }
    
}