package org.example.sboot.service;

import io.ebean.Database;
import io.ebean.annotation.Transactional;
import org.example.sboot.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    Database database;

    public List<Content> getContent() {
        return database.find(Content.class).findList();
    }

    @Transactional
    public Content save(Content content) {
        database.save(content);
        if (content.getName().equals("rollback")) {
            throw new RuntimeException("boooom!!");
        }
        return content;
    }
}
