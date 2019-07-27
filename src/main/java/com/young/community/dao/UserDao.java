package com.young.community.dao;

import com.young.community.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    @Select("insert into user( NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl});")
    void insertUser(User user);

    @Select("select * from user where token = #{token};")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id};")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId};")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name = #{name}, token = #{token}, gmt_modified = #{gmtModified}, avatar_url = #{avatarUrl} where id = #{id}")
    void update(User user);
}
