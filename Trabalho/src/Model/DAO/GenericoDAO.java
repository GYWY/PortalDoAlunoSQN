
package Model.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface GenericoDAO {
    
    void inserir(Object objeto);
    Object buscar(Object objeto);
    boolean alterar(Object objeto);
    boolean remover(Object objeto);
    ArrayList<Object> listar();
}
