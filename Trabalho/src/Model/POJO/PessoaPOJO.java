package Model.POJO;

import java.util.Objects;

public class PessoaPOJO {
    private String nome;
    private String cpf;
    
    public PessoaPOJO(String nome,String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    
    @Override
    public boolean equals(Object objeto){
        if(this == objeto){
            return true;
        }
        else if(!(objeto instanceof PessoaPOJO)){
            return false;
        }
        else{
            PessoaPOJO pessoa = (PessoaPOJO) objeto;
            return this.cpf.equals(pessoa.getCpf());
        }
    }
    
    @Override
    public int hashCode() {
        return cpf.hashCode();
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
