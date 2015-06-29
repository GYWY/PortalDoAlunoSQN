package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Turma;
import br.com.portalufln.trabalhobd.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class TurmaDAO implements GenericoDAO<Turma, Long> {

    @Override
    public void salvar(Turma turma) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.persist(turma);
        tx.commit();
        em.close();
    }

    @Override
    public void alterar(Turma turma) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(turma);
        tx.commit();
        em.close();
    }

    @Override
    public void remover(Turma turma) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.remove(turma);
        tx.commit();
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
