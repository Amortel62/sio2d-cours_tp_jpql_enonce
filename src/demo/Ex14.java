
package demo;

import entites.Salarie;
import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;

public class Ex14 {
    
    public static void main(String[] args) {
        
     EntityManager em= getEntityManager();    
     
     Salarie   salarie=em.find(Salarie.class,160L);
        
     System.out.println();
        
     if (salarie!=null) {
        
        System.out.printf("\n%-30s\n",
                
                salarie.getNomsal()
        );
        
        em.getTransaction().begin();
     
          em.remove(salarie);     
     
        em.getTransaction().commit();
     }
     else {
              
        System.out.println("Salarie inexistant");
     }  
     System.out.println();
    }
}
