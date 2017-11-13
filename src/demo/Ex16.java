
package demo;

import entites.Salarie;
import java.util.List;
import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;
/**
 *
 * @author rsmon
 */
public class Ex16 {
  
  public static void main( String[] args){  
    
    
  EntityManager em= getEntityManager();    
    
    
     List <Salarie> desSalaries= em.createQuery(
      
       " SELECT sal FROM Salarie  sal  WHERE sal.salaire = ( SELECT MAX(SalI.salaire) FROM Salarie salI )"
     
     ).getResultList();
     
     System.out.println("\nSalarié(s) dont le salaire est le plus élevé\n");
      
     for (Salarie s : desSalaries){
    
         System.out.printf("%4d %-20s %8.2f €%-30s\n",
                
                s.getNumsal(), 
                s.getNomsal(), 
                s.getSalaire(),
                s.getLaFonction().getLibfonct()
         );
     }
     
      System.out.println();  
  } 
}
