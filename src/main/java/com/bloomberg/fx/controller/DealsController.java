package com.bloomberg.fx.controller;

import com.bloomberg.fx.constants.APIConstant;
import com.bloomberg.fx.request.DealRequest;
import com.bloomberg.fx.response.Response;
import com.bloomberg.fx.service.DealsService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = APIConstant.DEALS)
public class DealsController {

    @Autowired
    private DealsService dealsService;

    @PostMapping
    public ResponseEntity<Response> requestDeal(@RequestBody @Valid DealRequest dealRequest) {
        Response response = dealsService.requestDeal(dealRequest);
        return new ResponseEntity<Response>(response, response.getHttpStatus());
    }
}
