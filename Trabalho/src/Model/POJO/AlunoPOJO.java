package Model.POJO;

public class AlunoPOJO extends PessoaPOJO {
    private FaltaPOJO falta;
    private NotaPOJO notaFinal;

    public AlunoPOJO(String nome, String cpf) {
        super(nome, cpf);
    }
}
