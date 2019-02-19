package Events;

import Airplane.Aircraft;
import Airport.Checkpoint;
import Airport.Locations;
import Airport.Runways;

public class RunwayClearedForTakeOffEvent {
    public Aircraft getAircraft() {
        return aircraft;
    }

    private Aircraft aircraft;
    private Locations target;


    public Locations getTarget() {
        return target;
    }

    public RunwayClearedForTakeOffEvent(Aircraft aircraft, Runways target) {
        this.aircraft = aircraft;
        this.target = runwayToPlace(target);
    }

    private Locations runwayToPlace(Runways place){
        if(place == Runways.R1_08L) return Locations.R1_08L;
        else if(place == Runways.R2_08R) return Locations.R2_08R;
        else if(place == Runways.R1_26R) return Locations.R1_26R;
        else if(place == Runways.R2_26L) return Locations.R2_26L;
        return null;
    }

}
