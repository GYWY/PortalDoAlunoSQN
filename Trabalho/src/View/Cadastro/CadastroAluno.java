/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Cadastro;

import Model.DAO.AlunoDAOImpl;
import Model.POJO.AlunoPOJO;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class CadastroAluno {
    
    public void coletarDados(AlunoPOJO aluno,Scanner leitor){
        System.out.println("Digite o nome do aluno:   ");
        aluno.setNome(leitor.nextLine());
        
        System.out.println("Digite o C.P.F. do aluno:   ");
        aluno.setCpf(leitor.nextLine());
    }   
    
    public void cadastrarAluno(){
        AlunoPOJO aluno = new AlunoPOJO(null,null);
        Scanner leitor = new Scanner(System.in);
        AlunoDAOImpl alunoDao = new AlunoDAOImpl();
              
        alunoDao.adicionarAluno(aluno);
    }
}
