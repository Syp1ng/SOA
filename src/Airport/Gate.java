package Airport;
import Airplane.Aircraft;

public class Gate {
    private boolean isOpen;
    private Aircraft aircraft;

    public String getName() {
        return name;
    }

    private String name;

    public Gate(String name,Aircraft aircraft) {
        this.aircraft = aircraft;
        this.name = name;
    }

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

