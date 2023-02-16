package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class OwnershipTest {

  @Test
  void shouldCreateOwnership(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Ownership.class));
  }

  @Test
  void shouldBuildOwnership(){
    Assertions.assertNotNull(Ownership.builder().build());
  }
}
