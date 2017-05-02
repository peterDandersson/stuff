package jms;

import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MessageService {

    @Inject
    @JMSConnectionFactory("jms/HookyQueue")
    private javax.jms.JMSContext context;
}
