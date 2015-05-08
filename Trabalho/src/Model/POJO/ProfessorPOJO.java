package Model.POJO;

public class ProfessorPOJO extends PessoaPOJO {
    private String departamento;
    
    public ProfessorPOJO(String nome, String cpf) {
        super(nome, cpf);
    }

    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
}
