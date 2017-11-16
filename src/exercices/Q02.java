
package exercices;

import entites.Client;
import entites.Projet;
import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;

public class Q02 {
    
    public static void main(String[] args) {
          
         EntityManager em= getEntityManager();
        
       Client client=em.find(Client.class,1001L);
    
        System.out.println(client.getNomcli()); 
        System.out.println("");
       
        for(Projet pr : client.getLesProjets()){
        
            System.out.print(pr.getCodeproj()+"        ");
            System.out.println(pr.getDescproj());
            
        
        }
        
     
     }
}
