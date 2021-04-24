package com.bloomberg.fx.service;

import com.bloomberg.fx.request.DealRequest;
import com.bloomberg.fx.response.Response;

public interface DealsService {

    Response requestDeal(DealRequest dealRequest);
}
