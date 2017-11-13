
package demo;

import entites.Salarie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex06 {
    
    public static void main(String[] args) {
       
   // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
     
   // Accès à la liste de tous les salaries

     Query          reqJPQL= em.createQuery("select s from Salarie s");
     
     List<Salarie>  tousLesSalaries=reqJPQL.getResultList();
 
     System.out.println();
    
     for (Salarie  sal : tousLesSalaries) {
     
         System.out.printf("%-25s %-30s\n",
                 
                           sal.getNomsal(),
                           sal.getLaFonction().getLibfonct()
                          );   
     }

    }
}
