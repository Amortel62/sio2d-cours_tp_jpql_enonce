
package demo;

import entites.Salarie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex10 {
    
    public static void main(String[] args) {
       
     // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
        
     // Salariés affectés à aucun projet
     
     String texteReqJPQL= " SELECT   s  "        +
                          " FROM     Salarie s " +
                          " WHERE    s.lesAffectations IS EMPTY ";
                           
     Query    reqJPQL= em.createQuery(texteReqJPQL);
     
     List<Salarie>  lesSalaries= reqJPQL.getResultList() ;    

     System.out.println(lesSalaries);
    
     System.out.println();
    
    }
}
