
package persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Persistance {
  
    private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("PU");
    private static EntityManager        em  =emf.createEntityManager();

    public static EntityManager getEntityManager() {
        return em;
    } 
}
