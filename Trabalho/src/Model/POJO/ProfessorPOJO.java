package Model.POJO;

import java.util.ArrayList;

public class ProfessorPOJO extends PessoaPOJO {
    private String departamento;
    private ArrayList<TurmaPOJO> listaTurmasMinistradas;
    
    public ProfessorPOJO(String nome, String cpf,String departamento) {
        super(nome, cpf);
        this.departamento = departamento;     
        listaTurmasMinistradas = new ArrayList<>();
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
