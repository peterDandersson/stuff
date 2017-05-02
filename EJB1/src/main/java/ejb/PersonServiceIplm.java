package ejb;

import javax.ejb.Stateless;

@Stateless
public class PersonServiceIplm implements PersonService {
    public void add(Person person) {
        System.out.println(person.toString());
    }
}
