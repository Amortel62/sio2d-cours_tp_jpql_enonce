
package exercices;



import entites.Affectation;
import entites.Projet;
import entites.Salarie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q07 {

    public static void main(String[] args) {
           
        EntityManager em = getEntityManager();    
     
        Projet projet =em.find(Projet.class,"Alpha");
        
        System.out.print(projet.getCodeproj()+"   ");
        System.out.print(projet.getDescproj()+"   ");
        System.out.print(projet.getMontantDevis()+"   ");
        System.out.print(projet.getLeClient().getNomcli()+"   ");
        System.out.println(projet.getLesAffectations().size()+" personnes affectées");
        
        System.out.println("Personnes affectées : ");
        
        for(Affectation A : projet.getLesAffectations()){
        
            System.out.println(A.getLeSalarie());
            
        }
    }
}