package pack;

import javax.faces.bean.ManagedBean;

/**
 * Created by Elev1 on 2017-03-06.
 */

@ManagedBean
public class MyMain {
    private String message;
    private String input = null;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public MyMain() {
        this.message = "Maven: Hello Sir! What's your name?";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String changeMessage(){
        message = (null != input) ? "Hello " + input : message;
        return message;
    }
}
