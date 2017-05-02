package packGrande;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by ElevNr1 (the best of them all) on 2017-03-03.
 */

public class LogIn implements Serializable {
    private Boolean isLogedIn;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLogedIn() {
        return isLogedIn;
    }

    public void setLogedIn(Boolean logedIn) {
        isLogedIn = logedIn;
    }

    public String m1() {
        return "vill du logga in?";
    }

    public String m2() {
        return "Skriv in ditt namn:";
    }

    public String m3() {
        return " du är nu inloggad!";
    }
}
