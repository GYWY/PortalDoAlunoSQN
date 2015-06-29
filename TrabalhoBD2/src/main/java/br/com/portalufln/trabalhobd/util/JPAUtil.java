package br.com.portalufln.trabalhobd.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
    
    private static JPAUtil instancia;
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
    
    public JPAUtil() {
        
    }
    
    public static JPAUtil getInstancia() {
        if(instancia == null) {
            instancia = new JPAUtil();
        }
        return instancia;
    }
    
    public EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    public EntityTransaction getTransaction(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        return tx;
    }
}