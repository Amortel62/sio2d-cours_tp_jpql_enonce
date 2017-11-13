
package demo;

import entites.Fonction;
import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;

public class Ex15 {
    
    public static void main(String[] args) {
        
     EntityManager em= getEntityManager();    
     
     Fonction  fonction=new Fonction();
     
     fonction.setCodefonct("CPT");
     fonction.setLibfonct("Compta");
       
     em.getTransaction().begin();
     
          em.persist(fonction);     
     
     em.getTransaction().commit();
         
    }
}
