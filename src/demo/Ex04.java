
package demo;

import entites.Fonction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex04 {
    
    public static void main(String[] args) {
       
   // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
     
   // 2° Accès à la liste de toutes les fonctions

     Query           reqJPQL1= em.createQuery("select fonction from Fonction fonction");
    
     List<Fonction>  toutesLesfonctions=reqJPQL1.getResultList();
 
     System.out.println();
     for (Fonction  f : toutesLesfonctions) {
     
         System.out.println(f);
     }
        System.out.println();
    }
}
