package parkinglot.component;

import util.LocalDateTimeUtil;

import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
    protected AtomicInteger number =  new AtomicInteger();
    protected LocalDateTimeUtil localDateTimeUtil;

    public Ticket(LocalDateTimeUtil localDateTimeUtil) {
        this.localDateTimeUtil = localDateTimeUtil;
    }

    public LocalDateTimeUtil getLocalDateTimeUtil() {
        return localDateTimeUtil;
    }
}
