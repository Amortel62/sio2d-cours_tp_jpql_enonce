
package demo;

import entites.Fonction;
import javax.persistence.EntityManager;
import static persistance.Persistance.getEntityManager;

public class Ex03 {
    
    public static void main(String[] args) {
       
     // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    
     
    
     // Accès à une un objet de la classe Fonction à partir de son indentifiant 
     // Exploration du graphe d'objets de racine: fonction
     // Les entités-classes instrumentées vont traduirent les parcours de collection
     // et les références en requêtes SQL si nécessaire

        Fonction fonction=em.find(Fonction.class,"SLAM");
        
        System.out.println();
        
        if (fonction!=null) {
        
            System.out.println();
            System.out.println(fonction.getLibfonct());
            System.out.println();
            
            System.out.printf("\nSomme des salaires: %5.2f\n",fonction.sommeSalaires());
        }
        else {
              
            System.out.println("Fonction inexistante");
        }
        System.out.println();
    }
}
