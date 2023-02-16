package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class ManagementTest {

  @Test
  void shouldCreateManagement(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Management.class));
  }

  @Test
  void shouldBuildManagement(){
    Assertions.assertNotNull(Management.builder().build());
  }
}
