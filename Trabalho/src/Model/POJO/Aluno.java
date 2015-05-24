package Model.POJO;

import java.util.ArrayList;

public class Aluno extends Pessoa {
    private Integer id;
    private ArrayList<Falta> listaFaltas;
    private ArrayList<Nota> listaNotas;
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Falta> getListaFaltas() {
        return listaFaltas;
    }

    public void setListaFaltas(ArrayList<Falta> listaFaltas) {
        this.listaFaltas = listaFaltas;
    }

    public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(ArrayList<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }
    
    public void adicionarNota(Nota nota) {
        this.listaNotas.add(nota);        
    }
    
    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", listaFaltas=" + listaFaltas + ", listaNotas=" + listaNotas + '}';
    }
    
}