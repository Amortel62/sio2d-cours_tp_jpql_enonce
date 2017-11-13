package appli;

import entites.Affectation;

import entites.Projet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rsmon
 */
public class RequetesJPQLExo {

  
    public static void main(String[] args) {

        EntityManagerFactory     emf= Persistence.createEntityManagerFactory("PU");
        EntityManager            em  =emf.createEntityManager();
//        
       
        // Question N°1

         Projet p=em.find(Projet.class, "Alpha");
         if (p!=null){
             System.out.print(p);
             System.out.println(p.getLeClient().getNomcli());
             for (Affectation a : p.getLesAffectations()){
                 System.out.printf("%s %s\n",a.getLeSalarie().getNomsal(),
                          a.getLeSalarie().getLaFonction().getLibfonct());
             }
         }



        // Question 2

//          Query reqSansProjets= em.createQuery("Select c From Client c where c.lesProjets IS EMPTY");
//          List<Client>  listeC=reqSansProjets.getResultList();
//
//          for(Client c : listeC) System.out.println(c.getNomcli());

        // Question 3

//          Query req= em.createQuery("SELECT DISTINCT s FROM Salarie s JOIN s.lesAffectations  a JOIN a.leProjet p " +
//                                    "WHERE p.codeproj='Alpha' ");
//          List<Salarie>  lesSals= req.getResultList();
//
//          System.out.println();
//          for(Salarie s: lesSals) System.out.println(s);





        // Question 4

//        List<Salarie> aAugmenter=(List<Salarie>) em.createQuery(" SELECT s FROM Salarie s JOIN s.laFonction  f " +
//                                                                         " WHERE s.sexe='F' AND f.codefonct='SLAM' ")
//                                                          .getResultList();
//        for( Salarie s : aAugmenter) System.out.println(s);
//
//        for(Salarie s: aAugmenter) s.setSalaire(s.getSalaire()*1.05F);
//
//        em.getTransaction().begin();
//        em.getTransaction().commit();

        // Question 5

//          Float  taux=0.02F;
//          Query augmenterSalaries=em.createQuery("UPDATE Salarie s SET s.salaire=s.salaire*(1 + :taux )");
//          augmenterSalaries.setParameter("taux", taux);
//
//           em.getTransaction().begin();
//           augmenterSalaries.executeUpdate();
//          em.getTransaction().commit();



        // Question 6
        
//        Long  numcli=1007L;
//        Query suppClient = em.createQuery("DELETE  FROM Client c where c.numcli=:numcli");
//        suppClient.setParameter("numcli", 1007L);
//        em.getTransaction().begin();
//        suppClient.executeUpdate();
//        em.getTransaction().commit();

         
        // Question 7

         
//         Salarie salar1   = em.find(Salarie.class, 102L);
//         Projet  projet1  = em.find(Projet.class, "Gamma");
//
//         Query reqRechAff=em.createQuery("SELECT  aff FROM  Affectation aff " +
//                                                           "WHERE aff.leSalarie=:salar1 " +
//                                                           "AND   aff.leProjet=:projet1 "
//                                                           );
//
//         reqRechAff.setParameter("salar1", salar1);
//         reqRechAff.setParameter("projet1",projet1);
//
//         Affectation affASupp=(Affectation) reqRechAff.getSingleResult();
//
//         projet1.getLesAffectations().remove(affASupp);
//         salar1.getLesAffectations().remove(affASupp);
//
//         em.getTransaction().begin();
//         em.remove(affASupp);
//         em.getTransaction().commit();

        

         // Question 8)

//         Salarie salar   = em.find(Salarie.class, 102L);
//         Projet  projet  = em.find(Projet.class, "ALPHA");
//
//         System.out.println("");
//         System.out.println(salar);
//         System.out.println(projet);
//
//         Affectation aff= new Affectation(projet,salar,UtilDate.parse("23/06/2010"),false);
//
//         em.getTransaction().begin();
//         em.persist(aff);
//         em.getTransaction().commit();
//
//         System.out.println();
//         for(Affectation af : salar.getLesAffectations()) System.out.println(af.getLeProjet().getCodeproj());


//              System.out.println("Effet du merge");
//
//              Fonction fonct=new Fonction("DA","Développeur d'Applic");
//
//               em.merge(fonct);
//
//               em.getTransaction().begin();
//               em.getTransaction().commit();

//            Fonction fonct1=em.find(Fonction.class,"CP");
     
// Question 9
//
//         Query   requete= em.createQuery("SELECT p FROM Projet p WHERE SIZE(p.lesAffectations)>2");
//         List<Projet> lp=requete.getResultList();
//         for(Projet prj : lp ) System.out.println(prj);

  // Question 10
//
//         Query chargeClient= em.createQuery("SELECT  DISTINCT c" +
//                 "                            FROM   Client c" +
//                 "                            JOIN   FETCH c.lesProjets " +
//                 "                            WHERE  c.numcli=1001 ");
//
//         
//
//         Client   client= (Client)chargeClient.getSingleResult();
//
//         System.out.println(client.getNomcli());
//
//          
               
    }


}
