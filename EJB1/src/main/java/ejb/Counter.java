package ejb;

import javax.ejb.Local;

@Local
public interface Counter {
    public int count();
}
