package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Disciplina;
import br.com.portalufln.trabalhobd.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DisciplianDAO implements GenericoDAO<Disciplina, Long> {

    @Override
    public void salvar(Disciplina disciplina) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.persist(disciplina);
        tx.commit();
        em.close();
    }

    @Override
    public void alterar(Disciplina disciplina) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(disciplina);
        tx.commit();
        em.close();
    }

    @Override
    public void remover(Disciplina disciplina) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.remove(disciplina);
        tx.commit();
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
    
}
