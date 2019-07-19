package com.young.community.dao;

import com.young.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    void insertUser(User user);

    User findByToken(String token);
}
