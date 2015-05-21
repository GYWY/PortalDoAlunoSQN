

package Model.DAO;

import Model.POJO.Atividade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AtividadeDAO implements GenericoDAO{
    
    ArrayList<Atividade> listaDeAtividades = new ArrayList<>();
    private static AtividadeDAO instancia = null;
    
    public static synchronized AtividadeDAO getInstancia() {
        if(instancia == null){
            instancia = new AtividadeDAO();
        }
        return instancia;
    }

    @Override
    public void inserir(Object objeto) {
        Atividade atividade = (Atividade) objeto;
         int contador = listaDeAtividades.size();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaDeAtividades;
    }
    
    public void salvarArquivo() throws FileNotFoundException, IOException {
        File arquivo;
        arquivo = new File("C:\\Users\\Reis\\Documents\\NetBeansProjects\\PortalDoAlunoSQN\\Aluno.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Atividade atividade : listaDeAtividades){
            dados += atividade.getId()+"#"+atividade.getNome()+"#"+atividade.getData()+"#"+atividade.getTipo();//aluno.getNotaFinal().getNota()+"\n"+aluno.getFalta().getFaltas()+"\n";
            /*dados += aluno.getListaAtividadesRealizadas().size()+"\n";
            for(Atividade atividade : aluno.getListaAtividadesRealizadas()){
                dados += atividade.getId()+"\n"+atividade.getTipo()+"\n"+atividade.getValor()+"\n";
            }*/
            //dados += aluno.getListaTurmasMatriculadas().size()+"\n";
            /*for(Turma turma : aluno.getListaTurmasMatriculadas()){
                dados += turma.getIdTurma()+"\n"+turma.getAno()+"\n"+turma.getHorario()+"\n"+turma.getLocal()+"\n"+turma.getPeriodo()+"\n"+turma.getProfessor()+"\n"+turma.getVaga()+"\n"+turma.getDisciplina()+"\n";
            } */      
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
