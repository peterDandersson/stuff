package packGrande;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

/**
 * Created by ElevNr1 (the best of them all) on 2017-03-03.
 */
@ConversationScoped
public class LogIn implements Serializable {

    @Inject
    private Conversation conversation;

    private Boolean isLogedIn;
    private String name;

    public void initLogIn() {
        conversation.begin();
    }

    public void endLogIn(){
        conversation.end();
    }

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
