package org.example.sboot.service;

import com.avaje.ebean.config.CurrentUserProvider;
import org.springframework.stereotype.Component;

/**
 * Provides the current user to EbeanServer.
 */
@Component
public class CurrentUser implements CurrentUserProvider {

  @Override
  public Object currentUser() {
    return "test";
  }
}
