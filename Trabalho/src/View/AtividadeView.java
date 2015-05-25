
package View;

import Model.DAO.AtividadeDAO;
import Model.POJO.Atividade;
import Model.DAO.GenericoDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Turma;
import java.util.Iterator;
import java.util.Scanner;

public class AtividadeView {

    public void cadastrarAtividade(){
        Scanner leitor = new Scanner(System.in);
        Atividade novaAtividade = new Atividade();
        GenericoDAO atividadeDao = AtividadeDAO.getInstancia();
        GenericoDAO turmaDao = TurmaDAO.getInstancia();
        
        System.out.println("\n **************** CADASTRO DE ATIVIDADES ***************");
        System.out.println("NOME DA ATIVIDADE: ");
        novaAtividade.setNome(leitor.nextLine().toUpperCase());
        System.out.println("TIPO DA ATIVIDADE: ");
        novaAtividade.setTipo(leitor.nextLine().toUpperCase());
        System.out.println("DATA (FORMATO: dd/mm/aa): ");
        novaAtividade.setData(leitor.nextLine());
        System.out.println("VALOR: ");
        novaAtividade.setValor(Double.parseDouble(leitor.nextLine()));
        System.out.println("ID DA TURMA: ");
        Integer idTurma = Integer.parseInt(leitor.nextLine());
        Turma turma = (Turma) turmaDao.buscar(idTurma);
        if(turma == null){
            System.out.println("\nTURMA NÃO CADASTRADA\n"
                    + "NÃO FOI POSSÍVEL O CADASTRO DA ATIVIDADE\n\n");
            return;
        }
        novaAtividade.setTurma(turma);
        atividadeDao.inserir(novaAtividade);
        turma.getListaDeAtividade().add(novaAtividade);
    }
    
    public void buscarAtividade() {
        Scanner leitor = new Scanner(System.in);
        Atividade novaAtividade = new Atividade();
        GenericoDAO atividade = AtividadeDAO.getInstancia();
        
        System.out.println("\n **************** PESQUISA ATIVIDADE ****************");
        System.out.println("ENTRE COM O TIPO: ");
        Object pesquisa = leitor.nextLine().toUpperCase();
        if(novaAtividade == null) {
            System.out.println("\n\t\t ATIVIDADE NÃO ENCONTRADA \n");
        }
        else
            System.out.println("\n"+novaAtividade);
    }
    
    public void listarAtividade() {
        
        GenericoDAO atividadeDao = AtividadeDAO.getInstancia();
        
        System.out.println("\n\t\t ATIVIDADES \n");
        for (Iterator<Object> it = atividadeDao.listar().iterator(); it.hasNext();) {
            Object listaAtividade = it.next();
            System.out.println(listaAtividade.toString());
        }     
    }
    
    public void imprimirMenuAtividade() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t DISCIPLINA \n");
        System.out.println("1- CADASTRAR ATIVIDADE");
        System.out.println("2- PESQUISAR ATIVIDADE");
        System.out.println("3- LISTAR ATIVIDADES");
        System.out.println("4- SAIR \n");
        System.out.println("OPÇÃO:");
    }
    
}