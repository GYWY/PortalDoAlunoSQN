/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.DisciplinaPOJO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DisciplinaDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
    
    private ArrayList<DisciplinaPOJO> disciplinas = null;
    private static DisciplinaDAOImpl instancia;
    
    public static synchronized DisciplinaDAOImpl getInstancia(){
        if(instancia == null)
            instancia = new DisciplinaDAOImpl();
        return instancia;
    } 
    
    @Override
    public void salvar(T objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(T objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T buscarPorId(ID id) {
        for (DisciplinaPOJO disciplina : disciplinas) {
            if (disciplina.getNome() == id) {
                return (T) disciplina;
            }
        }
       return null;
    }
    
}