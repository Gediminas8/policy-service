package com.proofit.policyservice.model;

import java.util.List;
import java.util.Objects;

public class Policy {

  private String number;
  private PolicyStatus status;
  private List<PolicyObject> policyObjects;

  public Policy(String number, PolicyStatus status, List<PolicyObject> policyObjects) {
    this.number = Objects.requireNonNull(number, "Policy number missing");
    this.status = Objects.requireNonNull(status, "Policy status missing");
    this.policyObjects = Objects.requireNonNull(policyObjects, "Policy objects missing");
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public PolicyStatus getStatus() {
    return status;
  }

  public void setStatus(PolicyStatus status) {
    this.status = status;
  }

  public List<PolicyObject> getObjects() {
    return policyObjects;
  }

  public void setObjects(List<PolicyObject> policyObjects) {
    this.policyObjects = policyObjects;
  }
}
