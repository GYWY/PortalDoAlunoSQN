package br.com.portalufln.trabalhobd.model.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FALTA")
public class Falta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer falta;
    
    @ManyToOne
    private Aluno aluno;
    
    @ManyToOne
    private Turma turma;
    
    public Falta() {
        
    }
    
    public Falta(Integer falta) {
        this.falta = falta;
    }
    
    public Falta(Integer falta, Aluno aluno, Turma turma) {
        this(falta);
        this.aluno = aluno;
        this.turma = turma;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFalta() {
        return falta;
    }

    public void setFalta(Integer falta) {
        this.falta = falta;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Falta)) {
            return false;
        }
        Falta other = (Falta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Faltas: " + falta);
    }
    
}
