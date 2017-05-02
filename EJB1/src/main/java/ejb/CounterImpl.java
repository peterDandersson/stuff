package ejb;

import javax.ejb.Singleton;

@Singleton
public class CounterImpl implements Counter {

    private int ids;

    public int count() {
        return ids++;
    }
}
