package fr.esaip.ir5.tthc.bo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt implements java.io.Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "DATE_DEBUT")
    private LocalDate dateDebut;

    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    @Column(name = "DELAI")
    private Integer delai;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName= "ID")
    )

    private Set<Livre> livres ;


    public Emprunt(){

    }

    public Emprunt(Integer id, LocalDate dateDebut, LocalDate dateFin, Integer delai) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }


    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", delai=" + delai +
                '}';
    }


}