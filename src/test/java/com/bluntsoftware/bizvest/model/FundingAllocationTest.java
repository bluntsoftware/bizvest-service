package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class FundingAllocationTest {

  @Test
  void shouldCreateFundingAllocation(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(FundingAllocation.class));
  }

  @Test
  void shouldBuildFundingAllocation(){
    Assertions.assertNotNull(FundingAllocation.builder().build());
  }
}
