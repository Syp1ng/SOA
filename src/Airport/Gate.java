package Airport;
import Airplane.Aircraft;

public class Gate {
    private boolean isOpen;
    private Aircraft aircraft;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}

