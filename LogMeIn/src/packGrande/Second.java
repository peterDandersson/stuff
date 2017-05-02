package packGrande;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Created by Elev1 on 2017-03-02.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Documented
public @interface Second {
}
