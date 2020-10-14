package com.proofit.policyservice.service;

import com.proofit.policyservice.model.Policy;
import com.proofit.policyservice.model.RiskType;
import com.proofit.policyservice.model.SubObject;
import com.proofit.policyservice.service.risk.Risk;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PremiumCalculator {

  private final Map<RiskType, Risk> risksMap;

  public PremiumCalculator(Map<RiskType, Risk> risksMap) {
    this.risksMap = risksMap;
  }

  public BigDecimal calculate(Policy policy) {
    return policy.getObjects().stream()
            .flatMap(object -> object.getSubObjects().stream())
            .collect(Collectors.groupingBy(SubObject::getRiskType))
            .entrySet().stream()
            .map(entry -> risksMap.get(entry.getKey()).calculateRiskPremium(entry.getValue()))
            .reduce(BigDecimal::add)
            .orElse(new BigDecimal("0.00"));
  }
}
