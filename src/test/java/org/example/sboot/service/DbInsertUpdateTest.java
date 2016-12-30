package org.example.sboot.service;

import io.ebean.EbeanServer;
import org.example.sboot.domain.Content;
import org.example.sboot.domain.query.QContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
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

        new QContent()
                .name.istartsWith("interested")
                .version.greaterOrEqualTo(1L)
                .findList();

    }
}