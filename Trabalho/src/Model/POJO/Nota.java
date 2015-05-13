package Model.POJO;

public class Nota {
    private Double nota;
    private Aluno aluno;
    private Atividade atividade;

    public Aluno getAluno() {
        return aluno;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
}
