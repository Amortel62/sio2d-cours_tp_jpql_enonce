
package demo;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex18 {
    
    public static void main(String[] args) {
        
     EntityManager em= getEntityManager();    
   
     Query reqJPQL= em.createQuery(
             
             " SELECT SUM(s.salaire)           " +
             " FROM Fonction f  JOIN  f.lesSalaries s" +
             " WHERE f.codefonct=:codefonct"
     );
    
     Scanner clavier= new Scanner(System.in);
     
     String codefonct;
     System.out.println("\nCode  Fonction?");
     codefonct=clavier.next();
     
     reqJPQL.setParameter("codefonct",codefonct);
     
     
     Double  sommeSalaires= (Double) reqJPQL.getSingleResult(); 
     
     System.out.println("\nSomme des salaires: "+sommeSalaires+" €\n");
     
    }
}
