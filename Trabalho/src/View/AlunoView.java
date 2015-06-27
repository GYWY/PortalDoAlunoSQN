package View;

import Model.DAO.AlunoDAO;
import Model.DAO.GenericoDAO;
import Model.POJO.Aluno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class AlunoView {
    
    public void cadastrarAluno(){
        Scanner leitor = new Scanner(System.in);
        GenericoDAO aluno = AlunoDAO.getInstancia();
        Aluno novoAluno = new Aluno();
        
        System.out.println("\n\t CADASTRO ALUNO ");
        System.out.println("\n NOME DO ALUNO: ");
        String nomeAluno = leitor.nextLine().toUpperCase();
        if(!(aluno.buscar(nomeAluno)== null)){
            System.out.println("\nALUNO JÁ CADASTRADO\n\n");
            return;
        }
        novoAluno.setNome(nomeAluno);
        System.out.println("\n CPF: ");
        novoAluno.setCpf(leitor.nextLine());
        aluno.inserir(novoAluno);
    }
    
    public void listarAluno(){
        
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        System.out.println("\n\t\t ALUNOS \n");
        for (Iterator<Object> it = alunoDao.listar().iterator(); it.hasNext();) {
            Object listaAluno = it.next();
            System.out.println(listaAluno.toString());
        }
    }
    
    public void buscarAluno(){
        Aluno novaAluno = new Aluno();
        Scanner leitor = new Scanner(System.in);
        GenericoDAO aluno = AlunoDAO.getInstancia();
        System.out.println("\n\t\t PESQUISA ALUNO \n");
        System.out.println("\n ALUNO: ");
        Object pesquisa = leitor.nextLine().toUpperCase();
        novaAluno = (Aluno) aluno.buscar(pesquisa);
        if(novaAluno == null) {
            System.out.println("\n\t\t ALUNO NÃO ENCONTRADA \n");
        }
        else
            System.out.println("\n"+novaAluno);
    }
    
    public void alterarAluno() {
        Scanner leitor = new Scanner(System.in);
        Aluno aluno = new Aluno();
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        
        System.out.println("\n NOME: ");
        String nome = leitor.nextLine().toUpperCase();
        aluno = (Aluno) alunoDao.buscar(nome);
        if(aluno == null){
            System.out.println("\n ALUNO NÃO CADASTRADO \n\n");
            return;
        }
        System.out.println("\n CPF ATUAL: " + aluno.getCpf());
        System.out.println("\n NOVO CPF: ");
        aluno.setCpf(leitor.nextLine().toUpperCase());
        alunoDao.alterar(aluno);
    }
    
    public void imprimirMenuAluno() {
        System.out.println("\n ****************************************************************************** \n");
        System.out.println("\t\t DISCIPLINA \n");
        System.out.println("1- CADASTRAR ALUNO");
        System.out.println("2- PESQUISAR ALUNO");
        System.out.println("3- LISTAR ALUNOS");
        System.out.println("4- ALTERAR ALUNO");
        System.out.println("5- SAIR \n");
        System.out.println("OPÇÃO:");
    }
 
    public void menuAluno() throws FileNotFoundException, ClassNotFoundException {
        Integer escolha = 0;
        Integer flag;
        Scanner leitor = new Scanner(System.in);
        AlunoView aluno = new AlunoView();
        GenericoDAO alunoDao = AlunoDAO.getInstancia();
        
        do{
            aluno.imprimirMenuAluno();
            do{
                try{
                    escolha = Integer.parseInt(leitor.nextLine());
                    flag = 1;
                } catch(Exception e){
                    System.out.println("\n ****************************************************************************** \n");
                    System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                    System.out.println("\n ****************************************************************************** \n");       
                    flag = 0;
                    aluno.imprimirMenuAluno();
                } 
            } while(flag == 0);
                switch(escolha) {
                    case 1:
                        try{
                            alunoDao.buscarTodos(aluno);
                            aluno.cadastrarAluno();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO CADASTRAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 2:
                        try{
                            alunoDao.buscarTodos(aluno);
                            aluno.buscarAluno();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO BUSCAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 3:
                        try{
                            alunoDao.buscarTodos(aluno);
                            aluno.listarAluno();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO LISTAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 4:
                        try{
                            alunoDao.buscarTodos(aluno);
                            aluno.alterarAluno();
                        } catch(IOException e){
                            System.out.println("\n ****************************************************************************** \n");
                            System.out.println("\n\t ERRO AO LISTAR DISCIPLINA! \n");
                            System.out.println("\n ****************************************************************************** \n");
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("\n ****************************************************************************** \n");
                        System.out.println("\n\t ENTRADA INVÁLIDA. TENTE NOVAMENTE \n");
                        System.out.println("\n ****************************************************************************** \n");       
                }
        } while(escolha != 5);
    }
}
