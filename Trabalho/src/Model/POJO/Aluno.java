package Model.POJO;

import java.util.ArrayList;

public class Aluno extends Pessoa {
    
    private Integer id;
    private ArrayList<Falta> listaFaltas;
    private ArrayList<Nota> listaNotas;

    /**
     * Método para instanciar a lista de faltas e notas do Aluno
     */
    public Aluno() {
        this.listaFaltas = new ArrayList<Falta>();
        this.listaNotas = new ArrayList<Nota>();
    } 
    
    /**
     * Método para retornar o Id do Aluno
     *
     * @return Integer - id - id do aluno
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Método para alterar o ID do Aluno
     *
     * @param id - id atribuido ao Aluno
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Método para retornar a Lista de Faltas
     *
     * @return ArrayList - lista - Lista de Faltas
     */
    public ArrayList<Falta> getListaFaltas() {
        return listaFaltas;
    }
    
    /**
     * Método para alterar o ID do Aluno
     *
     * @param listaFaltas - Lista de Faltas atribuido ao Aluno
     */
    public void setListaFaltas(ArrayList<Falta> listaFaltas) {
        this.listaFaltas = listaFaltas;
    }
    
    /**
     * Método para retornar a Lista de Faltas
     *
     * @return ArrayList - lista - Lista de Faltas
     */
    public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }
    
    /**
     * Método para alterar o Lista de Notas do Aluno
     *
     * @param listaNotas -  Lista de Notas atribuido ao Aluno
     */
    public void setListaNotas(ArrayList<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }
    
    /**
     * O metodo adiciona uma nota
     *
     * @param nota recebe um nota como parametro para adicionar na lista de notas
     */
    public void adicionarNota(Nota nota) {
        this.listaNotas.add(nota);        
    }

    /**
     * O metodo adiciona uma nota
     *
     * @param falta recebe uma falta como parametro para adicionar na lista de fatas
     */
    public void adicionarFalta(Falta falta) {
        this.listaFaltas.add(falta);        
    }
    
    /**
     * Sobrescrição do método toString para imprimir os atributos
     *
     * @return (impressão) - O método retorna o que será impresso para o usuario
     */
    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", listaFaltas=" + listaFaltas + ", listaNotas=" + listaNotas + '}';
    }
    
}