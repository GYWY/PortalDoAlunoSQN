
package Model.DAO;

import Model.POJO.AtividadePOJO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AtividadeDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private ArrayList<AtividadePOJO> atividades = null;
    private static AtividadeDAOImpl instancia = null;

    public AtividadeDAOImpl() {
        atividades = new ArrayList<AtividadePOJO>();
    }

    public static synchronized AtividadeDAOImpl getInstancia() {
        if(instancia == null){
            instancia = new AtividadeDAOImpl();
        }
        
        return instancia;
    }

    
    @Override
    public void salvar(T objeto) {
       this.atividades.add((AtividadePOJO) objeto);
    }

    @Override
    public void remover(T objeto) {
        this.atividades.remove((AtividadePOJO) objeto);
    }

    @Override
    public List<T> listar() {
        for(int i = 0; i<atividades.size(); i++)
            //printa atividades
    }

    @Override
    public T buscarPorId(ID id) {
        
    }
    
}