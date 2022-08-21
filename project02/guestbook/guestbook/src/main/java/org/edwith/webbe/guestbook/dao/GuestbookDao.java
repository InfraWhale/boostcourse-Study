package org.edwith.webbe.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

public class GuestbookDao {
  public List<Guestbook> getGuestbooks(){
    List<Guestbook> list = new ArrayList<>();

    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    String sql = "SELECT * FROM guestbook";

    try (Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

      try (ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
          Long id = rs.getLong("id");
          String name = rs.getString("name");
          String content = rs.getString("content");
          Date regdate = rs.getTimestamp("regdate");
          Guestbook book = new Guestbook(id, name, content, regdate);
          list.add(book);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return list;
  }

  public void addGuestbook(Guestbook guestbook){

    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    String sql = "INSERT INTO guestbook ( name, content, regdate) VALUES ( ?, ?, ?)";

    try (Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, guestbook.getName());
      ps.setString(2, guestbook.getContent());
      ps.setTimestamp(3, new java.sql.Timestamp(guestbook.getRegdate().getTime()));
      ps.executeUpdate();

    } catch (Exception ex) {
      ex.printStackTrace();
    }


  }
}
