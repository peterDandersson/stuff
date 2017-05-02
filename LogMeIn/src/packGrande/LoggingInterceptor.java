package packGrande;

import org.jboss.weld.context.beanstore.ejb.InvocationContextBeanStore;

import javax.enterprise.inject.Intercepted;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

/**
 * Created by Elev1 on 2017-03-03.
 */
@Loggable
@Interceptor
public class LoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    private Object Intercept(InvocationContext ic) throws Exception {
        logger.info("> Entry" + ic.getMethod());
        return ic.proceed();
    }
}
