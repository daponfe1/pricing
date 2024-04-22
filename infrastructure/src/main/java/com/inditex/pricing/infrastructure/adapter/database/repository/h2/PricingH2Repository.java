package com.inditex.pricing.infrastructure.adapter.database.repository.h2;

import com.inditex.pricing.infrastructure.adapter.database.entity.PricingEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingH2Repository extends JpaRepository<PricingEntity, UUID> {

  @Query(
      """
			select p from  PricingEntity p
			where p.endDate >= :applicationDate and p.startDate <= :applicationDate
			and p.product.id = :productId and p.brand.id = :brandId
			""")
  List<PricingEntity> findByApplicationDatesAndProductAndBrand(
      @Param("applicationDate") LocalDateTime applicationDate,
      @Param("productId") String productId,
      @Param("brandId") String brandId);
}
