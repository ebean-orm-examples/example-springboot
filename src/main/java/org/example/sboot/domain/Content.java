package org.example.sboot.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="exa_content")
public class Content extends BaseModel {

  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
