
package Model.DAO;

import Model.POJO.Professor;
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
        listaDeProfessores.add(professor);
    }

    @Override
    public Object buscar(Object objeto) {
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(Professor professor : listaDeProfessores){
                if(professor.getNome().equals(nome))
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
    public ArrayList<Object> listar() {
         return (ArrayList<Object>)(Object)listaDeProfessores;        
    }

    @Override
    public void alterar(Object objeto) {
        for(Professor professor : listaDeProfessores){
            if(professor.equals(objeto))
                professor = (Professor) objeto;
        }
    }
   
}

    
    

