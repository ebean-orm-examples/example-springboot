package org.example.sboot.service;

import io.ebean.Database;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WiringTest {

  @Autowired
  Database database;

  @Test
  public void testHello() throws Exception {

    assertNotNull(database);
  }
}