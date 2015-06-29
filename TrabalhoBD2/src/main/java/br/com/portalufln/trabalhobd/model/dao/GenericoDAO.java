package br.com.portalufln.trabalhobd.model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericoDAO<T, ID extends Serializable> {
    void salvar(T objeto);
    void alterar(T objeto);
    void remover(T objeto);
    List<T> buscarTodos();
    T buscarId(ID id);
}
