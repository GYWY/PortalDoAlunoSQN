package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Falta;
import Model.POJO.Turma;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FaltaDAO implements GenericoDAO {

    ArrayList<Falta> listaFaltas = new ArrayList<>();
    private static FaltaDAO instancia = null;
    private Integer ultimoID = 0;

    public static FaltaDAO getInstancia() {
        if(instancia == null){
            instancia = new FaltaDAO();
        }
        return instancia;
    }
    
    @Override
    public void inserir(Object objeto) {
        Falta falta = (Falta) objeto;
        ultimoID++;
        falta.setId(ultimoID);
        listaFaltas.add(falta); 
        try {    
            salvarArquivo();
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object buscar(Object objeto) {
             
        if(objeto instanceof String){
            String tipo = (String) objeto;
            for(Falta falta : listaFaltas){
                if(falta.getAluno().getNome().contains(tipo))
                    return falta;
            }            
        }        
        return null;   
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaFaltas;
    }
    
    private void salvarArquivo() throws IOException {
        
        File arquivo = new File("Falta.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Falta falta : listaFaltas){
            dados += falta.getId()+"\n"+falta.getAluno().getId()+"\n"+falta.getTurma().getIdTurma()+"\n"+falta.getFaltas();
        }
        fp.write(dados.getBytes());
        fp.close();
    }
    
    private void carregarArquivo() throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new FileReader("Falta.txt"));
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        GenericoDAO turmaDao = TurmaDAO.getInstancia();
        
        while(scan.hasNext()) {
            Falta addFalta = new Falta();
            ultimoID = Integer.parseInt(scan.nextLine());
            addFalta.setId(ultimoID);
            Integer idAluno = Integer.parseInt(scan.nextLine());
            addFalta.setAluno((Aluno) alunoDao.buscar(idAluno));
            Integer idTurma = Integer.parseInt(scan.nextLine());
            addFalta.setTurma((Turma) turmaDao.buscar(idTurma));
            addFalta.setFaltas(Integer.parseInt(scan.nextLine()));
            listaFaltas.add(addFalta);
            addFalta.getAluno().adicionarFalta(addFalta);
            addFalta.getTurma().adicionarFalta(addFalta);
        }
        
        scan.close();
        
    }


    @Override
    public boolean buscarTodos(Object objeto) throws IOException, FileNotFoundException, ClassNotFoundException {
        if(listaFaltas.isEmpty()) {
            carregarArquivo(); 
            return true;
        }
        else 
            return false;   
    }
    
}
