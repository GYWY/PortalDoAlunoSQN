package Model.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TURMA")
public class Turma implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer idTurma;
    
    private Long ano;
    private Integer periodo;
    private String local;
    private String horario;
    private Integer vaga;
    
    @OneToOne
    private Professor professor;
    
    @OneToOne
    private Disciplina disciplina;
    
    @OneToMany
    private ArrayList<Atividade> listaDeAtividade;
    
    @OneToMany
    private ArrayList<Falta> listaDeFalta;
    
    @OneToMany
    private ArrayList<Aluno> listaDeAluno;

    public Turma() {
        this.listaDeAtividade = new ArrayList<Atividade>();
        this.listaDeFalta = new ArrayList<Falta>();
        this.listaDeAluno = new ArrayList<Aluno>();
    }
    
    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    public ArrayList<Atividade> getListaDeAtividade() {
        return listaDeAtividade;
    }
    
    public void setListaDeAtividade(Atividade atividade){
        this.listaDeAtividade.add(atividade);
    }

    public void setListaFalta(Falta falta) {
        this.listaDeFalta.add(falta);        
    }   
    
     @Override
    public int hashCode() {
        return horario.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Turma ID: " + idTurma + "\nAno: " + ano + "\nPeríodo: " + periodo + "\nLocal: " + local + "\nHorário: " + horario + "\nVagas: " + vaga + "\n");
    } 

}
