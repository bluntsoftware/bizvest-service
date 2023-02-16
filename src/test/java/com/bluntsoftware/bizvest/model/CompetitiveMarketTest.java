package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class CompetitiveMarketTest {

  @Test
  void shouldCreateCompetitiveMarket(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(CompetitiveMarket.class));
  }

  @Test
  void shouldBuildCompetitiveMarket(){
    Assertions.assertNotNull(CompetitiveMarket.builder().build());
  }
}
