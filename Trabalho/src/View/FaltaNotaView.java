
package View;

import Model.DAO.AlunoDAO;
import Model.DAO.AtividadeDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.NotaDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Aluno;
import Model.POJO.Atividade;
import Model.POJO.Falta;
import Model.POJO.Nota;
import Model.POJO.Turma;
import java.util.Scanner;

public class FaltaNotaView {
    
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
        aluno.adicionarNota(nota);
        atividade.adicionarNota(nota);
    }

    public void cadastrarFalta() {
        Scanner leitor = new Scanner(System.in);
        Falta falta = new Falta();
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        GenericoDAO turmaDao = TurmaDAO.getInstancia();
        
        System.out.println("\n\t CADASTRO DE FALTAS ");
        System.out.println("\n ID DA TURMA: ");
        Turma turma = (Turma) turmaDao.buscar(Integer.parseInt(leitor.nextLine()));     
        if(turma == null) {
            System.out.println("\n TURMA NÃO CADASTRADA");
            return;
        }
        falta.setTurma(turma);
        
        System.out.println("\n NOME DO ALUNO: ");
        Aluno aluno = (Aluno) alunoDao.buscar(leitor.nextLine());
        if(aluno == null) {
            System.out.println("\n ALUNO NÃO CADASTRADO");
            return;
        }
        falta.setAluno(aluno);
        
        System.out.println("\n NÚMERO DE FALTAS: ");
        falta.setFaltas(Integer.parseInt(leitor.nextLine()));
        turma.adicionarFalta(falta);
        aluno.adicionarFalta(falta);

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
    
}
