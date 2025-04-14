package fr.esaip.ir5.tthc.bo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NOM", nullable = false)
    private String name;

    @Column(name = "PRENOM", nullable = false)
    private String surname;

    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunts ; // Reference vers les emprunts

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public Client() {

    }

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}

