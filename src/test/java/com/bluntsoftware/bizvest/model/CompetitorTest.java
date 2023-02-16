package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class CompetitorTest {

  @Test
  void shouldCreateCompetitor(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Competitor.class));
  }

  @Test
  void shouldBuildCompetitor(){
    Assertions.assertNotNull(Competitor.builder().build());
  }
}
