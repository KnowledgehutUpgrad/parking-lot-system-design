package parkinglot.component;

import org.junit.jupiter.api.Test;
import parkinglot.factory.FeeModelFactory;
import parkinglot.factory.MallFeeStrategyFactory;
import parkinglot.factory.ParkingFeeStrategy;
import parkinglot.factory.TwoWheelerMallFeeStrategy;
import parkinglot.model.FeeModel;
import util.LocalDateTimeUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static parkinglot.model.Vehicle.MOTORCYCLE;

class ExitTicketTest {
    @Test
    void shouldReturnExitTicket() {
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        FeeModelFactory feeModelFactory = mock(FeeModelFactory.class);
        TwoWheelerMallFeeStrategy twoWheelerMallFeeStrategy = mock(TwoWheelerMallFeeStrategy.class);
        ParkingTicket parkingTicket = mock(ParkingTicket.class);
        ExitTicket exitTicket = new ExitTicket(localDateTimeUtil, feeModelFactory);
        String expectedTicket = "Parking Receipt:\n" +
                "Receipt Number: R-1\n" +
                "Entry Date-time: 06-Feb-2023 09:00:00\n" +
                "Exit Date-time: 06-Feb-2023 10:00:00\n" +
                "Fees: 80.0";
        when(localDateTimeUtil.getLocalDateTime()).thenReturn("06-Feb-2023 10:00:00");
        MallFeeStrategyFactory mallFeeStrategyFactory = mock(MallFeeStrategyFactory.class);
        when(feeModelFactory.getFeeModelStrategyFactory(FeeModel.MALL)).thenReturn(mallFeeStrategyFactory);
        when(mallFeeStrategyFactory.getParkingFeeStrategy(MOTORCYCLE)).thenReturn(twoWheelerMallFeeStrategy);
        when(((ParkingFeeStrategy) twoWheelerMallFeeStrategy).getFee(any(), any())).thenReturn(80.0);
        when(parkingTicket.getEntryDateTime()).thenReturn("06-Feb-2023 09:00:00");

        String actualExitTicket = exitTicket.generateExitTicket(MOTORCYCLE, parkingTicket);

        assertEquals(expectedTicket, actualExitTicket);
    }
}