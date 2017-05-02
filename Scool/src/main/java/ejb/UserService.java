package ejb;

import javax.ejb.Local;

/**
 * Created by Elev1 on 2017-03-31.
 */
@Local
public interface UserService {
    public String logIn(String email, String password);
    public void createStudent(String email, String password);
    public String strudentToString();
}
