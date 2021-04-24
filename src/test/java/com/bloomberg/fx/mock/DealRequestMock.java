package com.bloomberg.fx.mock;

import com.bloomberg.fx.request.DealRequest;

public class DealRequestMock {

    public static DealRequest getDealRequestMock() {
        DealRequest dealRequest = new DealRequest();
        dealRequest.setDealId("D10");
        dealRequest.setFromCurrencyISOCode("USD");
        dealRequest.setToCurrencyISOCode("NPR");
        dealRequest.setOrderDate("2021-04-24 08:08:12");
        dealRequest.setDealAmount(100.00);
        return dealRequest;
    }
}
