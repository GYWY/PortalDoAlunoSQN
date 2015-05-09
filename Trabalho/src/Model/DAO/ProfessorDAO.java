
package Model.DAO;

import Model.POJO.AlunoPOJO;
import Model.POJO.ProfessorPOJO;
import java.util.ArrayList;


public class ProfessorDAO implements GenericoDAO{

    ArrayList<ProfessorPOJO> listaDeProfessores = new ArrayList<>();
    private static ProfessorDAO instancia = null;
    
    public static synchronized ProfessorDAO getInstancia() {
        if(instancia == null){
            instancia = new ProfessorDAO();
        }
        return instancia;
    }
    @Override
    public void inserir(Object objeto) {
        ProfessorPOJO professor = (ProfessorPOJO) objeto;
         int contador = listaDeProfessores.size();
         contador++;
         professor.setIdProfessor(contador);
         listaDeProfessores.add(professor);
    }

    @Override
    public Object buscar(Object objeto) {
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(ProfessorPOJO professor : listaDeProfessores){
                if(professor.getNome().contains(nome))
                    return professor;
            }            
        }
        else if(objeto instanceof Integer){
            Integer id =(Integer) objeto;
            
            for(ProfessorPOJO professor : listaDeProfessores){
                if(professor.getIdProfessor().equals(objeto)){
                    return professor;
                }
            }
        }
        return null;    
    }

    @Override
    public void alterar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Object objeto) {
       ProfessorPOJO professor = (ProfessorPOJO) buscar(objeto);
        if(professor != null){
            listaDeProfessores.remove(listaDeProfessores.indexOf(professor));
            return true;
        }
        return false;  
    }

    @Override
    public ArrayList<Object> listar(Object objeto) {
         return (ArrayList<Object>)(Object)listaDeProfessores;        
    }

    @Override
    public void salvarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void carregarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
