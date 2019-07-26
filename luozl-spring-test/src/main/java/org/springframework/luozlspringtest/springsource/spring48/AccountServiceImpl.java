package org.springframework.luozlspringtest.springsource.spring48;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class AccountServiceImpl implements AccountService {
    private JdbcTemplate jdbcTemplate;

    private static String insert_sql = "insert into account(balance) values (100)";
   // private static String insert_sql = "insert into account(balance) values ('ss')";

    //外部事物和外部已经执行的方法为Propagation.REQUIRED
    // 此方法为：Propagation.NOT_SUPPORTED
    //        此方法的操作能正常提交到数据库
    // 此方法为：其他事物类型
    //        所有操作都会回滚
    // Propagation.REQUIRES_NEW:新建事务，如果当前存在事务，把当前事务挂起。
    // 新建的事务将和被挂起的事务没有任何关系，是两个独立的事务，
    // 外层事务失败回滚之后，不能回滚内层事务执行的结果，
    // 内层事务失败抛出异常，外层事务捕获，也可以不处理回滚操作
    //
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void save() throws RuntimeException {
        System.out.println("==调用AccountService的save方法\n");
        jdbcTemplate.update(insert_sql);

      //  throw new RuntimeException("==AccountService的save方法手动抛出异常");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete() throws RuntimeException {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void beforeCommit(boolean readOnly) {
                System.out.println("==回调,事物提交之前");
                super.beforeCommit(readOnly);
            }

            @Override
            public void afterCommit() {
                System.out.println("==回调,事物提交之后");
                super.afterCommit();
            }

            @Override
            public void beforeCompletion() {
                super.beforeCompletion();
                System.out.println("==回调,事物完成之前");
            }

            @Override
            public void afterCompletion(int status) {
                super.afterCompletion(status);
                System.out.println("==回调,事物完成之后");
            }
        });

        System.out.println("==调用AccountService的dele方法\n");
        jdbcTemplate.update(insert_sql);

        throw new RuntimeException("==AccountService的delete方法手动抛出异常");

       }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
