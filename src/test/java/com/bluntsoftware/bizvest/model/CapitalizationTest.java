package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class CapitalizationTest {

  @Test
  void shouldCreateCapitalization(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Capitalization.class));
  }

  @Test
  void shouldBuildCapitalization(){
    Assertions.assertNotNull(Capitalization.builder().build());
  }
}
