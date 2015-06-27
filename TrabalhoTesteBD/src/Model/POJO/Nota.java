package Model.POJO;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="NOTA")
public class Nota implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private Double nota;
    
    @OneToOne
    private Aluno aluno;
    
    @OneToOne
    private Atividade atividade;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Nota{" + "id=" + id + ", nota=" + nota + ", aluno=" + aluno + ", atividade=" + atividade + '}';
    }      
    
}
