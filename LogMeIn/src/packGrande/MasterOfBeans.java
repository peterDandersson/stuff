package packGrande;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 * Created by Elev1 on 2017-03-02.
 */

@ManagedBean
public class MasterOfBeans {

    @Inject @First
    private Stringer stringIt;

    @Inject @Second
    private Stringer stringItMore;

    public String hello(){
        System.out.println(stringIt.givMeString());
        return stringIt.givMeString() + "  " + stringItMore.givMeString();
    }
}
