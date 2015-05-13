
package Model.DAO;

import Model.POJO.Aluno;
import java.util.ArrayList;


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

    private void salvarArquivo() { 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void carregarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
