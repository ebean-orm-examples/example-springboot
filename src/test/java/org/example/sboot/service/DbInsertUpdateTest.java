package org.example.sboot.service;

import com.avaje.ebean.EbeanServer;
import org.example.sboot.Application;
import org.example.sboot.domain.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DbInsertUpdateTest {

  @Autowired
  EbeanServer server;

  @Test
  public void testInsertUpdate() throws Exception {

    assertNotNull(server);

    Content content = new Content();
    content.setName("foo");
    server.save(content);

    content.setName("moo");
    content.save();
  }
}