package com.bloomberg.fx.mapper;

import com.bloomberg.fx.entities.Deal;
import com.bloomberg.fx.request.DealRequest;
import com.bloomberg.fx.utils.DateUtil;

public class DealMapper {

    public static Deal setDealForCreate(DealRequest dealRequest) {
        Deal deal = new Deal();
        deal.setDealId(dealRequest.getDealId());
        deal.setFromCurrencyISOCode(dealRequest.getFromCurrencyISOCode());
        deal.setToCurrencyISOCode(dealRequest.getToCurrencyISOCode());
        deal.setOrderDate(DateUtil.getDateFromStringDate(dealRequest.getOrderDate()));
        deal.setAmount(dealRequest.getDealAmount());
        return deal;
    }
}
