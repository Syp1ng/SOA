import Airplane.Aircraft;
import Airplane.AircraftID;
import Airport.Airport;
import Airport.Locations;
import Airport.Runways;

import java.util.Random;

public class Simulator {

    Runways landing;
    Runways takeOff;
    public Airport airport;


    public Simulator(){

        Aircraft[] aircraft = new Aircraft[20];
        aircraft[0] = new Aircraft(AircraftID.F01,"Airbus", Locations.A01);
        aircraft[1] = new Aircraft(AircraftID.F02,"Airbus", Locations.A02);
        aircraft[2] = new Aircraft(AircraftID.F03,"Airbus", Locations.A03);
        aircraft[3] = new Aircraft(AircraftID.F04,"Airbus", Locations.A04);
        aircraft[4] = new Aircraft(AircraftID.F05,"Airbus", Locations.A05);
        aircraft[5] = new Aircraft(AircraftID.F06,"Airbus", Locations.B01);
        aircraft[6] = new Aircraft(AircraftID.F07,"Airbus", Locations.B02);
        aircraft[7] = new Aircraft(AircraftID.F08,"Airbus", Locations.B03);
        aircraft[8] = new Aircraft(AircraftID.F09,"Airbus", Locations.B04);
        aircraft[9] = new Aircraft(AircraftID.F10,"Airbus", Locations.B05);
        aircraft[10] = new Aircraft(AircraftID.F11,"Airbus", Locations.inTheAir);
        aircraft[11] = new Aircraft(AircraftID.F12,"Airbus", Locations.inTheAir);
        aircraft[12] = new Aircraft(AircraftID.F13,"Airbus", Locations.inTheAir);
        aircraft[13] = new Aircraft(AircraftID.F14,"Airbus", Locations.inTheAir);
        aircraft[14] = new Aircraft(AircraftID.F15,"Airbus", Locations.inTheAir);
        aircraft[15] = new Aircraft(AircraftID.F16,"Airbus", Locations.inTheAir);
        aircraft[16] = new Aircraft(AircraftID.F17,"Airbus", Locations.inTheAir);
        aircraft[17] = new Aircraft(AircraftID.F18,"Airbus", Locations.inTheAir);
        aircraft[18] = new Aircraft(AircraftID.F19,"Airbus", Locations.inTheAir);
        aircraft[19] = new Aircraft(AircraftID.F20,"Airbus", Locations.inTheAir);


        airport = new Airport("München", aircraft);


        Random random = new Random();
        boolean bool = random.nextBoolean();
        if(bool) {
            airport.landingRunway = Runways.R1_08L;
            airport.takeOffRunway = Runways.R2_08R;
        }
        else {
            airport.landingRunway = Runways.R1_26R;
            airport.takeOffRunway = Runways.R2_26L;
        }
    }

    public void start() {
        airport.startSimulation();
    }
}
