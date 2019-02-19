package Airport;

import Airplane.Aircraft;
import Events.HoldShortEvent;
import Events.Subscriber;
import Events.TaxiEvent;
import com.google.common.eventbus.EventBus;

public class ApronControl {

    private EventBus eventbus;

    public ApronControl(){
        eventbus = new EventBus("Airport ApronControl");
    }
    public void addSubscriber(Subscriber subscriber){
        eventbus.register(subscriber);
    }
    public void removeSubscriber(Subscriber subscriber){
        eventbus.unregister(subscriber);
    }

    public void callTaxi(Aircraft aircraft, Locations target){
        eventbus.post(new TaxiEvent(aircraft, target));
    }

    public void callHoldShort(Aircraft aircraft, Checkpoint target){
        eventbus.post(new HoldShortEvent(aircraft, target));
    }

}
