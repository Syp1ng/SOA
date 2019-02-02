package Airplane;

import java.util.ArrayList;

public class Fan {
    int id;
    int rpm;
    private ArrayList<Blade> blades = new ArrayList<>();

    public Fan(){
        for(int i = 0; i<96;i++) {
            //blades.add(new Blade(i, bladeMaterial));
        }
    }
    public void start(){
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


