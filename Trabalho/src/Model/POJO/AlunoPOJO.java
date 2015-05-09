package Model.POJO;

import java.util.ArrayList;

public class AlunoPOJO extends PessoaPOJO {
    private Integer id;
    private FaltaPOJO falta;
    private NotaPOJO notaFinal;
    private ArrayList<TurmaPOJO> listaTurmasMatriculadas;
    private ArrayList<AtividadePOJO> listaAtividadesRealizadas;
    
    public AlunoPOJO(String nome, String cpf, Integer id){
        super(nome,cpf);
        this.id = id;
        this.falta = falta;
        this.notaFinal = notaFinal;
        this.listaTurmasMatriculadas = new ArrayList<TurmaPOJO>();
        this.listaAtividadesRealizadas = new ArrayList<AtividadePOJO>();
    }

    public ArrayList<TurmaPOJO> getListaTurmasMatriculadas() {
        return listaTurmasMatriculadas;
    }

    public void setListaTurmasMatriculadas(ArrayList<TurmaPOJO> listaTurmasMatriculadas) {
        this.listaTurmasMatriculadas = listaTurmasMatriculadas;
    }

    public ArrayList<AtividadePOJO> getListaAtividadesRealizadas() {
        return listaAtividadesRealizadas;
    }

    public void setListaAtividadesRealizadas(ArrayList<AtividadePOJO> listaAtividadesRealizadas) {
        this.listaAtividadesRealizadas = listaAtividadesRealizadas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FaltaPOJO getFalta() {
        return falta;
    }

    public void setFalta(FaltaPOJO falta) {
        this.falta = falta;
    }

   
    public NotaPOJO getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(NotaPOJO notaFinal) {
        this.notaFinal = notaFinal;
    }
    
       
    
}