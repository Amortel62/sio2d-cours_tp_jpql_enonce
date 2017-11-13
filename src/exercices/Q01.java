
package exercices;

import entites.Client;
import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;

public class Q01 {
    
    public static void main(String[] args) {
       
        EntityManager em= getEntityManager();
        
        Client client = em.find(Client.class, 1001);
        
        System.out.println( client.getNomcli());
        
        
        
        
    }
}
