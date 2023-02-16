package com.bluntsoftware.bizvest.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class AssociatedProductTest {

  @Test
  void shouldCreateAssociatedProduct(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(AssociatedProduct.class));
  }

  @Test
  void shouldBuildAssociatedProduct(){
    Assertions.assertNotNull(AssociatedProduct.builder().build());
  }
}
