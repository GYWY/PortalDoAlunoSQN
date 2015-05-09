package Model.POJO;

import java.util.ArrayList;

public class ProfessorPOJO extends PessoaPOJO {
    private Integer idProfessor;
    private String departamento;
    private ArrayList<TurmaPOJO> listaTurmasMinistradas;
    private ArrayList<DisciplinaPOJO> listaDisciplinas;
    
    public ProfessorPOJO(String nome, String cpf,String departamento, Integer idProfessor) {
        super(nome, cpf);
        this.idProfessor=idProfessor;
        this.departamento = departamento;     
        listaTurmasMinistradas = new ArrayList<>();
        listaDisciplinas = new ArrayList<>();
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
}
