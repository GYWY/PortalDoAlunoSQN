

package Model.DAO;

import Model.POJO.AtividadePOJO;
import java.util.ArrayList;


public class AtividadeDAO implements GenericoDAO{
    
    ArrayList<AtividadePOJO> listaDeAtividades = new ArrayList<>();
    private static AtividadeDAO instancia = null;
    
    public static synchronized AtividadeDAO getInstancia() {
        if(instancia == null){
            instancia = new AtividadeDAO();
        }
        return instancia;
    }

    @Override
    public void inserir(Object objeto) {
        AtividadePOJO atividade = (AtividadePOJO) objeto;
         int contador = listaDeAtividades.size();
         contador++;
         atividade.setId(contador);
         listaDeAtividades.add(atividade);
        
    }

    @Override
    public Object buscar(Object objeto) {
   
        if(objeto instanceof String){
            String tipo = (String) objeto;
            for(AtividadePOJO atividade : listaDeAtividades){
                if(atividade.getTipo().contains(tipo))
                    return atividade;
            }            
        }
        
        return null;      
    
    }

    @Override
       public boolean alterar(Object objeto, Object busca) {
        AtividadePOJO atividade = (AtividadePOJO) buscar(objeto);
        AtividadePOJO altera = (AtividadePOJO) objeto;
        if(atividade != null){
            int indice = listaDeAtividades.indexOf(atividade);
            listaDeAtividades.add(indice, altera);
            return true;
        }
        return false;
    }

    @Override
    public boolean remover(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> listar(Object objeto) {
        return (ArrayList<Object>)(Object)listaDeAtividades;
    }

    @Override
    public void salvarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void carregarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
