package Airplane;

public class Wing {
    WingPosition wingPosition;
    Flap flaps[];
    public Wing(){
        flaps = new Flap[2];
        flaps[0]= new Flap();
        flaps[1]= new Flap();
    }
}

