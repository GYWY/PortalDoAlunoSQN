package Model.POJO;

public class FaltaPOJO {
    //Atributos
    private Integer faltas;
    private AlunoPOJO aluno;
    private TurmaPOJO turma;

    //Construtor
    public FaltaPOJO(Integer faltas, TurmaPOJO turma, AlunoPOJO aluno) {
        this.faltas = faltas;
        this.aluno = aluno;
        this.turma = turma;
    }

    //Getters e Setters
    public Integer getFaltas() {
        return faltas;
    }
    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }
    public AlunoPOJO getAluno() {
        return aluno;
    }
    public void setAluno(AlunoPOJO aluno) {
        this.aluno = aluno;
    }
    public TurmaPOJO getTurma() {
        return turma;
    }
    public void setTurma(TurmaPOJO turma) {
        this.turma = turma;
    }
       
    //toString
    @Override
    public String toString() {
        return ("Número total de faltas: " + faltas);
    }
}
