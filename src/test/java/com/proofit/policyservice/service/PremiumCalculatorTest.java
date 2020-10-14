package com.proofit.policyservice.service;

import com.google.common.collect.ImmutableList;
import com.proofit.policyservice.model.Policy;
import com.proofit.policyservice.model.PolicyObject;
import com.proofit.policyservice.model.PolicyStatus;
import com.proofit.policyservice.model.SubObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static com.proofit.policyservice.model.RiskType.FIRE;
import static com.proofit.policyservice.model.RiskType.THEFT;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PremiumCalculatorTest {

  @Autowired
  private PremiumCalculator premiumCalculator;

  @Test
  public void calculatePolicyPremium1() {
    SubObject subObject1 = new SubObject("TV", new BigDecimal("100"), FIRE);
    SubObject subObject2 = new SubObject("Chair", new BigDecimal("8"), THEFT);
    PolicyObject object = new PolicyObject("HOUSE", ImmutableList.of(subObject1, subObject2));
    Policy policy = new Policy("TEST_POLICY-1", PolicyStatus.REGISTERED, ImmutableList.of(object));
    BigDecimal premium = premiumCalculator.calculate(policy);
    assertEquals(new BigDecimal("2.28"), premium);
  }

  @Test
  public void calculatePolicyPremium2() {
    SubObject subObject1 = new SubObject("Jewelry", new BigDecimal("500"), FIRE);
    SubObject subObject2 = new SubObject("TV", new BigDecimal("102.51"), THEFT);
    PolicyObject object = new PolicyObject("HOUSE", ImmutableList.of(subObject1, subObject2));
    Policy policy = new Policy("TEST_POLICY-2", PolicyStatus.APPROVED, ImmutableList.of(object));
    BigDecimal premium = premiumCalculator.calculate(policy);
    assertEquals(new BigDecimal("17.13"), premium);
  }

  @Test
  public void calculatePolicyPremiumMultipleObjects() {
    SubObject subObject1 = new SubObject("Jewelry", new BigDecimal("51"), FIRE);
    SubObject subObject2 = new SubObject("TV", new BigDecimal("9"), THEFT);
    PolicyObject object1 = new PolicyObject("HOUSE1", ImmutableList.of(subObject1, subObject2));
    SubObject subObject3 = new SubObject("Jewelry", new BigDecimal("51"), FIRE);
    SubObject subObject4 = new SubObject("TV", new BigDecimal("5"), THEFT);
    PolicyObject object2 = new PolicyObject("HOUSE2", ImmutableList.of(subObject3, subObject4));
    Policy policy = new Policy("TEST_POLICY-3", PolicyStatus.APPROVED, ImmutableList.of(object1, object2));
    BigDecimal premium = premiumCalculator.calculate(policy);
    assertEquals(new BigDecimal("3.99"), premium);
  }

  @Test
  public void calculatePolicyPremiumOneObjectEmpty() {
    SubObject subObject1 = new SubObject("Jewelry", new BigDecimal("500"), FIRE);
    SubObject subObject2 = new SubObject("TV", new BigDecimal("102.51"), THEFT);
    PolicyObject object1 = new PolicyObject("HOUSE1", ImmutableList.of(subObject1, subObject2));
    PolicyObject object2 = new PolicyObject("HOUSE2", ImmutableList.of());
    Policy policy = new Policy("TEST_POLICY-4", PolicyStatus.APPROVED, ImmutableList.of(object1, object2));
    BigDecimal premium = premiumCalculator.calculate(policy);
    assertEquals(new BigDecimal("17.13"), premium);
  }

  @Test
  public void calculatePolicyPremiumWithoutObjects() {
    Policy policy = new Policy("TEST_POLICY-5", PolicyStatus.APPROVED, ImmutableList.of());
    BigDecimal premium = premiumCalculator.calculate(policy);
    assertEquals(new BigDecimal("0.00"), premium);
  }

  @Test
  public void calculatePolicyPremiumWithoutSubObjects() {
    PolicyObject object = new PolicyObject("HOUSE", ImmutableList.of());
    Policy policy = new Policy("TEST_POLICY-6", PolicyStatus.APPROVED, ImmutableList.of(object));
    BigDecimal premium = premiumCalculator.calculate(policy);
    assertEquals(new BigDecimal("0.00"), premium);
  }
}