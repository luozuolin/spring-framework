package org.springframework.luozlspringtest.springsource.spring48;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class PersonServiceImpl implements  PersonService {
    private JdbcTemplate jdbcTemplate;


    private static String insert_sql = "insert into account(balance) values (200)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save() throws RuntimeException {
        System.out.println("==调用PersonService的save方法\n");
        jdbcTemplate.update(insert_sql);
     //   throw new RuntimeException("==BankServiceImpl的save方法手动抛出异常");
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
