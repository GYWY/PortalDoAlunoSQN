
package View;

import Model.DAO.AlunoDAO;
import Model.DAO.AtividadeDAO;
import Model.POJO.Atividade;
import Model.DAO.GenericoDAO;
import Model.DAO.NotaDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Aluno;
import Model.POJO.Nota;
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
    
    public void cadastrarNota() {
        Scanner leitor = new Scanner(System.in);
        Nota nota = new Nota();
        GenericoDAO notaDao = NotaDAO.getInstancia();
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        GenericoDAO atividadeDao = AtividadeDAO.getInstancia();
        
        System.out.println("\n\t CADASTRO NOTA \n");
        System.out.println("\n ALUNO: ");
        String nomeAluno = leitor.nextLine();
        Aluno aluno = (Aluno) alunoDao.buscar(nomeAluno);
        if(aluno == null){
            System.out.println("\n ALUNO NÃO CADASTRADO \n\n");
            return;
        }
        nota.setAluno(aluno);
        System.out.println("\n\t ATIVIDADE: ");
        String nomeAtividade = leitor.nextLine();
        Atividade atividade = (Atividade) atividadeDao.buscar(nomeAtividade);
        if(atividade == null){
            System.out.println("\n ATIVIDADE NÃO CADASTRADA \n\n");
            return;
        }
        nota.setAtividade(atividade);
        System.out.println("\n NOTA: ");
        nota.setNota(Double.parseDouble(leitor.nextLine()));
        notaDao.inserir(nota);
        aluno.getListaNotas().add(nota);
        atividade.getListaNotas().add(nota);
    }
  
    public void situacaoNotaAluno(){
        Scanner leitor = new Scanner(System.in);
        GenericoDAO notas = NotaDAO.getInstancia();
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        
        System.out.println("ALUNO: ");
        String nomeAluno = leitor.nextLine();
        System.out.println("ATIVIDADE: ");
        String nomeAtividade = leitor.nextLine();
        Aluno aluno = (Aluno) alunoDao.buscar(nomeAluno);
        Double valorTotal = 0.0;
        Double notaFinal = 0.0;
        for(Nota nota : aluno.getListaNotas()){
            if(nomeAtividade.equals(nota.getAtividade().getNome())){
                notaFinal += nota.getNota();
            }
        }
        for(Nota nota : aluno.getListaNotas()){
            if(nomeAtividade.equals(nota.getAtividade().getValor())){
                valorTotal +=nota.getAtividade().getValor();
            }
        }
        if((valorTotal*0.6)<=notaFinal){
            System.out.println("APROVADO POR NOTA");
        }
        else
           System.out.println("REPROVADO POR NOTA");
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