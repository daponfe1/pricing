package com.inditex.pricing.app.adapter.database.entity;

import com.inditex.pricing.app.domain.enums.Currency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pricing")
public class PricingEntity {

  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  private UUID id;

  @ManyToOne
  @JoinColumn(nullable = false)
  private ProductEntity product;

  @ManyToOne
  @JoinColumn(nullable = false)
  private BrandEntity brand;

  @ManyToOne
  @JoinColumn(nullable = false)
  private TariffEntity tariff;

  @Column(name = "create_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDateTime endDate;

  @Column(nullable = false)
  private Short priority;

  @Column(nullable = false)
  private Float price;

  @Enumerated(EnumType.STRING)
  private Currency currency;
}
