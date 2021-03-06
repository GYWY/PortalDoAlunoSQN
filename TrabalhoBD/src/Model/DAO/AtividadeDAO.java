package Model.DAO;

import Model.POJO.Atividade;
import Util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AtividadeDAO implements GenericoDAO<Atividade, Long> {

    @Override
    public void salvar(Atividade objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.persist(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void alterar(Atividade objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void remover(Atividade objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.remove(objeto);
        et.commit();
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
    
    public List<Atividade> buscarNome(String nome) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Atividade c WHERE c.nome LIKE :nome", Atividade.class)
                .setParameter("nome", em);
        em.close();
        return query.getResultList();
    }
    
    public List<Atividade> buscarTipo(String tipo) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Atividade c WHERE c.tipo LIKE :tipo", Atividade.class)
                .setParameter("tipo", em);
        em.close();
        return query.getResultList();
    }
    
    public List<Atividade> buscarDia(String dia) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Atividade c WHERE c.dia LIKE :dia", Atividade.class)
                .setParameter("tipo", em);
        em.close();
        return query.getResultList();
    }
    
}
