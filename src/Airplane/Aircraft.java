package Airplane;

import Airport.Locations;
import Events.*;
import com.google.common.eventbus.Subscribe;

public class Aircraft extends Subscriber {
    private AircraftID id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;

    private Locations currentLocation;

    public Aircraft(AircraftID id, String manufacturer, Locations currentLocation) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.currentLocation = currentLocation;
    }

    @Subscribe
    public void receive(TaxiEvent event){
        if(event.getAircraft().id == id){
            System.out.println("Airplane F" + (id + "") + " gets moved from " +
                    currentLocation + " to " + event.getTarget());
            currentLocation = event.getTarget();
        }
    }

    @Subscribe
    public void receive(HoldShortEvent event){
        if(event.getAircraft().id == id){
            System.out.println("Airplane F" + (id + "") + " moves from " +
                    currentLocation + " to " + event.getTarget());
            currentLocation = event.getTarget();
        }
    }

    @Subscribe
    public void receive(RunwayClearedForTakeOffEvent event){
        if(event.getAircraft().id == id){
            System.out.println("Airplane F" + (id + "") + " starts from " + event.getTarget());
            currentLocation = Locations.inTheAir;
        }
    }

    @Subscribe
    public void receive(RunwayClearedToLandEvent event){
        if(event.getAircraft().id == id){
            System.out.println("Airplane F" + (id + "") + " lands on " + event.getTarget());
            currentLocation = event.getTarget();
        }
    }
}
