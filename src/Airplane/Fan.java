package Airplane;

import java.util.ArrayList;

public class Fan {
    int id;
    int rpm;
    private ArrayList<Blade> blades = new ArrayList<>();

    public Fan(){
        for(int i = 0; i<96;i++) {
            blades.add(new Blade(i, BladeMaterial.Carbon));
        }
    }
    public void start(){
        rpm = 1;
    }

    public void increaseRPM(int value){
        if(rpm!=0){
            rpm+=value;
        }
    }
    public void decreaseRPM(int value){
        if(rpm!=0){
            rpm-=value;
        }
    }
    public void shutdown(){
        rpm=0;
    }


}


