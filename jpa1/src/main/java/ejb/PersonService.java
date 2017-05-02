package ejb;

import domain.PersonDomain;
import jpa.SuperPerson;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-20.
 */
@Local
public interface PersonService {

    void addPerson(PersonDomain person);
    void addPerson(SuperPerson person);
    void addPerson(SuperPerson person, PersonDomain personDomain);
    void updatePerson(PersonDomain person);
    void updatePerson(String sName, String name, Long id);
    PersonDomain getPerson(Long id);
    SuperPerson getHero(Long id);
    void removePerson(Long id);
    void removeHero(Long id);
    List<PersonDomain> getPersons();
    List<SuperPerson> getHeros();
}
