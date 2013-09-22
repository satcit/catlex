package ru.satcit.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseHandler {
  public static final String ARTICLES_TABLE_NAME = "articles";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "root";
  private static final String DB_HOSTNAME = "localhost";
  private static final String DB_PORT = "3306";
  private static DataBaseHandler instance;

  public static DataBaseHandler getInstance() {
    if( instance == null ) {
      synchronized( DataBaseHandler.class ){
        if( instance == null ) {
          instance = new DataBaseHandler();
        }
      }
    }
    return instance;
  }

  private DataBaseHandler() {
    // singleton
  }

  public Connection getConnection() throws SQLException {
    Connection conn = null;
    Properties connectionProps = new Properties();
    connectionProps.put("user", USERNAME);
    connectionProps.put("password", PASSWORD);

    conn = DriverManager.getConnection(
               "jdbc:mysql://" +
               DB_HOSTNAME +
               ":" + DB_PORT + "/",
               connectionProps);
    return conn;
  }
}
