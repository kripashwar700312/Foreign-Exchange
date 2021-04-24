package com.bloomberg.fx.controller;

import com.bloomberg.fx.AbstractTest;
import com.bloomberg.fx.constants.APIConstant;
import com.bloomberg.fx.mock.DealRequestMock;
import com.bloomberg.fx.request.DealRequest;
import com.bloomberg.fx.service.DealsService;
import com.bloomberg.fx.utils.ResponseUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class DealsControllerTest extends AbstractTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private DealsController dealsController;

    @Mock
    private DealsService dealsService;

    private ObjectMapper mapper;

    @Override
    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(dealsController).build();
        mapper = new ObjectMapper();
    }

    @Test
    public void dealRequestshouldReturn_CreatedResponse() throws Exception {
        DealRequest dealRequest = DealRequestMock.getDealRequestMock();
        when(dealsService.requestDeal(any(DealRequest.class))).thenReturn(ResponseUtility.getCreatedResponse("Successfully accepted deal."));
        mockMvc.perform(post("/" + APIConstant.DEALS)
                .content(mapper.writeValueAsString(dealRequest))
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void dealRequestshouldReturn_FailedResponse() throws Exception {
        DealRequest dealRequest = DealRequestMock.getDealRequestMock();
        when(dealsService.requestDeal(any(DealRequest.class))).thenReturn(ResponseUtility.getFailedResponse("Deal with id " + dealRequest.getDealId() + " already exists."));
        mockMvc.perform(post("/" + APIConstant.DEALS)
                .content(mapper.writeValueAsString(dealRequest))
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
}
