package Model.POJO;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="PESSOA")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="FROM_CLASS", discriminatorType=DiscriminatorType.STRING)

public abstract class Pessoa implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
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
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//public class Pessoa {
//    private String nome;
//    private String cpf;
//    
//    @Override
//    public boolean equals(Object objeto){
//        if(this == objeto){
//            return true;
//        }
//        else if(!(objeto instanceof Pessoa)){
//            return false;
//        }
//        else{
//            Pessoa pessoa = (Pessoa) objeto;
//            return this.cpf.equals(pessoa.getCpf());
//        }
//    }
//    
//    @Override
//    public int hashCode() {
//        return cpf.hashCode();
//    }
//    
//    public String getNome() {
//        return nome;
//    }
//    
//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//    
//    public void setCpf(String cpf) {
//        this.cpf = cpf;
//    }
//
//    @Override
//    public String toString() {
//        return ("Nome: " + nome + "\nCPF: " + cpf);
//    }
//
//}
