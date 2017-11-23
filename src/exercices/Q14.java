
package exercices;

import entites.Projet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;
import resumes.ResumeClient;

public class Q14 {
    
    public static void main(String[] args) {
        
      EntityManager em= getEntityManager();    
   
      Query reqJPQL= em.createQuery(
             
           " SELECT  new resumes.ResumeClient(c , SUM(p.montantDevis), COUNT(p) ) " +
           " FROM    Client c  JOIN  c.lesProjets p                                " +
           " GROUP   BY c                                                         "
      );
    
      List<ResumeClient> desResumes= reqJPQL.getResultList();
      
      System.out.println("\n\n\nListe des clients \n\n");
        
      for(ResumeClient  rc : desResumes ){
              
         System.out.printf("%-4d %-40s Somme des devis: %7.2f € Nb de Projets: %2d\n\n",
                    
           rc.getClient().getNumcli(),
           rc.getClient().getNomcli(),
           rc.getSommeDevis(),
           rc.getNbProjets()       
         );
         
         for (Projet p: rc.getClient().getLesProjets()){
         
               System.out.printf("%-50s %8.2f €\n", p.getDescproj(),p.getMontantDevis());
         }
         System.out.println("\n\n");
      }
      System.out.println("\n\n\n");
    }
}
