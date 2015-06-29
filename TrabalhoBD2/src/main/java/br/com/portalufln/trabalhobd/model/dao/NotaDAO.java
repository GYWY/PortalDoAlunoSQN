package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Nota;
import br.com.portalufln.trabalhobd.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class NotaDAO implements GenericoDAO<Nota, Long> {

    @Override
    public void salvar(Nota nota) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.persist(nota);
        tx.commit();
        em.close();
    }

    @Override
    public void alterar(Nota nota) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(nota);
        tx.commit();
        em.close();
    }

    @Override
    public void remover(Nota nota) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.remove(nota);
        tx.commit();
        em.close();
    }

    @Override
    public List<Nota> buscarTodos() {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Nota a", Nota.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public Nota buscarId(Long id) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        return em.find(Nota.class, id);
    }
    
}
