
package exercices;

import entites.Projet;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q11 {

    public static void main(String[] args) {
        
        EntityManager em = getEntityManager();
        
        Long numcli;
        
        Scanner  clavier= new Scanner(System.in); 
        
        Query reqJPQL=em.createQuery(
                
                "SELECT SUM(pr.montantDevis) "
              + "FROM   Projet pr "
              + "WHERE  pr.leClient.numcli = :numcli"
        );
        
       
        
         System.out.println("\nSaisie du paramètre\n");
         
         System.out.println("Numéro du client ?");
         numcli=clavier.nextLong();
         
         System.out.println("\n");
      
         reqJPQL.setParameter("numcli",numcli);
        
         Double  sommeSalaires= (Double) reqJPQL.getSingleResult(); 
         
         System.out.print("Somme des devis : ");
         System.out.println(sommeSalaires);
         
        }
          
        

    }


              