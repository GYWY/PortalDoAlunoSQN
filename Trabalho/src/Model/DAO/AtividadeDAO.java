

package Model.DAO;

import Model.POJO.Atividade;
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
                    +"\n"+atividade.getData()+"\n"+atividade.getTipo()+"\n"
                    +atividade.getValor()+"\n"+atividade.getTurma().getIdTurma()+"\n#\n";
        }
        fp.write(dados.getBytes());
        fp.close();
    }

    public void carregarArquivo() throws FileNotFoundException {
       Scanner scan = new Scanner(new FileReader("Atividade.txt"));
       GenericoDAO turma = TurmaDAO.getInstancia();
       
        while(scan.hasNext()) {
            Atividade addAtividade = new Atividade();
            ultimoID = Integer.parseInt(scan.nextLine());
            addAtividade.setId(ultimoID);
            addAtividade.setNome(scan.nextLine());
            addAtividade.setData(scan.nextLine());
            addAtividade.setTipo(scan.nextLine());
            addAtividade.setValor(Double.parseDouble(scan.nextLine()));
            Integer idTurma = Integer.parseInt(scan.nextLine());
            addAtividade.setTurma((Turma) turma.buscar(idTurma));
            addAtividade.getTurma().adicionarAtividade(addAtividade);
            scan.nextLine();
            listaDeAtividades.add(addAtividade);
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
