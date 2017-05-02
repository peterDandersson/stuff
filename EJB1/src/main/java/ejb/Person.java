package ejb;

public class Person {
    private int Id;
    private String firstname;
    private String lastname;

    public Person(int id, String firstname, String lastname) {
        Id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
