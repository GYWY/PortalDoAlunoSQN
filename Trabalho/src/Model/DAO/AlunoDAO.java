package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Atividade;
import Model.POJO.Turma;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO implements GenericoDAO{

    private ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    private static AlunoDAO instancia = null;
    private Integer ultimoID = 0;
    
    public static synchronized AlunoDAO getInstancia() {
        if(instancia == null){
            instancia = new AlunoDAO();
        }
        return instancia;
    }
    
    private AlunoDAO(){}
    
    @Override
    public void inserir(Object objeto) {
        Aluno aluno = (Aluno) objeto;
        ultimoID++;
        aluno.setId(ultimoID);
        listaDeAlunos.add(aluno);
        try {
            salvarArquivo();
        } catch (IOException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object buscar(Object objeto) {
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(Aluno aluno : listaDeAlunos){
                if(aluno.getNome().contains(nome))
                    return aluno;
            }            
        }
        else if(objeto instanceof Integer){
            Integer id =(Integer) objeto;
            for(Aluno aluno : listaDeAlunos){
                if(aluno.getId().equals(objeto)){
                    return aluno;
                }
            }
        }
        return null;      
    }

    @Override
    public boolean remover(Object objeto) {
        Aluno aluno = (Aluno) buscar(objeto);
        if(aluno != null){
            listaDeAlunos.remove(listaDeAlunos.indexOf(aluno));
            return true;
        }
        return false;    
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaDeAlunos;
    }
    
    private void salvarArquivo() throws IOException {
        File arquivo = new File("Alunos.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Aluno aluno : listaDeAlunos){
            dados += aluno.getId()+"\n"+aluno.getNome()+"\n"+aluno.getCpf()+"\n";

        fp.write(dados.getBytes());
        fp.close();
        }
    }
    

    private void carregarArquivo() throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new FileReader("Alunos.txt"));
        
        while(scan.hasNext()) {
            Aluno addAluno = new Aluno();
            ultimoID = Integer.parseInt(scan.nextLine());
            addAluno.setId(ultimoID);
            addAluno.setNome(scan.nextLine());
            addAluno.setCpf(scan.nextLine());
            listaDeAlunos.add(addAluno);
            scan.next();
            System.out.println(addAluno.getNome());
        }
        
    scan.close();
        
    }

    
    @Override
    public boolean buscarTodos(Object objeto) throws IOException, FileNotFoundException, ClassNotFoundException {
        if(listaDeAlunos.isEmpty()) {
            carregarArquivo(); 
            return true;
        }
        else 
            return false;
    }
    
}