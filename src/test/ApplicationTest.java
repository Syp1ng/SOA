import Airplane.Aircraft;
import Airport.Locations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {


    @Test
    public void GeneralTest(){

        //new Position Test

        Simulator s = new Simulator();
        s.start();
        Aircraft aircraft[]= s.airport.getAircraftList();
        for (int i=0;i<10;i++){
            assertEquals(aircraft[i].getCurrentLocation(), Locations.inTheAir);
        }

        assertEquals(aircraft[10].getCurrentLocation(), Locations.A01);
        assertEquals(aircraft[11].getCurrentLocation(), Locations.A02);
        assertEquals(aircraft[12].getCurrentLocation(), Locations.A03);
        assertEquals(aircraft[13].getCurrentLocation(), Locations.A04);
        assertEquals(aircraft[14].getCurrentLocation(), Locations.A05);
        assertEquals(aircraft[15].getCurrentLocation(), Locations.B01);
        assertEquals(aircraft[16].getCurrentLocation(), Locations.B02);
        assertEquals(aircraft[17].getCurrentLocation(), Locations.B03);
        assertEquals(aircraft[18].getCurrentLocation(), Locations.B04);
        assertEquals(aircraft[19].getCurrentLocation(), Locations.B05);


    }

}