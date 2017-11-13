
package demo;

import entites.Fonction;
import entites.Salarie;
import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;

public class Ex02b {
    
    public static void main(String[] args) {
       
     // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
     

     

        Fonction fonction=(Fonction)em.createQuery("SELECT f FROM Fonction f JOIN FETCH  f.lesSalaries WHERE f.codefonct='SLAM'").getSingleResult();
        
        System.out.println();
        
        if (fonction!=null) {
        
            System.out.println();
            System.out.println(fonction.getLibfonct());
            System.out.println("\n");
            
            for(Salarie  sal : fonction.getLesSalaries()){
              
              System.out.printf("%-25s  %2s %5.2f €\n",
                                sal.getNomsal(),sal.getSexe(),sal.getSalaire()
                               );           
            } 
            for(Salarie  sal : fonction.getLesSalaries()){
              
              System.out.printf("%-25s  %2s %5.2f €\n",
                                sal.getNomsal(),sal.getSexe(),sal.getSalaire()
                               );           
            }    
        }
        else {
              
            System.out.println("Fonction inexistante");
        }
        System.out.println();
    }
}
