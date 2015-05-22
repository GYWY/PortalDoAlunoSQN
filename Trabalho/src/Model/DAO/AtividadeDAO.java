

package Model.DAO;

import Model.POJO.Atividade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AtividadeDAO implements GenericoDAO{
    
    ArrayList<Atividade> listaDeAtividades = new ArrayList<>();
    private static AtividadeDAO instancia = null;
    private Integer ultimoID = 0;
    
    public static synchronized AtividadeDAO getInstancia() {
        if(instancia == null){
            instancia = new AtividadeDAO();
        }
        return instancia;
    }

    @Override
    public void inserir(Object objeto) {
        Atividade atividade = (Atividade) objeto;
         Integer contador = listaDeAtividades.size();
         contador++;
         atividade.setId(contador);
         listaDeAtividades.add(atividade);
        try {
            salvarArquivo();
        } catch (IOException ex) {
            Logger.getLogger(AtividadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object buscar(Object objeto) {
   
        if(objeto instanceof String){
            String tipo = (String) objeto;
            for(Atividade atividade : listaDeAtividades){
                if(atividade.getTipo().contains(tipo))
                    return atividade;
            }            
        }
        
        return null;      
    
    }

    @Override
    public boolean remover(Object objeto) {
        
        Atividade atividade = (Atividade) buscar(objeto);
        if(atividade != null){
            listaDeAtividades.remove(listaDeAtividades.indexOf(atividade));
            return true;
        }
        return false;        
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaDeAtividades;
    }
    
    public void salvarArquivo() throws FileNotFoundException, IOException {
        File arquivo;
        arquivo = new File("Atividade.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Atividade atividade : listaDeAtividades){
            dados += atividade.getId()+"\n"+atividade.getNome()
                    +"\n"+atividade.getData()+"\n"+atividade.getTipo()+"\n"+atividade.getValor()+"\n#\n";
        }
        fp.write(dados.getBytes());
        fp.close();
    }

    public void carregarArquivo() throws FileNotFoundException {
       Scanner scan = new Scanner(new FileReader("Atividade.txt"));
        
        while(scan.hasNext()) {
            Atividade addAtividade = new Atividade();
            ultimoID = scan.nextInt();
            addAtividade.setId(ultimoID);
            addAtividade.setNome(scan.next());
            addAtividade.setData(scan.next());
            addAtividade.setTipo(scan.next());
            addAtividade.setValor(scan.nextDouble());
            scan.next();
            System.out.println(addAtividade.getNome());
        }
                
    scan.close();    
    }

    @Override
    public boolean buscarTodos(Object objeto) throws FileNotFoundException, IOException {
        if(listaDeAtividades.isEmpty()) {
            carregarArquivo(); 
            return true;
        }
        else 
            return false;
    }
    
}
