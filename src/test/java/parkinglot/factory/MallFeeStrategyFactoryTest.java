package parkinglot.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static parkinglot.model.Vehicle.*;

class MallFeeStrategyFactoryTest {
    @Test
    void ShouldReturnStrategyForTwoWheelerWhenVehicleIsMotorcycle() {
        MallFeeStrategyFactory mallFeeStrategyFactory = new MallFeeStrategyFactory();

        ParkingFeeStrategy parkingFeeStrategy = mallFeeStrategyFactory.getParkingFeeStrategy(MOTORCYCLE);

        assertEquals(TwoWheelerMallFeeStrategy.class, parkingFeeStrategy.getClass());
    }

    @Test
    void ShouldReturnStrategyForTwoWheelerWhenVehicleIsScooter() {
        MallFeeStrategyFactory mallFeeStrategyFactory = new MallFeeStrategyFactory();

        ParkingFeeStrategy parkingFeeStrategy = mallFeeStrategyFactory.getParkingFeeStrategy(SCOOTER);

        assertEquals(TwoWheelerMallFeeStrategy.class, parkingFeeStrategy.getClass());
    }

    @Test
    void ShouldReturnStrategyForFourWheelerWhenVehicleIsCar() {
        MallFeeStrategyFactory mallFeeStrategyFactory = new MallFeeStrategyFactory();

        ParkingFeeStrategy parkingFeeStrategy = mallFeeStrategyFactory.getParkingFeeStrategy(CAR);

        assertEquals(FourWheelerMallFeeStrategy.class, parkingFeeStrategy.getClass());
    }

    @Test
    void ShouldReturnStrategyForFourWheelerWhenVehicleIsSuv() {
        MallFeeStrategyFactory mallFeeStrategyFactory = new MallFeeStrategyFactory();

        ParkingFeeStrategy parkingFeeStrategy = mallFeeStrategyFactory.getParkingFeeStrategy(SUV);

        assertEquals(FourWheelerMallFeeStrategy.class, parkingFeeStrategy.getClass());
    }

    @Test
    void ShouldReturnStrategyForSixWheelerWhenVehicleIsBus() {
        MallFeeStrategyFactory mallFeeStrategyFactory = new MallFeeStrategyFactory();

        ParkingFeeStrategy parkingFeeStrategy = mallFeeStrategyFactory.getParkingFeeStrategy(BUS);

        assertEquals(SixWheelerMallFeeStrategy.class, parkingFeeStrategy.getClass());
    }

    @Test
    void ShouldReturnStrategyForSixWheelerWhenVehicleIsTruck() {
        MallFeeStrategyFactory mallFeeStrategyFactory = new MallFeeStrategyFactory();

        ParkingFeeStrategy parkingFeeStrategy = mallFeeStrategyFactory.getParkingFeeStrategy(TRUCK);

        assertEquals(SixWheelerMallFeeStrategy.class, parkingFeeStrategy.getClass());
    }
}