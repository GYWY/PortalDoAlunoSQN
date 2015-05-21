package Model.DAO;

import Model.POJO.Aluno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO implements GenericoDAO{

    private ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    private static AlunoDAO instancia = null;
    private Integer ultimoID = 0;
    
    public static synchronized AlunoDAO getInstancia() {
        if(instancia == null){
            instancia = new AlunoDAO();
        }
        return instancia;
    }
    
    private AlunoDAO(){}
    
    @Override
    public void inserir(Object objeto) {
        Aluno aluno = (Aluno) objeto;
        ultimoID++;
        aluno.setId(ultimoID);
        listaDeAlunos.add(aluno);
        try {
            carregarArquivo();
        } catch (IOException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            salvarArquivo();
        } catch (IOException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object buscar(Object objeto) {
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(Aluno aluno : listaDeAlunos){
                if(aluno.getNome().contains(nome))
                    return aluno;
            }            
        }
        else if(objeto instanceof Integer){
            Integer id =(Integer) objeto;
            for(Aluno aluno : listaDeAlunos){
                if(aluno.getId().equals(objeto)){
                    return aluno;
                }
            }
        }
        return null;      
    }

    @Override
    public boolean remover(Object objeto) {
        Aluno aluno = (Aluno) buscar(objeto);
        if(aluno != null){
            listaDeAlunos.remove(listaDeAlunos.indexOf(aluno));
            return true;
        }
        return false;    
    }

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList<Object>)(Object)listaDeAlunos;
    }
    
    private void salvarArquivo() throws IOException {
//        File novoArquivo = new File("/home/wennya/Trabalho/Aluno.txt");
//        FileWriter arquivo = new FileWriter(novoArquivo, true);
//        BufferedWriter escreverArquivo = new BufferedWriter(arquivo);
//        for(Aluno aluno : listaDeAlunos) {
//            escreverArquivo.write(aluno.getId());
//            escreverArquivo.newLine();
//            escreverArquivo.write(aluno.getNome());
//            escreverArquivo.newLine();
//            escreverArquivo.write(aluno.getCpf());
//            escreverArquivo.newLine();
//        }
//        escreverArquivo.close();
//        arquivo.close();
        
        File arquivo = new File("/home/wennya/Trabalho/Aluno.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Aluno aluno : listaDeAlunos){
            dados = dados + aluno.getId()+"\n"+aluno.getNome()+"\n"+aluno.getCpf()+"\n";//aluno.getNotaFinal().getNota()+"\n"+aluno.getFalta().getFaltas()+"\n";
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
    
    
//    private void salvarArquivo() throws IOException { 
//        FileOutputStream arquivo = new FileOutputStream("/home/wennya/Trabalho/Aluno.bin");
//        ObjectOutputStream classe = new ObjectOutputStream(arquivo);
//        classe.writeObject(AlunoDAO.this);
//        classe.close();
//        arquivo.close();        
//    }
//
//    private AlunoDAO carregarArquivo()throws FileNotFoundException, IOException, ClassNotFoundException{
//        FileInputStream arquivo = new FileInputStream("/home/wennya/Trabalho/Aluno.bin");
//        ObjectInputStream classe = new ObjectInputStream(arquivo);
//        AlunoDAO aluno = (AlunoDAO) classe.readObject();
//        return aluno;
//    }

    private void carregarArquivo() throws FileNotFoundException, IOException {
//            FileReader arquivo = new FileReader("/home/wennya/Trabalho/Aluno.txt");
//            BufferedReader lerArquivo = new BufferedReader(arquivo);
//            Aluno addAluno = new Aluno();
//            Scanner leitor = new Scanner(arquivo);
//            
//            ultimoID = Integer.parseInt(lerArquivo.readLine());
//            
//            while(lerArquivo.ready()) {
//                addAluno.setId(lerArquivo.read());
//                addAluno.setNome(lerArquivo.readLine());
//                addAluno.setCpf(lerArquivo.readLine());
//                listaDeAlunos.add(addAluno);
//            }
//            
//            lerArquivo.close();
//            arquivo.close();  
        
        FileInputStream arquivo = new FileInputStream("/home/wennya/Trabalho/Aluno.txt");
        InputStreamReader lerArquivo = new InputStreamReader(arquivo);
        BufferedReader lerDado = new BufferedReader(lerArquivo);
        Aluno addAluno = new Aluno();
        
        while(lerDado.ready()) {
            addAluno.setId(lerDado.read());
            addAluno.setNome(lerDado.readLine());
            addAluno.setCpf(lerDado.readLine());
            listaDeAlunos.add(addAluno);
            System.out.println(addAluno.getNome());
        }
        
        lerDado.close();
        lerArquivo.close();
        arquivo.close();
        
    }

    public boolean buscarTodos(Object objeto) throws IOException, FileNotFoundException, ClassNotFoundException {
        if(listaDeAlunos.isEmpty()) {
             carregarArquivo();
             return true;
        }
        else 
            return false;
    }
    
}