package Model.POJO;

import java.util.Objects;

public class Nota {
    
    private Integer id;
    private Double nota;
    private Aluno aluno;
    private Atividade atividade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }
    
    
    
}
