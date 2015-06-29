package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Atividade;
import br.com.portalufln.trabalhobd.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AtividadeDAO implements GenericoDAO<Atividade, Long>{

    @Override
    public void salvar(Atividade atividade) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.persist(atividade);
        tx.commit();
        em.close();
    }

    @Override
    public void alterar(Atividade atividade) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(atividade);
        tx.commit();
        em.close();
    }

    @Override
    public void remover(Atividade atividade) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.remove(atividade);
        tx.commit();
        em.close();
    }

    @Override
    public List<Atividade> buscarTodos() {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Atividade a", Atividade.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public Atividade buscarId(Long id) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        return em.find(Atividade.class, id);
    }
    
}
