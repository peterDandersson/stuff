package ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * Created by Solidbeans on 2017-03-29.
 */
@Stateless
public class SenderAsync {
    @Inject
    JMSContext context;

    @Resource(mappedName="jms/jmsQueueAsync")
    Queue queueAsync;

    public void sendMessage(String message) {
        // sending to jmsQueueAsync queue

        for (int i = 0;i<5;i++) {
            context.createProducer().send(queueAsync, message + " " + i);
        }
        System.out.println("Sent: " + message);

    }
}
