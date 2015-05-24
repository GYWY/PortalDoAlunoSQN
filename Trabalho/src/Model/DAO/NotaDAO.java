package Model.DAO;

import Model.POJO.Aluno;
import Model.POJO.Nota;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
            dados += nota.getId()+"\n"+nota.getAluno()+"\n"+nota.getAtividade()+"\n"+nota.getNota()+"\n#\n";
        }
        fp.write(dados.getBytes());
        fp.close();
    }
    
    private void carregarArquivo() throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new FileReader("Nota.txt"));
        
        while(scan.hasNext()) {
            Nota addNota = new Nota();
            ultimoID = Integer.parseInt(scan.nextLine());
            addNota.setId(ultimoID);
            addNota.getAluno().setNome(scan.nextLine());
            addNota.getAtividade().setNome(scan.nextLine());
            addNota.setNota(scan.nextDouble());
            listaNotas.add(addNota);
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
