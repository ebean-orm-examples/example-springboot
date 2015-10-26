package org.example.sboot.service;

import com.avaje.ebean.EbeanServer;
import org.example.sboot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class WiringTest {

  @Autowired
  EbeanServer server;

  @Test
  public void testHello() throws Exception {

    assertNotNull(server);
  }
}