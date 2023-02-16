package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class ManagerTest {

  @Test
  void shouldCreateManager(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Manager.class));
  }

  @Test
  void shouldBuildManager(){
    Assertions.assertNotNull(Manager.builder().build());
  }
}
