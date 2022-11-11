package com.model.player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.ConnectionFactory;

public class PlayerDao {

  public String savePlayer(String name) {

    String sql = "INSERT INTO PLAYER SELECT ? , ? ";
    String id = findId();
    PreparedStatement pstmt;
    try {
      pstmt = ConnectionFactory.getConnection().prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, name);
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return id;
  }

  private String findId() {
    String sql = "SELECT COALESCE(MAX(IDPLAYER),0) + 1 id FROM PLAYER";
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
