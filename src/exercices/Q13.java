
package exercices;

import entites.Client;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q13 {
    
    public static void main(String[] args) {
        
      EntityManager em= getEntityManager();    
   
      Query reqJPQL= em.createQuery(
             
             " SELECT c , SUM(p.montantDevis)       " +
             " FROM   Client c  JOIN c.lesProjets p " +
             " GROUP BY c"
      );
    
      System.out.println("\nSomme des devis par clients\n");
      
      for(Object obj : reqJPQL.getResultList() ){
            
            Object[] tobj=( Object[] ) obj;
            
            System.out.printf("%-40s %7.2f €\n",
                    
                    ( (Client)tobj[0]).getNomcli(),
                    (Double)tobj[1]
            );
      }
     
      System.out.println();
    }
}
