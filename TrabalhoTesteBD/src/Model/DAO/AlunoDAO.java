package Model.DAO;

import Model.POJO.Aluno;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;

public class AlunoDAO implements GenericoDAO{

    private ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    private static AlunoDAO instancia = null;
  
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
        listaDeAlunos.add(aluno);
    }

    @Override
    public Object buscar(Object objeto) {
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(Aluno aluno : listaDeAlunos){
                if(aluno.getNome().equals(nome))
                    return aluno;
            }            
        }
        if(objeto instanceof String) {
            String cpf = (String) objeto;
            for(Aluno aluno : listaDeAlunos){
                if(aluno.getCpf().equals(cpf))
                    return aluno;
            }
        }
        if(objeto instanceof Long){
            Long id =(Long) objeto;
            for(Aluno aluno : listaDeAlunos){
                if(aluno.getId().equals(objeto)){
                    return aluno;
                }
            }
        }
        return null;      
    }
    
    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaDeAlunos;
    }

    @Override
    public void alterar(Object objeto) {
        for(Aluno aluno : listaDeAlunos){
            if(aluno.equals(objeto))
                aluno = (Aluno) objeto;
        }
    }
    
}