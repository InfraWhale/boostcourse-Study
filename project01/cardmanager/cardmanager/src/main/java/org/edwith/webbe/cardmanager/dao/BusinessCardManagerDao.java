package org.edwith.webbe.cardmanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.edwith.webbe.cardmanager.dto.BusinessCard;

public class BusinessCardManagerDao {

  private static String dburl = "jdbc:mysql://localhost:3306/businesscarddb?serverTimezone=UTC";
  private static String dbUser = "carduser";
  private static String dbpasswd = "card123!@#";

  public List<BusinessCard> searchBusinessCard(String keyword){
    List<BusinessCard> list = new ArrayList<>();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    String sql = "SELECT name, phone, company_name, date FROM business_card WHERE name LIKE ?";

    try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
        PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, "%"+keyword+"%");

      try (ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
          String name = rs.getString("name");
          String phone = rs.getString("phone");
          String company = rs.getString("company_name");
          Date date = rs.getTimestamp("date");
          BusinessCard card = new BusinessCard(name, phone, company, date);
          list.add(card);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return list;
  }

  // public BusinessCard addBusinessCard(BusinessCard businessCard){
  public int addBusinessCard(BusinessCard businessCard){ // 자료형 int로 변경
    int insertCount = 0;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    String sql = "INSERT INTO business_card (name, phone, company_name, date) VALUES ( ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
        PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, businessCard.getName());
      ps.setString(2, businessCard.getPhone());
      ps.setString(3, businessCard.getCompanyName());
      ps.setTimestamp(4, new java.sql.Timestamp(businessCard.getCreateDate().getTime()));
      insertCount = ps.executeUpdate();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return insertCount;
  }
}
