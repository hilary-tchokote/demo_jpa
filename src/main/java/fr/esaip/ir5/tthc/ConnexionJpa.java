package fr.esaip.ir5.tthc;

import fr.esaip.ir5.tthc.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager em = emf.createEntityManager();

        //EntityTransaction et = em.getTransaction();

        em.getTransaction().begin();

        // R -> CRUD
        // find permettant d’extraire un livre en fonction de son id.
        Livre livre = em.find(Livre.class, 2);
        if (livre != null) {
            System.out.println(livre);
        }

        // C -> CRUD
        Livre newlivre1 = new Livre("Hilary T", "Good Vibes");
        em.persist(newlivre1);

        //Get le livre
        Livre livreFromDB = em.find(Livre.class, newlivre1.getId());

        System.out.println(livreFromDB);


        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
