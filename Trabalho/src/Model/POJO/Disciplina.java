package Model.POJO;

import java.util.ArrayList;
import java.util.Objects;

public class Disciplina {
    //Atributos
    private Integer id;
    private String nome;
    private String ementa;
    private Integer cargaHoraria;
    private ArrayList<Professor> listaProfessores;
    private ArrayList<Turma> listaTurmas;
    
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
    public ArrayList<Professor> getListaProfessores() {
        return listaProfessores;
    }
    public void setListaProfessores(ArrayList<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }
    public ArrayList<Turma> getListaTurmas() {
        return listaTurmas;
    }
    public void setListaTurmas(ArrayList<Turma> listaTurmas) {
        this.listaTurmas = listaTurmas;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void adicionarTurma(Turma turma){
        this.listaTurmas.add(turma);
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
