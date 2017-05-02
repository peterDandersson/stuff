package rest;

import jpa.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Elev1 on 2017-04-10.
 */

@Stateless
public class PersonResourceIpml implements PersonResource {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> persons(){
        return em.createQuery("select p from Person p order by p.id", Person.class).getResultList();
    }

    @Override
    public Person getPerson(Long id){
        System.out.println(id);
        return em.find(Person.class, id);
    }
}
