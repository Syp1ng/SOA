package Airport;

import Airplane.Aircraft;
import Events.HoldShortEvent;
import Events.RunwayClearedForTakeOffEvent;
import Events.RunwayClearedToLandEvent;
import Events.Subscriber;
import com.google.common.eventbus.EventBus;

public class Tower {
    private EventBus eventbus;

    public Tower(){
        eventbus = new EventBus("Airport Tower");
    }
    public void addSubscriber(Subscriber subscriber){
        eventbus.register(subscriber);
    }
    public void removeSubscriber(Subscriber subscriber){
        eventbus.unregister(subscriber);
    }
    public void callHoldShort(Aircraft aircraft, Checkpoint target){
        eventbus.post(new HoldShortEvent(aircraft, target));
    }

    public void callRunwayClearedForTakeOff(Aircraft aircraft, Runways target){
        eventbus.post(new RunwayClearedForTakeOffEvent(aircraft, target));
        System.out.println("Tower: "+aircraft.getId()+" cleared for takeoff on " + target);
    }

    public void callRunwayClearedToLand(Aircraft aircraft, Runways target){
        eventbus.post(new RunwayClearedToLandEvent(aircraft, target));
        System.out.println("Tower: "+aircraft.getId()+" cleared to land on " + target);
    }

}
