package org.example.sboot.domain.finder;

import io.ebean.Finder;
import org.example.sboot.domain.Content;

public class ContentFinder extends Finder<Long,Content> {

  /**
   * Construct using the default EbeanServer.
   */
  public ContentFinder() {
    super(Content.class);
  }

}
