package rest;


import jpa.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonResourceImpl implements PersonResource {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getPersons()
    {
        return entityManager.createQuery("select p from Person p order by p.id", Person.class).getResultList();
    }

    @Override
    public Person getPerson(Long id) {
System.out.println(id);
        return entityManager.find(Person.class,id);
    }


}
