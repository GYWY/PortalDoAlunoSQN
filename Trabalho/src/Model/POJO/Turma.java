package Model.POJO;

import java.util.ArrayList;
import java.util.Objects;

public class Turma {
    
    private Integer idTurma;
    private Long ano;
    private Integer periodo;
    private String local;
    private String horario;
    private Integer vaga;
    private Professor professor;
    private Disciplina disciplina;
    private ArrayList<Aluno> listaAlunos;
    private ArrayList<Atividade> listaDeAtividade;

    public Turma(){
        this.listaAlunos = new ArrayList<Aluno>();
        this.listaDeAtividade = new ArrayList<Atividade>();
    }
    
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
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
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.disciplina);
        return hash;
    }
    
    

    @Override
    public String toString() {
        return ("Turma ID: " + idTurma + "\nAno: " + ano + "\nPeríodo: " + periodo + "\nLocal: " + local + "\nHorário: " + horario + "\nVagas: " + vaga);
    } 
}