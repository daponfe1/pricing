package com.inditex.pricing.infrastructure.adapter.database.repository.h2;

import com.inditex.pricing.infrastructure.adapter.database.entity.TariffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffH2Repository extends JpaRepository<TariffEntity, Long> {}
