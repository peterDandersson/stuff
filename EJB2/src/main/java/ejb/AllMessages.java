package ejb;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class AllMessages implements All {

    private List<Message> messages;

    public AllMessages() {
        this.messages = new ArrayList<Message>();
    }

    public void add(Message message) {
       messages.add(message);
    }

    public List<Message> getList() {
        return messages;
    }
}
