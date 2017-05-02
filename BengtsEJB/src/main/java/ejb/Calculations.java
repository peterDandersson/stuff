package ejb;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-14.
 */
@Remote
public interface Calculations {
    public void add(double x, double y,double result);
    public List<String> getResults();
    public int getResultsSize();
}
