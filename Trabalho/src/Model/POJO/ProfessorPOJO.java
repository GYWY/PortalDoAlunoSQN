package Model.POJO;

import java.util.ArrayList;

public class ProfessorPOJO extends PessoaPOJO {
    private Integer idProfessor;
    private String departamento;
    private ArrayList<TurmaPOJO> listaTurmasMinistradas;
    private ArrayList<DisciplinaPOJO> listaDisciplinas;
    
    public ProfessorPOJO(){
        this.listaTurmasMinistradas = new ArrayList<>();
        this.listaDisciplinas = new ArrayList<>();
    }
    
    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public ArrayList<DisciplinaPOJO> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(ArrayList<DisciplinaPOJO> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public ArrayList<TurmaPOJO> getListaTurmasMinistradas() {
        return listaTurmasMinistradas;
    }

    public void setListaTurmasMinistradas(ArrayList<TurmaPOJO> listaTurmasMinistradas) {
        this.listaTurmasMinistradas = listaTurmasMinistradas;
    }
    
    public void adicionarDisciplina(Object disciplina){
        if(disciplina instanceof String){
            DisciplinaPOJO novaDisciplina = new DisciplinaPOJO();
            
            novaDisciplina.setNome((String) disciplina);
            this.listaDisciplinas.add((DisciplinaPOJO) novaDisciplina);
        }
        else{
            this.listaDisciplinas.add((DisciplinaPOJO) disciplina);
        }    
    }
}
