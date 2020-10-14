package com.proofit.policyservice.api.rest;

import com.proofit.policyservice.model.Policy;
import com.proofit.policyservice.service.PremiumCalculator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/premium")
public class PremiumController {

  private final PremiumCalculator premiumCalculator;

  public PremiumController(PremiumCalculator premiumCalculator) {
    this.premiumCalculator = premiumCalculator;
  }

  @PostMapping
  public BigDecimal getPremium(@RequestBody Policy policy) {
    return premiumCalculator.calculate(policy);
  }
}
