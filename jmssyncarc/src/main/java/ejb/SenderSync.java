package ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * Created by brsve_000 on 2016-09-01.
 */
@Stateless
public class SenderSync {

    @Inject
    JMSContext context;

    @Resource(mappedName="jms/jmsQueueSync")
    Queue queueSync;


    public void sendMessage(String message) {

        // sending to jjmsQueueSync queue
        context.createProducer().send(queueSync, message);
        System.out.println("Sent: " + message);

    }
}

