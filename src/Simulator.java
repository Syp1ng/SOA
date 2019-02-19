import Airplane.Aircraft;
import Airplane.AircraftID;
import Airport.Airport;
import Airport.Locations;
import Airport.Runways;
import Events.RunwayClearedToLandEvent;

import java.util.Random;

public class Simulator {

    Runways landing;
    Runways takeOff;


    public Simulator(){
        Airport airport = new Airport("München");

        Aircraft F01 = new Aircraft(AircraftID.F01,"Airbus", Locations.A01);
        Aircraft F02 = new Aircraft(AircraftID.F02,"Airbus", Locations.A02);
        Aircraft F03 = new Aircraft(AircraftID.F03,"Airbus", Locations.A03);
        Aircraft F04 = new Aircraft(AircraftID.F04,"Airbus", Locations.A04);
        Aircraft F05 = new Aircraft(AircraftID.F05,"Airbus", Locations.A05);
        Aircraft F06 = new Aircraft(AircraftID.F06,"Airbus", Locations.B01);
        Aircraft F07 = new Aircraft(AircraftID.F07,"Airbus", Locations.B02);
        Aircraft F08 = new Aircraft(AircraftID.F08,"Airbus", Locations.B03);
        Aircraft F09 = new Aircraft(AircraftID.F09,"Airbus", Locations.B04);
        Aircraft F10 = new Aircraft(AircraftID.F10,"Airbus", Locations.B05);
        Aircraft F11 = new Aircraft(AircraftID.F11,"Airbus", Locations.inTheAir);
        Aircraft F12 = new Aircraft(AircraftID.F12,"Airbus", Locations.inTheAir);
        Aircraft F13 = new Aircraft(AircraftID.F13,"Airbus", Locations.inTheAir);
        Aircraft F14 = new Aircraft(AircraftID.F14,"Airbus", Locations.inTheAir);
        Aircraft F15 = new Aircraft(AircraftID.F15,"Airbus", Locations.inTheAir);
        Aircraft F16 = new Aircraft(AircraftID.F16,"Airbus", Locations.inTheAir);
    }

    public void start() {
        Random r = new Random();
        boolean x =r.nextBoolean();
      if(x){
          landing = Runways.R1_08L;
          takeOff = Runways.R1_26R;
      }
      else {
          takeOff = Runways.R1_08L;
          landing = Runways.R1_26R;
      }
    }
}
