package kr.or.connect.daoexam.dao;

import static kr.or.connect.daoexam.dao.RoleDaoSqls.DELETE_BY_ROLE_ID;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.SELECT_ALL;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.SELECT_BY_ROLE_ID;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.UPDATE;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import kr.or.connect.daoexam.dto.Role;

@Repository
public class RoleDao {
  private NamedParameterJdbcTemplate jdbc; // JdbcTemplate은 바인딩시 ? 사용 | 이건 이름 이용해서 바인딩하거나 결과값 가져옴
  private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class); // 셀렉트 한건 한건을 dto에 저장
  private SimpleJdbcInsert insertAction; // insert용 객체


  public RoleDao(DataSource dataSource) {
    this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
  }

  public List<Role> selectAll() {
    return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);// Collections.emptyMap() : 바인딩 할 값 전달
  }

  public int insert(Role role) { // 쿼리 없이 했음
    SqlParameterSource params = new BeanPropertySqlParameterSource(role);
    return insertAction.execute(params);
  }

  public int update(Role role) {
    SqlParameterSource params = new BeanPropertySqlParameterSource(role); // 자동으로 map으로 바뀜...?
    return jdbc.update(UPDATE, params);
  }

  public int deleteById(int id) {
    Map<String, ?> params = Collections.singletonMap("roleId", id);
    return jdbc.update(DELETE_BY_ROLE_ID, params);
  }

  public Role selectById(int id) {
    try {
      Map<String, ?> params = Collections.singletonMap("roleId", id);
      return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
    } catch(EmptyResultDataAccessException e) { // 해당 조건에 맞는 값이 없다면
      return null;
    }
  }
}
