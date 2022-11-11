package com.model.game;

public class Game {

  private Integer idGame;
  private Integer idPlayer;

  public Game(Integer idGame, Integer  idPlayer) {
    this.idGame = idGame;
    this.idPlayer = idPlayer;
  }
  
  public Integer getIdGame() {
    return idGame;
  }

  public void setIdGame(Integer idGame) {
    this.idGame = idGame;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }

  public void setIdPlayer(Integer idPlayer) {
    this.idPlayer = idPlayer;
  }

}
