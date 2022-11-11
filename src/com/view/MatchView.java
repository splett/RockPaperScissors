package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.controller.MatchController;
import com.model.game.Game;
import com.model.util.Symbol;

public class MatchView extends JFrame {
  
  private static final long serialVersionUID = -7089963981304036702L;
  private JPanel contentPane;
  private MatchController matchController; 
  private Integer humanPoints; 
  private Integer automaticPoints; 
  private Integer remainingMatches = 10; 
  private JLabel lblShowRemainingMatches = new JLabel(remainingMatches.toString());
  private JLabel lblShowScoreboard = new JLabel("0 x 0");

  private MatchView matchView;
  private InitGameView initGameView; 

  public MatchView(Game game, InitGameView initGameView) {
    setTitle("Jokenp\u00F4");
    initGame(game);
    createView();
    createButtons(initGameView);
    createLabels();
    this.initGameView = initGameView;
  }
  
  private void updateRemainingMatches() {
    remainingMatches--;
    lblShowRemainingMatches.setText(remainingMatches.toString());
    if(remainingMatches.equals(0)) {
      restartGame();
      JOptionPane.showMessageDialog(null, automaticPoints > humanPoints ? "You lose!" : (automaticPoints < humanPoints ? "You win!" : "Draw!"));
    }
  }

  private void toRealizePlay(Symbol play) {
    
    Integer result = matchController.realizeMatch(play);
    toUpdateScoreboard(result);
    updateRemainingMatches();
  }

  private void toUpdateScoreboard(Integer result) {
    if(result.equals(1))
      humanPoints++;
    else if(result.equals(2))
      automaticPoints++;
    lblShowScoreboard.setText("Human " + humanPoints + " X " + automaticPoints + " Machine");
  }
  
  private void createView() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
  }

  private void initGame(Game game) {
    humanPoints = 0; 
    matchView = this;
    automaticPoints = 0;
    remainingMatches = 10; 
    matchController = new MatchController(game);
  }

  private void createLabels() {
    JLabel lblScoreboard = new JLabel("Scoreboard");
    lblScoreboard.setHorizontalAlignment(SwingConstants.CENTER);
    lblScoreboard.setBounds(10, 11, 424, 14);
    contentPane.add(lblScoreboard);
    
    lblShowScoreboard.setHorizontalAlignment(SwingConstants.CENTER);
    lblShowScoreboard.setBounds(10, 36, 414, 14);
    contentPane.add(lblShowScoreboard);
    JLabel lblRemainingMatches = new JLabel("Remaining matches:");
    lblRemainingMatches.setBounds(10, 218, 116, 14);
    contentPane.add(lblRemainingMatches);
    
    lblShowRemainingMatches.setBounds(143, 218, 46, 14);
    contentPane.add(lblShowRemainingMatches);
  }

  private void createButtons(InitGameView initGameView) {
    JButton btnPaper = new JButton("Paper");
    btnPaper.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        toRealizePlay(Symbol.PAPER);
      }
    });
    btnPaper.setBounds(152, 61, 131, 115);
    contentPane.add(btnPaper);
    
    JButton btnScissors = new JButton("Scissors");
    btnScissors.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        toRealizePlay(Symbol.SCISSORS);
      }
    });
    btnScissors.setBounds(293, 61, 131, 115);
    contentPane.add(btnScissors);
    
    JButton btnRock = new JButton("Rock");
    btnRock.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        toRealizePlay(Symbol.ROCK);
      }
    });
    
    btnRock.setBounds(11, 61, 131, 115);
    contentPane.add(btnRock);
    
    JButton btnRestart = new JButton("Restart");
    btnRestart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        restartGame();
      }
    });
    
    btnRestart.setBounds(293, 214, 131, 23);
    contentPane.add(btnRestart);
  }

  private void restartGame() {
    matchView.setVisible(false);
    matchView = null;
    initGameView.restart();
  }
}
