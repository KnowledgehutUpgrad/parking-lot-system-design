//package parkinglot.factory;
//
//import parkinglot.model.Vehicle;
//import parkinglot.manager.FourWheelerParkingSpotManager;
//import parkinglot.manager.ParkingSpotManager;
//import parkinglot.manager.SixWheelerParkingSpotManager;
//import parkinglot.manager.TwoWheelerParkingSpotManager;
//import parkinglot.model.FourWheelerParkingSpot;
//import parkinglot.model.ParkingSpot;
//import parkinglot.model.SixWheelerParkingSpot;
//import parkinglot.model.TwoWheelerParkingSpot;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static parkinglot.model.Vehicle.*;
//import static parkinglot.config.Configuration.*;
//
//public class ParkingManagerFactory {
//    public ParkingSpotManager getParkingSpotManager(Vehicle vehicle) {
//        if (vehicle == MOTORCYCLE || vehicle == SCOOTER) {
//            return new TwoWheelerParkingSpotManager(getParkingSpots(vehicle, TWO_WHEELER_PARKING_SPOT_COUNT));
//        } else if (vehicle == CAR || vehicle == SUV) {
//            return new FourWheelerParkingSpotManager(getParkingSpots(vehicle, FOUR_WHEELER_PARKING_SPOT_COUNT));
//        } else if (vehicle == BUS || vehicle == TRUCK) {
//            return new SixWheelerParkingSpotManager(getParkingSpots(vehicle, SIX_WHEELER_PARKING_SPOT_COUNT));
//        } else {
//            throw new IllegalArgumentException(
//                    "Vehicle not supported. Please add a Parking spot Manager for " + vehicle.name()
//            );
//        }
//    }
//
//    private List<ParkingSpot> getParkingSpots(Vehicle vehicle, int count) {
//        List<ParkingSpot> parkingSpots = new ArrayList<>();
//        for (int id = 1; id <= count; id++) {
//            parkingSpots.add(getE(id, vehicle));
//        }
//        return parkingSpots;
//    }
//
//    private ParkingSpot getE(int id, Vehicle vehicle) {
//        if (vehicle == MOTORCYCLE || vehicle == SCOOTER) {
//            return new TwoWheelerParkingSpot(id);
//        } else if (vehicle == CAR || vehicle == SUV) {
//            return new FourWheelerParkingSpot(id);
//        } else if (vehicle == BUS || vehicle == TRUCK) {
//            return new SixWheelerParkingSpot(id);
//        } else {
//            throw new IllegalArgumentException(
//                    "Vehicle not supported. Please add a Parking spot Manager for " + vehicle.name()
//            );
//        }
//        return new TwoWheelerParkingSpot(id);
//    }
//}
