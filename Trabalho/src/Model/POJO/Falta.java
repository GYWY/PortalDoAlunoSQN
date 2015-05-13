package Model.POJO;

public class Falta {
    //Atributos
    private Integer faltas;
    private Aluno aluno;
    private Turma turma;

    //Getters e Setters
    public Integer getFaltas() {
        return faltas;
    }
    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
       
    //toString
    @Override
    public String toString() {
        return ("Número total de faltas: " + faltas);
    }
}
