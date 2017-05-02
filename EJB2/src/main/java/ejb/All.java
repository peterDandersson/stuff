package ejb;

import javax.ejb.Local;
import java.util.List;

@Local
public interface All {
    public void add(Message message);
    public List<Message> getList();
}
