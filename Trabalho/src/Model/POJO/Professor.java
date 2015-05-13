package Model.POJO;

import java.util.ArrayList;

public class Professor extends Pessoa {
    private Integer idProfessor;
    private String departamento;
    private ArrayList<Turma> listaTurmasMinistradas;
    private ArrayList<Disciplina> listaDisciplinas;
    
    public Professor(){
        this.listaTurmasMinistradas = new ArrayList<>();
        this.listaDisciplinas = new ArrayList<>();
    }
    
    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public ArrayList<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(ArrayList<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
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
    
    public void adicionarDisciplina(Object disciplina){
        if(disciplina instanceof String){
            Disciplina novaDisciplina = new Disciplina();
            
            novaDisciplina.setNome((String) disciplina);
            this.listaDisciplinas.add((Disciplina) novaDisciplina);
        }
        else{
            this.listaDisciplinas.add((Disciplina) disciplina);
        }    
    }
}
