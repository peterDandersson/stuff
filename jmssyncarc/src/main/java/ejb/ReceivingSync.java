package ejb;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;
import java.util.Enumeration;


/**
 * Created by brsve_000 on 2016-09-01.
 */
@Stateless
public class ReceivingSync {
    @Inject
    private JMSContext context;

    @Resource(mappedName="jms/jmsQueueSync")
    Queue queueSync;

    public String receiveMessage() {
        String message;
        StringBuilder sb = new StringBuilder();
        Enumeration qE = null;
        try {
            // browse through all messages
            qE = context.createBrowser(queueSync).getEnumeration();
            while (qE.hasMoreElements()) {
                TextMessage textMessage = (TextMessage) qE.nextElement();
                sb.append( textMessage.getText() );
                sb.append(System.lineSeparator());
            }
            // remove all messages
            removeMeaasges();
            if (sb.length() > 0)
                return "Sync Received " + sb.toString();

            return "Sync Received nothing" ;
        } catch (JMSException e) {
            System.out.println("JMSException in onMessage(): " + e.toString());
        }
        return "";
    }
    private void removeMeaasges() throws JMSException {
        JMSConsumer consumer = context.createConsumer(queueSync);
        Message message = null;
        do {
            message = consumer.receiveNoWait();
            if (message != null) message.acknowledge();
        }
        while (message != null);
    }
}
