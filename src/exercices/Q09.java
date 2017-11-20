
package exercices;

import entites.Projet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q09 {

    public static void main(String[] args) {
        
        EntityManager em = getEntityManager();   
        
        Query reqJPQL=em.createQuery("SELECT projet FROM Projet  projet  WHERE projet.montantDevis = (SELECT MAX(projet1.montantDevis) FROM Projet projet1)");
        
        List<Projet> listeProj= reqJPQL.getResultList();
        
        System.out.println("Projet(s) dans le coût est le plus élevé : ");
        System.out.println("");
        
        for(Projet pr : listeProj){
        
            System.out.print(pr.getCodeproj()+"    ");
            System.out.print(pr.getDescproj()+"    ");
            System.out.print(pr.getMontantDevis()+"    ");
            System.out.print(pr.getLeClient().getNomcli()+"    ");
            
        
        }
          
        

    }
}

              