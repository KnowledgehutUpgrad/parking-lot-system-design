package parkinglot.factory;

import parkinglot.model.FeeModelStrategyFactory;
import parkinglot.model.Vehicle;

import static parkinglot.model.Vehicle.*;

public class AirportFeeStrategyFactory implements FeeModelStrategyFactory {
    public ParkingFeeStrategy getParkingFeeStrategy(Vehicle vehicle) {
        if(vehicle == MOTORCYCLE) {
            return new TwoWheelerAirportFeeStrategy();
        } else if(vehicle == CAR || vehicle == SUV){
            return new FourWheelerAirportFeeStrategy();
        } else {
            throw new IllegalArgumentException("Vehicle not allowed in Airport parking");
        }
    }
}
