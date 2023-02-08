package parkinglot.model;

import parkinglot.factory.ParkingFeeStrategy;

public interface FeeModelStrategyFactory {
    public ParkingFeeStrategy getParkingFeeStrategy(Vehicle vehicle);
}
