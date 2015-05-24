package Model.POJO;

import java.util.ArrayList;
import java.util.Objects;

public class Disciplina {

    private Integer id;
    private String nome;
    private String ementa;
    private Integer cargaHoraria;
    private ArrayList<Turma> listaTurmas;

    public Disciplina() {
        this.listaTurmas = new ArrayList<Turma>();
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmenta() {
        return ementa;
    }
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    } 
    public ArrayList<Turma> getListaTurmas() {
        return listaTurmas;
    }
    public void setListaTurmas(Turma turma) {
        this.listaTurmas.add(turma);
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return ("Disciplina: " + nome +"\nCarga Horária: " + cargaHoraria + "\nEmenta: " + ementa + "\n");
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Disciplina))
            return false;
        Disciplina disciplina = (Disciplina)obj;
        return this.nome.equals(disciplina.getNome());
    }
    @Override
    public int hashCode() {
        return nome.hashCode();
    }
    
}
