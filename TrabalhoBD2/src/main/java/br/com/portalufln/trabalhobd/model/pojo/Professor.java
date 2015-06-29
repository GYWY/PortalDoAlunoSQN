package br.com.portalufln.trabalhobd.model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESSOR")
public class Professor extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String departamento;
    
    @OneToMany
    private List<Turma> listaTurmas;
    
    public Professor() {
        this.listaTurmas = new ArrayList<Turma>();
    }
    
    public Professor(String nome, String cpf) {
        super(nome,cpf);
    }

    public Professor(String nome, String cpf, String departamento) {
        this(nome,cpf);
        this.departamento = departamento;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<Turma> getListaTurmas() {
        return listaTurmas;
    }

    public void addTurmas(Turma turma) {
        this.listaTurmas.add(turma);
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
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nDepartamento: " + departamento);
    }
    
}
