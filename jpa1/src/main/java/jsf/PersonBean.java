package jsf;

import domain.PersonDomain;
import ejb.PersonService;
import jpa.Person;
import jpa.SuperPerson;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-20.
 */

@ManagedBean
@RequestScoped
public class PersonBean {
    private Long id;
    private String firstname;
    private String lastname;
    private boolean isHero;
    private int number;

    public boolean isHero() {
        return isHero;
    }

    public void setHero(boolean hero) {
        isHero = hero;
    }

    @EJB
    PersonService personService;

    public String addPerson(){
        if (getId()==null)
            if(isHero)
                personService.addPerson(new SuperPerson(firstname, lastname), getPersons().get(++number < getPersons().size()? number : --number));
            else
                personService.addPerson(new PersonDomain(getFirstname(),getLastname()));
        else
            if (isHero) {
                personService.updatePerson(firstname,lastname,getId());
            }else
                personService.updatePerson(new PersonDomain(getId(),getFirstname(),getLastname()));

        setId(null);
        setFirstname("");
        setLastname("");
        return "person";
    }
    public String editPerson(Long id){
        PersonDomain personDomain = personService.getPerson(id);
        setId(personDomain.getId());
        setFirstname(personDomain.getFirstName());
        setLastname(personDomain.getLastName());
        return "person";
    }

    public String editHero(Long id){
        SuperPerson p = personService.getHero(id);
        setId((long) p.getId());
        setFirstname(p.getHeroName());
        setLastname(p.getPrivateName());
        return "person";
    }

    public String removePerson(Long id){
        if (isHero)
            personService.removeHero(id);
        else
            personService.removePerson(id);

        return "person";
    }
    public List<PersonDomain> getPersons(){
        return personService.getPersons();
    }

    public List<SuperPerson> getHeros() { return personService.getHeros(); }

    public String getSubmitButtonLabel(){
        if (id==null)
            return "Add";
        else
            return "Update";
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
