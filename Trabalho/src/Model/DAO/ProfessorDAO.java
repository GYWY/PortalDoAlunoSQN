
package Model.DAO;

import Model.POJO.Professor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProfessorDAO implements GenericoDAO{

    ArrayList<Professor> listaDeProfessores = new ArrayList<>();
    private static ProfessorDAO instancia = null;
    private Integer ultimoID = 0;
    
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

   private void salvarArquivo() throws IOException {
        
        File arquivo = new File("Professor.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Professor professor : listaDeProfessores){
            dados += professor.getIdProfessor()+"\n"+professor.getNome()
                    +"\n"+professor.getCpf()+"\n"+professor.getDepartamento()+"\n#\n";     
        }
        fp.write(dados.getBytes());
        fp.close();
    }
    

    private void carregarArquivo() throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader("Professor.txt"));
        
        while(scan.hasNext()) {
            Professor addProfessor = new Professor();
            ultimoID = Integer.parseInt(scan.nextLine());
            addProfessor.setIdProfessor(ultimoID);
            addProfessor.setNome(scan.nextLine());
            addProfessor.setCpf(scan.nextLine());
            addProfessor.setDepartamento(scan.nextLine());
            listaDeProfessores.add(addProfessor);
            scan.nextLine();
        }
                
        scan.close();    
    }

    @Override
    public boolean buscarTodos(Object objeto) throws FileNotFoundException {
        if(listaDeProfessores.isEmpty()) {
            carregarArquivo(); 
            return true;
        }
        else 
            return false;
    }
}

    
    

