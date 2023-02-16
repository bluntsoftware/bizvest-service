package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class MilestoneTest {

  @Test
  void shouldCreateMilestone(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Milestone.class));
  }

  @Test
  void shouldBuildMilestone(){
    Assertions.assertNotNull(Milestone.builder().build());
  }
}
