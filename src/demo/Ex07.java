
package demo;

import entites.Salarie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex07 {
    
    public static void main(String[] args) {
       
     // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
     
     
     // Accès à la liste des Salaries dont le salaire  est supérieur à 2100
     // Sélection dès la recherche dans la base

        Query reqJPQL=em.createQuery("Select s from Salarie s where s.salaire > 2100 ");
        
        List<Salarie>  lesSalariesAplusDe2100=reqJPQL.getResultList();

        System.out.println();
       
        for (Salarie sal : lesSalariesAplusDe2100) {
        
            System.out.printf("%-25s %8.2f €\n",sal.getNomsal(),sal.getSalaire());
        }
        
        System.out.println();
    }
}
