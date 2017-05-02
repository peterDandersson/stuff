package ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CalculatorImpl implements Calculator {
    @EJB
    Calculations calculations;

    public double add(double x, double y) {
        double result =  x + y;
        calculations.add(x,y,result);
        return result;
    }

}