package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-14.
 */
@Singleton
public class CalculationsImpl implements Calculations{
    List<String> calculations;

    @PostConstruct
    public void PostConstruct() {
        calculations = new ArrayList<>();
    }
    @Override
    public void add(double x, double y, double result) {
        calculations.add("Result of adding " + x + " and " + y + " is " + result);
        System.out.println(calculations.size());
    }

    @Override
    public List<String> getResults() {
        return calculations;
    }

    @Override
    public int getResultsSize() {
        return calculations.size();
    }

}
