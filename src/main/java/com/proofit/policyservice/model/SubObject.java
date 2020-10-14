package com.proofit.policyservice.model;

import java.math.BigDecimal;
import java.util.Objects;

public class SubObject {

  private String name;
  private BigDecimal sumInsured;
  private RiskType riskType;

  public SubObject(String name, BigDecimal sumInsured, RiskType riskType) {
    this.name = Objects.requireNonNull(name, "Sub-object's name missing");
    this.sumInsured = Objects.requireNonNull(sumInsured, "Sum insured missing");
    this.riskType = riskType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getSumInsured() {
    return sumInsured;
  }

  public void setSumInsured(BigDecimal sumInsured) {
    this.sumInsured = sumInsured;
  }

  public RiskType getRiskType() {
    return riskType;
  }

  public void setRiskType(RiskType risk) {
    this.riskType = risk;
  }
}
