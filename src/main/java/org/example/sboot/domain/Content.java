package org.example.sboot.domain;

import org.example.sboot.domain.finder.ContentFinder;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="exa_content")
public class Content extends BaseModel {

  public static final ContentFinder find = new ContentFinder();

  String name;

  public Content(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
