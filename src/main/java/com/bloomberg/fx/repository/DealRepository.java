package com.bloomberg.fx.repository;

import com.bloomberg.fx.entities.Deal;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends AbstractRepository<Deal, Long> {

    @Query("SELECT D FROM Deal D WHERE D.dealId =:dealId")
    Optional<Deal> getByDealId(@Param("dealId") String dealId);
}
