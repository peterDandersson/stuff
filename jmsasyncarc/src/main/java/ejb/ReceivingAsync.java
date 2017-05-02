package ejb;


import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by brsve_000 on 2016-09-01.
 */

@MessageDriven(mappedName = "jms/jmsQueueAsync")
public class ReceivingAsync  {

    public void onMessage(Message message) {
        TextMessage msg = null;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                System.out.println("Async Received: " + msg.getText());
            } else {
                System.out.println("Message is not a " + "TextMessage");
            }
        } catch (JMSException e) {
            System.out.println("JMSException in onMessage(): " + e.toString());
        }
    }
}
