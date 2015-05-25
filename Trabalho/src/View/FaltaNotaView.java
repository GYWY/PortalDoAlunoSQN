package View;

import Model.DAO.AlunoDAO;
import Model.DAO.AtividadeDAO;
import Model.DAO.DisciplinaDAO;
import Model.DAO.FaltaDAO;
import Model.DAO.GenericoDAO;
import Model.DAO.NotaDAO;
import Model.DAO.TurmaDAO;
import Model.POJO.Aluno;
import Model.POJO.Atividade;
import Model.POJO.Disciplina;
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
        String nomeAluno = leitor.nextLine().toUpperCase();
        Aluno aluno = (Aluno) alunoDao.buscar(nomeAluno);
        if(aluno == null){
            System.out.println("\n ALUNO NÃO CADASTRADO \n\n");
            return;
        }
        nota.setAluno(aluno);
        System.out.println("\n\t ATIVIDADE: ");
        String nomeAtividade = leitor.nextLine().toUpperCase();
        Atividade atividade = (Atividade) atividadeDao.buscar(nomeAtividade);
        if(atividade == null){
            System.out.println("\n ATIVIDADE NÃO CADASTRADA \n\n");
            return;
        }
        nota.setAtividade(atividade);
        System.out.println("\n NOTA: ");
        nota.setNota(Double.parseDouble(leitor.nextLine()));
        notaDao.inserir(nota);
        aluno.setListaNota(nota);
        atividade.setListaNota(nota);
    }

    public void cadastrarFalta() {
        Scanner leitor = new Scanner(System.in);
        Falta falta = new Falta();
        GenericoDAO faltaDao = FaltaDAO.getInstancia();
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
        Aluno aluno = (Aluno) alunoDao.buscar(leitor.nextLine().toUpperCase());
        if(aluno == null) {
            System.out.println("\n ALUNO NÃO CADASTRADO");
            return;
        }
        falta.setAluno(aluno);
        
        System.out.println("\n NÚMERO DE FALTAS: ");
        falta.setFaltas(Integer.parseInt(leitor.nextLine()));
        faltaDao.inserir(falta);
        turma.adicionarFalta(falta);
        aluno.setListaFalta(falta);

    }
        
    public void situacaoNotaAluno(){
        Scanner leitor = new Scanner(System.in);
        GenericoDAO notas = NotaDAO.getInstancia();
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        GenericoDAO disciplinaDao = DisciplinaDAO.getInstancia();
        
        System.out.println("DISCIPLINA: ");
        String nomeDisciplina = leitor.nextLine().toUpperCase();
        Disciplina disciplina = (Disciplina) disciplinaDao.buscar(nomeDisciplina);
        System.out.println("ALUNO: ");
        String nomeAluno = leitor.nextLine().toUpperCase();
        Aluno aluno = (Aluno) alunoDao.buscar(nomeAluno);
        Integer faltaFinal = 0;
        Double valorTotal = 0.0;
        Double notaFinal = 0.0;
        for(Falta falta : aluno.getListaFaltas()){
            if(disciplina.getListaTurmas().contains(falta.getTurma())){
                faltaFinal = falta.getFaltas();
            }
        }
        if(faltaFinal > 0.25*disciplina.getCargaHoraria()){
            System.out.println("\n ALUNO REPROVADO POR FALTA");
            return;
        }
        for(Nota nota : aluno.getListaNotas()){
            for(Turma turma : disciplina.getListaTurmas()){
                if(turma.getListaDeAtividade().contains(nota.getAtividade()))
                    notaFinal += nota.getNota();
            }
        }
        for(Nota nota : aluno.getListaNotas()){
            for(Turma turma : disciplina.getListaTurmas()){
                if(turma.getListaDeAtividade().contains(nota.getAtividade()))
                    valorTotal += nota.getAtividade().getValor();
            }
        }
        if((valorTotal*0.6)<=notaFinal){
            System.out.println("APROVADO POR NOTA");
        }
        else
           System.out.println("REPROVADO POR NOTA");
    }
    
}
