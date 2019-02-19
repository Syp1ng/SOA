package Events;

import Airplane.Aircraft;
import Airport.Checkpoint;
import Airport.Locations;

public class HoldShortEvent {
    public Aircraft getAircraft() {
        return aircraft;
    }
    private Aircraft aircraft;
    private Locations target;


    public HoldShortEvent(Aircraft aircraft, Checkpoint target) {
        this.aircraft = aircraft;
        this.target = checkpointToPlace(target);
    }

    public Locations getTarget() {
        return target;
    }

    private Locations checkpointToPlace(Checkpoint checkpoint){
        if (checkpoint == Checkpoint.S1) return Locations.S1;
        else if (checkpoint == Checkpoint.S2) return Locations.S2;
        else if(checkpoint == Checkpoint.S3) return Locations.S3;
        else if(checkpoint == Checkpoint.S4)return Locations.S4;
        return null;
    }
}
