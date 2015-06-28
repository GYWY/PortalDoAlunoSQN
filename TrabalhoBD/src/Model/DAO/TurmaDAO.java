package Model.DAO;

import Model.POJO.Turma;
import Util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class TurmaDAO implements GenericoDAO<Turma, Long>{

    @Override
    public void salvar(Turma objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.persist(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void alterar(Turma objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void remover(Turma objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.remove(objeto);
        et.commit();
        em.close();
    }

    @Override
    public List<Turma> buscarTodos() {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Turma a", Turma.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public Turma buscarId(Long id) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        return em.find(Turma.class, id);
    }
    
}
