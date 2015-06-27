package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Nota;
import java.util.ArrayList;

public class NotaDAO implements GenericoDAO{
    
    ArrayList<Nota> listaNotas = new ArrayList<>();
    private ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    private static NotaDAO instancia = null;

    public static NotaDAO getInstancia() {
        if(instancia == null){
            instancia = new NotaDAO();
        }
        return instancia;
    }
    
    @Override
    public void inserir(Object objeto) {
        
        Nota nota = (Nota) objeto;
        listaNotas.add(nota);
    }

    @Override
    public Object buscar(Object objeto) {
           
        if(objeto instanceof String){
            String tipo = (String) objeto;
            for(Nota nota : listaNotas){
                if(nota.getAluno().getNome().contains(tipo))
                    return nota;
            }            
        }        
        return null;      
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaNotas;
    }

    @Override
    public void alterar(Object objeto) {
        for(Nota nota : listaNotas){
            if(nota.equals(objeto))
                nota = (Nota) objeto;
        }
    }
    
}
