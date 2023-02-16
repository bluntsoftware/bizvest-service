package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class CompetitiveAssessmentTest {

  @Test
  void shouldCreateCompetitiveAssessment(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(CompetitiveAssessment.class));
  }

  @Test
  void shouldBuildCompetitiveAssessment(){
    Assertions.assertNotNull(CompetitiveAssessment.builder().build());
  }
}
