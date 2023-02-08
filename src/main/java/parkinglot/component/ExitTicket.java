package parkinglot.component;

import parkinglot.factory.FeeModelFactory;
import parkinglot.factory.ParkingFeeStrategy;
import parkinglot.model.FeeModel;
import parkinglot.model.Vehicle;
import parkinglot.model.FeeModelStrategyFactory;
import util.LocalDateTimeUtil;

import static parkinglot.model.FeeModel.*;

public class ExitTicket extends Ticket {
    String exitDateTime;
    FeeModelFactory feeModelFactory;

    public ExitTicket(LocalDateTimeUtil localDateTimeUtil, FeeModelFactory feeModelFactory) {
        super(localDateTimeUtil);
        this.feeModelFactory = feeModelFactory;
    }

    public String generateExitTicket(Vehicle vehicle, ParkingTicket parkingTicket) {
        exitDateTime = localDateTimeUtil.getLocalDateTime();
        double fee  = calculateFee(vehicle, parkingTicket, exitDateTime);

        return "Parking Receipt:\n" +
                "Receipt Number: R-" + number.incrementAndGet() + "\n" +
                "Entry Date-time: " + parkingTicket.getEntryDateTime() + "\n" +
                "Exit Date-time: " + exitDateTime + "\n" +
                "Fees: " + fee;
    }

    private double calculateFee(Vehicle vehicle, ParkingTicket parkingTicket, String exitDateTime) {
        FeeModelStrategyFactory feeModelStrategyFactory = feeModelFactory.getFeeModelStrategyFactory(MALL);
        ParkingFeeStrategy parkingFeeStrategy = feeModelStrategyFactory.getParkingFeeStrategy(vehicle);

        return parkingFeeStrategy.getFee(parkingTicket, exitDateTime);
    }
}
