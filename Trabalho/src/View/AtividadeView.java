
package View;

import Model.DAO.AtividadeDAO;
import Model.POJO.Atividade;
import Model.DAO.GenericoDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Turma;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class AtividadeView {

    public void cadastrarAtividade(){
        Scanner leitor = new Scanner(System.in);
        Atividade novaAtividade = new Atividade();
        GenericoDAO atividadeDao = AtividadeDAO.getInstancia();
        GenericoDAO turmaDao = TurmaDAO.getInstancia();
        
        System.out.println("\n\t\t CADASTRO DISCIPLINA \n");
        System.out.println("\n NOME DA ATIVIDADE: ");
        novaAtividade.setNome(leitor.nextLine().toUpperCase());
        System.out.println("\n TIPO DA ATIVIDADE: ");
        novaAtividade.setTipo(leitor.nextLine().toUpperCase());
        System.out.println("\n DATA (FORMATO: dd/mm/aa): ");
        novaAtividade.setData(leitor.nextLine());
        System.out.println("\n VALOR: ");
        novaAtividade.setValor(Double.parseDouble(leitor.nextLine()));
        System.out.println("\n ID DA TURMA: ");
        Integer idTurma = Integer.parseInt(leitor.nextLine());
        Turma turma = (Turma) turmaDao.buscar(idTurma);
        if(turma == null){
            System.out.println("\n ****************************************************************************** \n");
            System.out.println("\n\t TURMA NÃO ESTÁ CADASTRADA \n");
            return;
        }
        novaAtividade.setTurma(turma);
        atividadeDao.inserir(novaAtividade);
        turma.getListaDeAtividade().add(novaAtividade);
    }
    
    public void buscarAtividade() {
        Scanner leitor = new Scanner(System.in);
        Atividade atividade = new Atividade();
        GenericoDAO atividadeDao = AtividadeDAO.getInstancia();
        
        System.out.println("\n\t\t PESQUISA ATIVIDADE \n");
        System.out.println("\n NOME: ");
        Object pesquisa = leitor.nextLine().toUpperCase();
        atividade = (Atividade) atividadeDao.buscar(pesquisa);
        if(atividade == null) {
            System.out.println("\n\t\t ATIVIDADE NÃO ENCONTRADA \n");
        }
        else
            System.out.println("\n"+atividade);
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
    
    public void menuAtividade() throws FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Scanner leitor = new Scanner(System.in);
        AtividadeView atividade = new AtividadeView();
        GenericoDAO atividadeDao = AtividadeDAO.getInstancia();
        
        do{
            atividade.imprimirMenuAtividade();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine());
                    flag = 1;
                } catch(Exception e){
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
                    flag = 0;
                    atividade.imprimirMenuAtividade();
                } 
            } while(flag == 0);
                switch(escolha) {
                    case 1:
                        try{
                            atividadeDao.buscarTodos(atividade);
                            atividade.cadastrarAtividade();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO CADASTRAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 2:
                        try{
                            atividadeDao.buscarTodos(atividade);
                            atividade.buscarAtividade();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO BUSCAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 3:
                        try{
                            atividadeDao.buscarTodos(atividade);
                            atividade.listarAtividade();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO LISTAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("\n ****************************************************************************** \n");
                        System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                        System.out.println("\n ****************************************************************************** \n");       
                }
        } while(escolha != 4);
    }
    
}