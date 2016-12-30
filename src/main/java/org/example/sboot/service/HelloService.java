package org.example.sboot.service;

import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

  @Autowired
  EbeanServer server;

  public String hello() {
    return "Hello Service";
  }
}
