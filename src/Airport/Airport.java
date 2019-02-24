package Airport;

import Airplane.Aircraft;

public class Airport {
    public String name;
    public Tower tower = new Tower();
    private ApronControl apronControl = new ApronControl();
    public Gate[] gate;
    public Runways landingRunway;
    public Runways takeOffRunway;

    public Aircraft[] getAircraftList() {
        return aircraftList;
    }

    private Aircraft aircraftList[];

    public Airport(String name, Aircraft aircraftList[] ) {
        this.name = name;
        this.aircraftList = aircraftList;
        gate = new Gate[10];
        for(int i = 0; i<5; i++){
            gate[i] = new Gate("A0"+(i+1), aircraftList[i]);
            gate[i+5] = new Gate("B0"+(i+1), aircraftList[i+5]);
        }
        for(int i = 0; i<10; i++){
            apronControl.addSubscriber(aircraftList[i]);
            tower.addSubscriber(aircraftList[i+10]);
        }
    }



    private Checkpoint getNextCheckpointFromRunwayLanding(Runways runwayPlace){
        if(runwayPlace == Runways.R1_26R) return Checkpoint.S2;
        else if(runwayPlace == Runways.R1_08L) return Checkpoint.S1;
        else if(runwayPlace == Runways.R2_26L) return Checkpoint.S4;
        else if(runwayPlace == Runways.R2_08R) return Checkpoint.S3;
        return null;
    }
    private Checkpoint getNextCheckpointFromRunwayTakeOff(Runways runwayPlace){
        if(runwayPlace == Runways.R1_26R) return Checkpoint.S1;
        else if(runwayPlace == Runways.R1_08L) return Checkpoint.S2;
        else if(runwayPlace == Runways.R2_26L) return Checkpoint.S3;
        else if(runwayPlace == Runways.R2_08R) return Checkpoint.S4;
        return null;
    }

    public void startSimulation(){

        Gate gateClear = new Gate("nix", null);
        for(int x = 0; x < 10; x++){
            //x+10 Tower: 128.5
            tower.callRunwayClearedToLand(aircraftList[x + 10], landingRunway);
            tower.callHoldShort(aircraftList[x + 10], getNextCheckpointFromRunwayLanding(landingRunway));
            tower.removeSubscriber(aircraftList[x + 10]);
            apronControl.addSubscriber(aircraftList[x + 10]);

            //X AP:121.5
            for(int i = 0; i<10;i++){
                if(gate[i].getAircraft()== aircraftList[x]){
                    gateClear = gate[i];
                    gate[i].setAircraft(null);
                }
            }
            apronControl.callTaxi(aircraftList[x], Locations.valueOf(getNextCheckpointFromRunwayTakeOff(takeOffRunway).toString()));
            apronControl.callHoldShort(aircraftList[x], getNextCheckpointFromRunwayTakeOff(takeOffRunway));
            apronControl.removeSubscriber(aircraftList[x]);
            tower.addSubscriber(aircraftList[x]);

            //x+10 AP:121.5
           apronControl.callTaxi(aircraftList[x + 10], Locations.valueOf(gateClear.getName()));
            for(int i = 0; i<10;i++){
                if(gate[i].getName().equals(aircraftList[x+10].getCurrentLocation().toString())){
                    gate[i].setAircraft(aircraftList[x+10]);
                }
            }

            //X Tower: 128.5
            tower.callRunwayClearedForTakeOff(aircraftList[x], takeOffRunway);
        }
    }


}
