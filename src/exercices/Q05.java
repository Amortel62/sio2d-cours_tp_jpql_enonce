
package exercices;


import entites.Projet;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q05 {

    public static void main(String[] args) {

        EntityManager em= getEntityManager();
      
       Scanner  clavier= new Scanner(System.in); 
       
       Float  seuil;
       
        Query reqJPQL=em.createQuery("SELECT pr FROM Projet pr WHERE pr.montantDevis >:seuil");
        
      System.out.println("\nSaisie des paramètres\n"); 
       
      System.out.println("Seuil?");
      seuil=clavier.nextFloat();
      
       System.out.println("\n");
      
      reqJPQL.setParameter("seuil",seuil);
       
       List<Projet> listeProj= reqJPQL.getResultList();
       
       for(Projet pr : listeProj){
       
           System.out.print(pr.getCodeproj()+"   ");
           System.out.print(pr.getDescproj()+"   ");
           System.out.print(pr.getMontantDevis()+"   ");
           System.out.println(pr.getLeClient().getNomcli()+"   ");
       
       
       
       }
       
       
        
    }
    
      
    
}
