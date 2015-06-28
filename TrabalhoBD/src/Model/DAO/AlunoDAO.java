package Model.DAO;

import Model.POJO.Aluno;
import Util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AlunoDAO implements GenericoDAO<Aluno, Long>{

    @Override
    public void salvar(Aluno objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.persist(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void alterar(Aluno objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void remover(Aluno objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.remove(objeto);
        et.commit();
        em.close();
    }

    @Override
    public List<Aluno> buscarTodos() {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Aluno a", Aluno.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public Aluno buscarId(Long id) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        return em.find(Aluno.class, id);
    }
    
    public List<Aluno> buscarNome(String nome) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select aluno from Aluno aluno where"
            + "aluno.nome like '%" + nome + "%'", Aluno.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }
    
    public List<Aluno> buscarCpf(String cpf) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Aluno a where a.cpf"
            + "like :cpf", Aluno.class);
        query.setParameter("cpf", cpf);
        return query.getResultList();
    }
    
}
