
package Model.DAO;

import java.util.ArrayList;


public interface GenericoDAO {
    
    void inserir(Object objeto);
    Object buscar(Object objeto);
    void alterar(Object objeto);
    boolean remover(Object objeto);
    ArrayList<Object> listar(Object objeto, Object busca);
    void salvarArquivo();
    void carregarArquivo();
}
