package Model.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROFESSOR")
public class Professor extends Pessoa implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String departamento;
    
    @OneToMany
    private ArrayList<Turma> listaTurmasMinistradas;
    
    public Professor(){
        this.listaTurmasMinistradas = new ArrayList<Turma>();
    }
    
    public Long getIdProfessor() {
        return id;
    }

    public void setIdProfessor(Long idProfessor) {
        this.id = idProfessor;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public ArrayList<Turma> getListaTurmasMinistradas() {
        return listaTurmasMinistradas;
    }

    public void setListaTurmasMinistradas(Turma turma) {
        this.listaTurmasMinistradas.add(turma);        
    }

    @Override
    public String toString() {        
        return (super.toString()+"\nDepartamento: " + departamento + "\n");
    }
    
}
