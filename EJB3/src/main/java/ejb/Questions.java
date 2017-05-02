package ejb;

import javax.ejb.Local;
import java.util.List;

@Local
public interface Questions {
    public List getQuestions(int numberOfQuestions);
    public int getExistingNumber();
}
