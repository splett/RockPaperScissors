package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  private static Connection dataSource = null;

  private static final String USER = "root";
  private static final String PASSWORD = "";
  private static final String URL = "jdbc:mysql://localhost:3306/project";
  private static final String CLASS_NAME = "com.mysql.jdbc.Driver";


  public static Connection getConnection() throws SQLException, ClassNotFoundException {
    if (dataSource == null) {
      Class.forName(CLASS_NAME);
      dataSource = DriverManager.getConnection(URL, USER,PASSWORD);
    }

    return dataSource;
  }
}
