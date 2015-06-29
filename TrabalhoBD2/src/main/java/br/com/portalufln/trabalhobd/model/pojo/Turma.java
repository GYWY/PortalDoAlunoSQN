package br.com.portalufln.trabalhobd.model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TURMA")
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long ano;
    
    @Column
    private Integer periodo;
    
    @Column
    private String sala;
    
    @Column
    private String horario;
    
    @Column
    private Integer vaga;
    
    @OneToMany
    private List<Atividade> listaAtividades;
    
    @ManyToOne
    private Disciplina disciplina;
    
    @OneToMany
    private List<Falta> listaFaltas;
    
    @ManyToOne
    private Professor professor;
    
    @ManyToMany
    private List<Aluno> listaAlunos;
    
    public Turma() {
        this.listaAtividades = new ArrayList<Atividade>();
        this.listaFaltas = new ArrayList<Falta>();
        this.listaAlunos = new ArrayList<Aluno>();
    }

    public Turma(Long ano, Integer periodo, String sala, String horario, Integer vaga) {
        this.ano = ano;
        this.periodo = periodo;
        this.sala = sala;
        this.horario = horario;
        this.vaga = vaga;
    }

    private Turma(Long ano, Integer periodo, String sala, String horario, Integer vaga, Disciplina disciplina, Professor professor) {
        this(ano,periodo,sala,horario,vaga);
        this.disciplina = disciplina;
        this.professor = professor;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getVaga() {
        return vaga;
    }

    public void setVaga(Integer vaga) {
        this.vaga = vaga;
    }

    public List<Atividade> getListaAtividades() {
        return listaAtividades;
    }

    public void addAtividades(Atividade atividade) {
        this.listaAtividades.add(atividade);
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Falta> getListaFaltas() {
        return listaFaltas;
    }

    public void addFaltas(Falta falta) {
        this.listaFaltas.add(falta);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void addAlunos(Aluno aluno) {
        this.listaAlunos.add(aluno);
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
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Número: " + id + "\nAno: " + ano + "\nPeríodo: " + periodo + "\nSala: " + sala + "\nHorário: " + horario + "\nVagas: " + vaga);
    }
    
}
