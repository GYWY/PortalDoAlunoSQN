
package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Professor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class ProfessorDAO implements GenericoDAO{

    ArrayList<Professor> listaDeProfessores = new ArrayList<>();
    private static ProfessorDAO instancia = null;
    
    public static synchronized ProfessorDAO getInstancia() {
        if(instancia == null){
            instancia = new ProfessorDAO();
        }
        return instancia;
    }
    @Override
    public void inserir(Object objeto) {
        Professor professor = (Professor) objeto;
         int contador = listaDeProfessores.size();
         contador++;
         professor.setIdProfessor(contador);
         listaDeProfessores.add(professor);
    }

    @Override
    public Object buscar(Object objeto) {
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(Professor professor : listaDeProfessores){
                if(professor.getNome().contains(nome))
                    return professor;
            }            
        }
        else if(objeto instanceof Integer){
            Integer id =(Integer) objeto;
            
            for(Professor professor : listaDeProfessores){
                if(professor.getIdProfessor().equals(objeto)){
                    return professor;
                }
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
       Professor professor = (Professor) buscar(objeto);
        if(professor != null){
            listaDeProfessores.remove(listaDeProfessores.indexOf(professor));
            return true;
        }
        return false;  
    }

    @Override
    public ArrayList<Object> listar() {
         return (ArrayList<Object>)(Object)listaDeProfessores;        
    }

    public void salvarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void carregarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buscarTodos(Object objeto) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
