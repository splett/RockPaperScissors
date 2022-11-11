package com.controller;

import java.util.Random;

import javax.swing.JOptionPane;

import com.model.game.Game;
import com.model.game.MatchDao;
import com.model.util.Symbol;

public class MatchController {

  private Game game;
  private MatchDao matchDao;

  public MatchController(Game game) {
    this.game = game;
    matchDao = new MatchDao();
  }

  public Integer realizeMatch(Symbol humanPlayer) {
    Symbol automaticPlay = automaticRandomPlay();
    matchDao.realizePlay(game.getIdGame(), humanPlayer.getId(), automaticPlay.getId());
    
    return toDetermineWinner(humanPlayer, automaticPlay);
  }

  private int toDetermineWinner(Symbol humanPlayer, Symbol automaticPlay) {
    if(humanPlayer.equals(automaticPlay))
      return 0;
    else if (humanPlayer.equals(Symbol.PAPER)) {
      if (automaticPlay.equals(Symbol.ROCK))
        return 1; 
      else 
        return 2; 
    }
    else if (humanPlayer.equals(Symbol.ROCK)) {
      if (automaticPlay.equals(Symbol.SCISSORS))
        return 1; 
      else 
        return 2; 
    }
    else if (humanPlayer.equals(Symbol.SCISSORS)) {
      if (automaticPlay.equals(Symbol.PAPER))
        return 1; 
      else 
        return 2; 
    }
    return 0;
  }

  private Symbol automaticRandomPlay() {
    Integer automaticPlay = new Random().nextInt(3) + 1;
    
    switch (automaticPlay) {
    case 1:
      JOptionPane.showMessageDialog(null, "Automatic player: Rock!");
      return Symbol.ROCK;
    case 2:
      JOptionPane.showMessageDialog(null, "Automatic player: Paper!");
      return Symbol.PAPER;
    case 3:
      JOptionPane.showMessageDialog(null, "Automatic player: Scissors!");
      return Symbol.SCISSORS;
    default:
      break;
    }
    
    return null;
  }
}
