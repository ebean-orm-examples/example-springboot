package org.example.sboot.controller;

import org.example.sboot.domain.Content;
import org.example.sboot.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Content> getContent() {
        return contentService.getContent();
    }
    
    @PostMapping
    public Content add(@RequestBody Content content) {
        return contentService.save(content);
    }
}
