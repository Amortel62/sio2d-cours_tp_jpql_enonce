
package demo;

import entites.Fonction;
import entites.Salarie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex05 {
    
    public static void main(String[] args) {
       
   // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
     
   // Accès à la liste de tous les salaries

     Query          reqJPQL= em.createQuery("select s from Salarie s order by s.nomsal");
     
     List<Salarie>  tousLesSalaries=reqJPQL.getResultList();
 
     System.out.println();
    
     for (Salarie  sal : tousLesSalaries) {
     
         System.out.printf("%-30s\n",sal.getNomsal());
       //  System.out.println(sal.getNomsal()+ sal.getLaFonction().getLibfonct());
     }

     System.out.println();
    }
}
