package ctrl;

import ejb.SenderAsync;

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

    @Inject
    SenderAsync senderAsync;


    public String submitAsync() {
        senderAsync.sendMessage(getMessage());

        return "index";
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
