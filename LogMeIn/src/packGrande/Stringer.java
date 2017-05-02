package packGrande;

import javax.transaction.Transactional;

/**
 * Created by Elev1 on 2017-03-02.
 */
@Transactional
//@Secured
public interface Stringer {
    @Loggable
    public String givMeString();
}
