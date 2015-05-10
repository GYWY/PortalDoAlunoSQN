package Model.POJO;

public class NotaPOJO {
    private Double nota;
    private AlunoPOJO aluno;
    private AtividadePOJO atividade;

    public AlunoPOJO getAluno() {
        return aluno;
    }

    public AtividadePOJO getAtividade() {
        return atividade;
    }

    public void setAluno(AlunoPOJO aluno) {
        this.aluno = aluno;
    }

    public void setAtividade(AtividadePOJO atividade) {
        this.atividade = atividade;
    }
    
    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
}
