package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class MarketTest {

  @Test
  void shouldCreateMarket(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Market.class));
  }

  @Test
  void shouldBuildMarket(){
    Assertions.assertNotNull(Market.builder().build());
  }
}
