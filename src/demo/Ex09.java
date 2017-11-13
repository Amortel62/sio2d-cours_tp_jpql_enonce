
package demo;

import entites.Fonction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex09 {
    
    public static void main(String[] args) {
           
      EntityManager em= getEntityManager();    
        
      String texteReqJPQL= " SELECT       DISTINCT f    " +
                           " FROM         Fonction f    " +
                           " JOIN FETCH   f.lesSalaries " ;
                    
      Query  reqJPQL= em.createQuery(texteReqJPQL);
     
      List<Fonction>  lesFonctions= reqJPQL.getResultList() ;    

      System.out.println();
     
      for (Fonction  fonction : lesFonctions){
     
         System.out.printf("%-30s %8.2f€\n",fonction.getLibfonct(),fonction.sommeSalaires());
      }
     
      System.out.println();
    }
}
