package com.controller;

import com.model.game.Game;
import com.model.game.GameDao;
import com.model.player.Player;
import com.model.player.PlayerDao;

public class InitGameController {

  private PlayerDao playerDao;
  private GameDao gameDao; 
  
  private Player player; 
  private Game game;
  
  public InitGameController() {
    playerDao = new PlayerDao();
    gameDao = new GameDao();
  }

  public Game savePlayer(String name) {
    player = new Player(playerDao.savePlayer(name), name);
    game = new Game(gameDao.createGame(player.getId().toString()), player.getId());
    return game;
  }
}
