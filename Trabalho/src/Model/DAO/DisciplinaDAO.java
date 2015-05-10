package Model.DAO;

import Model.POJO.DisciplinaPOJO;
import java.util.ArrayList;

public class DisciplinaDAO implements GenericoDAO{
    
    private ArrayList<DisciplinaPOJO> listaDisciplina = new ArrayList<>();
    private static DisciplinaDAO instancia = null;
    
    public static synchronized DisciplinaDAO getInstancia() {
        if(instancia == null){
            instancia = new DisciplinaDAO();
        }
        return instancia;
    }

    @Override
    public void inserir(Object objeto) {
        
         DisciplinaPOJO disciplina = (DisciplinaPOJO) objeto;
         
         int contador = listaDisciplina.size();
         contador++;
         disciplina.setId(contador);
         listaDisciplina.add(disciplina);
    }

    @Override
    public Object buscar(Object objeto) {
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(DisciplinaPOJO disciplina : listaDisciplina){
                if(disciplina.getNome().contains(nome))
                    return disciplina;
            }
        }
        else if(objeto instanceof Integer){
            Integer id =(Integer) objeto;
            for(DisciplinaPOJO disciplina : listaDisciplina){
                if(disciplina.getId().equals(objeto)){ //ver id
                    return disciplina;
                }
            }
        }
        return null;
    }

    @Override
    public boolean alterar(Object objeto, Object busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Object objeto) {
        DisciplinaPOJO disciplina = (DisciplinaPOJO) buscar(objeto);
        if(disciplina != null){
            listaDisciplina.remove(listaDisciplina.indexOf(disciplina));
            return true;
        }
        return false;    
    }

    @Override
    public ArrayList<Object> listar(Object objeto) {
        return (ArrayList<Object>)(Object)listaDisciplina;
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
