package se.lexicon.timer;

import javax.ejb.Stateless;

@Stateless
public class HelloService {
    public String sayHello(String from ){
        return "Hello from control + " + from + ": " + System.currentTimeMillis();
    }
}
