/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.AlunoPOJO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class AlunoDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
    ArrayList<AlunoPOJO> listaDeAlunos = new ArrayList<>();
    private static AlunoDAOImpl instancia = null;

    public static synchronized AlunoDAOImpl getInstancia() {
        if(instancia == null){
            instancia = new AlunoDAOImpl();
        }
        return instancia;
    }
        
    public void AlunoDAOImpl() throws FileNotFoundException, IOException{
        this.carregarAlunos();
    }
    
    public AlunoPOJO lerAluno(Scanner leitor){
        AlunoPOJO aluno = new AlunoPOJO(null,null);
        
        aluno.setNome(leitor.nextLine());
        aluno.setCpf(leitor.nextLine());
        
        return aluno;                
    }
    
    public void criarArquivo(String nomeDoArquivo) throws IOException{
        File arquivo = new File(nomeDoArquivo);
        FileWriter escrevedor = new FileWriter(arquivo);
    }
    
    public void carregarAlunos() throws FileNotFoundException, IOException{
        File arquivo = new File("Alunos.txt");
        
        if(arquivo.exists()){
            Scanner leitor = new Scanner(arquivo);
            
            while(leitor.hasNext()){
                this.adicionarAluno(lerAluno(leitor));
            }
        }
        else{
            this.criarArquivo("Alunos.txt");
        }
    }
    
    public void salvarAluno(FileWriter escrevedor, AlunoPOJO aluno) throws IOException{
        escrevedor.write(aluno.getNome());
        escrevedor.write(aluno.getCpf());
    }
    
    public void salvarAlunos() throws IOException{
        File arquivo = new File("Aluno.txt");
        FileWriter escrevedor = new FileWriter(arquivo);
                
        for (AlunoPOJO aluno : this.listaDeAlunos) {
            this.salvarAluno(escrevedor,aluno);
        }        
    }
    
    public void adicionarAluno(AlunoPOJO aluno) throws IOException{
        this.listaDeAlunos.add(aluno);
        this.salvarAlunos();
    }

    public ArrayList<AlunoPOJO> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(ArrayList<AlunoPOJO> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
