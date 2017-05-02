package jsf;

import ejb.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LogIn {

    @EJB
    UserService us;

    private String email;
    private String password;

    public String logIn(){
        us.createStudent(email,password);
        return us.logIn(email, password);
    }

    public void createStudent(){
        //email = "peter@java.com";
        //password = "Hej123";
        us.createStudent(email,password);
        logIn();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String myStudentInfo(){
        us.logIn(email, password);
        return us.strudentToString();
    }
}
