package Model.POJO;

public class Aluno extends Pessoa {
    private Integer id;
    private Falta falta;
    private Nota notaFinal;
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Falta getFalta() {
        return falta;
    }

    public void setFalta(Falta falta) {
        this.falta = falta;
    }

   
    public Nota getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Nota notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return ("Id: " + id + "\nFalta: " + falta);
    }
    
}