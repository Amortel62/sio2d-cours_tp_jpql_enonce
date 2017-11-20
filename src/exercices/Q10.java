
package exercices;

import entites.Projet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q10 {

    public static void main(String[] args) {
        
        EntityManager em = getEntityManager();   
        
        Query reqJPQL=em.createQuery("SELECT SUM(pr.montantDevis) FROM Projet pr");
        
        Double  sommeSalaires= (Double) reqJPQL.getSingleResult(); 
       
        
        System.out.print("Total de tous les devis"+"    ");
        System.out.print(sommeSalaires+" € ");

        
        
        }
          
        

    }


              