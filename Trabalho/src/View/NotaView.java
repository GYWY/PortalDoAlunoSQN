
package View;

import Model.DAO.AlunoDAO;
import Model.DAO.AtividadeDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.NotaDAO;
import Model.POJO.Aluno;
import Model.POJO.Atividade;
import Model.POJO.Nota;
import java.util.Scanner;

public class NotaView {
    
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
