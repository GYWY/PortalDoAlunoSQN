package Model.POJO;

import java.util.ArrayList;

public class AlunoPOJO extends PessoaPOJO {
    private FaltaPOJO falta;
    private NotaPOJO notaFinal;
    private ArrayList<TurmaPOJO> listaTurmasMatriculadas;
    private ArrayList<AtividadePOJO> listaAtividadesRealizadas;
    
    public AlunoPOJO(String nome, String cpf){
        super(nome,cpf);
        this.falta = falta;
        this.notaFinal = notaFinal;
        listaTurmasMatriculadas = new ArrayList<TurmaPOJO>();
        listaAtividadesRealizadas = new ArrayList<AtividadePOJO>();
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
 
    
}