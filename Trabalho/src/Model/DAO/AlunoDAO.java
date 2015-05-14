
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
    
    public static synchronized AlunoDAO getInstancia() {
        if(instancia == null){
            instancia = new AlunoDAO();
        }
        return instancia;
    }
    
    @Override
    public void inserir(Object objeto) {
         Aluno aluno = (Aluno) objeto;
         int contador = listaDeAlunos.size();
         contador++;
         aluno.setId(contador);
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
    public boolean alterar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private void carregarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buscarTodos(Object objeto) throws FileNotFoundException, IOException {
        if(listaDeAlunos.isEmpty()) {
            FileReader arquivo = new FileReader("D:\\Arquivos\\Aluno.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            Aluno addAluno = new Aluno();
            Scanner leitor = new Scanner(arquivo);
            
            while(lerArquivo.ready()) {
                addAluno.setNome(lerArquivo.readLine());
                addAluno.setCpf(lerArquivo.readLine());
                System.out.println(addAluno.getNome());
            }
            
            lerArquivo.close();
            arquivo.close();    
        }
    }
    
}
