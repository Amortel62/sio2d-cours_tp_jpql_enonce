
package demo;

import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;

public class Ex17 {
    
    public static void main(String[] args) {
        
     EntityManager em= getEntityManager();    
    
     Double totalSalaires= (Double) em.createQuery(
      
        " SELECT SUM(s.salaire) FROM Salarie s "
     
     ).getSingleResult();
      
     System.out.println("\nTotal de tous les salaires: "+totalSalaires+"€\n");
         
    }
}
