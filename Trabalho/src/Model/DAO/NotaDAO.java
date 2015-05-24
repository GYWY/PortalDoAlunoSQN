package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Atividade;
import Model.POJO.Nota;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaDAO implements GenericoDAO{
    
    ArrayList<Nota> listaNotas = new ArrayList<>();
    private ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    private static NotaDAO instancia = null;
    private Integer ultimoID = 0;

    public static NotaDAO getInstancia() {
        if(instancia == null){
            instancia = new NotaDAO();
        }
        return instancia;
    }
    
    @Override
    public void inserir(Object objeto) {
        
        Nota nota = (Nota) objeto;
        ultimoID++;
        nota.setId(ultimoID);
        listaNotas.add(nota);
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
    
    private void salvarArquivo() throws IOException {
        
        File arquivo = new File("Nota.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Nota nota : listaNotas){
            dados += nota.getId()+"\n"+nota.getAluno().getId()+"\n"+nota.getAtividade().getId()+"\n"+nota.getNota()+"\n#\n";
        }
        fp.write(dados.getBytes());
        fp.close();
    }
    
    private void carregarArquivo() throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new FileReader("Nota.txt"));
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        GenericoDAO atividadeDao = AtividadeDAO.getInstancia();
        
        while(scan.hasNext()) {
            Nota addNota = new Nota();
            ultimoID = Integer.parseInt(scan.nextLine());
            addNota.setId(ultimoID);
            Integer idAluno = Integer.parseInt(scan.nextLine());
            addNota.setAluno((Aluno) alunoDao.buscar(idAluno));
            Integer idAtividade = Integer.parseInt(scan.nextLine());
            addNota.setAtividade((Atividade) atividadeDao.buscar(idAtividade));
            addNota.setNota(Double.parseDouble(scan.nextLine()));
            listaNotas.add(addNota);
            addNota.getAluno().adicionarNota(addNota);
            addNota.getAtividade().adicionarNota(addNota);
            scan.nextLine();
        }
        
        scan.close();
        
    }
    
    @Override
    public boolean buscarTodos(Object objeto) throws IOException, FileNotFoundException, ClassNotFoundException {
       if(listaNotas.isEmpty()) {
            carregarArquivo(); 
            return true;
        }
        else 
            return false;
    }
    
}
