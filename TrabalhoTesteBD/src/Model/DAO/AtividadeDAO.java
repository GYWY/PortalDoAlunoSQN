

package Model.DAO;

import Model.POJO.Atividade;
import java.util.ArrayList;

public class AtividadeDAO implements GenericoDAO{
    
    ArrayList<Atividade> listaDeAtividades = new ArrayList<>();
    private static AtividadeDAO instancia = null;
    
    public static synchronized AtividadeDAO getInstancia() {
        if(instancia == null){
            instancia = new AtividadeDAO();
        }
        return instancia;
    }

    @Override
    public void inserir(Object objeto) {
        Atividade atividade = (Atividade) objeto;
        listaDeAtividades.add(atividade);
    }

    @Override
    public Object buscar(Object objeto) {
   
        if(objeto instanceof String){
            String tipo = (String) objeto;
            for(Atividade atividade : listaDeAtividades){
                if(atividade.getNome().contains(tipo))
                    return atividade;
            }            
        }
        else if(objeto instanceof Long){
            Long id =(Long) objeto;
            for(Atividade atividade : listaDeAtividades){
                if(atividade.getId().equals(id)){
                    return atividade;
                }
            }
        }
        return null;  
    
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaDeAtividades;
    }
    
    @Override
    public void alterar(Object objeto) {
        for(Atividade atividade : listaDeAtividades){
            if(atividade.equals(objeto))
                atividade = (Atividade) objeto;
        }
    }
    
}
