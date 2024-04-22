package com.inditex.pricing.infrastructure.adapter.database.repository.h2;

import com.inditex.pricing.infrastructure.adapter.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductH2Repository extends JpaRepository<ProductEntity, Long> {}
