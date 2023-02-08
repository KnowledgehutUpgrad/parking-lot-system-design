package parkinglot.strategy;

import org.junit.jupiter.api.Test;
import parkinglot.component.ParkingTicket;
import parkinglot.strategy.TwoWheelerMallFeeStrategy;
import parkinglot.util.LocalDateTimeUtil;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TwoWheelerMallFeeStrategyTest {
    private final TwoWheelerMallFeeStrategy twoWheelerMallFeeStrategy = new TwoWheelerMallFeeStrategy();
    private final LocalDateTimeUtil localDateTimeUtil = mock(LocalDateTimeUtil.class);
    private final ParkingTicket parkingTicket = new ParkingTicket(localDateTimeUtil, mock(AtomicInteger.class));

    @Test
    void shouldReturnTotalFee() {
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023, 2, 6, 9, 0))
                .thenReturn(LocalDateTime.of(2023, 2, 6, 10, 0));

        double actualFee = twoWheelerMallFeeStrategy.getFee(parkingTicket, "06-Feb-2023 10:00:00");

        assertEquals(10.0, actualFee);
    }

    @Test
    void shouldReturnCeilingTimeDifferenceInHours() {
        when(localDateTimeUtil.parseToLocalDateTIme(any()))
                .thenReturn(LocalDateTime.of(2023, 2, 6, 10, 0, 0))
                .thenReturn(LocalDateTime.of(2023, 2, 6, 11, 0, 1));

        double actualFee = twoWheelerMallFeeStrategy.getFee(parkingTicket, "06-Feb-2023 11:00:01");

        assertEquals(20.0, actualFee);
    }
}