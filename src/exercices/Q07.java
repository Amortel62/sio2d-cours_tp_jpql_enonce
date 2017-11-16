
package exercices;



import entites.Projet;
import entites.Salarie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static persistance.Persistance.getEntityManager;

public class Q07 {

    public static void main(String[] args) {
           
         EntityManager em= getEntityManager();    
     
        Projet projet =em.find(Projet.class,"Alpha");
        
        System.out.print(projet.getCodeproj()+"   ");
        System.out.print(projet.getDescproj()+"   ");
        System.out.print(projet.getMontantDevis()+"   ");
        System.out.print(projet.getLeClient().getNomcli()+"   ");
       
          Query reqJPQL=em.createQuery(
                "SELECT SIZE(pr.lesAffectations) "
              + "FROM Projet pr "
              + "WHERE pr.codeproj = 'Alpha' ");
        
          Integer unProjet = (Integer) reqJPQL.getSingleResult();
          
          System.out.println(unProjet+" personnes");
          
          System.out.println("");
          
          System.out.println("Personnes affectées : ");
          
          System.out.println("");
          
           List <Salarie> desSalaries= em.createQuery(
      
  //     "SELECT s"
 //    + "FROM  Projet pr"
 //    + "JOIN FETCH pr.lesAffectations "
  //   + "WHERE pr.codeproj = 'Alpha"
                   
     
     ).getResultList();
          
           for(Salarie sal : desSalaries){
           
               System.out.print(sal.getNomsal()+"    ");
               System.out.print(sal.getLaFonction().getCodefonct()+"    ");
           
           
           }
    }
}
