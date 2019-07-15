package org.springframework.luozlspringtest.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;

    //设置数据源
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(User user) {
        this.jdbcTemplate.update("INSERT INTO t_user (user_name, age) VALUES (?, ?)",
                new Object[]{user.getUserName(), user.getAge()}, new int[]{Types.VARCHAR, Types.INTEGER});
    }

    public List<User> getList() {
        List<User> users = this.jdbcTemplate.query("select * from t_user",new UserRowMapper());
        return users;
    }
}
