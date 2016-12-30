package org.example.sboot.service;

import io.ebean.EbeanServer;
import io.ebean.annotation.Transactional;
import org.example.sboot.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import org.springframework.transaction.annotation.Transactional;

@Service
public class ContentService {

    @Autowired
    EbeanServer server;

    public List<Content> getContent() {
        return server.find(Content.class).findList();
    }

    @Transactional
    public Content save(Content content) {
        server.save(content);
        if (content.getName().equals("rollback")) {
            throw new RuntimeException("boooom!!");
        }
        return content;
    }
}
