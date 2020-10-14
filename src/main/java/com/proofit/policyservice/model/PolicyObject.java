package com.proofit.policyservice.model;

import java.util.List;
import java.util.Objects;

public class PolicyObject {

  private String name;
  private List<SubObject> subObjects;

  public PolicyObject(String name, List<SubObject> subObjects) {
    this.name = Objects.requireNonNull(name, "Policy object name missing");
    this.subObjects = Objects.requireNonNull(subObjects, "Sub-objects missing");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SubObject> getSubObjects() {
    return subObjects;
  }

  public void setSubObjects(List<SubObject> subObjects) {
    this.subObjects = subObjects;
  }
}
