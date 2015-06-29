package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Falta;
import br.com.portalufln.trabalhobd.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class FaltaDAO implements GenericoDAO<Falta, Long> {

    @Override
    public void salvar(Falta falta) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.persist(falta);
        tx.commit();
        em.close();
    }

    @Override
    public void alterar(Falta falta) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(falta);
        tx.commit();
        em.close();
    }

    @Override
    public void remover(Falta falta) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.remove(falta);
        tx.commit();
        em.close();
    }

    @Override
    public List<Falta> buscarTodos() {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Falta a", Falta.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public Falta buscarId(Long id) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        return em.find(Falta.class, id);
    }
    
}
