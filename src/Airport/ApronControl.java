package Airport;

import Airplane.Aircraft;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class ApronControl {
    private EventBus eventBus;

    private String name;

    public ApronControl(String name) {
        eventBus = new EventBus("Apron Control");
    }
    public void addSubscriber(Subscribe subscriber) {
        eventBus.register(subscriber);
    }

    public void removeSubscriber(Subscribe subscriber) {
        eventBus.unregister(subscriber);
    }

    //don't know which one is better
    public void taxi(Aircraft aircraft,
                     Location start,
                     List<Location> junktions, Location end){
        eventBus.post(new TaxiEvent(aircraft,start,junktions,end));
    }
    public void callTaxi(int aircraftID, Place target){
        eventbus.post(new TaxiEvent(aircraftID, target));
        Airport.writeLog("ApronControl, ID: " + aircraftID + ", Taxi " + target);
    }
}
