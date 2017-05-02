package ejb;

import domain.PersonDomain;
import jpa.Person;
import jpa.SuperPerson;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.eclipse.persistence.jpa.JpaHelper.createQuery;

/**
 * Created by Solidbeans on 2017-03-20.
 */

@Stateless
public class PersonServiceImpl implements PersonService{
    @PersistenceContext
    EntityManager em;

    @Override
    public void addPerson(PersonDomain person) {
        Person p = new Person(person.getFirstName(),person.getLastName());
        em.persist(p);
    }

    @Override
    public void addPerson(SuperPerson person){
        em.persist(person);
    }

    @Override
    public void addPerson(SuperPerson person, PersonDomain personDomain){
        Person p = em.find(Person.class, personDomain.getId());
        person.setPerson(p);
        List<Person> l = em.createNamedQuery("selectAll").getResultList();
        Set<Person> set = l.stream().collect(Collectors.toSet());
        person.setPersons(set);
        em.persist(person);
    }

    @Override
    public void updatePerson(PersonDomain person) {
        Person p = em.find(Person.class,person.getId());
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        em.merge(p);
    }
    @Override
    public void updatePerson(String sName, String name, Long id){
        //SuperPerson p = em.find(SuperPerson.class, id);
        System.out.println("g");
       /* p.setHeroName(sName);
        p.setPrivateName(name);
        em.merge(p);*/
    }

    @Override
    public PersonDomain getPerson(Long id) {
        Person p = em.find(Person.class,id);
        return new PersonDomain(p.getId(),p.getFirstName(),p.getLastName());
    }

    @Override
    public SuperPerson getHero(Long id) {
        return em.find(SuperPerson.class,id);
    }

    @Override
    public void removePerson(Long id) {
        Person p = em.find(Person.class,id);
        em.remove(p);
    }

    @Override
    public void removeHero(Long id) {
        SuperPerson p = em.find(SuperPerson.class,id);
        em.remove(p);
    }

    @Override
    public List<PersonDomain> getPersons() {

        List<Person> l = em.createNamedQuery("selectAll").getResultList();

        return l.stream().map(p->new PersonDomain(p.getId(),p.getFirstName(),p.getLastName())).collect(Collectors.toList());

    }
    @Override
    public List<SuperPerson> getHeros(){
        return em.createNamedQuery("selectAllHeros").getResultList();
    }
}
