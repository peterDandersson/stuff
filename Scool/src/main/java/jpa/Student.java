package jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
/*@NamedQueries({
        @NamedQuery(name = "getStudent", query = "SELECT s FROM Student s WHERE s.id = :id")
})*/
@DiscriminatorValue("STUDENT")
public class Student extends User_ {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<StudentCourse> courses;

    public Student(){};

    public Student(String email, String password, String firstName, String lastName, String address, Date birthDate) {
        super(email, password, firstName, lastName, address, birthDate);
    }
}
