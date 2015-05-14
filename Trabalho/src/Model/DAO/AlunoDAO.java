
package Model.DAO;

import Model.POJO.Aluno;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

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
    
    @Override
    public void inserir(Object objeto) {
        Aluno aluno = (Aluno) objeto;
        ultimoID++;
        aluno.setId(ultimoID);
        listaDeAlunos.add(aluno);
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
        
    }

    private void carregarArquivo() throws FileNotFoundException, IOException {
            FileReader arquivo = new FileReader("D:\\Arquivos\\Aluno.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            Aluno addAluno = new Aluno();
            Scanner leitor = new Scanner(arquivo);
            
            ultimoID = Integer.parseInt(lerArquivo.readLine());
            
            while(lerArquivo.ready()) {
                addAluno.setId(lerArquivo.readLine());
                addAluno.setNome(lerArquivo.readLine());
                addAluno.setCpf(lerArquivo.readLine());
                System.out.println(addAluno.getId());
                System.out.println(addAluno.getNome());
                System.out.println(addAluno.getCpf());
            }
            
            lerArquivo.close();
            arquivo.close();  
    }

    public void buscarTodos(Object objeto) throws IOException {
        if(listaDeAlunos.isEmpty())
            carregarArquivo();
    }
    
}
