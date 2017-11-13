
package demo;

import entites.Salarie;
import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;

public class Ex12 {
    
    public static void main(String[] args) {
       
     // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
     
     Salarie   salarie=em.find(Salarie.class,101L);
        
     System.out.println();
        
     if (salarie!=null) {
        
        System.out.printf("\n%-30s %8.2f €\n",
                
                salarie.getNomsal(),
                salarie.getSalaire()
        );
        
        
        em.getTransaction().begin();
     
         salarie.setSalaire(4000f);
     
        em.getTransaction().commit();
     
        
     }
     else {
              
        System.out.println("Fonction inexistante");
     }
     
     
     System.out.println();
    }
}
