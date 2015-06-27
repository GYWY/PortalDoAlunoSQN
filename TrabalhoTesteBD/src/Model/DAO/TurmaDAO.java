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
         listaDeTurmas.add(turma);
    }

    @Override
    public Object buscar(Object objeto) {
        
        if(objeto instanceof Long){
            Long id = (Long) objeto;
            for(Turma turma : listaDeTurmas){
                if(turma.getIdTurma().equals(id)){
                    return turma;
                }
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Object> listar() {
         return (ArrayList<Object>)(Object)listaDeTurmas;
    }

    @Override
    public void alterar(Object objeto) {
        for(Turma turma : listaDeTurmas){
            if(turma.equals(objeto))
                turma = (Turma) objeto;
        }
    }
    
}

    

