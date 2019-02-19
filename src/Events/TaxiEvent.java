package Events;


import Airplane.Aircraft;
import Airport.Locations;

public class TaxiEvent {
    private Aircraft aircraft;

    public Locations getTarget() {
        return target;
    }

    private Locations target;
    public Aircraft getAircraft() {
        return aircraft;
    }


    public TaxiEvent(Aircraft aircraft, Locations target){
        this.aircraft = aircraft;
        this.target = target;
    }


}
