package com.proofit.policyservice.service.risk;

import com.proofit.policyservice.model.RiskType;
import com.proofit.policyservice.model.SubObject;

import java.math.BigDecimal;
import java.util.List;

public interface Risk {

  RiskType getRiskType();

  BigDecimal calculateRiskPremium(List<SubObject> subObjects);

}
