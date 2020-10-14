package com.proofit.policyservice;

import com.proofit.policyservice.model.RiskType;
import com.proofit.policyservice.service.risk.Risk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class BeanConfig {

  @Bean
  public Map<RiskType, Risk> mapTypeToRisk(List<Risk> risks) {
    Map<RiskType, Risk> map = new HashMap<>();
    risks.forEach(risk -> map.put(risk.getRiskType(), risk));
    return map;
  }
}
