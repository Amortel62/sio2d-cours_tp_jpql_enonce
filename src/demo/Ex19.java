
package demo;
import entites.Affectation;
import entites.Salarie;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Ex19 {
    
    public static void main(String[] args) {
        
       EntityManager em= getEntityManager();
      
       Scanner  clavier= new Scanner(System.in); 
       
       String sexe;
       Float  plancher,plafond;
       
       Query reqJPQL=em.createQuery(
               
                " SELECT DISTINCT s                                 " +
                " FROM   Salarie s                                  " +
                " JOIN   FETCH        s.laFonction                  " +
                " LEFT   JOIN   FETCH s.lesAffectations             " +
                " WHERE  s.sexe= :sexe                              " +
                " AND    s.salaire BETWEEN  :plancher AND :plafond  "
       ); 
        
      System.out.println("\nSaisie des paramètres\n"); 
       
      System.out.println("Sexe?");
      sexe=clavier.next();
      
      System.out.println("Salaire plancher?");
      plancher=clavier.nextFloat();
      
      System.out.println("Salaire plafond?");
      plafond=clavier.nextFloat();
      

      System.out.println("\n");
      
      reqJPQL.setParameter("sexe",sexe);
      reqJPQL.setParameter("plancher",plancher);
      reqJPQL.setParameter("plafond" ,plafond);
      
      List<Salarie> listeSalar= reqJPQL.getResultList();
       
      for (Salarie s : listeSalar ){
      
          System.out.printf("%-20s %8.2f € %-60s\n",
            
             s.getNomsal(),
             s.getSalaire(),
             s.getLaFonction().getLibfonct()                  
          );
          System.out.println();
          
          for (Affectation aff : s.getLesAffectations()){
          
              System.out.printf("     %-10s %-60s %-30s\n",
                      
                 aff.getLeProjet().getCodeproj(),
                 aff.getLeProjet().getDescproj(),
                 aff.getLeProjet().getLeClient().getNomcli()
              );      
          }
          System.out.println("\n");
      }  
      System.out.println(); 
      
      
      for (Salarie s : listeSalar) System.out.println(s);
    }
}
