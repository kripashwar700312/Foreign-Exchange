package com.bloomberg.fx.service.impl;

import com.bloomberg.fx.entities.Deal;
import com.bloomberg.fx.mapper.DealMapper;
import com.bloomberg.fx.repository.DealRepository;
import com.bloomberg.fx.request.DealRequest;
import com.bloomberg.fx.response.Response;
import com.bloomberg.fx.service.DealsService;
import com.bloomberg.fx.utils.ResponseUtility;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DealsServiceImpl implements DealsService {

    @Autowired
    private DealRepository dealRepository;

    @Override
    public Response requestDeal(DealRequest dealRequest) {
        log.trace("Inside requestDeal");
        try {
            Optional<Deal> dealOpt = dealRepository.getByDealId(dealRequest.getDealId());
            if (!dealOpt.isPresent()) {
                dealRepository.save(DealMapper.setDealForCreate(dealRequest));
                return ResponseUtility.getCreatedResponse("Successfully accepted deal.");
            }
            return ResponseUtility.getFailedResponse("Deal with id " + dealRequest.getDealId() + " already exists.");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return ResponseUtility.getFailedResponse("Couldn't accept deal.");
    }

}
