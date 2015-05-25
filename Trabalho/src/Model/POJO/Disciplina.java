package Model.POJO;

import java.util.ArrayList;
import java.util.Objects;

public class Disciplina {

    private Integer id;
    private String nome;
    private String ementa;
    private Integer cargaHoraria;
    private ArrayList<Turma> listaTurmas;

    /*
    *Construtor da classe
    */
    
    public Disciplina() {
        this.listaTurmas = new ArrayList<Turma>();
    }
    
    /**
     * Método para retornar o nome da Disciplina
     *
     * @return nome - nome do Disciplina
     */
    
    public String getNome() {
        return nome;
    }
    
    /**
     * Método para alterar o nome da Disciplina
     *
     * @return nome - nome do Disciplina
     */
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método que retorna a ementa da Disciplina
     *
     * @return ementa - ementa  da Disciplina
     */
    
    public String getEmenta() {
        return ementa;
    }
    /**
     * Método para alterar a ementa da Disciplina
     *
     * @param ementa - nome da Disciplina
     */
    
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }
    /**
     * Método para retornar a carga horária da Disciplina
     *
     * @return cargaHoraria - cargaHoraria do Disciplina
     */
    
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    
    /**
     * Método para alterar a carga horária da Disciplina
     *
     * @param cargaHoraria - carga horária da Disciplina
     */
    
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    } 
    
    /**
     * Método para retornar as turmas pertencentes a Disciplina
     *
     * @return listaTurmas - lista de turmas da Disciplina
    */
    
    public ArrayList<Turma> getListaTurmas() {
        return listaTurmas;
    }
    
    /**
     * Método para alterar as turmas pertencentes a Disciplina, adicionando uma
     * nova turma a lista
     *
     * @param turma - turma a ser adicionada na disciplina
    */
    
    public void setListaTurmas(Turma turma) {
        this.listaTurmas.add(turma);
    }
    
    /**
     * Método para retornar o id da Disciplina
     *
     * @return id - id da Disciplina
    */
    
    public Integer getId() {
        return id;
    }
    
    /**
     * Método para alterar o id da Disciplina
     *
     *@param id - id da Disciplina
    */
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    /*
    *Mètodo que formata todos os dados da disciplina em uma única string, para que assim
    *possamos salvar os dados em um único padrão
    *
    *@return "Disciplina: " + nome +"\nCarga Horária: " + cargaHoraria + "\nEmenta: " + ementa + "\n"
    *String transformada
    */
    
    @Override
    public String toString() {
        return ("Disciplina: " + nome +"\nCarga Horária: " + cargaHoraria + "\nEmenta: " + ementa + "\n");
    }
    
    /**
     *Método criado com o objetivo de possibibilitar tanto a comparaçao por nome
     * como por objeto(entidade)
     * @param obj
     * @return true of false - dependendo do objeto passado como parâmetro
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Disciplina))
            return false;
        Disciplina disciplina = (Disciplina)obj;
        return this.nome.equals(disciplina.getNome());
    }
    
    /**
     *Sobrescrita do método hashcode
     * @return
     */
    
    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}
