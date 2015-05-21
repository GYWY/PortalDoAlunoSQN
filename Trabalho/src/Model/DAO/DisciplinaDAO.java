package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Disciplina;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplinaDAO implements GenericoDAO{
    
    private ArrayList<Disciplina> listaDisciplina = new ArrayList<>();
    private static DisciplinaDAO instancia = null;
    private Integer ultimoID = 0;
    
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
        
        File arquivo = new File("Disciplina.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Disciplina disciplina : listaDisciplina){
            dados += "\n"+disciplina.getId()+"\n"+disciplina.getNome()+"\n"+disciplina.getEmenta()+"\n"+disciplina.getCargaHoraria()+"\n#";       
        }
        fp.write(dados.getBytes());
        fp.close();
    }

    private void carregarArquivo() throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new FileReader("Disciplina.txt"));
        
        while(scan.hasNext()) {
            Disciplina addDisciplina = new Disciplina();
            ultimoID = scan.nextInt();
            addDisciplina.setId(ultimoID);
            addDisciplina.setNome(scan.next());
            addDisciplina.setEmenta(scan.next());
            addDisciplina.setCargaHoraria(ultimoID);
            listaDisciplina.add(addDisciplina);
            scan.next();
            System.out.println(addDisciplina.getNome());
        }
        
    scan.close();
        
    }
    
    
    @Override
    public boolean buscarTodos(Object objeto) throws IOException, FileNotFoundException, ClassNotFoundException {
        if(listaDisciplina.isEmpty()) {
            carregarArquivo(); 
            return true;
        }
        else 
            return false;
    }
}
