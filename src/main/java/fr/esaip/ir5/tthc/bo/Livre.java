package fr.esaip.ir5.tthc.bo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="LIVRE")
public class Livre implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false, unique = true)
    private Integer id;

    @Column(name="TITRE",length = 50, nullable = false)
    private String titre;

    @Column(name="AUTEUR", length = 30,nullable = false)
    private String auteur;

    @ManyToMany(mappedBy = "livres")
    private Set<Emprunt> emprunts ;

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public Livre() {

    }

    public Livre(String auteur, String titre) {
        this.auteur = auteur;
        this.titre = titre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }
}
