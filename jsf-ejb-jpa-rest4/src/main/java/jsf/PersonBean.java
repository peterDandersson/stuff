package jsf;

import domain.PersonDomain;
import ejb.PersonService;

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
    private String myFilter;
    @EJB
    PersonService personService;

    public String addPerson(){
        if (getId()==null)
            personService.addPerson(new PersonDomain(getFirstname(),getLastname()));
        else
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
    public String removePerson(Long id){
        personService.removePerson(id);
        return "person";
    }
    public List<PersonDomain> getPersons(){
        return personService.getPersons();
    }
    public List<PersonDomain> getPersonsFilter(){
        if (myFilter==null || myFilter.equals(""))
            return personService.getPersons();
        else
            return personService.getPersonsFirtsNameContain(myFilter);
    }

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

    public String getMyFilter() {
        return myFilter;
    }

    public void setMyFilter(String myFilter) {
        this.myFilter = myFilter;
    }
}
