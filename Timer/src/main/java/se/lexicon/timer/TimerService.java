package se.lexicon.timer;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Schedule;
import javax.inject.Inject;

@Singleton
public class TimerService {
    @EJB
    HelloService helloService;
  
    @Schedule(second="*/1", minute="*",hour="*", persistent=false)
    public void doWork(){
        System.out.println("timer: " + helloService.sayHello("doWork1"));
    }

    @Schedule(second="*/3", minute="*",hour="*", persistent=false)
    public void doWork2(){
        System.out.println("timer: " + helloService.sayHello("doWork2"));
    }
}
