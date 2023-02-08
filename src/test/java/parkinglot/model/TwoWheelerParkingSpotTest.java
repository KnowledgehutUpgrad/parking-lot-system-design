//package parkinglot.model;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TwoWheelerParkingSpotTest {
//    @Test
//    void shouldReturnParkingSpotId() {
//        TwoWheelerParkingSpot twoWheelerParkingSpot = new TwoWheelerParkingSpot(1);
//
//        assertEquals(1, twoWheelerParkingSpot.getId());
//    }
//
//    @Test
//    void shouldReturnFalseForUnoccupiedParkingSpot() {
//        TwoWheelerParkingSpot twoWheelerParkingSpot = new TwoWheelerParkingSpot(1);
//
//        assertFalse(twoWheelerParkingSpot.isOccupied());
//    }
//
//    @Test
//    void shouldReturnTrueForOccupiedParkingSpot() {
//        TwoWheelerParkingSpot twoWheelerParkingSpot = new TwoWheelerParkingSpot(1);
//
//        twoWheelerParkingSpot.park();
//
//        assertTrue(twoWheelerParkingSpot.isOccupied());
//    }
//
//    @Test
//    void shouldReturnFalseWhenParkingSpotIsVacated() {
//        TwoWheelerParkingSpot twoWheelerParkingSpot = new TwoWheelerParkingSpot(1);
//        twoWheelerParkingSpot.park();
//
//        twoWheelerParkingSpot.vacate();
//
//        assertFalse(twoWheelerParkingSpot.isOccupied());
//    }
//}