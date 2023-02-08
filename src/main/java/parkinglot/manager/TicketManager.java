package parkinglot.manager;

import parkinglot.component.ExitTicket;
import parkinglot.component.ParkingTicket;
import parkinglot.factory.FeeModelFactory;
import parkinglot.model.FeeModel;
import parkinglot.util.LocalDateTimeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketManager {
    List<ParkingTicket> parkingTickets = new ArrayList<>();
    LocalDateTimeUtil  localDateTimeUtil;
    AtomicInteger atomicInteger;
    FeeModel feeModel;

    public TicketManager(LocalDateTimeUtil localDateTimeUtil, AtomicInteger  atomicInteger, FeeModel feeModel) {
        this.localDateTimeUtil = localDateTimeUtil;
        this.atomicInteger = atomicInteger;
        this.feeModel = feeModel;
    }

    public ParkingTicket getParkingTicket() {
        ParkingTicket parkingTicket = new ParkingTicket(localDateTimeUtil, atomicInteger);
        parkingTickets.add(parkingTicket);
        return parkingTicket;
    }

    public ExitTicket getExitTicket() {
        return new ExitTicket(localDateTimeUtil, new FeeModelFactory(), atomicInteger, feeModel);
    }

    public Optional<ParkingTicket> findParkingTicketBy(int ticketNumber) {
        return parkingTickets
                .stream()
                .filter(parkingTicket -> parkingTicket.getTicketNumber() == ticketNumber)
                .findFirst();
    }
}
