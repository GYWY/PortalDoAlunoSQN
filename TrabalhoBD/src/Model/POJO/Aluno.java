package Model.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNO")
public class Aluno extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "ALUNO")
    private ArrayList<Falta> listaFaltas;
    
    @OneToMany(mappedBy = "ALUNO")
    private ArrayList<Nota> listaNotas;
    
    public Aluno() {
        this.listaFaltas = new ArrayList<Falta>();
        this.listaNotas = new ArrayList<Nota>();
    } 
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Falta> getListaFaltas() {
        return listaFaltas;
    }
    
    public void setListaFalta(Falta falta) {
        this.listaFaltas.add(falta);        
    }
    
    public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }
    
    public void setListaNota(Nota nota) {
        this.listaNotas.add(nota);        
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
        return (super.toString() + "\n");
    }
    
}
