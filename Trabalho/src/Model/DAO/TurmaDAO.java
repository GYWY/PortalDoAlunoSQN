package Model.DAO;

import Model.POJO.Turma;
import java.util.ArrayList;


public class TurmaDAO implements GenericoDAO{

    private ArrayList<Turma> listaDeTurmas = new ArrayList<>();
    private static TurmaDAO instancia = null;
    
    public static synchronized TurmaDAO getInstancia() {
        if(instancia == null){
            instancia = new TurmaDAO();
        }
        return instancia;
    }
      
    @Override
    public void inserir(Object objeto) {
         Turma turma = (Turma) objeto;
         int contador = listaDeTurmas.size();
         contador++;
         turma.setIdTurma(contador);
         listaDeTurmas.add(turma);
    }

    @Override
    public Object buscar(Object objeto) {
        Integer id = (Integer) objeto;
        for(Turma turma : listaDeTurmas){
            if(turma.getIdTurma().equals(objeto)){
                return turma;
            }
        }

        return null; 
    }

    @Override
    public boolean alterar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Object objeto) {
        Turma turma = (Turma) buscar(objeto);
        if(turma != null){
            listaDeTurmas.remove(listaDeTurmas.indexOf(turma));
            return true;
        }
        return false;   
    }

    @Override
    public ArrayList<Object> listar() {
         return (ArrayList<Object>)(Object)listaDeTurmas;
    }

    public void salvarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void carregarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
