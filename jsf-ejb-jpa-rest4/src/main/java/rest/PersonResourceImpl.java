package rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import jpa.Person;
import jpa.PersonList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;
import java.io.IOException;

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
        return entityManager.find(Person.class,id);
    }

    @Override
    public void removePerson(Long id){
        Person p = entityManager.find(Person.class,id);
        entityManager.remove(p);
    }

    @Override
    public Person addPerson(Person p) {
        System.out.println("Add");
        System.out.println(p);
        entityManager.persist(p);
        return p;
    }

/*    @Override
    public void addPersons(String jsonString) {

        ObjectMapper mapper = new ObjectMapper();
        PersonList pList = null;
        try {
            pList = mapper.readValue(jsonString, PersonList.class);
            for (Person p :  pList.getPersonList()) {

                  entityManager.persist(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

/*    @Override
    public Person updatePerson(Long id, Person p) {
        Person pUpdate = entityManager.find(Person.class,id);
        pUpdate.setFirstName(p.getFirstName());
        pUpdate.setLastName(p.getLastName());
        entityManager.merge(pUpdate);
        return pUpdate;
    }*/
}
