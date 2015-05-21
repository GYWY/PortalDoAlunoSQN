package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Disciplina;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
         
         int contador = listaDisciplina.size();
         contador++;
         disciplina.setId(contador);
         listaDisciplina.add(disciplina);
         try {
            
            salvarArquivo();
            System.out.printf("Numero de elementos do array: "+listaDisciplina.size());
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object buscar(Object objeto) {
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(Disciplina disciplina : listaDisciplina){
                if(disciplina.getNome().contains(nome))
                    return disciplina;
            }
        }
        else if(objeto instanceof Integer){
            Integer id =(Integer) objeto;
            for(Disciplina disciplina : listaDisciplina){
                if(disciplina.getId().equals(objeto)){ //ver id
                    return disciplina;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remover(Object objeto) {
        Disciplina disciplina = (Disciplina) buscar(objeto);
        if(disciplina != null){
            listaDisciplina.remove(listaDisciplina.indexOf(disciplina));
            return true;
        }
        return false;    
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaDisciplina;
    }

    private void salvarArquivo() throws IOException {
        
        File arquivo = new File("/home/wennya/Trabalho/Disciplina.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Disciplina disciplina : listaDisciplina){
            dados += disciplina.getId()+"\n"+disciplina.getNome()+"\n"+disciplina.getEmenta()+"\n"+disciplina.getCargaHoraria()+"\n"+"\n\n";       
        }
        fp.write(dados.getBytes());
        fp.close();
    }

    public void carregarArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void buscarTodos(Object objeto) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
