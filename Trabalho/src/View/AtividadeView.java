
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
        novaAtividade.setNome(leitor.nextLine());
        System.out.println("TIPO DA ATIVIDADE: ");
        novaAtividade.setTipo(leitor.nextLine());
        System.out.println("DATA (FORMATO: dd/mm/aa): ");
        novaAtividade.setData(leitor.nextLine());
        System.out.println("VALOR: ");
        novaAtividade.setValor(Double.parseDouble(leitor.nextLine()));
        System.out.println("TURMA: ");
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