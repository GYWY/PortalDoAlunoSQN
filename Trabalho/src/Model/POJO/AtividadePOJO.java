package Model.POJO;

public class AtividadePOJO {
    //atributos
    private String nome;
    private String tipo;
    private String data;
    private Float valor;
    private AlunoPOJO aluno; 
    private NotaPOJO nota;
    private TurmaPOJO turma;

    public AlunoPOJO getAluno() {
        return aluno;
    }

    public NotaPOJO getNota() {
        return nota;
    }

    public TurmaPOJO getTurma() {
        return turma;
    }

    public void setAluno(AlunoPOJO aluno) {
        this.aluno = aluno;
    }

    public void setNota(NotaPOJO nota) {
        this.nota = nota;
    }

    public void setTurma(TurmaPOJO turma) {
        this.turma = turma;
    }
    
    //construtor

    public AtividadePOJO(String nome, String tipo, String data, Float valor, AlunoPOJO aluno, NotaPOJO nota) {
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.aluno = aluno;
        this.nota = nota;
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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
 
}
