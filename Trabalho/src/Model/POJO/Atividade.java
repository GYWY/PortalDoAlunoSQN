package Model.POJO;

public class Atividade {
    //atributos
    private String nome;
    private String tipo;
    private String data;
    private Double valor;
    private Integer id; 
    private Nota nota;
    private Turma turma;


    public Nota getNota() {
        return nota;
    }

    public Turma getTurma() {
        return turma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    //gets e setters
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setId(int contador) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ("Nome do aluno: " + nome + "\nTipo da atividade: " + tipo + "\nData: " + data + "\nValor: " + valor + "\nId: " + id);
    }
    
}
