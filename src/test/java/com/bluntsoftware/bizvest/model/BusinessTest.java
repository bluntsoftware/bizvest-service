package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class BusinessTest {

  @Test
  void shouldCreateBusiness(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Business.class));
  }

  @Test
  void shouldBuildBusiness(){
    Assertions.assertNotNull(Business.builder().build());
  }
}
