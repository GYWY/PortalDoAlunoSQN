package Model.DAO;

import Model.POJO.TurmaPOJO;
import java.util.ArrayList;


public class TurmaDAO implements GenericoDAO{

    private ArrayList<TurmaPOJO> listaDeTurmas = new ArrayList<>();
    private static TurmaDAO instancia = null;
    
    public static synchronized TurmaDAO getInstancia() {
        if(instancia == null){
            instancia = new TurmaDAO();
        }
        return instancia;
    }
      
    @Override
    public void inserir(Object objeto) {
         TurmaPOJO turma = (TurmaPOJO) objeto;
         int contador = listaDeTurmas.size();
         contador++;
         turma.setIdTurma(contador);
         listaDeTurmas.add(turma);
    }

    @Override
    public Object buscar(Object objeto) {
        Integer id =(Integer) objeto;
        for(TurmaPOJO turma : listaDeTurmas){
            if(turma.getIdTurma().equals(objeto)){
                return turma;
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
        TurmaPOJO turma = (TurmaPOJO) buscar(objeto);
        if(turma != null){
            listaDeTurmas.remove(listaDeTurmas.indexOf(turma));
            return true;
        }
        return false;   
    }

    @Override
    public ArrayList<Object> listar(Object objeto) {
         return (ArrayList<Object>)(Object)listaDeTurmas;
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
