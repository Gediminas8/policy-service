package com.proofit.policyservice.service.risk;

import com.proofit.policyservice.model.RiskType;
import com.proofit.policyservice.model.SubObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class Theft implements Risk {

  private static final BigDecimal COEFFICIENT_STANDARD = new BigDecimal("0.11");
  private static final BigDecimal COEFFICIENT_ADJUSTED = new BigDecimal("0.05");
  private static final BigDecimal THRESHOLD = new BigDecimal("15");

  @Override
  public RiskType getRiskType() {
    return RiskType.THEFT;
  }

  @Override
  public BigDecimal calculateRiskPremium(List<SubObject> subObjects) {
    BigDecimal sumInsured = subObjects.stream()
            .map(SubObject::getSumInsured)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);
    BigDecimal coefficient = sumInsured.compareTo(THRESHOLD) < 0 ? COEFFICIENT_STANDARD : COEFFICIENT_ADJUSTED;
    return coefficient.multiply(sumInsured).setScale(2, RoundingMode.HALF_UP);
  }
}
