/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appli;


import entites.Fonction;
import entites.Salarie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author rsmon
 */
public class RequetesJPQL_Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PU");
        EntityManager        em  =emf.createEntityManager();
        
        ////////////////////////////////////////////////////////////////////////////////////////////////
        // JPQL PARTIE 1
        ///////////////////////////////////////////////////////////////////////////////////////////////

        // 1° Acces par la cle

        // Exploration du graphe d objets de racine: fonction
        // Les entities classes instrumentées vont traduirent les parcours de collection
        // et les références en requêtes SQL si nécessaire

        Fonction fonction=em.find(Fonction.class,"SLAM");
        
        System.out.println();
        
        if (fonction!=null) {
        
            System.out.println();
            System.out.println(fonction.getLibfonct());
            System.out.println();
            
            for(Salarie  sal : fonction.getLesSalaries()){
              
              System.out.printf("%s  %2s %5.2f\n",sal.getNomsal(),sal.getSexe(),sal.getSalaire());            }
              System.out.printf("Somme des salaires: %5.2f\n",fonction.sommeSalaires());
        }
        else {
              
              System.out.println("Fonction inexistante");
        }
        
        System.out.println();
        
        // 2° Accès à la liste de toutes les fonctions

//        Query  reqJPQL1= em.createQuery("select fonction from Fonction fonction");
//        List<Fonction>  toutesLesfonctions=reqJPQL1.getResultList();
//
//        System.out.println();
//        for (Fonction  f : toutesLesfonctions) System.out.println(f);

        // 3°Accès à la liste des Salaries dont le salaire  est supérieur à 2500
        //   Sélection dès la recherche dans la base

//        Query reqJPQL2=em.createQuery("Select s from Salarie s where s.salaire>2100");
//        List<Salarie>  lesSalariesAplus2500=reqJPQL2.getResultList();
//
//        System.out.println();
//        for (Salarie s : lesSalariesAplus2500) System.out.println(s);

        // 4°Accès à la liste des Salaries dont le salaire  est supérieur à
        //   une valeur passée en paramètre
        //   Sélection dès la recherche dans la base

//         Query reqJPQL3=em.createQuery("Select s from Salarie s where s.salaire>:borne");
//
//         Float borne=2150f;
//
//         reqJPQL3.setParameter("borne", borne);
//         
//         List<Salarie>  lesSalariesAplusX=reqJPQL3.getResultList();
//
//         System.out.println();
//         System.out.println("Liste des salariés dont le salaire est supérieur à "+borne);
//         for (Salarie s : lesSalariesAplusX) System.out.println(s);


        // 5° Modification d'un objet managé ( = attaché au contexte de persistance)
        //    Modification du salaire d'un salarié

//        Salarie salM =em.find(Salarie.class,105L);
//
//        salM.setSalaire(2250f);
//        em.getTransaction().begin();
//        em.getTransaction().commit();

        // 6° Détachement de tous les objets;

//        em.clear();
//
//        // plus aucun objet n'est managé car fermeture de session
//        // Les instructions qui suivent ne changeront pas la valeur du salaire
//
//
//        em.getTransaction().begin();
//        salM.setSalaire(0f);
//        em.getTransaction().commit();

        // 7° Nous réattachons le salarié au contexte de persistance

//         em.merge(salM);
//         em.getTransaction().begin();
//         salM.setSalaire(0f);
//         em.getTransaction().commit();

        // La modification va donc être répercutée dans la base

      //  8°Supprimer le  salarie de numero  102 s'il existe et  qu'il n'est affecté à aucun projet

//        Salarie salSupp= em.find(Salarie.class, 102L);
//
//        if (salSupp!=null){
//            if(salSupp.getLesAffectations().isEmpty()){
//              em.getTransaction().begin();
//              em.remove(salSupp);
//              em.getTransaction().commit();
//            }
//            else{System.out.printf("\nSuppression refusée: ce salarié est affecté à des projets\n\n"); }
//         }
//         else{ System.out.println("Ce salarié n'existe pas");}


        // JPQL PARTIE 2



        //Liste des projets  où des  Administratices réseaux  sont affectées

//        System.out.println("");
//        Query reqJPQL4=em.createQuery(
//                
//                "SELECT DISTINCT p FROM Projet p JOIN p.lesAffectations  a " +
//                "JOIN a.leSalarie s " +
//                "WHERE s.sexe='F' AND s.laFonction.codefonct='SISR'"
//         
//         );
//
//         List<Projet>  lesProjetsAvecAdminFem=reqJPQL4.getResultList();
//
//         System.out.printf("\nListe des projets  où des  Administrices réseaux  sont affectées\n\n");
//         for ( Projet  p : lesProjetsAvecAdminFem ) System.out.println(p);


        // Liste des salariés non affectés à un projet
//
//         Query reqJPQL5=em.createQuery("Select s from Salarie s where s.lesAffectations IS EMPTY");
//         List<Salarie>  lesSalariesNonAffectes=reqJPQL5.getResultList();
//
//         System.out.printf("\nLes salariés non affectés\n\n");
//         for (Salarie s : lesSalariesNonAffectes) System.out.println(s);


         //Liste des salariés affectés à au moins 2 projets

//         Query reqJPQL6=em.createQuery(
//                 "SELECT s  FROM Salarie s  WHERE SIZE(s.lesAffectations) >= 2"
//         );
//         List<Salarie>  lesSalariesAffectesPlus2=reqJPQL6.getResultList();
//
//         System.out.printf("\nListe des salariés affectés à plus de 2 projets\n\n");
//         for (Salarie s : lesSalariesAffectesPlus2) System.out.println(s);

        
        //  Group by

//        Query reqJPQL7=em.createQuery(
//                 
//                 "Select f, sum(s.salaire) " +
//                 "From   Fonction f JOIN f.lesSalaries s  group by f "
//        );
//
//        System.out.println();
//        
//        for(Object obj : reqJPQL7.getResultList() ){
//            
//            Object[] tobj=( Object[])obj;
//            
//            System.out.printf("%-40s %7.2f €\n ",((Fonction)tobj[0]).getLibfonct(),(Double)tobj[1]);
//        }
//         
//         
        
    }


}
