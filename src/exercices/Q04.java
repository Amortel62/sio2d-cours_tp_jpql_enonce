
package exercices;

import entites.Projet;
import entites.Salarie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q04 {

    public static void main(String[] args) {

       EntityManager em= getEntityManager();
       
            String texteReqJPQL= " SELECT   pr  FROM Projet pr where pr.lesAffectations IS EMPTY ";
        
            Query    reqJPQL= em.createQuery(texteReqJPQL);
     
            List<Projet>  lesProjets= reqJPQL.getResultList() ;
            
             System.out.println(lesProjets);
    }
}
