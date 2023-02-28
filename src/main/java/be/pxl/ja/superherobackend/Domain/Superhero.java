package be.pxl.ja.superherobackend.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "superheroes")
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String LastName;
    private String superheroName;

    public Superhero(){
        //JPA only
    }

    public Superhero(String firstname, String lastname, String superheroName) {
        this.firstName = firstname;
        this.LastName = lastname;
        this.superheroName = superheroName;
    }
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    @Override
    public String toString() {
        return superheroName;
    }

}
