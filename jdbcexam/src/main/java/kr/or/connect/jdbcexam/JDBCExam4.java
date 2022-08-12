package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam4 {

  public static void main(String[] args) {
    int roleId = 501;
    String description = "CTOO";
    int prevId = 500;

    Role role = new Role(roleId, description);

    RoleDao dao = new RoleDao();
    int updateCount = dao.updateRole(role, prevId);

    System.out.println(updateCount);
  }
}
