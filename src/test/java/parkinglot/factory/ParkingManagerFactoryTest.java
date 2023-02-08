//package parkinglot.factory;
//
//import org.junit.jupiter.api.Test;
//import parkinglot.manager.ParkingSpotManager;
//import parkinglot.manager.TwoWheelerParkingSpotManager;
//
//import static parkinglot.model.Vehicle.MOTORCYCLE;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class ParkingManagerFactoryTest {
//    private final ParkingManagerFactory parkingManagerFactory = new ParkingManagerFactory();
//
//    @Test
//    void shouldReturnParkingSpotManagerForTwoWheeler() {
//        ParkingSpotManager parkingSpotManager = parkingManagerFactory.getParkingSpotManager(MOTORCYCLE);
//
//        assertEquals(TwoWheelerParkingSpotManager.class, parkingSpotManager.getClass());
//    }
//
//    @Test
//    void shouldThrowExceptionForUnsupportedVehicle() {
//        ParkingSpotManager parkingSpotManager = parkingManagerFactory.getParkingSpotManager(MOTORCYCLE);
//
//        assertEquals(TwoWheelerParkingSpotManager.class, parkingSpotManager.getClass());
//    }
//}