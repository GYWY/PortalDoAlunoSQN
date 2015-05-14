package Model.POJO;

import java.util.ArrayList;

public class Aluno extends Pessoa {
    private Integer id;
    private Falta falta;
    private Nota notaFinal;
    private ArrayList<Turma> listaTurmasMatriculadas;
    private ArrayList<Atividade> listaAtividadesRealizadas;

    public ArrayList<Turma> getListaTurmasMatriculadas() {
        return listaTurmasMatriculadas;
    }

    public void setListaTurmasMatriculadas(ArrayList<Turma> listaTurmasMatriculadas) {
        this.listaTurmasMatriculadas = listaTurmasMatriculadas;
    }

    public ArrayList<Atividade> getListaAtividadesRealizadas() {
        return listaAtividadesRealizadas;
    }

    public void setListaAtividadesRealizadas(ArrayList<Atividade> listaAtividadesRealizadas) {
        this.listaAtividadesRealizadas = listaAtividadesRealizadas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Falta getFalta() {
        return falta;
    }

    public void setFalta(Falta falta) {
        this.falta = falta;
    }

   
    public Nota getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Nota notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return ("Id: " + id + "\nFalta: " + falta);
    }
    
}