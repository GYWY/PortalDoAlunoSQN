
package Model.DAO;

import java.util.ArrayList;


public interface GenericoDAO {
    
    void inserir(Object objeto);
    Object buscar(Object objeto);
    boolean alterar(Object objeto, Object busca);
    boolean remover(Object objeto);
    ArrayList<Object> listar(Object objeto);
    void salvarArquivo();
    void carregarArquivo();
}
