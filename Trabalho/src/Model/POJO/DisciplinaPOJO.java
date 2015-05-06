package Model.POJO;

import java.util.Objects;

public class DisciplinaPOJO {
    //Atributos
    private String nome;
    private String ementa;
    private Integer cargaHoraria;
    private ProfessorPOJO[] professor;
    private TurmaPOJO[] turma;

    //Construtor
    public DisciplinaPOJO(String nome, String ementa, Integer cargaHoraria, ProfessorPOJO[] professor, TurmaPOJO[] turma) {
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.turma = turma;
    }

    
    //Getters e Setters
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

    //toString
    @Override
    public String toString() {
        return ("Disciplina: " + nome +"\nCarga Horária: " + cargaHoraria + "\nEmenta: " + ementa);
    }
    
    //Equals e HashCode
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof DisciplinaPOJO))
            return false;
        DisciplinaPOJO disciplina = (DisciplinaPOJO)obj;
        return (this.nome == disciplina.getNome());
    }
    @Override
    public int hashCode() {
        return nome.hashCode();
    }
    
}
