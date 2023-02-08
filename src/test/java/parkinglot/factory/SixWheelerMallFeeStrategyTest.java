package parkinglot.factory;

import org.junit.jupiter.api.Test;
import parkinglot.component.ParkingTicket;
import util.LocalDateTimeUtil;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SixWheelerMallFeeStrategyTest {
    @Test
    void shouldReturnTotalFee() {
        SixWheelerMallFeeStrategy sixWheelerMallFeeModel = new SixWheelerMallFeeStrategy();
        LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
        ParkingTicket parkingTicket  = new ParkingTicket(localDateTimeUtil);
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023,2,6,9,0))
                .thenReturn(LocalDateTime.of(2023,2,6,10,0));

        double actualFee = sixWheelerMallFeeModel.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(50.0, actualFee);
    }
}