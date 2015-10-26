package org.example.sboot.domain;

import javax.persistence.Entity;

@Entity
public class Content extends BaseModel {

  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
