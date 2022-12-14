package org.edwith.webbe.guestbook.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
  public static Connection getConnection(){

    return getConnection("jdbc:mysql://localhost:3306/bookdb?"
        + "serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&"
        + "useSSL=false","bookuser","book123!@#");
  }

  public static Connection getConnection(String dbURL, String dbId, String dbPassword){
    Connection conn = null;
    try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
      return conn;
    }catch(Exception ex){
      throw new RuntimeException("Connection Error");
    }
  }
}
