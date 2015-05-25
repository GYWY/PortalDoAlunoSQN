package Model.POJO;

import java.util.ArrayList;

public class Atividade {
    //atributos
    private String nome;
    private String tipo;
    private String data;
    private Double valor;
    private Integer id; 
    private ArrayList<Nota> listaNotas;
    private Turma turma;

    public Atividade() {
        this.listaNotas = new ArrayList<Nota>();
    }
  
    public Turma getTurma() {
        return turma;
    }

    public Integer getId() {
        return id;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setId(int contador) {
        this.id = contador;
    }

    public void setListaNota(Nota nota) {
        this.listaNotas.add(nota);        
    }
    
    @Override
    public String toString() {
        return ("Nome do aluno: " + nome + "\nTipo da atividade: " + tipo + "\nData: " + data + "\nValor: " + valor + "\nId: " + id);
    }
    
}
