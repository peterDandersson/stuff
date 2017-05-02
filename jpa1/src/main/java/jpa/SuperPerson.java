package jpa;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Elev1 on 2017-03-23.
 */
@Entity
@Table(name = "SUPER_PERSONS")
@NamedQueries({
        @NamedQuery(name="selectAllHeros",query="SELECT p FROM SuperPerson p")
})
public class SuperPerson {

    @Id @GeneratedValue
    private Long id;

    @Transient
    private String heroName;
    @Transient
    private String privateName;

    private String firstName;
    private String lastName;

    @JoinTable(name = "hero_person", joinColumns = @JoinColumn(name = "hero_fk"), inverseJoinColumns = @JoinColumn(name = "person_fk"))
    private Person person;

    @PostLoad
    @PostPersist
    @PostUpdate
    public void setPersona(){
        heroName = "Super" + firstName;
        privateName = firstName + " " + lastName;
    }

    private Set<Person> persons;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public SuperPerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public SuperPerson(String firstName, String lastName, Person person) {
        this.person = person;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public SuperPerson(){ }

    @Override
    public String toString() {
        return "SuperPerson{" +
                "id=" + id +
                ", heroName='" + heroName + '\'' +
                ", privateName='" + privateName + '\'' +
                '}';
    }

    public String getHeroName() {
        return heroName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }

}
