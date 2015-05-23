package Model.POJO;

import java.util.ArrayList;

public class Professor extends Pessoa {
    private Integer idProfessor;
    private String departamento;
    private ArrayList<Turma> listaTurmasMinistradas;
    
    public Professor(){
        this.listaTurmasMinistradas = new ArrayList<>();
    }
    
    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
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

    public void setListaTurmasMinistradas(ArrayList<Turma> listaTurmasMinistradas) {
        this.listaTurmasMinistradas = listaTurmasMinistradas;
    }
}
