package jsf;


import ejb.Counter;
import ejb.Person;
import ejb.PersonService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Front {

    @EJB
    PersonService personService;
    @EJB
    Counter counter;

    private String firstname;
    private String lastname;

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

    public String submit(){
        personService.add(new Person(counter.count(), firstname, lastname));
        firstname = "";
        lastname = "";
        return "index";
    }

}
