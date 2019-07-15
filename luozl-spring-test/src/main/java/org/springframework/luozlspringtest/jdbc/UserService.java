package org.springframework.luozlspringtest.jdbc;

import java.util.List;

public interface UserService {
    void insert(User user);
    List<User> getList();
}
