package Model.POJO;

import java.util.ArrayList;

public class Turma {
    
    private Integer idTurma;
    private Long ano;
    private Integer periodo;
    private String local;
    private String horario;
    private Integer vaga;
    private Professor professor;
    private Disciplina disciplina;
    private ArrayList<Atividade> listaDeAtividade;
    private ArrayList<Falta> listaDeFalta;

    public Turma(){
        this.listaDeAtividade = new ArrayList<Atividade>();
        this.listaDeFalta = new ArrayList<Falta>();
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
        if(!(obj instanceof Turma))
            return false;
        Turma turma = (Turma)obj;
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

    public ArrayList<Atividade> getListaDeAtividade() {
        return listaDeAtividade;
    }

    public void setListaDeAtividade(ArrayList<Atividade> listaDeAtividade) {
        this.listaDeAtividade = listaDeAtividade;
    }

    public ArrayList<Falta> getListaDeFalta() {
        return listaDeFalta;
    }

    public void setListaDeFalta(ArrayList<Falta> listaDeFalta) {
        this.listaDeFalta = listaDeFalta;
    }
}