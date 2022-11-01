package org.example.sboot.service;

import io.ebean.Database;
import org.example.sboot.domain.Content;
import org.example.sboot.domain.repo.ContentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DbInsertUpdateTest {

  @Autowired
  Database database;

  @Autowired
  ContentRepository contentRepository;

  @Test
  void testInsertUpdate() {

    assertNotNull(database);

    // -------------------------------------------------------------
    // Model and Finder style ...

    Content foo = new Content("foo");
    foo.save();
    //server.save(foo);

    foo.setName("moo");
    foo.save();

    Content fetchFoo = Content.find.byId(foo.getId());
    fetchFoo.setName("boo");
    fetchFoo.save();


    // -------------------------------------------------------------
    // Repository style ...

    Content baz = new Content("baz");
    contentRepository.save(baz);

    Content fetchBaz = contentRepository.findById(baz.getId());

    fetchBaz.setName("bazza");
    contentRepository.save(fetchBaz);

//    new QContent()
//        .name.istartsWith("interested")
//        .version.greaterOrEqualTo(1L)
//        .findList();
  }
}