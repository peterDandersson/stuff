package jsf;

import javax.faces.bean.ManagedBean;

/**
 * Created by Elev1 on 2017-03-21.
 */

@ManagedBean
public class Page {
    private String inOut;

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }
    public String out(){
        if (inOut != null)
            return "   = " + inOut;
        else
            return "";
    }
}
