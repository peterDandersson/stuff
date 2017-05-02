package ejb;

import javax.ejb.Local;

@Local
public interface PersonService {
    public void add(Person person);
}
