package com.proofit.policyservice.service.risk;

import com.google.common.collect.ImmutableList;
import com.proofit.policyservice.model.RiskType;
import com.proofit.policyservice.model.SubObject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheftTest {

  @Test
  public void calculateRiskPremiumStandard() {
    SubObject subObject1 = new SubObject("subObject1", new BigDecimal("10"), RiskType.THEFT);
    SubObject subObject2 = new SubObject("subObject2", new BigDecimal("4.99"), RiskType.THEFT);
    BigDecimal premium = new Theft().calculateRiskPremium(ImmutableList.of(subObject1, subObject2));
    assertEquals(new BigDecimal("1.65"), premium);
  }

  @Test
  public void calculateRiskPremiumAdjusted() {
    SubObject subObject1 = new SubObject("subObject1", new BigDecimal("10"), RiskType.THEFT);
    SubObject subObject2 = new SubObject("subObject2", new BigDecimal("5"), RiskType.THEFT);
    BigDecimal premium = new Theft().calculateRiskPremium(ImmutableList.of(subObject1, subObject2));
    assertEquals(new BigDecimal("0.75"), premium);
  }

  @Test
  public void calculateRiskPremiumEmptyList() {
    BigDecimal premium = new Theft().calculateRiskPremium(ImmutableList.of());
    assertEquals(new BigDecimal("0.00"), premium);
  }
}