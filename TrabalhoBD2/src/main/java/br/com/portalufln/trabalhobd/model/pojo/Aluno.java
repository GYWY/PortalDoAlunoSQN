package br.com.portalufln.trabalhobd.model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNO")
public class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Nota> listaNotas;
    
    @OneToMany
    private List<Falta> listaFaltas;
    
    @ManyToMany
    private List<Turma> listaTurmas;
    
    public Aluno() {
        this.listaNotas = new ArrayList<Nota>();
        this.listaFaltas = new ArrayList<Falta>();
        this.listaTurmas = new ArrayList<Turma>();
    }
    
    public Aluno(String nome, String cpf) {
        super(nome,cpf);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    public void addNotas(Nota nota) {
        this.listaNotas.add(nota);
    }

    public List<Falta> getListaFaltas() {
        return listaFaltas;
    }

    public void addFaltas(Falta falta) {
        this.listaFaltas.add(falta);
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
        
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (super.toString()+"\n");
    }
    
}
