package com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.controller.InitGameController;
import com.model.game.Game;

public class InitGameView extends JFrame {

  private static final long serialVersionUID = -6535305059143918415L;
  private JPanel contentPane;
  private JTextField txtPlayer;
  private InitGameController initGameController;
  private static InitGameView frame = new InitGameView();
  private MatchView matchView;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public InitGameView() {
    setTitle("Jokenp\u00F4");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 120);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblPlayer = new JLabel("Player:");
    
    txtPlayer = new JTextField();
    txtPlayer.setToolTipText("Enter with player name");
    txtPlayer.setHorizontalAlignment(SwingConstants.LEFT);
    txtPlayer.setColumns(10);
    
    JButton btnStartGame = new JButton("Start");
    btnStartGame.addActionListener(new ActionListener() {
      @SuppressWarnings("deprecation")
      public void actionPerformed(ActionEvent arg0) {
        initGameController = new InitGameController();
        Game game = initGameController.savePlayer(txtPlayer.getText());
        frame.setVisible(false);
        matchView = new MatchView(game, frame);
        matchView.show();
      }
    });
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.TRAILING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(btnStartGame, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addComponent(lblPlayer, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(txtPlayer, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)))
          .addContainerGap())
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblPlayer, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
            .addComponent(txtPlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnStartGame)
          .addGap(12))
    );
    contentPane.setLayout(gl_contentPane);
  }

  @SuppressWarnings("deprecation")
  public void restart() {
    this.show();
  }
}
