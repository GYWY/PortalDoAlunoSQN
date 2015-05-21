
package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Professor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        try {
            salvarArquivo();
        } catch (IOException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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

   private void salvarArquivo() throws IOException {
        
        File arquivo = new File("/home/wennya/Trabalho/Professor.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Professor professor : listaDeProfessores){
            dados += professor.getIdProfessor()+"\n"+professor.getNome()+"\n"+professor.getCpf()+"\n"+professor.getDepartamento()+"\n\n";     
        }
        fp.write(dados.getBytes());
        fp.close();
    }
    

    public void carregarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buscarTodos(Object objeto) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
