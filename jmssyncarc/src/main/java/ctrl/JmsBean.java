package ctrl;

import ejb.ReceivingSync;

import ejb.SenderSync;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Created by brsve_000 on 2016-09-01.
 */
@Named
@RequestScoped
public class JmsBean {
    private String message;
    private boolean doReceive;
    @Inject
    SenderSync senderSync;

    @Inject
    ReceivingSync receivingSync;
    public String submitSync() {

        senderSync.sendMessage(getMessage());
        if (doReceive)
            System.out.println(receivingSync.receiveMessage());
        return "index";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDoReceive() {
        return doReceive;
    }

    public void setDoReceive(boolean doReceive) {
        this.doReceive = doReceive;
    }
}
