package com.inditex.pricing.infrastructure.adapter.database.repository.h2;

import com.inditex.pricing.infrastructure.adapter.database.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandH2Repository extends JpaRepository<BrandEntity, Long> {}
