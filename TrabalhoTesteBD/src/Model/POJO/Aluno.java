package Model.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ALUNO")
public class Aluno extends Pessoa implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @OneToMany
    private ArrayList<Falta> listaFaltas;
    
    @OneToMany
    private ArrayList<Nota> listaNotas;

    public Aluno() { 
        this.listaFaltas = new ArrayList<Falta>();
        this.listaNotas = new ArrayList<Nota>();
    } 

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Falta> getListaFaltas() {
        return listaFaltas;
    }

    public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNota(Nota nota) {
        this.listaNotas.add(nota);        
    }

    public void setListaFalta(Falta falta) {
        this.listaFaltas.add(falta);        
    }

    @Override
    public String toString() {
        return (super.toString()+"\n");
    }
    
}