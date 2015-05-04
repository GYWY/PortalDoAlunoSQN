package POJO;

import java.util.Objects;

public class Disciplina {
    //Atributos
    public String nome;
    public String ementa;
    public Integer cargaHoraria;

    //Construtor
    public Disciplina(String nome, String ementa, Integer cargaHoraria) {
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
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
 
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Disciplina))
            return false;
        Disciplina disciplina = (Disciplina)obj;
        return (this.nome == disciplina.getNome());
    }

}
