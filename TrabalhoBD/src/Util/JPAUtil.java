package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
    
    private static JPAUtil instancia;
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    
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
        EntityTransaction et = em.getTransaction();
        et.begin();
        return et;
    }
    
}
