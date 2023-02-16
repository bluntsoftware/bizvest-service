package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class MarketAssessmentTest {

  @Test
  void shouldCreateMarketAssessment(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(MarketAssessment.class));
  }

  @Test
  void shouldBuildMarketAssessment(){
    Assertions.assertNotNull(MarketAssessment.builder().build());
  }
}
