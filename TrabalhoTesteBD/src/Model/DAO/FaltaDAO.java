package Model.DAO;

import Model.POJO.Falta;
import java.util.ArrayList;

public class FaltaDAO implements GenericoDAO {

    ArrayList<Falta> listaFaltas = new ArrayList<>();
    private static FaltaDAO instancia = null;

    public static FaltaDAO getInstancia() {
        if(instancia == null){
            instancia = new FaltaDAO();
        }
        return instancia;
    }
    
    @Override
    public void inserir(Object objeto) {
        Falta falta = (Falta) objeto;
        listaFaltas.add(falta); 
    }

    @Override
    public Object buscar(Object objeto) {
             
        if(objeto instanceof String){
            String tipo = (String) objeto;
            for(Falta falta : listaFaltas){
                if(falta.getAluno().getNome().contains(tipo))
                    return falta;
            }            
        }        
        return null;   
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaFaltas;
    }

    @Override
    public void alterar(Object objeto) {
        for(Falta falta : listaFaltas){
            if(falta.equals(objeto))
                falta = (Falta) objeto;
        }
    }
    
}
