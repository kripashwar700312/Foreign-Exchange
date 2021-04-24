package com.bloomberg.fx.service;

import com.bloomberg.fx.AbstractTest;
import com.bloomberg.fx.mock.DealMock;
import com.bloomberg.fx.mock.DealRequestMock;
import com.bloomberg.fx.repository.DealRepository;
import com.bloomberg.fx.response.Response;
import com.bloomberg.fx.service.impl.DealsServiceImpl;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DealsServiceTest extends AbstractTest {

    @Mock
    private DealRepository dealRepository;

    @InjectMocks
    private DealsServiceImpl dealsService;

    @Before
    public void initMocks() {
    }

    @Test
    public void requestDeal_shouldReturnCreated() {
        when(dealRepository.getByDealId(any(String.class))).thenReturn(Optional.empty());
        Response response = dealsService.requestDeal(DealRequestMock.getDealRequestMock());
        assertEquals(HttpStatus.CREATED, response.getHttpStatus());
    }

    @Test
    public void requestDeal_shouldReturnNotAcceptable() {
        when(dealRepository.getByDealId(any(String.class))).thenReturn(Optional.of(DealMock.getDealMock()));
        Response response = dealsService.requestDeal(DealRequestMock.getDealRequestMock());
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getHttpStatus());
    }
}
