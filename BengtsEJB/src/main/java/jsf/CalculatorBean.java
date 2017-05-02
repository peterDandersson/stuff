package jsf;

import ejb.Calculations;
import ejb.CalculationsStateful;
import ejb.Calculator;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class CalculatorBean {

    @EJB
    Calculator calculator;
    @EJB
    Calculations calculations;
    @EJB
    CalculationsStateful calculationsStateful;

    private double x;
    private double y;
    private double result;

    private double preX;
    private double preY;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double getPreX() {
        return preX;
    }

    public double getPreY() {
        return preY;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public List<String> getResults(){
        return calculations.getResults();
    }
    public int getResultsSize(){
        return calculations.getResultsSize();
    }
    public int getResultsSizeStatful(){
        return calculationsStateful.getResultsSize();
    }

    public String add() {
        result = calculator.add(x, y);
        calculationsStateful.add(x,y,result);
        preX = x;
        preY = y;
        x = 0;
        y = 0;
        return "success";
    }
}