package Model.POJO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TurmaPOJO {
    
    private Long ano;
    private Integer periodo;
    private String local;
    private String horario;
    private Integer vaga;
    private ProfessorPOJO professor;
    private DisciplinaPOJO disciplina;
    private List<AlunoPOJO> listaAluno;

    
    public TurmaPOJO(Long ano, Integer periodo, String local, String horario, Integer vaga, ProfessorPOJO professor, DisciplinaPOJO disciplina) {
        this.ano = ano;
        this.periodo = periodo;
        this.local = local;
        this.horario = horario;
        this.vaga = vaga;
        this.professor=professor;
        this.disciplina=disciplina;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.ano);
        hash = 59 * hash + Objects.hashCode(this.periodo);
        hash = 59 * hash + Objects.hashCode(this.local);
        hash = 59 * hash + Objects.hashCode(this.horario);
        hash = 59 * hash + Objects.hashCode(this.vaga);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TurmaPOJO other = (TurmaPOJO) obj;
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TurmaPOJO{" + "ano=" + ano + ", periodo=" + periodo + ", local=" + local + ", horario=" + horario + ", vaga=" + vaga + '}';
    }
    
      
}
