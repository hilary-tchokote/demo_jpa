package fr.esaip.ir5.tthc;

import fr.esaip.ir5.tthc.bo.Client;
import fr.esaip.ir5.tthc.bo.Emprunt;
import fr.esaip.ir5.tthc.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Requetes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        // 1. Réaliser une requête qui permet d’extraire un emprunt en fonction son id et affichez les livres associés

        Emprunt emprunt = em.find(Emprunt.class, 1);

        if (emprunt != null) {
            System.out.println("Emprunt ID : " + emprunt.getId());
            for (Livre livre : emprunt.getLivres()) {
                System.out.println("Livre : " + livre.getTitre() + " - " + livre.getAuteur());
            }
        } else {
            System.out.println("Aucun emprunt trouvé pour cet ID.");
        }


        // 2. Extraire tous les emprunts d’un client donné

        Client client = em.find(Client.class, 1);

        if (client != null) {
            System.out.println("Emprunts de " + client.getSurname() + " " + client.getName() + " :");
            for (Emprunt e : client.getEmprunts()) {
                System.out.println("Emprunt ID: " + e.getId() + " - Début: " + e.getDateDebut());
            }
        } else {
            System.out.println("Client non trouvé.");
        }


        et.commit();
        em.close();
        emf.close();

    }
}
