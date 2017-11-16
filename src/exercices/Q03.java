
package exercices;

import entites.Client;
import entites.Fonction;
import entites.Projet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q03 {
    
    public static void main(String[] args) {
     
        EntityManager em= getEntityManager();
        
        Query           reqJPQL1= em.createQuery("select client from Client client");
        
        List<Client>  tousLesClients=reqJPQL1.getResultList();
        
        for(Client c : tousLesClients){
             for(Projet pr : c.getLesProjets()){
           
                 System.out.print(c.getNomcli()+"   ");
                 System.out.println(pr.getMontantDevis());
            
        
             }
        }
        
    }
}
