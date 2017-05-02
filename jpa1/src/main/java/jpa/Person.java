package jpa;

import javax.persistence.*;

/**
 * Created by Solidbeans on 2017-03-20.
 */
@Entity
@NamedQueries({
        @NamedQuery(name="selectAll",query="SELECT p FROM Person p"),
        @NamedQuery(name="selectSome",query="SELECT t FROM Person t WHERE LOCATE(:filt,t.firstName) >0 ")
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String firstName;
    private String lastName;

    @JoinTable(name = "hero_person", joinColumns = @JoinColumn(name = "person_fk"), inverseJoinColumns = @JoinColumn(name = "hero_fk"))
    private SuperPerson sPerson;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, SuperPerson superPerson) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sPerson = superPerson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
