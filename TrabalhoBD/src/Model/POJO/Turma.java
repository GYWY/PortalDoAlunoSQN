package Model.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TURMA")
public class Turma implements Serializable {
    
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
    
    @ManyToOne
    @JoinColumn(name = "PROFESSOR_ID")
    private Professor professor;
    
    @ManyToOne
    @JoinColumn(name = "DISCIPLINA_ID")
    private Disciplina disciplina;
    
    @OneToMany(mappedBy = "TURMA")
    private ArrayList<Atividade> listaAtividades;
    
    @OneToMany(mappedBy = "TURMA")
    private ArrayList<Falta> listaFaltas;
    
    @OneToMany(mappedBy = "TURMA")
    private ArrayList<Aluno> listaAlunos;
    
    public Turma() {
        this.listaAtividades = new ArrayList<Atividade>();
        this.listaFaltas = new ArrayList<Falta>();
        this.listaAlunos = new ArrayList<Aluno>();
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

    public Professor getProfessor() {
        return professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public ArrayList<Atividade> getListaAtividades() {
        return listaAtividades;
    }

    public void setListaAtividades(Atividade atividade) {
        this.listaAtividades.add(atividade);        
    }
    
    public ArrayList<Falta> getListaFaltas() {
        return listaFaltas;
    }

    public void setListaFaltas(Falta falta) {
        this.listaFaltas.add(falta);        
    }
    
    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(Aluno aluno) {
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
        return ("Turma ID: " + id + "\nAno: " + ano + "\nPeríodo: " + periodo + "\nLocal: " + sala + "\nHorário: " + horario + "\nVagas: " + vaga + "\n");
    }
    
}
