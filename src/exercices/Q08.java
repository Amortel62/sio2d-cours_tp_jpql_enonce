
package exercices;

import entites.Affectation;
import entites.Projet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q08 {

    public static void main(String[] args) {
        
        EntityManager em = getEntityManager();   
        
         String texteReqJPQL= " "
                 + "SELECT   pr  FROM Projet pr "
                 + "JOIN FETCH pr.lesAffectations "
                 + "JOIN FETCH pr.leClient "
                 + "where pr.codeproj = 'Alpha'";
                
            Query    reqJPQL2= em.createQuery(texteReqJPQL);
     
            List<Projet>  lesProjets= reqJPQL2.getResultList() ;
            
            for(Projet pr : lesProjets){
            
                System.out.print(pr.getCodeproj()+"   ");
                System.out.print(pr.getDescproj()+"   ");
                System.out.print(pr.getMontantDevis()+"   ");
                System.out.print(pr.getLeClient().getNomcli()+"   ");
                System.out.println(pr.getLesAffectations().size()+" personnes affectées");
                
                for(Affectation af : pr.getLesAffectations()){
                
                    System.out.print(af.getLeSalarie().getNomsal()+"   ");
                    System.out.println(af.getLeProjet().getDescproj());
                
                }
            
            }
           
      
    
          
          
          
      
        
        

    }
}

              