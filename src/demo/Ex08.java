
package demo;

import entites.Salarie;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex08 {
    
    public static void main(String[] args) {
       
     // Obtention d'une référence à l'EntityManager   
        
     EntityManager em= getEntityManager();    

     // 
     Scanner clavier = new Scanner(System.in);
     
     Float borne=0f;
     
    // Accès à la liste des Salaries dont le salaire  est supérieur à
    // une valeur passée en paramètre
    // Sélection dès la recherche dans la base

         Query reqJPQL=em.createQuery("Select s from Salarie s where s.salaire > :borne");

         
         System.out.println("Entrez la valeur seuil en Euros");
         borne= clavier.nextFloat();

         reqJPQL.setParameter("borne", borne);
         
         List<Salarie>  lesSalariesAplusDeX=reqJPQL.getResultList();

         System.out.println();
         System.out.println("Liste des salariés dont le salaire est supérieur à "+borne+ " €");
        
         for (Salarie sal : lesSalariesAplusDeX) {
             
              System.out.printf("%-25s %8.2f €\n",sal.getNomsal(),sal.getSalaire());
         }

        System.out.println();
    }
}
