

package Model.DAO;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T,ID extends Serializable> {
    void salvar(T objeto);
    void remover(T objeto);
    List<T> listar();
    T buscarPorId(ID id);
    
}
