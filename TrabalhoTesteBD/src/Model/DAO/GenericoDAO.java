
package Model.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface GenericoDAO {
    
    void inserir(Object objeto);
    void alterar(Object objeto);
    Object buscar(Object objeto);
    ArrayList<Object> listar();
}
