package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class FinancialSummaryTest {

  @Test
  void shouldCreateFinancialSummary(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(FinancialSummary.class));
  }

  @Test
  void shouldBuildFinancialSummary(){
    Assertions.assertNotNull(FinancialSummary.builder().build());
  }
}
