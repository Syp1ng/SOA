package Airplane;

public class Gear {
    GearType type;
    private boolean isDown;
    private boolean isBrakeSet;

    public void up(){
        isDown=false;
    }

    public void down(){
        isDown=true;
    }

    public void setBrake(){
        isBrakeSet=true;
    }

    public void releaseBrake(){
        isBrakeSet=false;
    }
}
