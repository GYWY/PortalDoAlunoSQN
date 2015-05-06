package Model.POJO;

public class FaltaPOJO {
    //Atributos
    public Integer faltas;

    //Construtor
    public FaltaPOJO(Integer faltas) {
        this.faltas = faltas;
    }

    //Getters e Setters
    public Integer getFaltas() {
        return faltas;
    }
    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }
       
    //toString
    @Override
    public String toString() {
        return ("Número total de faltas: " + faltas);
    }
}
