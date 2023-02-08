package parkinglot;

import org.junit.jupiter.api.Test;

import static parkinglot.model.FeeModel.MALL;
import static parkinglot.model.Vehicle.MOTORCYCLE;
import static parkinglot.model.Vehicle.SCOOTER;

class ParkingLotApplicationIntegrationTest {
    @Test
    void run1() {
        ParkingLotApplication parkingLotApplication
                = new ParkingLotApplication(MALL, 2, 0,0);

        parkingLotApplication.park(MOTORCYCLE);
        parkingLotApplication.park(SCOOTER);
        parkingLotApplication.park(SCOOTER);

        parkingLotApplication.unpark(SCOOTER, 2);

        parkingLotApplication.park(MOTORCYCLE);
        parkingLotApplication.unpark(MOTORCYCLE, 1);
    }
}