package Airport;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Tower {
    private EventBus eventbus;

    public Tower(){
        eventbus = new EventBus("Airport Tower");
    }
    public void addSubscriber(Subscriber subscriber){
        //System.out.println(subscriber.getClass());
        eventbus.register(subscriber);
    }
    public void removeSubscriber(Subscriber subscriber){
        eventbus.unregister(subscriber);
    }

}
