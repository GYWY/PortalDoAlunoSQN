package Model.DAO;

import Model.POJO.Disciplina;
import Model.POJO.Professor;
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


public class TurmaDAO implements GenericoDAO{

    private ArrayList<Turma> listaDeTurmas = new ArrayList<>();
    private static TurmaDAO instancia = null;
    private Integer ultimoID = 0;
    
    
    public static synchronized TurmaDAO getInstancia() {
        if(instancia == null){
            instancia = new TurmaDAO();
        }
        return instancia;
    }
      
    @Override
    public void inserir(Object objeto) {
         Turma turma = (Turma) objeto;
         int contador = listaDeTurmas.size();
         contador++;
         turma.setIdTurma(contador);
         listaDeTurmas.add(turma);
        try {
            salvarArquivo();
        } catch (IOException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object buscar(Object objeto) {
        
        if(objeto instanceof String){
            String nome = (String) objeto;
            for(Turma turma : listaDeTurmas){
                if(turma.getDisciplina().equals(nome))
                    return turma;
            }            
        }
        else if(objeto instanceof Integer){
            Integer id =(Integer) objeto;
            
            for(Turma turma : listaDeTurmas){
                if(turma.getIdTurma().equals(objeto)){
                    return turma;
                }
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Object> listar() {
         return (ArrayList<Object>)(Object)listaDeTurmas;
    }

    private void salvarArquivo() throws IOException {
        
        File arquivo = new File("Turma.txt");
        FileOutputStream fp = new FileOutputStream(arquivo);
        String dados = "";
        for(Turma turma : listaDeTurmas){
            dados += turma.getIdTurma()+"\n"+turma.getLocal()
                    +"\n"+turma.getAno()+"\n"+turma.getPeriodo()+"\n"
                    +turma.getHorario()+"\n"+turma.getVaga()+"\n"+turma.getDisciplina().getId()
                    +"\n"+turma.getProfessor().getIdProfessor()+"\n#\n";
        }
        fp.write(dados.getBytes());
        fp.close();
    }

    private void carregarArquivo() throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader("Turma.txt"));
        
        while(scan.hasNext()) {
            Turma addTurma = new Turma();
            GenericoDAO disciplina = DisciplinaDAO.getInstancia();
            GenericoDAO professor = ProfessorDAO.getInstancia();
                    
            ultimoID = Integer.parseInt(scan.nextLine());
            addTurma.setIdTurma(ultimoID);
            addTurma.setLocal(scan.nextLine());
            addTurma.setAno(Long.parseLong(scan.nextLine()));
            addTurma.setPeriodo(Integer.parseInt(scan.nextLine()));
            addTurma.setHorario(scan.nextLine());
            addTurma.setVaga(Integer.parseInt(scan.nextLine()));
            Integer idDisciplina = Integer.parseInt(scan.nextLine());
            addTurma.setDisciplina((Disciplina) disciplina.buscar(idDisciplina));
            addTurma.getDisciplina().setListaTurmas(addTurma);
            Integer idProfessor = Integer.parseInt(scan.nextLine());
            addTurma.setProfessor((Professor) professor.buscar(idProfessor));
            addTurma.getProfessor().adicionarTurma(addTurma);
            listaDeTurmas.add(addTurma);
            scan.nextLine();
        }
        
        scan.close();    
    }

    @Override
    public boolean buscarTodos(Object objeto) throws IOException, FileNotFoundException, ClassNotFoundException {
        if(listaDeTurmas.isEmpty()) {
            carregarArquivo();
            return true;
        }
        else 
            return false;
    
    }
    
}

    

