package org.example.sboot.service;

import com.avaje.ebean.EbeanServer;
import org.example.sboot.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    EbeanServer server;

    public List<Content> getContent() {
        return server.find(Content.class).findList();
    }
}
