package Model.POJO;

import java.util.ArrayList;

public class ProfessorPOJO extends PessoaPOJO {
    private String departamento;
    private ArrayList<TurmaPOJO> listaTurmasMinistradas;
    
    public ProfessorPOJO(String nome, String cpf,String departamento) {
        super(nome, cpf);
        this.departamento = departamento;     
        listaTurmasMinistradas = new ArrayList<TurmaPOJO>();
    }

    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
}
