/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


import Model.POJO.ProfessorPOJO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProfessorDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
    
    ArrayList<ProfessorPOJO> listaDeProfessores;
    private static ProfessorDAOImpl instancia = null;
    
      
    public static synchronized ProfessorDAOImpl getInstancia(){
        if(instancia == null)
            instancia = new ProfessorDAOImpl();
        return instancia;
    }  
    
    
    public void ProfessorDAOImpl() throws FileNotFoundException, IOException{
        this.carregarProfessores();
    }
    
    public ProfessorPOJO lerProfessor(Scanner leitor){
        ProfessorPOJO professor = new ProfessorPOJO(null,null);
        
        professor.setNome(leitor.nextLine());
        professor.setCpf(leitor.nextLine());
        professor.setDepartamento(leitor.nextLine());
        return professor;                
    }
    
    public void criarArquivo(String nomeDoArquivo) throws IOException{
        File arquivo = new File(nomeDoArquivo);
        FileWriter escrevedor = new FileWriter(arquivo);
    }
    
    public void carregarProfessores() throws FileNotFoundException, IOException{
        File arquivo = new File("Professores.txt");
        
        if(arquivo.exists()){
            Scanner leitor = new Scanner(arquivo);
            
            while(leitor.hasNext()){
                this.adicionarProfessor(lerProfessor(leitor));
            }
        }
        else{
            this.criarArquivo("Professores.txt");
        }
    }
    
    public void salvarProfessor(FileWriter escrevedor, ProfessorPOJO Professor) throws IOException{
        escrevedor.write(Professor.getNome());
        escrevedor.write(Professor.getCpf());
    }
    
    public void salvarProfessores() throws IOException{
        File arquivo = new File("Professor.txt");
        FileWriter escrevedor = new FileWriter(arquivo);
                
        for (ProfessorPOJO Professor : this.listaDeProfessores) {
            this.salvarProfessor(escrevedor,Professor);
        }        
    }
    
    public void adicionarProfessor(ProfessorPOJO professor) throws IOException{
        this.listaDeProfessores.add(professor);
        this.salvarProfessores();
    }

    public ArrayList<ProfessorPOJO> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(ArrayList<ProfessorPOJO> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
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
        for (ProfessorPOJO listaDeProfessor : listaDeProfessores) {
            if (listaDeProfessor.getNome() == id) {
                return (T) listaDeProfessor;
            }
        }
       return null;
    }
}