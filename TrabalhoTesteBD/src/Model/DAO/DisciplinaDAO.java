package Model.DAO;

import Model.POJO.Disciplina;
import java.util.ArrayList;

public class DisciplinaDAO implements GenericoDAO{
    
    private ArrayList<Disciplina> listaDisciplina = new ArrayList<>();
    private static DisciplinaDAO instancia = null;
    
    public static synchronized DisciplinaDAO getInstancia() {
        if(instancia == null){
            instancia = new DisciplinaDAO();
        }
        return instancia;
    }

    @Override
    public void inserir(Object objeto) {
         Disciplina disciplina = (Disciplina) objeto;
         listaDisciplina.add(disciplina);
    }

    @Override
    public Object buscar(Object objeto) {
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(Disciplina disciplina : listaDisciplina){
                if(disciplina.getNome().equals(nome))
                    return disciplina;
            }
        }
        else if(objeto instanceof Integer){
            Integer id =(Integer) objeto;
            for(Disciplina disciplina : listaDisciplina){
                if(disciplina.getId().equals(id)){
                    return disciplina;
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaDisciplina;
    }

    @Override
    public void alterar(Object objeto) {
        for(Disciplina disciplina : listaDisciplina){
            if(disciplina.equals(objeto))
                disciplina = (Disciplina) objeto;
        }
    }
}
