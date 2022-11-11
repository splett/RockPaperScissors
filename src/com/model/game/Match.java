package com.model.game;

import com.model.util.Symbol;

public class Match {

  private Integer idGame;
  private Integer idMatch;
  private Symbol humanPlayer;
  private Symbol automaticPlayer;

  public Integer getIdMatch() {
    return idMatch;
  }

  public void setIdMatch(Integer idMatch) {
    this.idMatch = idMatch;
  }

  public Integer getIdGame() {
    return idGame;
  }

  public void setIdGame(Integer idGame) {
    this.idGame = idGame;
  }

  public Symbol getHumanPlayer() {
    return humanPlayer;
  }

  public void setHumanPlayer(Symbol humanPlayer) {
    this.humanPlayer = humanPlayer;
  }

  public Symbol getAutomaticPlayer() {
    return automaticPlayer;
  }

  public void setAutomaticPlayer(Symbol automaticPlayer) {
    this.automaticPlayer = automaticPlayer;
  }

}
