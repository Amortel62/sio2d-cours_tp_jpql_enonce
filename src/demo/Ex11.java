
package demo;

import entites.Fonction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex11 {
    
    public static void main(String[] args) {
       
     // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
        
     // Fonctions comportant plus de 3 Salaries
     
     String reqJPQL= " SELECT       f  "         +
                     " FROM         Fonction f " +
                     " WHERE        SIZE( f.lesSalaries ) > 3 ";
                           
     Query chargeLesFonctions= em.createQuery(reqJPQL);
     
     List<Fonction>  lesFonctions= chargeLesFonctions.getResultList() ;    

     System.out.println(lesFonctions);
    
     System.out.println();
    
    }
}
