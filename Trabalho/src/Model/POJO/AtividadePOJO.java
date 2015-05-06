package Model.POJO;

import java.util.Objects;

public class AtividadePOJO {
    //atributos
    private String nome;//verificar com equals se repete
    private String tipo;
    private String data;
    private Float valor;
    private AlunoPOJO aluno; 
    private LancamentoNotaPOJO nota;
    
    //construtor
    public AtividadePOJO(String tipo, AlunoPOJO aluno) {
        this.tipo = tipo; 
        this.aluno = aluno;
    }

    //gets e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
 
}
