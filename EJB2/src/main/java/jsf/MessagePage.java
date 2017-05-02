package jsf;

import ejb.All;
import ejb.Message;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class MessagePage {

    @EJB
    All all;

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String submit(){
        name = (name.length()> 0) ? name : "John Doe";
        System.out.println(name + "  " + message);
        all.add(new Message(name, message));
        name = "";
        message = "";
        return "index";
    }

    public List<Message> getMessages(){
        return all.getList();
    }
}
