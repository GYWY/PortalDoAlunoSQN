package br.com.portalufln.trabalhobd.model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ATIVIDADE")
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;
    
    @Column
    private String tipo;
    
    @Column
    private String dia;
    
    @Column
    private Double valor;
    
    @OneToMany
    private List<Nota> listaNotas;
    
    @ManyToOne
    private Turma turma;
    
    public Atividade( ){
        this.listaNotas = new ArrayList<Nota>();
    }

    public Atividade(String nome, String tipo, String dia, Double valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.dia = dia;
        this.valor = valor;
    }
    
    public Atividade(String nome, String tipo, String dia, Double valor, Turma turma) {
        this(nome,tipo,dia,valor);
        this.turma = turma;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    public void addNotas(Nota nota) {
        this.listaNotas.add(nota);
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Nome: " + nome + "\nTipo: " + tipo + "\nData: " + dia + "\nValor: " + valor);
    }
    
}
