package parkinglot.component;

import org.junit.jupiter.api.Test;
import parkinglot.manager.ParkingSpotManager;
import parkinglot.model.ParkingSpot;

import java.util.Optional;

import static parkinglot.model.Vehicle.MOTORCYCLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EntranceGateTest {
    @Test
    void shouldCallParkingSpotManagerToFindAvailableParkingSpot() {
        ParkingTicket mockParkingTicket = mock(ParkingTicket.class);
        ParkingSpotManager mockParkingSpotManager = mock(ParkingSpotManager.class);
        EntranceGate entranceGate = new EntranceGate(mockParkingTicket, mockParkingSpotManager);
        when(mockParkingSpotManager.findAvailableParkingSpot(MOTORCYCLE))
                .thenReturn(Optional.of(new ParkingSpot(1, MOTORCYCLE)));

        entranceGate.findParkingSpace(MOTORCYCLE);

        verify(mockParkingSpotManager).findAvailableParkingSpot(MOTORCYCLE);
    }

    @Test
    void shouldCallParkingTicketToOnSuccessfulParking() {
        ParkingTicket mockParkingTicket = mock(ParkingTicket.class);
        ParkingSpotManager mockParkingSpotManager = mock(ParkingSpotManager.class);
        EntranceGate entranceGate = new EntranceGate(mockParkingTicket, mockParkingSpotManager);
        when(mockParkingSpotManager.findAvailableParkingSpot(MOTORCYCLE))
                .thenReturn(Optional.of(new ParkingSpot(1, MOTORCYCLE)));

        entranceGate.findParkingSpace(MOTORCYCLE);

        verify(mockParkingTicket).generateEntryTicket(1);
    }

    @Test
    void shouldReturnWarningMessageForUnsuccessfulParking() {
        ParkingTicket mockParkingTicket = mock(ParkingTicket.class);
        ParkingSpotManager mockParkingSpotManager = mock(ParkingSpotManager.class);
        EntranceGate entranceGate = new EntranceGate(mockParkingTicket, mockParkingSpotManager);
        when(mockParkingSpotManager.findAvailableParkingSpot(MOTORCYCLE)).thenReturn(Optional.empty());

        String result = entranceGate.findParkingSpace(MOTORCYCLE);

        assertEquals("No space available", result);
    }
}