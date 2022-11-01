package org.example.sboot.service;

import io.ebean.Database;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class WiringTest {

  @Autowired
  Database database;

  @Test
  void testHello() {
    assertNotNull(database);
  }
}