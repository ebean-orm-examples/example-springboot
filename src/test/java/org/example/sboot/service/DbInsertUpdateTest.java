package org.example.sboot.service;

import org.example.sboot.domain.Content;
import org.example.sboot.domain.repo.ContentRepository;
import org.h2.engine.Database;
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
  Database database;

  @Autowired
  ContentRepository contentRepository;

  @Test
  public void testInsertUpdate() {

    assertNotNull(database);

    // -------------------------------------------------------------
    // Model and Finder style ...

    Content foo = new Content();
    foo.setName("foo");
    foo.save();
    //server.save(foo);

    foo.setName("moo");
    foo.save();

    Content fetchFoo = Content.find.byId(foo.getId());
    fetchFoo.setName("boo");
    fetchFoo.save();


    // -------------------------------------------------------------
    // Repository style ...

    Content baz = new Content();
    baz.setName("baz");

    contentRepository.save(baz);

    Content fetchBaz = contentRepository.byId(baz.getId());

    fetchBaz.setName("bazza");
    contentRepository.save(fetchBaz);

//    new QContent()
//        .name.istartsWith("interested")
//        .version.greaterOrEqualTo(1L)
//        .findList();
  }
}