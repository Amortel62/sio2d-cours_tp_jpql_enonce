
package demo;

import entites.Fonction;
import entites.Salarie;
import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;

public class Ex13 {
    
    public static void main(String[] args) {
       
     // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
     
     Fonction   fonction=em.find(Fonction.class,"SISR");
        
     System.out.println();
        
     if (fonction!=null) {
        
        System.out.printf("\n%-30s\n",
                
                fonction.getLibfonct()
        );
     }
     else {
              
        System.out.println("Fonction inexistante");
     }
     
     
     Salarie s= new Salarie();
     
     s.setNumsal(160L);
     s.setNomsal("LeRouge Anne-Marie");
     s.setSexe("F");
     s.setSalaire(2133f);
     
     s.setLaFonction(fonction);
     fonction.getLesSalaries().add(s);
   
     
     em.getTransaction().begin();
     
       em.merge(fonction);     
     
     em.getTransaction().commit();
     
     System.out.println();
    }
}
