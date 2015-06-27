package Model.POJO;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FALTA")
public class Falta implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private Integer faltas;
    
    @OneToOne
    private Aluno aluno;
    
    @OneToOne
    private Turma turma;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {    
        this.id = id;
    }
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

    @Override
    public String toString() {
        return ("Número total de faltas: " + faltas);
    }
}
