package com.luozl.mapper1;

import com.luozl.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserDao {
   // @Select("SELECT count(0) FROM tbl_user")
    long getUserList();

  /*  @Select("SELECT * FROM tbl_user WHERE userId = #{userId}")
    User getUserById(@Param("userId") String userId);

    @Update("UPDATE tbl_user SET sex = #{sex} WHERE userId = #{userId}")
    void updateUserEmailById(@Param("userId") String userId, @Param("sex") String sex);

    @Delete("DELETE FROM tbl_user WHERE userId = #{userId}")
    void deleteUserById(@Param("userId") String userId);

   // void insertUser(User user);
   */
}
