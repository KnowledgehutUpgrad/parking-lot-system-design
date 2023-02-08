package parkinglot.component;

import org.junit.jupiter.api.Test;
import parkinglot.manager.ParkingSpotManager;
import parkinglot.model.ParkingSpot;

import java.util.Optional;

import static parkinglot.model.Vehicle.MOTORCYCLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ExitGateTest {
    @Test
    void shouldCallParkingSpotManagerToFindParkingSpotForGivenSpotId() {
        ExitTicket mockExitTicket = mock(ExitTicket.class);
        ParkingSpotManager mockParkingSpotManager = mock(ParkingSpotManager.class);
        ExitGate exitGate = new ExitGate(mockExitTicket, mockParkingSpotManager);
        ParkingTicket mockParkingTicket = mock(ParkingTicket.class);
        when(mockParkingSpotManager.findParkingSpot(MOTORCYCLE, 1))
                .thenReturn(Optional.of(new ParkingSpot(1, MOTORCYCLE)));
        when(mockParkingTicket.getSpotId()).thenReturn(1);

        exitGate.exit(MOTORCYCLE, mockParkingTicket);

        verify(mockParkingSpotManager).findParkingSpot(MOTORCYCLE, 1);
    }

    @Test
    void shouldCallParkingTicketToOnSuccessfulVacate() {
        ExitTicket mockExitTicket = mock(ExitTicket.class);
        ParkingSpotManager mockParkingSpotManager = mock(ParkingSpotManager.class);
        ExitGate exitGate = new ExitGate(mockExitTicket, mockParkingSpotManager);
        ParkingTicket mockParkingTicket = mock(ParkingTicket.class);
        when(mockParkingSpotManager.findParkingSpot(MOTORCYCLE, 1))
                .thenReturn(Optional.of(new ParkingSpot(1, MOTORCYCLE)));
        when(mockParkingTicket.getSpotId()).thenReturn(1);

        exitGate.exit(MOTORCYCLE, mockParkingTicket);

        verify(mockExitTicket).generateExitTicket(MOTORCYCLE, mockParkingTicket);
    }

    @Test
    void shouldReturnWarningMessageForUnsuccessfulVacate() {
        ExitTicket mockExitTicket = mock(ExitTicket.class);
        ParkingSpotManager mockParkingSpotManager = mock(ParkingSpotManager.class);
        ExitGate exitGate = new ExitGate(mockExitTicket, mockParkingSpotManager);
        ParkingTicket mockParkingTicket = mock(ParkingTicket.class);
        when(mockParkingSpotManager.findParkingSpot(MOTORCYCLE, 1)).thenReturn(Optional.empty());
        when(mockParkingTicket.getSpotId()).thenReturn(1);

        String result = exitGate.exit(MOTORCYCLE, mockParkingTicket);

        assertEquals("Invalid Operation", result);
    }
}