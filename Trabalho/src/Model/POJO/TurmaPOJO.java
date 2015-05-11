package Model.POJO;

import java.util.ArrayList;

public class TurmaPOJO {
    
    private Integer idTurma;
    private Long ano;
    private Integer periodo;
    private String local;
    private String horario;
    private Integer vaga;
    private ProfessorPOJO professor;
    private DisciplinaPOJO disciplina;
    private ArrayList<AlunoPOJO> listaAlunos;
    private ArrayList<AtividadePOJO> listaDeAtividade;

    public ProfessorPOJO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorPOJO professor) {
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

    public DisciplinaPOJO getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaPOJO disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<AlunoPOJO> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<AlunoPOJO> listaAlunos) {
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
        if(this == obj)
            return true;
        if(!(obj instanceof TurmaPOJO))
            return false;
        TurmaPOJO turma = (TurmaPOJO)obj;
        return this.horario.equals(turma.getHorario());
    }
    
     @Override
    public int hashCode() {
        return horario.hashCode();
    }

    @Override
    public String toString() {
        return ("Turma ID: " + idTurma + "\nAno: " + ano + "\nPeríodo: " + periodo + "\nLocal: " + local + "\nHorário: " + horario + "\nVagas: " + vaga);
    } 
}