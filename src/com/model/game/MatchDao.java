package com.model.game;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.ConnectionFactory;

public class MatchDao {

  public Integer realizePlay(Integer idGame, Integer humanPlayer, Integer automaticPlayer) {

    String sql = "INSERT INTO MATCHS SELECT ? , ? , ?, ?";
    String idMatch = findId();
    PreparedStatement pstmt;
    try {
      pstmt = ConnectionFactory.getConnection().prepareStatement(sql);
      pstmt.setString(1, idGame.toString());
      pstmt.setString(2, idMatch);
      pstmt.setString(3, humanPlayer.toString());
      pstmt.setString(4, automaticPlayer.toString());
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return Integer.valueOf(idMatch);
  }

  private String findId() {
    String sql = "SELECT COALESCE(MAX(IDMATCH),0) + 1 id FROM MATCHS";
    try {
      ResultSet rs = ConnectionFactory.getConnection().prepareStatement(sql).executeQuery(sql);
     
      while(rs.next()){
        return rs.getString("id");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return "0";
  }
}
