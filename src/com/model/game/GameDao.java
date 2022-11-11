package com.model.game;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.ConnectionFactory;

public class GameDao {


  public Integer createGame(String idPlayer) {

    String sql = "INSERT INTO GAME SELECT ? , ? ";
    String id = findId();
    PreparedStatement pstmt;
    try {
      pstmt = ConnectionFactory.getConnection().prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, idPlayer);
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return Integer.valueOf(id);
  }

  private String findId() {
    String sql = "SELECT COALESCE(MAX(IDGAME),0) + 1 id FROM GAME";
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
