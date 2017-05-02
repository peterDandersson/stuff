package jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "getTeacher", query = "SELECT t FROM Teacher t WHERE t.id = :id")
})
@DiscriminatorValue("TEACHER")
public class Teacher extends User_ {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<Course> courses;

    public Teacher(){};

    public Teacher(String email, String password, String firstName, String lastName, String address, Date birthDate) {
        super(email, password, firstName, lastName, address, birthDate);
    }
}
