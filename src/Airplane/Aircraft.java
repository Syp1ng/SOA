package Airplane;

import Airport.Locations;
import Events.*;
import com.google.common.eventbus.Subscribe;

public class Aircraft extends Subscriber {
    public AircraftID getId() {
        return id;
    }
    private Gear[] gear;
    private Wing[] wing;
    private AircraftID id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;

    public Locations getCurrentLocation() {
        return currentLocation;
    }

    private Locations currentLocation;

    public Aircraft(AircraftID id, String manufacturer, Locations currentLocation) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.currentLocation = currentLocation;
        wing = new Wing[2];
        wing[0] = new Wing();
        wing[1] = new Wing();
        gear = new Gear[5];
        gear[0] = new Gear();
        gear[1] = new Gear();
        gear[2] = new Gear();
        gear[3] = new Gear();
        gear[4] = new Gear();

    }

    @Subscribe
    public void receive(TaxiEvent event){
        if(event.getAircraft().id == id){
            flightRecorder("moving from " +currentLocation + " to " +event.getTarget());
            currentLocation = event.getTarget();
        }
    }

    @Subscribe
    public void receive(HoldShortEvent event){
        if(event.getAircraft().id == id){
            currentLocation = event.getTarget();
            flightRecorder("short to runway and holding on " + currentLocation);
        }
    }

    @Subscribe
    public void receive(RunwayClearedForTakeOffEvent event){
        if(event.getAircraft().id == id){
            currentLocation = event.getTarget();
            flightRecorder("starting from " +currentLocation );
            currentLocation = Locations.inTheAir;
        }
    }

    @Subscribe
    public void receive(RunwayClearedToLandEvent event){
        if(event.getAircraft().id == id){
            flightRecorder("landing on " + event.getTarget() + " now");
            currentLocation = event.getTarget();
        }
    }


    public void flightRecorder(String message){
        System.out.println(id+": "+ message);
    }
}
