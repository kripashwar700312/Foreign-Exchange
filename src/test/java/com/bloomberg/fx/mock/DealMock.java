package com.bloomberg.fx.mock;

import com.bloomberg.fx.entities.Deal;
import java.util.Date;

public class DealMock {

    public static Deal getDealMock() {
        Deal deal = new Deal();
        deal.setId(1L);
        deal.setDealId("D10");
        deal.setFromCurrencyISOCode("USD");
        deal.setToCurrencyISOCode("NPR");
        deal.setOrderDate(new Date());
        deal.setAmount(100.00);
        return deal;
    }
}
