package Model.DAO;

import Model.POJO.Disciplina;
import Util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DisciplinaDAO implements GenericoDAO<Disciplina, Long>{

    @Override
    public void salvar(Disciplina objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.persist(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void alterar(Disciplina objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void remover(Disciplina objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.remove(objeto);
        et.commit();
        em.close();
    }

    @Override
    public List<Disciplina> buscarTodos() {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Disciplina a", Disciplina.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public Disciplina buscarId(Long id) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        return em.find(Disciplina.class, id);
    }
    
    public List<Disciplina> buscarNome(String nome) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Disciplina c WHERE c.nome LIKE :nome", Disciplina.class)
                .setParameter("nome", em);
        em.close();
        return query.getResultList();
    }
    
}
