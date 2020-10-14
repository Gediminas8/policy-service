package com.proofit.policyservice.service.risk;

import com.google.common.collect.ImmutableList;
import com.proofit.policyservice.model.RiskType;
import com.proofit.policyservice.model.SubObject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FireTest {

  @Test
  public void calculateRiskPremiumStandard() {
    SubObject subObject1 = new SubObject("subObject1", new BigDecimal("50"), RiskType.FIRE);
    SubObject subObject2 = new SubObject("subObject2", new BigDecimal("50"), RiskType.FIRE);
    BigDecimal premium = new Fire().calculateRiskPremium(ImmutableList.of(subObject1, subObject2));
    assertEquals(new BigDecimal("1.40"), premium);
  }

  @Test
  public void calculateRiskPremiumAdjusted() {
    SubObject subObject1 = new SubObject("subObject1", new BigDecimal("50"), RiskType.FIRE);
    SubObject subObject2 = new SubObject("subObject2", new BigDecimal("50.01"), RiskType.FIRE);
    BigDecimal premium = new Fire().calculateRiskPremium(ImmutableList.of(subObject1, subObject2));
    assertEquals(new BigDecimal("2.40"), premium);
  }

  @Test
  public void calculateRiskPremiumEmptyList() {
    BigDecimal premium = new Fire().calculateRiskPremium(ImmutableList.of());
    assertEquals(new BigDecimal("0.00"), premium);
  }
}