package jpa;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@NamedQueries({
        @NamedQuery(name = "LogIn", query = "SELECT u FROM User_ u WHERE u.email = :email AND u.password = :password"),
        @NamedQuery(name = "getStudent", query = "SELECT s FROM Student s WHERE s.id = :id")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ROLE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USER")
public class User_ {
    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthDate;

    public User_(){};

    public User_(String email, String password, String firstName, String lastName, String address, Date birthDate) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = birthDate;
    }

    @Transient
    public String getDecriminatorValue() {
        try {
            return this.getClass().getAnnotation(DiscriminatorValue.class).value();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "no";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

/*    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private Date birthDate;*/

    @Override
    public String toString() {
        return "User_{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
