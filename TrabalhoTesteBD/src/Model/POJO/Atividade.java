package Model.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ATIVIDADE")
public class Atividade implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private String nome;
    private String tipo;
    private String data;
    private Double valor; 
    
    @ManyToOne
    private Turma turma;
    
    @OneToMany
    private ArrayList<Nota> listaNotas;
    
    public Atividade() {
        this.listaNotas = new ArrayList<Nota>();
    }
    
    public Turma getTurma() {
        return turma;
    }

    public Long getId() {
        return id;
    }

     public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }

    public String getNome() {
        return nome;
    }

    public void setData(String data) {
        this.data = data;
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
    
    public Double getValor() {
        return valor;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setId(Long contador) {
        this.id = contador;
    }

    public void setListaNota(Nota nota) {
        this.listaNotas.add(nota);        
    }
    
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
     
    public void setListaNotas(ArrayList<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }
    
    @Override
    public String toString() {
        return ("Nome do aluno: " + nome + "\nTipo da atividade: " + tipo + "\nData: " + data + "\nValor: " + valor + "\n");
    }
    
}
