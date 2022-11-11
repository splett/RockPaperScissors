package com.model.player;

public class Player {

  private Integer id;
  private String name;

  public Player(String id, String name) {
    this.id = Integer.valueOf(id);
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
