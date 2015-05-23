
package View;

import Model.DAO.AtividadeDAO;
import Model.POJO.Atividade;
import Model.DAO.AlunoDAO;
import Model.DAO.GenericoDAO;
import Model.POJO.Aluno;
import Model.POJO.Nota;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AtividadeView {

    public void cadastrarAtividade(){
        Scanner leitor = new Scanner(System.in);
        Atividade novaAtividade = new Atividade();
        GenericoDAO atividade = AtividadeDAO.getInstancia();
        String nomeAluno;
        
        System.out.println("\n **************** CADASTRO DE ATIVIDADES ***************");
        System.out.println("NOME DA ATIVIDADE ");
        nomeAluno = leitor.nextLine();
        Aluno aluno = (Aluno) AlunoDAO.getInstancia().buscar(nomeAluno);
        novaAtividade.setNome(nomeAluno);
        System.out.println("TIPO DA ATIVIDADE: ");
        novaAtividade.setTipo(leitor.nextLine());
        System.out.println("DATA (FORMATO: dd/mm/aa): ");
        novaAtividade.setData(leitor.nextLine());
        System.out.println("VALOR: ");
        novaAtividade.setValor(Double.parseDouble(leitor.nextLine()));
        atividade.inserir(novaAtividade);
        aluno.getListaAtividadesRealizadas().add(novaAtividade);

    }
    
    public void cadastrarNota() {
        Scanner leitor = new Scanner(System.in);
        Nota nota = new Nota();
        Atividade novaAtividade = new Atividade();
        GenericoDAO atividade = AtividadeDAO.getInstancia();
        
        System.out.println("\n **************** CADASTRO DE NOTAS ***************");
        System.out.println("NOME DO ALUNO: ");
        novaAtividade = (Atividade) atividade.buscar(leitor.nextLine());
        System.out.println("CÓDIGO DA ATIVIDADE: ");
        nota.setAtividade((Atividade) atividade.buscar(Integer.parseInt(leitor.nextLine())));
        System.out.println("NOTA: ");
        nota.setNota(Double.parseDouble(leitor.nextLine()));
        atividade.inserir(novaAtividade);
    }
    
    public void buscarAtividade() {
        Scanner leitor = new Scanner(System.in);
        Atividade novaAtividade = new Atividade();
        GenericoDAO atividade = AtividadeDAO.getInstancia();
        
        System.out.println("\n **************** PESQUISA ATIVIDADE ****************");
        System.out.println("ENTRE COM O TIPO: ");
        Object pesquisa = leitor.nextLine();
        if(atividade.buscar(pesquisa) == null) {
            System.out.println("ATIVIDADE NÃO ENCONTRADA");
        }
        else if(novaAtividade == (Atividade) atividade.buscar(pesquisa)){
            System.out.println(novaAtividade);
        }
    }
    
    public void listarAtividade() {
        GenericoDAO atividade = AtividadeDAO.getInstancia();
        
        System.out.println("\n **************** ALUNOS ****************");
        for (Iterator<Object> it = atividade.listar().iterator(); it.hasNext();) {
            Object atividadeLista = it.next();
            System.out.println(atividadeLista);
        }     
    }
    
}