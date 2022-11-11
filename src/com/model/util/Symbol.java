package com.model.util;

public enum Symbol {

  ROCK(1), PAPER(2), SCISSORS(3);

  private Integer id;

  private Symbol(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

}
