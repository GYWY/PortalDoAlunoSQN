package Model.POJO;

import java.util.Objects;

public class Pessoa {
    private String nome;
    private String cpf;
    
    @Override
    public boolean equals(Object objeto){
        if(this == objeto){
            return true;
        }
        else if(!(objeto instanceof Pessoa)){
            return false;
        }
        else{
            Pessoa pessoa = (Pessoa) objeto;
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

    @Override
    public String toString() {
        return ("Nome: " + nome + "\nCPF: " + cpf);
    }

}
