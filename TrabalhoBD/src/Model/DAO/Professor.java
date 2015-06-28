package Model.DAO;

import Util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class Professor implements GenericoDAO<Professor, Long>{

    @Override
    public void salvar(Professor objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.persist(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void alterar(Professor objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.refresh(objeto);
        et.commit();
        em.close();
    }

    @Override
    public void remover(Professor objeto) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction et = JPAUtil.getInstancia().getTransaction(em);
        em.remove(objeto);
        et.commit();
        em.close();
    }

    @Override
    public List<Professor> buscarTodos() {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Professor a", Professor.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public Professor buscarId(Long id) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        return em.find(Professor.class, id);
    }
    
    public List<Professor> buscarNome(String nome) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Professor c WHERE c.nome LIKE :nome", Professor.class)
                .setParameter("nome", em);
        em.close();
        return query.getResultList();
    }
    
    public List<Professor> buscarCpf(String cpf) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Professor c WHERE c.cpf LIKE :cpf", Professor.class)
                .setParameter("cpf", em);
        em.close();
        return query.getResultList();
    }
    
    public List<Professor> buscarDepartamento(String cpf) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Professor c WHERE c.cpf LIKE :departamento", Professor.class)
                .setParameter("departamento", em);
        em.close();
        return query.getResultList();
    }
    
}
