package Model.POJO;

import java.util.ArrayList;

public class Professor extends Pessoa {
    private Integer idProfessor;
    private String departamento;
    private ArrayList<Turma> listaTurmasMinistradas;
    
    public Professor(){
        this.listaTurmasMinistradas = new ArrayList<Turma>();
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

    public void setListaTurmasMinistradas(Turma turma) {
        this.listaTurmasMinistradas.add(turma);        
    }

    @Override
    public String toString() {        
        return (super.toString()+"\nDepartamento: " + departamento + "\n");
    }
    
}
